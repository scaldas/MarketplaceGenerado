package co.edu.uniandes.csw.marketplace.entities;

import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import java.util.List;
import javax.persistence.OneToMany;

/**
 * @generated
 */
@Entity
public class PermisoEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "Permiso")
    private Long id;

    private String name;

    private String url;

    private String metodoRest;

    @OneToMany
    private List<RolEntity> roles;
    /**
     * @generated
     */
    public Long getId(){
        return id;
    }

    /**
     * @generated
     */
    public void setId(Long id){
        this.id = id;
    }

    /**
     * @generated
     */
    public String getName(){
        return name;
    }

    /**
     * @generated
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * @generated
     */
    public String getUrl(){
        return url;
    }

    /**
     * @generated
     */
    public void setUrl(String url){
        this.url = url;
    }

    /**
     * @generated
     */
    public String getMetodoRest(){
        return metodoRest;
    }

    /**
     * @generated
     */
    public void setMetodoRest(String metodoRest){
        this.metodoRest = metodoRest;
    }

    /**
     * @generated
     */
    public List<RolEntity> getRoles() {
        return roles;
    }

    /**
     * @generated
     */
    public void setRoles(List<RolEntity> roles) {
        this.roles = roles;
    }

}
