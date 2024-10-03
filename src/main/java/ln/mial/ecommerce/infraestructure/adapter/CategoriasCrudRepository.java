package ln.mial.ecommerce.infraestructure.adapter;

import ln.mial.ecommerce.infraestructure.entity.CategoriasEntity;
import org.springframework.data.repository.CrudRepository;

public interface CategoriasCrudRepository extends CrudRepository<CategoriasEntity, Integer> {
}
