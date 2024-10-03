package ln.mial.ecommerce.app.repository;

import ln.mial.ecommerce.infraestructure.entity.PagosEntity;
import ln.mial.ecommerce.infraestructure.entity.PedidosEntity;

import java.util.List;
import ln.mial.ecommerce.infraestructure.entity.UsuariosEntity;

public interface PagosRepository {
    List<PagosEntity> getPayments();
    PagosEntity getPaymentById(Integer id);
    List<PagosEntity> getPaymentsByOrder(PedidosEntity orderEntity);
    PagosEntity savePayment(PagosEntity paymentsEntity);
    List<PagosEntity> findAllByOrderUser(UsuariosEntity user);
    boolean deletePaymentById(Integer id);
}
