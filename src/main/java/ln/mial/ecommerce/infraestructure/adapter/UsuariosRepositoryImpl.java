package ln.mial.ecommerce.infraestructure.adapter;

import ln.mial.ecommerce.infraestructure.entity.UsuariosEntity;
import org.springframework.stereotype.Repository;
import ln.mial.ecommerce.app.repository.UsuariosRepository;

@Repository
public class UsuariosRepositoryImpl implements UsuariosRepository{
    
    private final UsuariosCrudRepository userCrudRepository;

    public UsuariosRepositoryImpl(UsuariosCrudRepository userCrudRepository) {
        this.userCrudRepository = userCrudRepository;
    }

    @Override
    public UsuariosEntity createUser(UsuariosEntity userEntity) {
        return userCrudRepository.save(userEntity);
    }

    @Override
    public UsuariosEntity findByEmail(String email) {
     return userCrudRepository.findByEmail(email).orElse(null);
    }

    @Override
    public UsuariosEntity findById(Integer id) {
        return userCrudRepository.findById(id).get();
    }
    
    
    
}
