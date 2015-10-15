package co.edu.uniandes.csw.marketplace.entities;

import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import java.util.List;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;

/**
 * @generated
 */
@Entity
public class ServicioEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "Servicio")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "paquete", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PrecioUnitarioEntity> precios;
    @OneToMany
    private List<PaqueteEntity> paquetes;
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
    public List<PrecioUnitarioEntity> getPrecios() {
        return precios;
    }

    /**
     * @generated
     */
    public void setPrecios(List<PrecioUnitarioEntity> precios) {
        this.precios = precios;
    }

    /**
     * @generated
     */
    public List<PaqueteEntity> getPaquetes() {
        return paquetes;
    }

    /**
     * @generated
     */
    public void setPaquetes(List<PaqueteEntity> paquetes) {
        this.paquetes = paquetes;
    }

}
