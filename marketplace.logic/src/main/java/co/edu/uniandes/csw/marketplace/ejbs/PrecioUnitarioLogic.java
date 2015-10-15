package co.edu.uniandes.csw.marketplace.ejbs;

import co.edu.uniandes.csw.marketplace.api.IPrecioUnitarioLogic;
import co.edu.uniandes.csw.marketplace.converters.PrecioUnitarioConverter;
import co.edu.uniandes.csw.marketplace.dtos.PrecioUnitarioDTO;
import co.edu.uniandes.csw.marketplace.entities.PrecioUnitarioEntity;
import co.edu.uniandes.csw.marketplace.persistence.PrecioUnitarioPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * @generated
 */
@Stateless
public class PrecioUnitarioLogic implements IPrecioUnitarioLogic {

    @Inject private PrecioUnitarioPersistence persistence;

    /**
     * @generated
     */
    public int countPrecioUnitarios() {
        return persistence.count();
    }

    /**
     * @generated
     */
    public List<PrecioUnitarioDTO> getPrecioUnitarios(Integer page, Integer maxRecords) {
        return PrecioUnitarioConverter.listEntity2DTO(persistence.findAll(page, maxRecords));
    }

    /**
     * @generated
     */
    public PrecioUnitarioDTO getPrecioUnitario(Long id) {
        return PrecioUnitarioConverter.fullEntity2DTO(persistence.find(id));
    }

    /**
     * @generated
     */
    public PrecioUnitarioDTO createPrecioUnitario(PrecioUnitarioDTO dto) {
        PrecioUnitarioEntity entity = PrecioUnitarioConverter.fullDTO2Entity(dto);
        persistence.create(entity);
        return PrecioUnitarioConverter.fullEntity2DTO(entity);
    }

    /**
     * @generated
     */
    public PrecioUnitarioDTO updatePrecioUnitario(PrecioUnitarioDTO dto) {
        PrecioUnitarioEntity entity = persistence.update(PrecioUnitarioConverter.fullDTO2Entity(dto));
        return PrecioUnitarioConverter.fullEntity2DTO(entity);
    }

    /**
     * @generated
     */
    public void deletePrecioUnitario(Long id) {
        persistence.delete(id);
    }

    /**
     * @generated
     */
    public List<PrecioUnitarioDTO> findByName(String name) {
        return PrecioUnitarioConverter.listEntity2DTO(persistence.findByName(name));
    }
}
