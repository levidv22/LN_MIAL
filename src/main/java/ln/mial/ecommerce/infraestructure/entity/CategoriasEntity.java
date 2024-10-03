package ln.mial.ecommerce.infraestructure.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "categoria")
public class CategoriasEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String name; // Nombre de la categoría
    
    @Enumerated(EnumType.STRING)
    private StatusCategoria statusCategoria; // Activo o Inactivo
    
    

    public CategoriasEntity() {
    }

    public CategoriasEntity(Integer id, String name, StatusCategoria statusCategoria) {
        this.id = id;
        this.name = name;
        this.statusCategoria = statusCategoria;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StatusCategoria getStatusCategoria() {
        return statusCategoria;
    }

    public void setStatusCategoria(StatusCategoria statusCategoria) {
        this.statusCategoria = statusCategoria;
    }

    
}
