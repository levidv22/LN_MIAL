package ln.mial.ecommerce.infraestructure.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import jakarta.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.List;
import ln.mial.ecommerce.app.service.*;
import ln.mial.ecommerce.infraestructure.entity.*;
import org.springframework.ui.Model;

@Controller
@RequestMapping
public class UsuarioController {

    private final UsuariosService userService;
    private final ProductosService productService;
    private final CategoriasService categoriasService;
    private final PedidosService pedidosService;

    public UsuarioController(UsuariosService userService, ProductosService productService, CategoriasService categoriasService, PedidosService pedidosService) {
        this.userService = userService;
        this.productService = productService;
        this.categoriasService = categoriasService;
        this.pedidosService = pedidosService;
    }

    // Ruta pública (cuando el cliente aún no se ha registrado ni ha iniciado sesión)
    @GetMapping("/")
    public String showIndexWithoutLogin(Model model) {
        // Mostrar productos de la categoría con ID 1 por defecto
        return showProductsByCategoryInternal(1, model);
    }

    // Ruta para el cliente autenticado (después de iniciar sesión)
    @GetMapping("/index/products")
    public String showIndexAfterLogin(Model model) {
        // Mostrar productos de la categoría con ID 1 por defecto
        return showProductsByCategoryInternal(1, model);
    }

    // Ruta para mostrar productos por categoría (común)
    @GetMapping("/category/{id}")
    public String showProductsByCategory(@PathVariable Integer id, Model model) {
        // Mostrar productos según la categoría seleccionada
        return showProductsByCategoryInternal(id, model);
    }

    // Método privado para reutilizar la lógica
    private String showProductsByCategoryInternal(Integer categoryId, Model model) {
        // Obtener productos por categoría
        Iterable<ProductosEntity> products = productService.getProductsByCategory(categoryId);
        // Obtener todas las categorías para los botones
        Iterable<CategoriasEntity> categories = categoriasService.getCategories();
        // Añadir productos y categorías al modelo
        model.addAttribute("products", products);
        model.addAttribute("categories", categories);
        return "index"; // Redirigir a la vista index.html
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // Invalida la sesión actual
        return "redirect:/";  // Redirige a la página de inicio
    }

    @GetMapping("/register")
    public String showRegister() {
        return "register"; // Redirige a register.html
    }

    // Maneja el registro de usuario
    @PostMapping("/register")
    public ModelAndView registerUser(@RequestParam String username, @RequestParam String email, @RequestParam String cellphone, @RequestParam String password) {
        UsuariosEntity user = new UsuariosEntity();
        user.setUsername(username);
        user.setEmail(email);
        user.setCellphone(cellphone);
        user.setPassword(password);
        user.setDateCreated(LocalDateTime.now());
        user.setTypeUser(TypeUser.USER);  // Set default user type as USER
        userService.createUser(user);
        return new ModelAndView("redirect:/login");
    }

    @GetMapping("/login")
    public String showLogin() {
        return "login"; // Redirige a login.html
    }

    @PostMapping("/login")
    public ModelAndView loginUser(@RequestParam String email, @RequestParam String password, HttpSession session) {
        UsuariosEntity user = userService.findByEmail(email);

        if (user != null) { // Verificar si el usuario fue encontrado
            if (user.getPassword().equals(password)) {
                session.setAttribute("username", user.getUsername());
                session.setAttribute("email", user.getEmail());
                session.setAttribute("iduser", user.getId());  // Guardar el `iduser`
                session.setAttribute("user", user); // Guardar objeto usuario en la sesión

                // Recuperar el pedido con estado EN_PROCESO para este usuario
                List<PedidosEntity> ordersInProcess = pedidosService.getOrdersByUserAndStatus(user, StatusPedido.EN_PROCESO);
                if (!ordersInProcess.isEmpty()) {
                    // Si hay un pedido en proceso, lo colocamos en la sesión
                    session.setAttribute("currentOrder", ordersInProcess.get(0));
                }

                if (user.getTypeUser() == TypeUser.USER) {
                    return new ModelAndView("redirect:/index/products");
                } else {
                    return new ModelAndView("redirect:/admin/products");
                }
            } else {
                return new ModelAndView("redirect:/login?error=invalid_password"); // Error de contraseña
            }
        } else {
            return new ModelAndView("redirect:/login?error=user_not_found"); // Error de usuario no encontrado
        }
    }


}
