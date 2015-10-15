package co.edu.uniandes.csw.marketplace.ejbs;

import co.edu.uniandes.csw.marketplace.api.IIVALogic;
import co.edu.uniandes.csw.marketplace.converters.IVAConverter;
import co.edu.uniandes.csw.marketplace.dtos.IVADTO;
import co.edu.uniandes.csw.marketplace.entities.IVAEntity;
import co.edu.uniandes.csw.marketplace.persistence.IVAPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * @generated
 */
@Stateless
public class IVALogic implements IIVALogic {

    @Inject private IVAPersistence persistence;

    /**
     * @generated
     */
    public int countIVAs() {
        return persistence.count();
    }

    /**
     * @generated
     */
    public List<IVADTO> getIVAs(Integer page, Integer maxRecords) {
        return IVAConverter.listEntity2DTO(persistence.findAll(page, maxRecords));
    }

    /**
     * @generated
     */
    public IVADTO getIVA(Long id) {
        return IVAConverter.fullEntity2DTO(persistence.find(id));
    }

    /**
     * @generated
     */
    public IVADTO createIVA(IVADTO dto) {
        IVAEntity entity = IVAConverter.fullDTO2Entity(dto);
        persistence.create(entity);
        return IVAConverter.fullEntity2DTO(entity);
    }

    /**
     * @generated
     */
    public IVADTO updateIVA(IVADTO dto) {
        IVAEntity entity = persistence.update(IVAConverter.fullDTO2Entity(dto));
        return IVAConverter.fullEntity2DTO(entity);
    }

    /**
     * @generated
     */
    public void deleteIVA(Long id) {
        persistence.delete(id);
    }

    /**
     * @generated
     */
    public List<IVADTO> findByName(String name) {
        return IVAConverter.listEntity2DTO(persistence.findByName(name));
    }
}
