package co.edu.uniandes.csw.marketplace.dtos;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

/**
 * @generated
 */
@XmlRootElement 
public class OrdenDTO {

    private Long id;
    private String name;
    private Boolean manejoCreditoConsumo;
    private Boolean manejoCreditoComercial;
    private Boolean manejoCreditoLibranza;
    private Boolean manejoCreditoHipotecario;
    private Boolean manejoMicrocredito;
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date fechaRegistroOrden;
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date fechaInicioFacturacion;
    private Integer estadoOrden;
    private String idCoreCartera;
    private String usuarioCoreCartera;
    private String urlCoreCartera;
    private Integer numeroUsuariosInicial;
    private Integer numeroCreditosInicial;
    private Integer valorCarteraInicial;
    private EmpresaDTO empresa;
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
    public Boolean getManejoCreditoConsumo() {
        return manejoCreditoConsumo;
    }

    /**
     * @generated
     */
    public void setManejoCreditoConsumo(Boolean manejocreditoconsumo) {
        this.manejoCreditoConsumo = manejocreditoconsumo;
    }

    /**
     * @generated
     */
    public Boolean getManejoCreditoComercial() {
        return manejoCreditoComercial;
    }

    /**
     * @generated
     */
    public void setManejoCreditoComercial(Boolean manejocreditocomercial) {
        this.manejoCreditoComercial = manejocreditocomercial;
    }

    /**
     * @generated
     */
    public Boolean getManejoCreditoLibranza() {
        return manejoCreditoLibranza;
    }

    /**
     * @generated
     */
    public void setManejoCreditoLibranza(Boolean manejocreditolibranza) {
        this.manejoCreditoLibranza = manejocreditolibranza;
    }

    /**
     * @generated
     */
    public Boolean getManejoCreditoHipotecario() {
        return manejoCreditoHipotecario;
    }

    /**
     * @generated
     */
    public void setManejoCreditoHipotecario(Boolean manejocreditohipotecario) {
        this.manejoCreditoHipotecario = manejocreditohipotecario;
    }

    /**
     * @generated
     */
    public Boolean getManejoMicrocredito() {
        return manejoMicrocredito;
    }

    /**
     * @generated
     */
    public void setManejoMicrocredito(Boolean manejomicrocredito) {
        this.manejoMicrocredito = manejomicrocredito;
    }

    /**
     * @generated
     */
    public Date getFechaRegistroOrden() {
        return fechaRegistroOrden;
    }

    /**
     * @generated
     */
    public void setFechaRegistroOrden(Date fecharegistroorden) {
        this.fechaRegistroOrden = fecharegistroorden;
    }

    /**
     * @generated
     */
    public Date getFechaInicioFacturacion() {
        return fechaInicioFacturacion;
    }

    /**
     * @generated
     */
    public void setFechaInicioFacturacion(Date fechainiciofacturacion) {
        this.fechaInicioFacturacion = fechainiciofacturacion;
    }

    /**
     * @generated
     */
    public Integer getEstadoOrden() {
        return estadoOrden;
    }

    /**
     * @generated
     */
    public void setEstadoOrden(Integer estadoorden) {
        this.estadoOrden = estadoorden;
    }

    /**
     * @generated
     */
    public String getIdCoreCartera() {
        return idCoreCartera;
    }

    /**
     * @generated
     */
    public void setIdCoreCartera(String idcorecartera) {
        this.idCoreCartera = idcorecartera;
    }

    /**
     * @generated
     */
    public String getUsuarioCoreCartera() {
        return usuarioCoreCartera;
    }

    /**
     * @generated
     */
    public void setUsuarioCoreCartera(String usuariocorecartera) {
        this.usuarioCoreCartera = usuariocorecartera;
    }

    /**
     * @generated
     */
    public String getUrlCoreCartera() {
        return urlCoreCartera;
    }

    /**
     * @generated
     */
    public void setUrlCoreCartera(String urlcorecartera) {
        this.urlCoreCartera = urlcorecartera;
    }

    /**
     * @generated
     */
    public Integer getNumeroUsuariosInicial() {
        return numeroUsuariosInicial;
    }

    /**
     * @generated
     */
    public void setNumeroUsuariosInicial(Integer numerousuariosinicial) {
        this.numeroUsuariosInicial = numerousuariosinicial;
    }

    /**
     * @generated
     */
    public Integer getNumeroCreditosInicial() {
        return numeroCreditosInicial;
    }

    /**
     * @generated
     */
    public void setNumeroCreditosInicial(Integer numerocreditosinicial) {
        this.numeroCreditosInicial = numerocreditosinicial;
    }

    /**
     * @generated
     */
    public Integer getValorCarteraInicial() {
        return valorCarteraInicial;
    }

    /**
     * @generated
     */
    public void setValorCarteraInicial(Integer valorcarterainicial) {
        this.valorCarteraInicial = valorcarterainicial;
    }

    /**
     * @generated
     */
    public EmpresaDTO getEmpresa() {
        return empresa;
    }

    /**
     * @generated
     */
    public void setEmpresa(EmpresaDTO empresa) {
        this.empresa = empresa;
    }

}
