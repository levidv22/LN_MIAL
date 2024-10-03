package ln.mial.ecommerce.infraestructure.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "almacen")
public class AlmacenEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String descripcion;
    private Integer entradas;
    private Integer salidas = 0;
    private Integer balance;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductosEntity productosEntity;

    public AlmacenEntity() {
    }

    public AlmacenEntity(Integer id, String descripcion, Integer entradas, Integer salidas, Integer balance, ProductosEntity productosEntity) {
        this.id = id;
        this.descripcion = descripcion;
        this.entradas = entradas;
        this.salidas = salidas;
        this.balance = balance;
        this.productosEntity = productosEntity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getEntradas() {
        return entradas;
    }

    public void setEntradas(Integer entradas) {
        this.entradas = entradas;
    }

    public Integer getSalidas() {
        return salidas;
    }

    public void setSalidas(Integer salidas) {
        this.salidas = salidas;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public ProductosEntity getProductosEntity() {
        return productosEntity;
    }

    public void setProductosEntity(ProductosEntity productosEntity) {
        this.productosEntity = productosEntity;
    }
    
    
}

