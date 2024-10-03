package ln.mial.ecommerce.infraestructure.configuration;

import ln.mial.ecommerce.app.repository.*;
import ln.mial.ecommerce.app.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //  declarar configuraciones y gestionar la creación de objetos (@Bean) de manera centralizada.
public class BeanConfig {

    @Bean
    public UsuariosService userService(UsuariosRepository userRepository) {
        return new UsuariosService(userRepository);
    }

    @Bean
    public ProductosService productService(ProductosRepository productRepository, UploadFile uploadFile) {
        return new ProductosService(productRepository, uploadFile);
    }

    @Bean
    public UploadFile uploadFile() {
        return new UploadFile();
    }

    @Bean
    public CategoriasService categoryService(CategoriasRepository categoryRepository) {
        return new CategoriasService(categoryRepository);
    }

    @Bean
    public PedidosService orderService(PedidosRepository orderRepository) {
        return new PedidosService(orderRepository);
    }

    @Bean
    public DetallePedidosService orderDetailsService(DetallePedidosRepository orderDetailsRepository) {
        return new DetallePedidosService(orderDetailsRepository);
    }

    @Bean
    public PagosService paymentService(PagosRepository paymentRepository) {
        return new PagosService(paymentRepository);
    }

    @Bean
    public EnviosService shippingService(EnviosRepository shippingRepository) {
        return new EnviosService(shippingRepository);
    }

    @Bean
    public CalificacionProductosService reviewService(CalificacionProductosRepository reviewRepository) {
        return new CalificacionProductosService(reviewRepository);
    }

    @Bean
    public AlmacenService stockService(AlmacenRepository stockRepository) {
        return new AlmacenService(stockRepository);
    }

    @Bean
    public ValidateStock validateStock(AlmacenService stockService) {
        return new ValidateStock(stockService);
    }

}
