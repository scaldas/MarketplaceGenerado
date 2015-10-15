package co.edu.uniandes.csw.marketplace.ejbs;

import co.edu.uniandes.csw.marketplace.api.IOrdenLogic;
import co.edu.uniandes.csw.marketplace.converters.OrdenConverter;
import co.edu.uniandes.csw.marketplace.dtos.OrdenDTO;
import co.edu.uniandes.csw.marketplace.entities.OrdenEntity;
import co.edu.uniandes.csw.marketplace.persistence.OrdenPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * @generated
 */
@Stateless
public class OrdenLogic implements IOrdenLogic {

    @Inject private OrdenPersistence persistence;

    /**
     * @generated
     */
    public int countOrdens() {
        return persistence.count();
    }

    /**
     * @generated
     */
    public List<OrdenDTO> getOrdens(Integer page, Integer maxRecords) {
        return OrdenConverter.listEntity2DTO(persistence.findAll(page, maxRecords));
    }

    /**
     * @generated
     */
    public OrdenDTO getOrden(Long id) {
        return OrdenConverter.fullEntity2DTO(persistence.find(id));
    }

    /**
     * @generated
     */
    public OrdenDTO createOrden(OrdenDTO dto) {
        OrdenEntity entity = OrdenConverter.fullDTO2Entity(dto);
        persistence.create(entity);
        return OrdenConverter.fullEntity2DTO(entity);
    }

    /**
     * @generated
     */
    public OrdenDTO updateOrden(OrdenDTO dto) {
        OrdenEntity entity = persistence.update(OrdenConverter.fullDTO2Entity(dto));
        return OrdenConverter.fullEntity2DTO(entity);
    }

    /**
     * @generated
     */
    public void deleteOrden(Long id) {
        persistence.delete(id);
    }

    /**
     * @generated
     */
    public List<OrdenDTO> findByName(String name) {
        return OrdenConverter.listEntity2DTO(persistence.findByName(name));
    }
}
