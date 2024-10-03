package ln.mial.ecommerce.infraestructure.adapter;

import ln.mial.ecommerce.infraestructure.entity.CategoriasEntity;
import ln.mial.ecommerce.infraestructure.entity.ProductosEntity;
import ln.mial.ecommerce.infraestructure.entity.UsuariosEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProductosCrudRepository extends CrudRepository<ProductosEntity, Integer>{
    Iterable<ProductosEntity> findByUserEntity(UsuariosEntity userEntity);
    Iterable<ProductosEntity> findByCategory(CategoriasEntity category);
}
