package ln.mial.ecommerce.infraestructure.adapter;

import jakarta.transaction.Transactional;
import ln.mial.ecommerce.infraestructure.entity.PagosEntity;
import ln.mial.ecommerce.infraestructure.entity.PedidosEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import ln.mial.ecommerce.app.repository.PagosRepository;
import ln.mial.ecommerce.infraestructure.entity.UsuariosEntity;

@Repository
public class PagosRepositoryImpl implements PagosRepository {
    private final PagosCrudRepository paymentCrudRepository;

    public PagosRepositoryImpl(PagosCrudRepository paymentCrudRepository) {
        this.paymentCrudRepository = paymentCrudRepository;
    }

    @Override
    public List<PagosEntity> getPayments() {
        return (List<PagosEntity>) paymentCrudRepository.findAll();
    }

    @Override
    public PagosEntity getPaymentById(Integer id) {
        return paymentCrudRepository.findById(id).orElse(null);
    }

    @Override
    public List<PagosEntity> getPaymentsByOrder(PedidosEntity orderEntity) {
        return paymentCrudRepository.findByOrder(orderEntity);
    }

    @Override
    public PagosEntity savePayment(PagosEntity paymentsEntity) {
        return paymentCrudRepository.save(paymentsEntity);
    }
    
    @Override
    public List<PagosEntity> findAllByOrderUser(UsuariosEntity user){
        return paymentCrudRepository.findAllByOrderUser(user);
    }

    @Override
    @Transactional
    public boolean deletePaymentById(Integer id) {
        paymentCrudRepository.deleteById(id);
        return true;
    }
}
