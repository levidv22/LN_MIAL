package ln.mial.ecommerce.infraestructure.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "detalle_pedido")
public class DetallePedidosEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private Integer quantity; // Catidad
    private BigDecimal price; // Precio

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private PedidosEntity order;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private ProductosEntity product;

    public DetallePedidosEntity() {
    }

    public DetallePedidosEntity(Integer id, Integer quantity, BigDecimal price, PedidosEntity order, ProductosEntity product) {
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.order = order;
        this.product = product;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public PedidosEntity getOrder() {
        return order;
    }

    public void setOrder(PedidosEntity order) {
        this.order = order;
    }

    public ProductosEntity getProduct() {
        return product;
    }

    public void setProduct(ProductosEntity product) {
        this.product = product;
    }
}
