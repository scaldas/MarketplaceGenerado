package co.edu.uniandes.csw.marketplace.dtos;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @generated
 */
@XmlRootElement 
public class PaqueteDTO {

    private Long id;
    private String name;
    private String descripcion;
    private Boolean activo;
    private List<OrdenDTO> ordenes;
    private List<ServicioDTO> servicios;
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
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @generated
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @generated
     */
    public Boolean getActivo() {
        return activo;
    }

    /**
     * @generated
     */
    public void setActivo(Boolean activo) {
        this.activo = activo;
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

    /**
     * @generated
     */
    public List<ServicioDTO> getServicios() {
        return servicios;
    }

    /**
     * @generated
     */
    public void setServicios(List<ServicioDTO> servicios) {
        this.servicios = servicios;
    }

}
