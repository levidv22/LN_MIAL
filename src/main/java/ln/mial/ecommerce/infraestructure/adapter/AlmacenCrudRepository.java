package ln.mial.ecommerce.infraestructure.adapter;

import java.util.List;
import ln.mial.ecommerce.infraestructure.entity.AlmacenEntity;
import ln.mial.ecommerce.infraestructure.entity.ProductosEntity;
import org.springframework.data.repository.CrudRepository;

public interface AlmacenCrudRepository extends CrudRepository<AlmacenEntity, Integer>{
       List<AlmacenEntity> getStockByProductosEntity(ProductosEntity productosEntity); 
}
