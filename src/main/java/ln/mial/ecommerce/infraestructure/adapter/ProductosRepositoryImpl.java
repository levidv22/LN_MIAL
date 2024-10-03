package ln.mial.ecommerce.infraestructure.adapter;

import jakarta.transaction.Transactional;
import ln.mial.ecommerce.infraestructure.entity.ProductosEntity;
import ln.mial.ecommerce.infraestructure.entity.UsuariosEntity;
import org.springframework.stereotype.Repository;
import ln.mial.ecommerce.app.repository.ProductosRepository;
import ln.mial.ecommerce.infraestructure.entity.CategoriasEntity;

@Repository
public class ProductosRepositoryImpl implements ProductosRepository {
    private final ProductosCrudRepository productCrudRepository;

    public ProductosRepositoryImpl(ProductosCrudRepository productCrudRepository) {
        this.productCrudRepository = productCrudRepository;
    }

    @Override
    public Iterable<ProductosEntity> getProducts() {
        return productCrudRepository.findAll();
    }

    @Override
    public Iterable<ProductosEntity> getProductsByUser(UsuariosEntity userEntity) {
        return productCrudRepository.findByUserEntity(userEntity);
    }

    @Override
    public Iterable<ProductosEntity> findByCategory(CategoriasEntity category) {
        return productCrudRepository.findByCategory(category);  // Add this method
    }

    @Override
    public ProductosEntity getProductById(Integer id) {
        return productCrudRepository.findById(id).get();
    }

    @Override
    public ProductosEntity saveProduct(ProductosEntity productEntity) {
        return productCrudRepository.save(productEntity);
    }

    @Override
    @Transactional
    public boolean deleteProductById(Integer id) {
        productCrudRepository.deleteById(id);
        return true;
    }
}
