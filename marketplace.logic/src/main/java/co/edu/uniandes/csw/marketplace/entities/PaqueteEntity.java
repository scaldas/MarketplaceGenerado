package co.edu.uniandes.csw.marketplace.entities;

import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import java.util.List;
import javax.persistence.OneToMany;

/**
 * @generated
 */
@Entity
public class PaqueteEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "Paquete")
    private Long id;

    private String name;

    private String descripcion;

    private Boolean activo;

    @OneToMany
    private List<OrdenEntity> ordenes;
    @OneToMany
    private List<ServicioEntity> servicios;
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
    public String getDescripcion(){
        return descripcion;
    }

    /**
     * @generated
     */
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }

    /**
     * @generated
     */
    public Boolean getActivo(){
        return activo;
    }

    /**
     * @generated
     */
    public void setActivo(Boolean activo){
        this.activo = activo;
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

    /**
     * @generated
     */
    public List<ServicioEntity> getServicios() {
        return servicios;
    }

    /**
     * @generated
     */
    public void setServicios(List<ServicioEntity> servicios) {
        this.servicios = servicios;
    }

}
