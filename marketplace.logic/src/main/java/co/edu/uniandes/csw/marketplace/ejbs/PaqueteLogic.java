package co.edu.uniandes.csw.marketplace.ejbs;

import co.edu.uniandes.csw.marketplace.api.IPaqueteLogic;
import co.edu.uniandes.csw.marketplace.converters.PaqueteConverter;
import co.edu.uniandes.csw.marketplace.dtos.PaqueteDTO;
import co.edu.uniandes.csw.marketplace.entities.PaqueteEntity;
import co.edu.uniandes.csw.marketplace.persistence.PaquetePersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * @generated
 */
@Stateless
public class PaqueteLogic implements IPaqueteLogic {

    @Inject private PaquetePersistence persistence;

    /**
     * @generated
     */
    public int countPaquetes() {
        return persistence.count();
    }

    /**
     * @generated
     */
    public List<PaqueteDTO> getPaquetes(Integer page, Integer maxRecords) {
        return PaqueteConverter.listEntity2DTO(persistence.findAll(page, maxRecords));
    }

    /**
     * @generated
     */
    public PaqueteDTO getPaquete(Long id) {
        return PaqueteConverter.fullEntity2DTO(persistence.find(id));
    }

    /**
     * @generated
     */
    public PaqueteDTO createPaquete(PaqueteDTO dto) {
        PaqueteEntity entity = PaqueteConverter.fullDTO2Entity(dto);
        persistence.create(entity);
        return PaqueteConverter.fullEntity2DTO(entity);
    }

    /**
     * @generated
     */
    public PaqueteDTO updatePaquete(PaqueteDTO dto) {
        PaqueteEntity entity = persistence.update(PaqueteConverter.fullDTO2Entity(dto));
        return PaqueteConverter.fullEntity2DTO(entity);
    }

    /**
     * @generated
     */
    public void deletePaquete(Long id) {
        persistence.delete(id);
    }

    /**
     * @generated
     */
    public List<PaqueteDTO> findByName(String name) {
        return PaqueteConverter.listEntity2DTO(persistence.findByName(name));
    }
}
