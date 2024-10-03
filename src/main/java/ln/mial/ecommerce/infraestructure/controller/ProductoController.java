package ln.mial.ecommerce.infraestructure.controller;

import jakarta.servlet.http.*;
import java.io.*;
import java.util.*;
import ln.mial.ecommerce.app.service.*;
import ln.mial.ecommerce.infraestructure.entity.*;
import org.slf4j.*;
import org.springframework.ui.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.*;

@Controller
@RequestMapping("/admin/products")
public class ProductoController {

    private final ProductosService productService;
    private final CategoriasService categoriasService;
    private final AlmacenService almacenService;
    private final DetallePedidosService detallePedidosService;
    private final PedidosService pedidosService;
    private final PagosService pagosService;
    private final Logger log = LoggerFactory.getLogger(ProductoController.class);

    public ProductoController(ProductosService productService, CategoriasService categoriasService, AlmacenService almacenService, DetallePedidosService detallePedidosService, PedidosService pedidosService, PagosService pagosService) {
        this.productService = productService;
        this.categoriasService = categoriasService;
        this.almacenService = almacenService;
        this.detallePedidosService = detallePedidosService;
        this.pedidosService = pedidosService;
        this.pagosService = pagosService;
    }


    

    @GetMapping
    public String showProducts(Model model) {
        Iterable<ProductosEntity> products = productService.getProducts();
        Iterable<CategoriasEntity> categories = categoriasService.getCategories(); // Obtener las categorías

        for (ProductosEntity product : products) {
            List<AlmacenEntity> stockList = almacenService.getStockByProductEntity(product);
            if (!stockList.isEmpty()) {
                AlmacenEntity stock = stockList.get(0); // Asumiendo que hay solo un stock por producto
                product.setBalance(stock.getBalance()); // Asigna el balance directamente al producto
            } else {
                product.setBalance(0); // No hay stock, establecer a 0
            }
        }

        model.addAttribute("products", products);
        model.addAttribute("categories", categories); // Añadir las categorías al modelo

        List<PedidosEntity> allPaidOrders = pedidosService.getOrdersByStatus(StatusPedido.PAGADO);

        // Crear una lista de DetallePedidosEntity que combine los detalles de todos los pedidos pagados
        List<DetallePedidosEntity> allPurchasedDetails = new ArrayList<>();
        for (PedidosEntity order : allPaidOrders) {
            allPurchasedDetails.addAll(detallePedidosService.getOrderDetailsByOrder(order));
        }

        // Obtener los pagos realizados
        List<PagosEntity> allPayments = new ArrayList<>();
        for (PedidosEntity order : allPaidOrders) {
            List<PagosEntity> payments = pagosService.getPaymentsByOrder(order);
            allPayments.addAll(payments);
        }

        // Añadir los detalles de pedidos y pagos al modelo
        model.addAttribute("allPurchasedDetails", allPurchasedDetails);
        model.addAttribute("allPayments", allPayments);
        return "admin";
    }

    @PostMapping
    public String addProduct(ProductosEntity product, @RequestParam("file") MultipartFile multipartfile, @RequestParam("categoryId") Integer categoryId, @RequestParam("stockQuantity") Integer stockQuantity, HttpSession session) throws IOException {
        CategoriasEntity category = categoriasService.getCategoryById(categoryId);
        product.setCategory(category);  // Set selected category
        productService.saveProduct(product, multipartfile, session);
        return "redirect:/admin/products";
    }

    @GetMapping("/edit/{id}")
    public String editProduct(@PathVariable Integer id, Model model) {
        ProductosEntity product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "admin";
    }

    @PostMapping("/update")
    public String updateProduct(ProductosEntity product, @RequestParam("file") MultipartFile multipartfile, HttpSession session) throws IOException {
        productService.saveProduct(product, multipartfile, session);
        return "redirect:/admin/products";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Integer id) {
        productService.deleteProductById(id);
        return "redirect:/admin/products";
    }

}
