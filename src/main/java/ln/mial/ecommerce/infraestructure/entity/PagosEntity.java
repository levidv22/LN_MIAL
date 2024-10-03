package ln.mial.ecommerce.infraestructure.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "pago")
public class PagosEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
   
    private BigDecimal amount; // monto
    private LocalDateTime paymentDate; // fecha de pago
    private String imagePago;
    
    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private PedidosEntity order;

    public PagosEntity() {
    }

    public PagosEntity(Integer id, BigDecimal amount, LocalDateTime paymentDate, String imagePago, PedidosEntity order) {
        this.id = id;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.imagePago = imagePago;
        this.order = order;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }

    public PedidosEntity getOrder() {
        return order;
    }

    public void setOrder(PedidosEntity order) {
        this.order = order;
    }

    public String getImagePago() {
        return imagePago;
    }

    public void setImagePago(String imagePago) {
        this.imagePago = imagePago;
    }
    
    
    
}

