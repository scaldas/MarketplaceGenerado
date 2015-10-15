package co.edu.uniandes.csw.marketplace.entities;

import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import java.util.List;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;

/**
 * @generated
 */
@Entity
public class UsuarioEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "Usuario")
    private Long id;

    private String name;

    private String correoElectronico;

    private String contrasenia;

    private String cargo;

    private String nombresContacto;

    private String apellidosContacto;

    @OneToMany
    private List<RolEntity> roles;
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EmpresaEntity> empresas;
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
    public String getCorreoElectronico(){
        return correoElectronico;
    }

    /**
     * @generated
     */
    public void setCorreoElectronico(String correoElectronico){
        this.correoElectronico = correoElectronico;
    }

    /**
     * @generated
     */
    public String getContrasenia(){
        return contrasenia;
    }

    /**
     * @generated
     */
    public void setContrasenia(String contrasenia){
        this.contrasenia = contrasenia;
    }

    /**
     * @generated
     */
    public String getCargo(){
        return cargo;
    }

    /**
     * @generated
     */
    public void setCargo(String cargo){
        this.cargo = cargo;
    }

    /**
     * @generated
     */
    public String getNombresContacto(){
        return nombresContacto;
    }

    /**
     * @generated
     */
    public void setNombresContacto(String nombresContacto){
        this.nombresContacto = nombresContacto;
    }

    /**
     * @generated
     */
    public String getApellidosContacto(){
        return apellidosContacto;
    }

    /**
     * @generated
     */
    public void setApellidosContacto(String apellidosContacto){
        this.apellidosContacto = apellidosContacto;
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

    /**
     * @generated
     */
    public List<EmpresaEntity> getEmpresas() {
        return empresas;
    }

    /**
     * @generated
     */
    public void setEmpresas(List<EmpresaEntity> empresas) {
        this.empresas = empresas;
    }

}
