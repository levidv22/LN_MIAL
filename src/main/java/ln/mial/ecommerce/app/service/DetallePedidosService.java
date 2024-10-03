package ln.mial.ecommerce.app.service;

import ln.mial.ecommerce.infraestructure.entity.DetallePedidosEntity;
import ln.mial.ecommerce.infraestructure.entity.PedidosEntity;

import java.util.List;
import ln.mial.ecommerce.app.repository.DetallePedidosRepository;
import ln.mial.ecommerce.infraestructure.entity.UsuariosEntity;

public class DetallePedidosService {

    private final DetallePedidosRepository orderDetailsRepository;

    public DetallePedidosService(DetallePedidosRepository orderDetailsRepository) {
        this.orderDetailsRepository = orderDetailsRepository;
    }

    public List<DetallePedidosEntity> getOrderDetails() {
        return orderDetailsRepository.getOrderDetails();
    }

    public DetallePedidosEntity getOrderDetailById(Integer id) {
        return orderDetailsRepository.getOrderDetailById(id);
    }

    public List<DetallePedidosEntity> getOrderDetailsByOrder(PedidosEntity orderEntity) {
        return orderDetailsRepository.getOrderDetailsByOrder(orderEntity);
    }

    public DetallePedidosEntity saveOrderDetail(DetallePedidosEntity orderDetailsEntity) {
        return orderDetailsRepository.saveOrderDetail(orderDetailsEntity);
    }

    public boolean deleteOrderDetailById(Integer id) {
        return orderDetailsRepository.deleteOrderDetailById(id);
    }
}
