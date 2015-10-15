package co.edu.uniandes.csw.marketplace.entities;

import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.ManyToOne;

/**
 * @generated
 */
@Entity
public class OrdenEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "Orden")
    private Long id;

    private String name;

    private Boolean manejoCreditoConsumo;

    private Boolean manejoCreditoComercial;

    private Boolean manejoCreditoLibranza;

    private Boolean manejoCreditoHipotecario;

    private Boolean manejoMicrocredito;

    @Temporal(TemporalType.DATE)
    private Date fechaRegistroOrden;

    @Temporal(TemporalType.DATE)
    private Date fechaInicioFacturacion;

    private Integer estadoOrden;

    private String idCoreCartera;

    private String usuarioCoreCartera;

    private String urlCoreCartera;

    private Integer numeroUsuariosInicial;

    private Integer numeroCreditosInicial;

    private Integer valorCarteraInicial;

    @ManyToOne
    private EmpresaEntity empresa;
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
    public Boolean getManejoCreditoConsumo(){
        return manejoCreditoConsumo;
    }

    /**
     * @generated
     */
    public void setManejoCreditoConsumo(Boolean manejoCreditoConsumo){
        this.manejoCreditoConsumo = manejoCreditoConsumo;
    }

    /**
     * @generated
     */
    public Boolean getManejoCreditoComercial(){
        return manejoCreditoComercial;
    }

    /**
     * @generated
     */
    public void setManejoCreditoComercial(Boolean manejoCreditoComercial){
        this.manejoCreditoComercial = manejoCreditoComercial;
    }

    /**
     * @generated
     */
    public Boolean getManejoCreditoLibranza(){
        return manejoCreditoLibranza;
    }

    /**
     * @generated
     */
    public void setManejoCreditoLibranza(Boolean manejoCreditoLibranza){
        this.manejoCreditoLibranza = manejoCreditoLibranza;
    }

    /**
     * @generated
     */
    public Boolean getManejoCreditoHipotecario(){
        return manejoCreditoHipotecario;
    }

    /**
     * @generated
     */
    public void setManejoCreditoHipotecario(Boolean manejoCreditoHipotecario){
        this.manejoCreditoHipotecario = manejoCreditoHipotecario;
    }

    /**
     * @generated
     */
    public Boolean getManejoMicrocredito(){
        return manejoMicrocredito;
    }

    /**
     * @generated
     */
    public void setManejoMicrocredito(Boolean manejoMicrocredito){
        this.manejoMicrocredito = manejoMicrocredito;
    }

    /**
     * @generated
     */
    public Date getFechaRegistroOrden(){
        return fechaRegistroOrden;
    }

    /**
     * @generated
     */
    public void setFechaRegistroOrden(Date fechaRegistroOrden){
        this.fechaRegistroOrden = fechaRegistroOrden;
    }

    /**
     * @generated
     */
    public Date getFechaInicioFacturacion(){
        return fechaInicioFacturacion;
    }

    /**
     * @generated
     */
    public void setFechaInicioFacturacion(Date fechaInicioFacturacion){
        this.fechaInicioFacturacion = fechaInicioFacturacion;
    }

    /**
     * @generated
     */
    public Integer getEstadoOrden(){
        return estadoOrden;
    }

    /**
     * @generated
     */
    public void setEstadoOrden(Integer estadoOrden){
        this.estadoOrden = estadoOrden;
    }

    /**
     * @generated
     */
    public String getIdCoreCartera(){
        return idCoreCartera;
    }

    /**
     * @generated
     */
    public void setIdCoreCartera(String idCoreCartera){
        this.idCoreCartera = idCoreCartera;
    }

    /**
     * @generated
     */
    public String getUsuarioCoreCartera(){
        return usuarioCoreCartera;
    }

    /**
     * @generated
     */
    public void setUsuarioCoreCartera(String usuarioCoreCartera){
        this.usuarioCoreCartera = usuarioCoreCartera;
    }

    /**
     * @generated
     */
    public String getUrlCoreCartera(){
        return urlCoreCartera;
    }

    /**
     * @generated
     */
    public void setUrlCoreCartera(String urlCoreCartera){
        this.urlCoreCartera = urlCoreCartera;
    }

    /**
     * @generated
     */
    public Integer getNumeroUsuariosInicial(){
        return numeroUsuariosInicial;
    }

    /**
     * @generated
     */
    public void setNumeroUsuariosInicial(Integer numeroUsuariosInicial){
        this.numeroUsuariosInicial = numeroUsuariosInicial;
    }

    /**
     * @generated
     */
    public Integer getNumeroCreditosInicial(){
        return numeroCreditosInicial;
    }

    /**
     * @generated
     */
    public void setNumeroCreditosInicial(Integer numeroCreditosInicial){
        this.numeroCreditosInicial = numeroCreditosInicial;
    }

    /**
     * @generated
     */
    public Integer getValorCarteraInicial(){
        return valorCarteraInicial;
    }

    /**
     * @generated
     */
    public void setValorCarteraInicial(Integer valorCarteraInicial){
        this.valorCarteraInicial = valorCarteraInicial;
    }

    /**
     * @generated
     */
    public EmpresaEntity getEmpresa() {
        return empresa;
    }

    /**
     * @generated
     */
    public void setEmpresa(EmpresaEntity empresa) {
        this.empresa = empresa;
    }

}
