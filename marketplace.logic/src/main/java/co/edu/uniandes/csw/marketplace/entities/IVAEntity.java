package co.edu.uniandes.csw.marketplace.entities;

import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @generated
 */
@Entity
public class IVAEntity implements Serializable {

    private Double porcentajeIVA;

    @Temporal(TemporalType.DATE)
    private Date fechaInicioVigencia;

    @Temporal(TemporalType.DATE)
    private Date fechaFinVigencia;

    @Id
    @GeneratedValue(generator = "IVA")
    private Long id;

    private String name;

    /**
     * @generated
     */
    public Double getPorcentajeIVA(){
        return porcentajeIVA;
    }

    /**
     * @generated
     */
    public void setPorcentajeIVA(Double porcentajeIVA){
        this.porcentajeIVA = porcentajeIVA;
    }

    /**
     * @generated
     */
    public Date getFechaInicioVigencia(){
        return fechaInicioVigencia;
    }

    /**
     * @generated
     */
    public void setFechaInicioVigencia(Date fechaInicioVigencia){
        this.fechaInicioVigencia = fechaInicioVigencia;
    }

    /**
     * @generated
     */
    public Date getFechaFinVigencia(){
        return fechaFinVigencia;
    }

    /**
     * @generated
     */
    public void setFechaFinVigencia(Date fechaFinVigencia){
        this.fechaFinVigencia = fechaFinVigencia;
    }

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

}
