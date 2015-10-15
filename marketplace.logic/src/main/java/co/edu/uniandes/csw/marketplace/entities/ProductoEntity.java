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
public class ProductoEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "Producto")
    private Long id;

    private String name;

    private String descripcion;

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
