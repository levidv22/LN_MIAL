package ln.mial.ecommerce.app.repository;

import ln.mial.ecommerce.infraestructure.entity.CategoriasEntity;

public interface CategoriasRepository {
    // especifica métodos que interctuan con las varibles del entity
    Iterable<CategoriasEntity> getCategories();
    CategoriasEntity getCategoryById(Integer id);
    CategoriasEntity saveCategory(CategoriasEntity categoriesEntity);
    boolean deleteCategoryById(Integer id);
}
