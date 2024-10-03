package ln.mial.ecommerce.app.service;

import ln.mial.ecommerce.infraestructure.entity.PagosEntity;
import ln.mial.ecommerce.infraestructure.entity.PedidosEntity;

import java.util.List;
import ln.mial.ecommerce.app.repository.PagosRepository;
import ln.mial.ecommerce.infraestructure.entity.UsuariosEntity;

public class PagosService {

    private final PagosRepository paymentRepository;

    public PagosService(PagosRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public List<PagosEntity> getPayments() {
        return paymentRepository.getPayments();
    }

    public PagosEntity getPaymentById(Integer id) {
        return paymentRepository.getPaymentById(id);
    }

    public List<PagosEntity> getPaymentsByOrder(PedidosEntity orderEntity) {
        return paymentRepository.getPaymentsByOrder(orderEntity);
    }

    public PagosEntity savePayment(PagosEntity paymentsEntity) {
        return paymentRepository.savePayment(paymentsEntity);
    }

    public List<PagosEntity> getPagosByUser(UsuariosEntity user) {
        return paymentRepository.findAllByOrderUser(user);
    }

    public boolean deletePaymentById(Integer id) {
        return paymentRepository.deletePaymentById(id);
    }
}
