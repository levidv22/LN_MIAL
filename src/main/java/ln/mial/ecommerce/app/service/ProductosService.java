package ln.mial.ecommerce.app.service;

import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;
import ln.mial.ecommerce.infraestructure.entity.ProductosEntity;
import ln.mial.ecommerce.infraestructure.entity.UsuariosEntity;
import org.springframework.web.multipart.MultipartFile;
import ln.mial.ecommerce.app.repository.ProductosRepository;
import ln.mial.ecommerce.infraestructure.entity.CategoriasEntity;

public class ProductosService {

    private final ProductosRepository productRepository;
    private final UploadFile uploadFile;

    public ProductosService(ProductosRepository productRepository, UploadFile uploadFile) {
        this.productRepository = productRepository;
        this.uploadFile = uploadFile;
    }

    public Iterable<ProductosEntity> getProducts() {
        return productRepository.getProducts();
    }

    public Iterable<ProductosEntity> getProductsByUser(UsuariosEntity userEntity) {
        return productRepository.getProductsByUser(userEntity);
    }

    public ProductosEntity getProductById(Integer id) {
        return productRepository.getProductById(id);
    }

    public ProductosEntity saveProduct(ProductosEntity productEntity, MultipartFile multipartfile, HttpSession session) throws IOException {
        if (productEntity.getId() == null) {
            // Nuevo producto
            UsuariosEntity user = new UsuariosEntity();
            user.setId(Integer.parseInt(session.getAttribute("iduser").toString()));
            productEntity.setDateCreated(LocalDateTime.now());
            productEntity.setDateUpdated(LocalDateTime.now());
            productEntity.setUserEntity(user);
            productEntity.setImage(uploadFile.upload(multipartfile)); // Guarda la imagen
            return productRepository.saveProduct(productEntity);
        } else {
            // Actualizar producto
            ProductosEntity productDB = productRepository.getProductById(productEntity.getId());
            if (multipartfile.isEmpty()) {
                productEntity.setImage(productDB.getImage()); // Mantener imagen existente
            } else {
                if (!productDB.getImage().equals("default.png")) {
                    uploadFile.delete(productDB.getImage()); // Eliminar imagen antigua
                }
                productEntity.setImage(uploadFile.upload(multipartfile)); // Guardar nueva imagen
            }
            productEntity.setCode(productDB.getCode());
            productEntity.setDateCreated(productDB.getDateCreated());
            productEntity.setDateUpdated(LocalDateTime.now());
            return productRepository.saveProduct(productEntity);
        }
    }

    public Iterable<ProductosEntity> getProductsByCategory(Integer categoryId) {
        CategoriasEntity category = new CategoriasEntity();
        category.setId(categoryId);
        return productRepository.findByCategory(category); // Assuming you have this in the repository
    }

    public boolean deleteProductById(Integer id) {
        return productRepository.deleteProductById(id);
    }
}
