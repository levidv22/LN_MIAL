package ln.mial.ecommerce.infraestructure.adapter;

import jakarta.transaction.Transactional;
import java.util.List;
import ln.mial.ecommerce.infraestructure.entity.AlmacenEntity;
import ln.mial.ecommerce.infraestructure.entity.ProductosEntity;
import org.springframework.stereotype.Repository;
import ln.mial.ecommerce.app.repository.AlmacenRepository;

@Repository
public class AlmacenRepositoryImpl implements AlmacenRepository{
private final AlmacenCrudRepository stockCrudRepository;

    public AlmacenRepositoryImpl(AlmacenCrudRepository stockCrudRepository) {
        this.stockCrudRepository = stockCrudRepository;
    }

    @Override
    public AlmacenEntity saveStock(AlmacenEntity stockEntity) {
        return stockCrudRepository.save(stockEntity);
    }

    @Override
    public List<AlmacenEntity> getStockByProductEntity(ProductosEntity productosEntity) {
    return stockCrudRepository.getStockByProductosEntity(productosEntity);
    }
    
    @Override
    @Transactional
    public boolean deleteStockById(Integer id) {
        stockCrudRepository.deleteById(id);
        return true;
    }
    
}

