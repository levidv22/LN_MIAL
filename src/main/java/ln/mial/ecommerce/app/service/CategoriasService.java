package ln.mial.ecommerce.app.service;

import ln.mial.ecommerce.infraestructure.entity.CategoriasEntity;
import ln.mial.ecommerce.app.repository.CategoriasRepository;

public class CategoriasService {
    private final CategoriasRepository categoryRepository;
    
    //se conecta con el repository y permite que se pueda guardar, eliminar y editar

    public CategoriasService(CategoriasRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Iterable<CategoriasEntity> getCategories() {
        return categoryRepository.getCategories();
    }

    public CategoriasEntity getCategoryById(Integer id) {
        return categoryRepository.getCategoryById(id);
    }

    public CategoriasEntity saveCategory(CategoriasEntity categoriesEntity) {
        return categoryRepository.saveCategory(categoriesEntity);
    }

    public boolean deleteCategoryById(Integer id) {
        return categoryRepository.deleteCategoryById(id);
    }
}

