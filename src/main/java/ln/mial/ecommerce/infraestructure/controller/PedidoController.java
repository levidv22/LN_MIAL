package ln.mial.ecommerce.infraestructure.controller;

import jakarta.servlet.http.*;
import ln.mial.ecommerce.app.service.*;
import ln.mial.ecommerce.infraestructure.entity.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import java.math.*;
import java.time.*;
import java.util.List;
import ln.mial.ecommerce.app.service.AlmacenService;
import org.springframework.web.servlet.mvc.support.*;

@Controller
@RequestMapping("/carrito")
public class PedidoController {

    private final PedidosService pedidosService;
    private final DetallePedidosService detallePedidosService;
    private final ProductosService productosService;
    private final AlmacenService almacenService;

    public PedidoController(PedidosService pedidosService, DetallePedidosService detallePedidosService, ProductosService productosService, AlmacenService almacenService) {
        this.pedidosService = pedidosService;
        this.detallePedidosService = detallePedidosService;
        this.productosService = productosService;
        this.almacenService = almacenService;
    }

    @GetMapping
    public String showCart(HttpSession session, Model model) {
        PedidosEntity order = (PedidosEntity) session.getAttribute("currentOrder");

        // Si el pedido no existe o ya fue enviado, mostrar un carrito vacío
        if (order == null || order.getStatusPedido() == StatusPedido.PAGADO) {
            model.addAttribute("cart", List.of());
            model.addAttribute("totalAmount", BigDecimal.ZERO);
        } else {
            // Filtrar los detalles del pedido para excluir los ya pagados (PAGADO)
            List<DetallePedidosEntity> orderDetails = detallePedidosService.getOrderDetailsByOrder(order).stream()
                    .filter(detail -> order.getStatusPedido() != StatusPedido.PAGADO)
                    .toList();

            BigDecimal totalAmount = orderDetails.stream()
                    .map(item -> item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
                    .reduce(BigDecimal.ZERO, BigDecimal::add);

            model.addAttribute("cart", orderDetails);
            model.addAttribute("totalAmount", totalAmount);
        }

        return "carrito";
    }

    @PostMapping("/add")
    public String addToCart(@RequestParam("productId") Integer productId,
            @RequestParam("quantity") Integer quantity,
            HttpSession session) {
        UsuariosEntity user = (UsuariosEntity) session.getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }

        PedidosEntity order = (PedidosEntity) session.getAttribute("currentOrder");
        if (order == null || order.getStatusPedido() == StatusPedido.PAGADO) {
            order = new PedidosEntity();
            order.setOrderDate(LocalDateTime.now());
            order.setStatusPedido(StatusPedido.EN_PROCESO); // Estado inicial del pedido
            order.setUser(user);
            order = pedidosService.saveOrder(order);
            session.setAttribute("currentOrder", order);
        }

        ProductosEntity product = productosService.getProductById(productId);
        DetallePedidosEntity orderDetail = new DetallePedidosEntity();
        orderDetail.setProduct(product);
        orderDetail.setQuantity(quantity);
        orderDetail.setPrice(product.getPrice());
        orderDetail.setOrder(order);
        detallePedidosService.saveOrderDetail(orderDetail);

        return "redirect:/carrito";
    }

    @PostMapping("/checkout")
    public String checkout(HttpSession session) {
        PedidosEntity order = (PedidosEntity) session.getAttribute("currentOrder");
        if (order != null && order.getStatusPedido() == StatusPedido.EN_PROCESO) {
            // Aquí se valida el pago
            order.setStatusPedido(StatusPedido.PAGADO);
            pedidosService.saveOrder(order);
        }
        return "redirect:/carrito";
    }

    @GetMapping("/cantidad")
    @ResponseBody
    public int getCartItemCount(HttpSession session) {
        PedidosEntity order = (PedidosEntity) session.getAttribute("currentOrder");
        if (order == null || order.getStatusPedido() == StatusPedido.PAGADO) {
            return 0; // Si no hay productos o el pedido fue enviado, la cantidad es 0
        }

        List<DetallePedidosEntity> orderDetails = detallePedidosService.getOrderDetailsByOrder(order);
        // Contar el número de productos diferentes en el carrito
        return orderDetails.size(); // Devolver el número de líneas en el carrito
    }

    @PostMapping("/delete/{id}")
    public String deleteFromCart(@PathVariable("id") Integer orderDetailId, HttpSession session, RedirectAttributes redirectAttributes) {
        try {
            // Obtener el detalle del pedido que se va a eliminar
            DetallePedidosEntity orderDetail = detallePedidosService.getOrderDetailById(orderDetailId);
            if (orderDetail == null) {
                redirectAttributes.addFlashAttribute("error", "El producto no existe en el carrito.");
                return "redirect:/carrito"; // Si no existe, redirigir al carrito
            }

            // Obtener el producto asociado al detalle del pedido
            ProductosEntity product = orderDetail.getProduct();

            // Obtener el stock de ese producto en el almacén
            List<AlmacenEntity> stockList = almacenService.getStockByProductEntity(product);
            if (stockList.isEmpty()) {
                redirectAttributes.addFlashAttribute("error", "No se pudo encontrar el stock del producto.");
                return "redirect:/carrito"; // Si no hay stock, redirigir
            }

            AlmacenEntity stock = stockList.get(0);  // Asumir que hay solo un stock por producto

            // Actualizar el campo "salidas" y "balance"
            int quantity = orderDetail.getQuantity();
            int newSalidas = stock.getSalidas() - quantity;
            stock.setSalidas(newSalidas);

            // Recalcular el balance (entradas - salidas)
            int newBalance = stock.getEntradas() - newSalidas;
            stock.setBalance(newBalance);

            // Guardar los cambios en el stock
            almacenService.saveStock(stock);

            // Eliminar el detalle del pedido
            detallePedidosService.deleteOrderDetailById(orderDetailId);

            redirectAttributes.addFlashAttribute("success", "Producto eliminado correctamente.");
        } catch (Exception e) {
            // Mensaje de error
            redirectAttributes.addFlashAttribute("error", "Hubo un error al eliminar el producto.");
        }

        return "redirect:/carrito";
    }

}
