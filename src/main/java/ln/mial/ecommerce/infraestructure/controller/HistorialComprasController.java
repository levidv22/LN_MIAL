package ln.mial.ecommerce.infraestructure.controller;

import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import ln.mial.ecommerce.app.service.*;
import ln.mial.ecommerce.infraestructure.entity.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/historial")
public class HistorialComprasController {

    private final PagosService pagosService;
    private final PedidosService pedidosService;
    private final DetallePedidosService detallePedidosService;

    public HistorialComprasController(PagosService pagosService, PedidosService pedidosService, DetallePedidosService detallePedidosService) {
        this.pagosService = pagosService;
        this.pedidosService = pedidosService;
        this.detallePedidosService = detallePedidosService;
    }

    @GetMapping("/user")
    public String showPurchasedProducts(HttpSession session, Model model) {
        // Obtener el usuario de la sesión
        UsuariosEntity user = (UsuariosEntity) session.getAttribute("user");
        if (user == null) {
            return "redirect:/login"; // Redirigir si no está logueado
        }

        // Obtener los pedidos pagados (ENVIADO) del usuario
        List<PedidosEntity> paidOrders = pedidosService.getOrdersByUserAndStatus(user, StatusPedido.PAGADO);

        // Obtener todos los detalles de los pedidos pagados
        List<DetallePedidosEntity> purchasedDetails = new ArrayList<>();
        for (PedidosEntity order : paidOrders) {
            purchasedDetails.addAll(detallePedidosService.getOrderDetailsByOrder(order));
        }

        // Agregar los detalles de los productos al modelo
        model.addAttribute("purchasedDetails", purchasedDetails);

        return "historial-compras"; // Vista donde mostrar el historial de compras
    }

}
