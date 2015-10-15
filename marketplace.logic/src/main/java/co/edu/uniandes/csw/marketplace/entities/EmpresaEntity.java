package co.edu.uniandes.csw.marketplace.entities;

import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.List;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;

/**
 * @generated
 */
@Entity
public class EmpresaEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "Empresa")
    private Long id;

    private String name;

    private String nit;

    private Integer actividadEconomica;

    private String direccion;

    private String ciudad;

    private String telefono;

    private String fax;

    private String paginaWeb;

    private String nombresRepresentateLegal;

    private String apellidosRepresentanteLegal;

    private String tipoEmpresa;

    private Boolean vigiladaSuperfinanciera;

    private Boolean vigiliadaSupersolidaria;

    @ManyToOne
    private UsuarioEntity usuario;
    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrdenEntity> ordenes;
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
    public String getNit(){
        return nit;
    }

    /**
     * @generated
     */
    public void setNit(String nit){
        this.nit = nit;
    }

    /**
     * @generated
     */
    public Integer getActividadEconomica(){
        return actividadEconomica;
    }

    /**
     * @generated
     */
    public void setActividadEconomica(Integer actividadEconomica){
        this.actividadEconomica = actividadEconomica;
    }

    /**
     * @generated
     */
    public String getDireccion(){
        return direccion;
    }

    /**
     * @generated
     */
    public void setDireccion(String direccion){
        this.direccion = direccion;
    }

    /**
     * @generated
     */
    public String getCiudad(){
        return ciudad;
    }

    /**
     * @generated
     */
    public void setCiudad(String ciudad){
        this.ciudad = ciudad;
    }

    /**
     * @generated
     */
    public String getTelefono(){
        return telefono;
    }

    /**
     * @generated
     */
    public void setTelefono(String telefono){
        this.telefono = telefono;
    }

    /**
     * @generated
     */
    public String getFax(){
        return fax;
    }

    /**
     * @generated
     */
    public void setFax(String fax){
        this.fax = fax;
    }

    /**
     * @generated
     */
    public String getPaginaWeb(){
        return paginaWeb;
    }

    /**
     * @generated
     */
    public void setPaginaWeb(String paginaWeb){
        this.paginaWeb = paginaWeb;
    }

    /**
     * @generated
     */
    public String getNombresRepresentateLegal(){
        return nombresRepresentateLegal;
    }

    /**
     * @generated
     */
    public void setNombresRepresentateLegal(String nombresRepresentateLegal){
        this.nombresRepresentateLegal = nombresRepresentateLegal;
    }

    /**
     * @generated
     */
    public String getApellidosRepresentanteLegal(){
        return apellidosRepresentanteLegal;
    }

    /**
     * @generated
     */
    public void setApellidosRepresentanteLegal(String apellidosRepresentanteLegal){
        this.apellidosRepresentanteLegal = apellidosRepresentanteLegal;
    }

    /**
     * @generated
     */
    public String getTipoEmpresa(){
        return tipoEmpresa;
    }

    /**
     * @generated
     */
    public void setTipoEmpresa(String tipoEmpresa){
        this.tipoEmpresa = tipoEmpresa;
    }

    /**
     * @generated
     */
    public Boolean getVigiladaSuperfinanciera(){
        return vigiladaSuperfinanciera;
    }

    /**
     * @generated
     */
    public void setVigiladaSuperfinanciera(Boolean vigiladaSuperfinanciera){
        this.vigiladaSuperfinanciera = vigiladaSuperfinanciera;
    }

    /**
     * @generated
     */
    public Boolean getVigiliadaSupersolidaria(){
        return vigiliadaSupersolidaria;
    }

    /**
     * @generated
     */
    public void setVigiliadaSupersolidaria(Boolean vigiliadaSupersolidaria){
        this.vigiliadaSupersolidaria = vigiliadaSupersolidaria;
    }

    /**
     * @generated
     */
    public UsuarioEntity getUsuario() {
        return usuario;
    }

    /**
     * @generated
     */
    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    /**
     * @generated
     */
    public List<OrdenEntity> getOrdenes() {
        return ordenes;
    }

    /**
     * @generated
     */
    public void setOrdenes(List<OrdenEntity> ordenes) {
        this.ordenes = ordenes;
    }

}
