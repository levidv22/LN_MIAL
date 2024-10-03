package ln.mial.ecommerce.infraestructure.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "clasif_pro")
public class CalificacionProductosEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String reviewText; // Texto de la opinión
    private Integer rating; // Limitar entre 1-5
    private LocalDateTime reviewDate; // Fecha de la reseña

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private ProductosEntity product;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private UsuariosEntity user;

    public CalificacionProductosEntity() {
    }

    public CalificacionProductosEntity(Integer id, String reviewText, Integer rating, LocalDateTime reviewDate, ProductosEntity product, UsuariosEntity user) {
        this.id = id;
        this.reviewText = reviewText;
        this.rating = rating;
        this.reviewDate = reviewDate;
        this.product = product;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public ProductosEntity getProduct() {
        return product;
    }

    public void setProduct(ProductosEntity product) {
        this.product = product;
    }

    public UsuariosEntity getUser() {
        return user;
    }

    public void setUser(UsuariosEntity user) {
        this.user = user;
    }

    public LocalDateTime getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(LocalDateTime reviewDate) {
        this.reviewDate = reviewDate;
    }
   
}
