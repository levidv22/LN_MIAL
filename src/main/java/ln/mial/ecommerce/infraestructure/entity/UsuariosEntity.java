package ln.mial.ecommerce.infraestructure.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "usuario")
public class UsuariosEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String username;
    private String email;
    private String cellphone;
    private String password;
    private LocalDateTime dateCreated;
    @Enumerated(EnumType.STRING)
    private TypeUser typeUser;   
    
    public UsuariosEntity() {
    }

    public UsuariosEntity(Integer id, String username, String email, String cellphone, String password, LocalDateTime dateCreated, TypeUser typeUser) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.cellphone = cellphone;
        this.password = password;
        this.dateCreated = dateCreated;
        this.typeUser = typeUser;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public TypeUser getTypeUser() {
        return typeUser;
    }

    public void setTypeUser(TypeUser typeUser) {
        this.typeUser = typeUser;
    }
}
