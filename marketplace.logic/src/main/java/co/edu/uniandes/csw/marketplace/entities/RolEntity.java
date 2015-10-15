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
public class RolEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "Rol")
    private Long id;

    private String name;

    @OneToMany
    private List<PermisoEntity> permisos;
    @OneToMany
    private List<UsuarioEntity> usuarios;
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
    public List<PermisoEntity> getPermisos() {
        return permisos;
    }

    /**
     * @generated
     */
    public void setPermisos(List<PermisoEntity> permisos) {
        this.permisos = permisos;
    }

    /**
     * @generated
     */
    public List<UsuarioEntity> getUsuarios() {
        return usuarios;
    }

    /**
     * @generated
     */
    public void setUsuarios(List<UsuarioEntity> usuarios) {
        this.usuarios = usuarios;
    }

}
