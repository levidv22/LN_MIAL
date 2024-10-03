package ln.mial.ecommerce.app.service;

import ln.mial.ecommerce.infraestructure.entity.EnviosEntity;
import ln.mial.ecommerce.infraestructure.entity.PedidosEntity;

import java.util.List;
import ln.mial.ecommerce.app.repository.EnviosRepository;

public class EnviosService {
    private final EnviosRepository shippingRepository;

    public EnviosService(EnviosRepository shippingRepository) {
        this.shippingRepository = shippingRepository;
    }

    public List<EnviosEntity> getShipping() {
        return shippingRepository.getShipping();
    }

    public EnviosEntity getShippingById(Integer id) {
        return shippingRepository.getShippingById(id);
    }

    public List<EnviosEntity> getShippingByOrder(PedidosEntity orderEntity) {
        return shippingRepository.getShippingByOrder(orderEntity);
    }

    public EnviosEntity saveShipping(EnviosEntity shippingEntity) {
        return shippingRepository.saveShipping(shippingEntity);
    }

    public boolean deleteShippingById(Integer id) {
        return shippingRepository.deleteShippingById(id);
    }
}
