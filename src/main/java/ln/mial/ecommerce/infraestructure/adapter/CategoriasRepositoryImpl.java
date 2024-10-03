package ln.mial.ecommerce.infraestructure.adapter;

import jakarta.transaction.Transactional;
import ln.mial.ecommerce.infraestructure.entity.CategoriasEntity;
import org.springframework.stereotype.Repository;
import ln.mial.ecommerce.app.repository.CategoriasRepository;

@Repository
public class CategoriasRepositoryImpl implements CategoriasRepository {
    private final CategoriasCrudRepository categoryCrudRepository;

    public CategoriasRepositoryImpl(CategoriasCrudRepository categoryCrudRepository) {
        this.categoryCrudRepository = categoryCrudRepository;
    }

    @Override
    public Iterable<CategoriasEntity> getCategories() {
        return categoryCrudRepository.findAll();
    }

    @Override
    public CategoriasEntity getCategoryById(Integer id) {
        return categoryCrudRepository.findById(id).orElse(null);
    }

    @Override
    public CategoriasEntity saveCategory(CategoriasEntity categoriesEntity) {
        return categoryCrudRepository.save(categoriesEntity);
    }

    @Override
    @Transactional
    public boolean deleteCategoryById(Integer id) {
        categoryCrudRepository.deleteById(id);
        return true;
    }
}
