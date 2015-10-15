package co.edu.uniandes.csw.marketplace.dtos;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

/**
 * @generated
 */
@XmlRootElement 
public class PrecioUnitarioDTO {

    private Long id;
    private String name;
    private Double precioUnidad;
    private Integer rangoInicial;
    private Integer rangoFinal;
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date fechaInicioValidez;
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date fechaFinValidez;
    private ServicioDTO paquete;
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
    public Double getPrecioUnidad() {
        return precioUnidad;
    }

    /**
     * @generated
     */
    public void setPrecioUnidad(Double preciounidad) {
        this.precioUnidad = preciounidad;
    }

    /**
     * @generated
     */
    public Integer getRangoInicial() {
        return rangoInicial;
    }

    /**
     * @generated
     */
    public void setRangoInicial(Integer rangoinicial) {
        this.rangoInicial = rangoinicial;
    }

    /**
     * @generated
     */
    public Integer getRangoFinal() {
        return rangoFinal;
    }

    /**
     * @generated
     */
    public void setRangoFinal(Integer rangofinal) {
        this.rangoFinal = rangofinal;
    }

    /**
     * @generated
     */
    public Date getFechaInicioValidez() {
        return fechaInicioValidez;
    }

    /**
     * @generated
     */
    public void setFechaInicioValidez(Date fechainiciovalidez) {
        this.fechaInicioValidez = fechainiciovalidez;
    }

    /**
     * @generated
     */
    public Date getFechaFinValidez() {
        return fechaFinValidez;
    }

    /**
     * @generated
     */
    public void setFechaFinValidez(Date fechafinvalidez) {
        this.fechaFinValidez = fechafinvalidez;
    }

    /**
     * @generated
     */
    public ServicioDTO getPaquete() {
        return paquete;
    }

    /**
     * @generated
     */
    public void setPaquete(ServicioDTO paquete) {
        this.paquete = paquete;
    }

}
