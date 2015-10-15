package co.edu.uniandes.csw.marketplace.dtos;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @generated
 */
@XmlRootElement 
public class RolDTO {

    private Long id;
    private String name;
    private List<PermisoDTO> permisos;
    private List<UsuarioDTO> usuarios;
    /**
     * @generated
     */
    public Long getId() {
        return id;
    }

    /**
     * @generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @generated
     */
    public String getName() {
        return name;
    }

    /**
     * @generated
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @generated
     */
    public List<PermisoDTO> getPermisos() {
        return permisos;
    }

    /**
     * @generated
     */
    public void setPermisos(List<PermisoDTO> permisos) {
        this.permisos = permisos;
    }

    /**
     * @generated
     */
    public List<UsuarioDTO> getUsuarios() {
        return usuarios;
    }

    /**
     * @generated
     */
    public void setUsuarios(List<UsuarioDTO> usuarios) {
        this.usuarios = usuarios;
    }

}
