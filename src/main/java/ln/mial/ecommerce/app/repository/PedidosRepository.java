package ln.mial.ecommerce.app.repository;

import ln.mial.ecommerce.infraestructure.entity.PedidosEntity;
import ln.mial.ecommerce.infraestructure.entity.UsuariosEntity;

import java.util.List;
import ln.mial.ecommerce.infraestructure.entity.StatusPedido;

public interface PedidosRepository {
    List<PedidosEntity> getOrders();
    PedidosEntity getOrderById(Integer id);
    List<PedidosEntity> getOrdersByUser(UsuariosEntity userEntity);
    List<PedidosEntity> getOrdersByUserAndStatus(UsuariosEntity userEntity, StatusPedido status);
    PedidosEntity saveOrder(PedidosEntity ordersEntity);
    List<PedidosEntity> getOrdersByStatus(StatusPedido status);
    boolean deleteOrderById(Integer id);
}

