package ln.mial.ecommerce.infraestructure.adapter;

import java.util.Optional;
import ln.mial.ecommerce.infraestructure.entity.UsuariosEntity;
import org.springframework.data.repository.CrudRepository;

public interface UsuariosCrudRepository extends CrudRepository<UsuariosEntity, Integer>{
   //METODO ADICIONAL NO TIENE EL CRUD REPOSITORY
    public Optional<UsuariosEntity> findByEmail(String email);
    
}
