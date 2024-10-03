package ln.mial.ecommerce.infraestructure.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@Entity
@Table(name = "pedido")
public class PedidosEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private LocalDateTime orderDate; // Fecha del pedido
    private BigDecimal totalAmount; // Monto total

    private String shippingAddress; // Dirección de envío del pedido
    
    @Enumerated(EnumType.STRING)
    private StatusPedido statusPedido; // Estado del pedido (En Proceso, Enviado)
    
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private UsuariosEntity user;

    public PedidosEntity() {
    }

    public PedidosEntity(Integer id, LocalDateTime orderDate, BigDecimal totalAmount, String shippingAddress, StatusPedido statusPedido, UsuariosEntity user) {
        this.id = id;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.shippingAddress = shippingAddress;
        this.statusPedido = statusPedido;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public UsuariosEntity getUser() {
        return user;
    }

    public void setUser(UsuariosEntity user) {
        this.user = user;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public StatusPedido getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(StatusPedido statusPedido) {
        this.statusPedido = statusPedido;
    }

    
}
