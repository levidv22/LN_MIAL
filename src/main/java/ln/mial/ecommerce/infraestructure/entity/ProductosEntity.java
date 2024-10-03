package ln.mial.ecommerce.infraestructure.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "producto")
public class ProductosEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String code;
    private String name;
    private String description;
    private String image;
    private BigDecimal price;    
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;
    
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private UsuariosEntity userEntity;
    
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private CategoriasEntity category;
    
    @OneToMany(mappedBy = "product", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<DetallePedidosEntity> detallePedidos; // Detalles del pedido

    @OneToMany(mappedBy = "productosEntity", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<AlmacenEntity> almacen; // Entradas en Almacen
    
    @Transient // Esto indica que este campo no se persistirá en la base de datos
    private Integer balance;

    public ProductosEntity() {
    }

    public ProductosEntity(Integer id, String code, String name, String description, String image, BigDecimal price, LocalDateTime dateCreated, LocalDateTime dateUpdated, UsuariosEntity userEntity, CategoriasEntity category, List<DetallePedidosEntity> detallePedidos, List<AlmacenEntity> almacen, Integer balance) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.description = description;
        this.image = image;
        this.price = price;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
        this.userEntity = userEntity;
        this.category = category;
        this.detallePedidos = detallePedidos;
        this.almacen = almacen;
        this.balance = balance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDateTime getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(LocalDateTime dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public UsuariosEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UsuariosEntity userEntity) {
        this.userEntity = userEntity;
    }
    
    public CategoriasEntity getCategory() {
        return category;
    }

    public void setCategory(CategoriasEntity category) {
        this.category = category;
    }

    public List<DetallePedidosEntity> getDetallePedidos() {
        return detallePedidos;
    }

    public void setDetallePedidos(List<DetallePedidosEntity> detallePedidos) {
        this.detallePedidos = detallePedidos;
    }

    public List<AlmacenEntity> getAlmacen() {
        return almacen;
    }

    public void setAlmacen(List<AlmacenEntity> almacen) {
        this.almacen = almacen;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    
}
