package co.edu.uniandes.csw.marketplace.dtos;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @generated
 */
@XmlRootElement 
public class ServicioDTO {

    private Long id;
    private String name;
    private List<PrecioUnitarioDTO> precios;
    private List<PaqueteDTO> paquetes;
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
    public List<PrecioUnitarioDTO> getPrecios() {
        return precios;
    }

    /**
     * @generated
     */
    public void setPrecios(List<PrecioUnitarioDTO> precios) {
        this.precios = precios;
    }

    /**
     * @generated
     */
    public List<PaqueteDTO> getPaquetes() {
        return paquetes;
    }

    /**
     * @generated
     */
    public void setPaquetes(List<PaqueteDTO> paquetes) {
        this.paquetes = paquetes;
    }

}
