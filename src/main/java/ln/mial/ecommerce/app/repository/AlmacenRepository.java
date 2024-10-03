package ln.mial.ecommerce.app.repository;

import java.util.List;
import ln.mial.ecommerce.infraestructure.entity.AlmacenEntity;
import ln.mial.ecommerce.infraestructure.entity.ProductosEntity;

public interface AlmacenRepository {
    AlmacenEntity saveStock(AlmacenEntity stockEntity);
    List<AlmacenEntity> getStockByProductEntity(ProductosEntity productosEntity);  
    boolean deleteStockById(Integer id);
}
