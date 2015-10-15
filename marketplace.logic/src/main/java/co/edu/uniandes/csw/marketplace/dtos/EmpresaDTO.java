package co.edu.uniandes.csw.marketplace.dtos;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @generated
 */
@XmlRootElement 
public class EmpresaDTO {

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
    private UsuarioDTO usuario;
    private List<OrdenDTO> ordenes;
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
    public String getNit() {
        return nit;
    }

    /**
     * @generated
     */
    public void setNit(String nit) {
        this.nit = nit;
    }

    /**
     * @generated
     */
    public Integer getActividadEconomica() {
        return actividadEconomica;
    }

    /**
     * @generated
     */
    public void setActividadEconomica(Integer actividadeconomica) {
        this.actividadEconomica = actividadeconomica;
    }

    /**
     * @generated
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @generated
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @generated
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * @generated
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * @generated
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @generated
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @generated
     */
    public String getFax() {
        return fax;
    }

    /**
     * @generated
     */
    public void setFax(String fax) {
        this.fax = fax;
    }

    /**
     * @generated
     */
    public String getPaginaWeb() {
        return paginaWeb;
    }

    /**
     * @generated
     */
    public void setPaginaWeb(String paginaweb) {
        this.paginaWeb = paginaweb;
    }

    /**
     * @generated
     */
    public String getNombresRepresentateLegal() {
        return nombresRepresentateLegal;
    }

    /**
     * @generated
     */
    public void setNombresRepresentateLegal(String nombresrepresentatelegal) {
        this.nombresRepresentateLegal = nombresrepresentatelegal;
    }

    /**
     * @generated
     */
    public String getApellidosRepresentanteLegal() {
        return apellidosRepresentanteLegal;
    }

    /**
     * @generated
     */
    public void setApellidosRepresentanteLegal(String apellidosrepresentantelegal) {
        this.apellidosRepresentanteLegal = apellidosrepresentantelegal;
    }

    /**
     * @generated
     */
    public String getTipoEmpresa() {
        return tipoEmpresa;
    }

    /**
     * @generated
     */
    public void setTipoEmpresa(String tipoempresa) {
        this.tipoEmpresa = tipoempresa;
    }

    /**
     * @generated
     */
    public Boolean getVigiladaSuperfinanciera() {
        return vigiladaSuperfinanciera;
    }

    /**
     * @generated
     */
    public void setVigiladaSuperfinanciera(Boolean vigiladasuperfinanciera) {
        this.vigiladaSuperfinanciera = vigiladasuperfinanciera;
    }

    /**
     * @generated
     */
    public Boolean getVigiliadaSupersolidaria() {
        return vigiliadaSupersolidaria;
    }

    /**
     * @generated
     */
    public void setVigiliadaSupersolidaria(Boolean vigiliadasupersolidaria) {
        this.vigiliadaSupersolidaria = vigiliadasupersolidaria;
    }

    /**
     * @generated
     */
    public UsuarioDTO getUsuario() {
        return usuario;
    }

    /**
     * @generated
     */
    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

    /**
     * @generated
     */
    public List<OrdenDTO> getOrdenes() {
        return ordenes;
    }

    /**
     * @generated
     */
    public void setOrdenes(List<OrdenDTO> ordenes) {
        this.ordenes = ordenes;
    }

}
