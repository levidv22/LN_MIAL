package ln.mial.ecommerce.app.service;

import ln.mial.ecommerce.infraestructure.entity.CalificacionProductosEntity;
import ln.mial.ecommerce.infraestructure.entity.ProductosEntity;
import ln.mial.ecommerce.infraestructure.entity.UsuariosEntity;

import java.util.List;
import ln.mial.ecommerce.app.repository.CalificacionProductosRepository;

public class CalificacionProductosService {
    private final CalificacionProductosRepository reviewRepository;

    public CalificacionProductosService(CalificacionProductosRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<CalificacionProductosEntity> getReviews() {
        return reviewRepository.getReviews();
    }

    public CalificacionProductosEntity getReviewById(Integer id) {
        return reviewRepository.getReviewById(id);
    }

    public List<CalificacionProductosEntity> getReviewsByProduct(ProductosEntity productEntity) {
        return reviewRepository.getReviewsByProduct(productEntity);
    }

    public List<CalificacionProductosEntity> getReviewsByUser(UsuariosEntity userEntity) {
        return reviewRepository.getReviewsByUser(userEntity);
    }

    public CalificacionProductosEntity saveReview(CalificacionProductosEntity reviewsEntity) {
        return reviewRepository.saveReview(reviewsEntity);
    }

    public boolean deleteReviewById(Integer id) {
        return reviewRepository.deleteReviewById(id);
    }
}
