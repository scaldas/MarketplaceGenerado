package co.edu.uniandes.csw.marketplace.dtos;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @generated
 */
@XmlRootElement 
public class PermisoDTO {

    private Long id;
    private String name;
    private String url;
    private String metodoRest;
    private List<RolDTO> roles;
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
    public String getUrl() {
        return url;
    }

    /**
     * @generated
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @generated
     */
    public String getMetodoRest() {
        return metodoRest;
    }

    /**
     * @generated
     */
    public void setMetodoRest(String metodorest) {
        this.metodoRest = metodorest;
    }

    /**
     * @generated
     */
    public List<RolDTO> getRoles() {
        return roles;
    }

    /**
     * @generated
     */
    public void setRoles(List<RolDTO> roles) {
        this.roles = roles;
    }

}
