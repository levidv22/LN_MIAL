package ln.mial.ecommerce.app.repository;

import ln.mial.ecommerce.infraestructure.entity.CalificacionProductosEntity;
import ln.mial.ecommerce.infraestructure.entity.ProductosEntity;
import ln.mial.ecommerce.infraestructure.entity.UsuariosEntity;

import java.util.List;

public interface CalificacionProductosRepository {
    List<CalificacionProductosEntity> getReviews();
    CalificacionProductosEntity getReviewById(Integer id);
    List<CalificacionProductosEntity> getReviewsByProduct(ProductosEntity productEntity);
    List<CalificacionProductosEntity> getReviewsByUser(UsuariosEntity userEntity);
    CalificacionProductosEntity saveReview(CalificacionProductosEntity reviewsEntity);
    boolean deleteReviewById(Integer id);
}

