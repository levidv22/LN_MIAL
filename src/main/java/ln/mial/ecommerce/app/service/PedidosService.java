package ln.mial.ecommerce.app.service;

import ln.mial.ecommerce.infraestructure.entity.PedidosEntity;
import ln.mial.ecommerce.infraestructure.entity.UsuariosEntity;
import java.util.List;
import ln.mial.ecommerce.app.repository.PedidosRepository;
import ln.mial.ecommerce.infraestructure.entity.StatusPedido;

public class PedidosService {

    private final PedidosRepository orderRepository;

    public PedidosService(PedidosRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<PedidosEntity> getOrders() {
        return orderRepository.getOrders();
    }

    public PedidosEntity getOrderById(Integer id) {
        return orderRepository.getOrderById(id);
    }

    public List<PedidosEntity> getOrdersByUser(UsuariosEntity userEntity) {
        return orderRepository.getOrdersByUser(userEntity);
    }

    public PedidosEntity saveOrder(PedidosEntity ordersEntity) {
        return orderRepository.saveOrder(ordersEntity);
    }

    public boolean deleteOrderById(Integer id) {
        return orderRepository.deleteOrderById(id);
    }

    public void updateOrderStatus(PedidosEntity order, StatusPedido status) {
        order.setStatusPedido(status);
        saveOrder(order);
    }
    
    public List<PedidosEntity> getOrdersByStatus(StatusPedido status) {
        return orderRepository.getOrdersByStatus(status);
    }

    public List<PedidosEntity> getOrdersByUserAndStatus(UsuariosEntity userEntity, StatusPedido status) {
        return orderRepository.getOrdersByUserAndStatus(userEntity, status);
    }

}
