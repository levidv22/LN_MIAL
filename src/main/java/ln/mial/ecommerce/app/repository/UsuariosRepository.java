package ln.mial.ecommerce.app.repository;

import ln.mial.ecommerce.infraestructure.entity.UsuariosEntity;

public interface UsuariosRepository {
    
    //crear un nuevo usuario
    public UsuariosEntity createUser(UsuariosEntity userEntity);
    public UsuariosEntity findByEmail(String email);
    public UsuariosEntity findById(Integer id);
    
    
}
