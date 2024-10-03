package ln.mial.ecommerce.app.service;

import java.util.List;
import ln.mial.ecommerce.infraestructure.entity.AlmacenEntity;
import ln.mial.ecommerce.infraestructure.entity.ProductosEntity;

public class ValidateStock {
    private final AlmacenService stockService;

    public ValidateStock(AlmacenService stockService) {
        this.stockService = stockService;
    }
    
    private boolean existBalance(ProductosEntity product){
        List<AlmacenEntity> stockList = stockService.getStockByProductEntity(product);
        return stockList.isEmpty() ? false : true;
    }
    
    public AlmacenEntity calculateBalance(AlmacenEntity stock){
        
        if(stock.getEntradas() != 0){
            if(existBalance(stock.getProductosEntity())){
                List<AlmacenEntity> stockList = stockService.getStockByProductEntity(stock.getProductosEntity());
                Integer balance = stockList.get(stockList.size()-1).getBalance();
                stock.setBalance(balance + stock.getEntradas());
            }else{
                stock.setBalance(stock.getEntradas());
            }
            
        }else{
            List<AlmacenEntity> stockList = stockService.getStockByProductEntity(stock.getProductosEntity());
                Integer balance = stockList.get(stockList.size()-1).getBalance();
                stock.setBalance(balance - stock.getSalidas());
                    
        }
        
        return stock;
    }
}
