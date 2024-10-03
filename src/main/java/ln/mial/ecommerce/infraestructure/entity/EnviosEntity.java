package ln.mial.ecommerce.infraestructure.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "envio")
public class EnviosEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String shippingMethod; // Método de envío
    private LocalDateTime shippingDate; // Fecha de envío
    private String shippingStatus; // En camino, Entregado.
    private LocalDateTime estimatedDeliveryDate; // Fecha estimada de entreg

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private PedidosEntity order;

    public EnviosEntity() {
    }

    public EnviosEntity(Integer id, String shippingMethod, LocalDateTime shippingDate, String shippingStatus, LocalDateTime estimatedDeliveryDate, PedidosEntity order) {
        this.id = id;
        this.shippingMethod = shippingMethod;
        this.shippingDate = shippingDate;
        this.shippingStatus = shippingStatus;
        this.estimatedDeliveryDate = estimatedDeliveryDate;
        this.order = order;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(String shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    public LocalDateTime getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(LocalDateTime shippingDate) {
        this.shippingDate = shippingDate;
    }

    public PedidosEntity getOrder() {
        return order;
    }

    public void setOrder(PedidosEntity order) {
        this.order = order;
    }

    public String getShippingStatus() {
        return shippingStatus;
    }

    public void setShippingStatus(String shippingStatus) {
        this.shippingStatus = shippingStatus;
    }

    public LocalDateTime getEstimatedDeliveryDate() {
        return estimatedDeliveryDate;
    }

    public void setEstimatedDeliveryDate(LocalDateTime estimatedDeliveryDate) {
        this.estimatedDeliveryDate = estimatedDeliveryDate;
    }

    
}
