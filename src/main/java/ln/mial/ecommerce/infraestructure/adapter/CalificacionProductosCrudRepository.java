package ln.mial.ecommerce.infraestructure.adapter;

import ln.mial.ecommerce.infraestructure.entity.CalificacionProductosEntity;
import ln.mial.ecommerce.infraestructure.entity.ProductosEntity;
import ln.mial.ecommerce.infraestructure.entity.UsuariosEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CalificacionProductosCrudRepository extends CrudRepository<CalificacionProductosEntity, Integer> {
    List<CalificacionProductosEntity> findByProduct(ProductosEntity productEntity);
    List<CalificacionProductosEntity> findByUser(UsuariosEntity userEntity);
}
