package co.edu.uniandes.csw.marketplace.dtos;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @generated
 */
@XmlRootElement 
public class UsuarioDTO {

    private Long id;
    private String name;
    private String correoElectronico;
    private String contrasenia;
    private String cargo;
    private String nombresContacto;
    private String apellidosContacto;
    private List<RolDTO> roles;
    private List<EmpresaDTO> empresas;
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
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    /**
     * @generated
     */
    public void setCorreoElectronico(String correoelectronico) {
        this.correoElectronico = correoelectronico;
    }

    /**
     * @generated
     */
    public String getContrasenia() {
        return contrasenia;
    }

    /**
     * @generated
     */
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    /**
     * @generated
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * @generated
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    /**
     * @generated
     */
    public String getNombresContacto() {
        return nombresContacto;
    }

    /**
     * @generated
     */
    public void setNombresContacto(String nombrescontacto) {
        this.nombresContacto = nombrescontacto;
    }

    /**
     * @generated
     */
    public String getApellidosContacto() {
        return apellidosContacto;
    }

    /**
     * @generated
     */
    public void setApellidosContacto(String apellidoscontacto) {
        this.apellidosContacto = apellidoscontacto;
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

    /**
     * @generated
     */
    public List<EmpresaDTO> getEmpresas() {
        return empresas;
    }

    /**
     * @generated
     */
    public void setEmpresas(List<EmpresaDTO> empresas) {
        this.empresas = empresas;
    }

}
