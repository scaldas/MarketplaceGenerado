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
public class PrecioUnitarioEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "PrecioUnitario")
    private Long id;

    private String name;

    private Double precioUnidad;

    private Integer rangoInicial;

    private Integer rangoFinal;

    @Temporal(TemporalType.DATE)
    private Date fechaInicioValidez;

    @Temporal(TemporalType.DATE)
    private Date fechaFinValidez;

    @ManyToOne
    private ServicioEntity paquete;
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
    public Double getPrecioUnidad(){
        return precioUnidad;
    }

    /**
     * @generated
     */
    public void setPrecioUnidad(Double precioUnidad){
        this.precioUnidad = precioUnidad;
    }

    /**
     * @generated
     */
    public Integer getRangoInicial(){
        return rangoInicial;
    }

    /**
     * @generated
     */
    public void setRangoInicial(Integer rangoInicial){
        this.rangoInicial = rangoInicial;
    }

    /**
     * @generated
     */
    public Integer getRangoFinal(){
        return rangoFinal;
    }

    /**
     * @generated
     */
    public void setRangoFinal(Integer rangoFinal){
        this.rangoFinal = rangoFinal;
    }

    /**
     * @generated
     */
    public Date getFechaInicioValidez(){
        return fechaInicioValidez;
    }

    /**
     * @generated
     */
    public void setFechaInicioValidez(Date fechaInicioValidez){
        this.fechaInicioValidez = fechaInicioValidez;
    }

    /**
     * @generated
     */
    public Date getFechaFinValidez(){
        return fechaFinValidez;
    }

    /**
     * @generated
     */
    public void setFechaFinValidez(Date fechaFinValidez){
        this.fechaFinValidez = fechaFinValidez;
    }

    /**
     * @generated
     */
    public ServicioEntity getPaquete() {
        return paquete;
    }

    /**
     * @generated
     */
    public void setPaquete(ServicioEntity paquete) {
        this.paquete = paquete;
    }

}
