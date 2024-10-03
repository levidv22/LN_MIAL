package ln.mial.ecommerce.app.service;

import java.util.List;
import ln.mial.ecommerce.infraestructure.entity.AlmacenEntity;
import ln.mial.ecommerce.infraestructure.entity.ProductosEntity;
import ln.mial.ecommerce.app.repository.AlmacenRepository;

public class AlmacenService {

    private final AlmacenRepository stockRepository;

    public AlmacenService(AlmacenRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public AlmacenEntity saveStock(AlmacenEntity stockEntity) {
        return stockRepository.saveStock(stockEntity);
    }

    public List<AlmacenEntity> getStockByProductEntity(ProductosEntity productosEntity) {
        return stockRepository.getStockByProductEntity(productosEntity);
    }

    public boolean deleteStockById(Integer id) {
        return stockRepository.deleteStockById(id);
    }

    public AlmacenEntity updateStockAfterOrder(AlmacenEntity stock, int quantity) {
        int newSalidas = stock.getSalidas() + quantity;
        stock.setSalidas(newSalidas);

        // Calcular el nuevo balance
        int newBalance = stock.getEntradas() - newSalidas;
        stock.setBalance(newBalance);

        return stockRepository.saveStock(stock);
    }

}
