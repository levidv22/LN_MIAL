package ln.mial.ecommerce.app.repository;

import ln.mial.ecommerce.infraestructure.entity.EnviosEntity;
import ln.mial.ecommerce.infraestructure.entity.PedidosEntity;

import java.util.List;

public interface EnviosRepository {
    List<EnviosEntity> getShipping();
    EnviosEntity getShippingById(Integer id);
    List<EnviosEntity> getShippingByOrder(PedidosEntity orderEntity);
    EnviosEntity saveShipping(EnviosEntity shippingEntity);
    boolean deleteShippingById(Integer id);
}
