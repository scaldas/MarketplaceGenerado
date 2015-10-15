package co.edu.uniandes.csw.marketplace.dtos;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

/**
 * @generated
 */
@XmlRootElement 
public class IVADTO {

    private Double porcentajeIVA;
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date fechaInicioVigencia;
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date fechaFinVigencia;
    private Long id;
    private String name;
    /**
     * @generated
     */
    public Double getPorcentajeIVA() {
        return porcentajeIVA;
    }

    /**
     * @generated
     */
    public void setPorcentajeIVA(Double porcentajeiva) {
        this.porcentajeIVA = porcentajeiva;
    }

    /**
     * @generated
     */
    public Date getFechaInicioVigencia() {
        return fechaInicioVigencia;
    }

    /**
     * @generated
     */
    public void setFechaInicioVigencia(Date fechainiciovigencia) {
        this.fechaInicioVigencia = fechainiciovigencia;
    }

    /**
     * @generated
     */
    public Date getFechaFinVigencia() {
        return fechaFinVigencia;
    }

    /**
     * @generated
     */
    public void setFechaFinVigencia(Date fechafinvigencia) {
        this.fechaFinVigencia = fechafinvigencia;
    }

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

}
