package ln.mial.ecommerce.infraestructure.adapter;

import jakarta.transaction.Transactional;
import ln.mial.ecommerce.infraestructure.entity.CalificacionProductosEntity;
import ln.mial.ecommerce.infraestructure.entity.ProductosEntity;
import ln.mial.ecommerce.infraestructure.entity.UsuariosEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import ln.mial.ecommerce.app.repository.CalificacionProductosRepository;

@Repository
public class CalificacionProductosRepositoryImpl implements CalificacionProductosRepository {
    private final CalificacionProductosCrudRepository reviewCrudRepository;

    public CalificacionProductosRepositoryImpl(CalificacionProductosCrudRepository reviewCrudRepository) {
        this.reviewCrudRepository = reviewCrudRepository;
    }

    @Override
    public List<CalificacionProductosEntity> getReviews() {
        return (List<CalificacionProductosEntity>) reviewCrudRepository.findAll();
    }

    @Override
    public CalificacionProductosEntity getReviewById(Integer id) {
        return reviewCrudRepository.findById(id).orElse(null);
    }

    @Override
    public List<CalificacionProductosEntity> getReviewsByProduct(ProductosEntity productEntity) {
        return reviewCrudRepository.findByProduct(productEntity);
    }

    @Override
    public List<CalificacionProductosEntity> getReviewsByUser(UsuariosEntity userEntity) {
        return reviewCrudRepository.findByUser(userEntity);
    }

    @Override
    public CalificacionProductosEntity saveReview(CalificacionProductosEntity reviewsEntity) {
        return reviewCrudRepository.save(reviewsEntity);
    }

    @Override
    @Transactional
    public boolean deleteReviewById(Integer id) {
        reviewCrudRepository.deleteById(id);
        return true;
    }
}
