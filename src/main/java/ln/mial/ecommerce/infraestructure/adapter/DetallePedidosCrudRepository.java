package ln.mial.ecommerce.infraestructure.adapter;

import ln.mial.ecommerce.infraestructure.entity.DetallePedidosEntity;
import ln.mial.ecommerce.infraestructure.entity.PedidosEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import ln.mial.ecommerce.infraestructure.entity.UsuariosEntity;

public interface DetallePedidosCrudRepository extends CrudRepository<DetallePedidosEntity, Integer> {
    List<DetallePedidosEntity> findByOrder(PedidosEntity orderEntity);
}
