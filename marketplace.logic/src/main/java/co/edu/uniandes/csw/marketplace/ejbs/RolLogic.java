package co.edu.uniandes.csw.marketplace.ejbs;

import co.edu.uniandes.csw.marketplace.api.IRolLogic;
import co.edu.uniandes.csw.marketplace.converters.RolConverter;
import co.edu.uniandes.csw.marketplace.dtos.RolDTO;
import co.edu.uniandes.csw.marketplace.entities.RolEntity;
import co.edu.uniandes.csw.marketplace.persistence.RolPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * @generated
 */
@Stateless
public class RolLogic implements IRolLogic {

    @Inject private RolPersistence persistence;

    /**
     * @generated
     */
    public int countRols() {
        return persistence.count();
    }

    /**
     * @generated
     */
    public List<RolDTO> getRols(Integer page, Integer maxRecords) {
        return RolConverter.listEntity2DTO(persistence.findAll(page, maxRecords));
    }

    /**
     * @generated
     */
    public RolDTO getRol(Long id) {
        return RolConverter.fullEntity2DTO(persistence.find(id));
    }

    /**
     * @generated
     */
    public RolDTO createRol(RolDTO dto) {
        RolEntity entity = RolConverter.fullDTO2Entity(dto);
        persistence.create(entity);
        return RolConverter.fullEntity2DTO(entity);
    }

    /**
     * @generated
     */
    public RolDTO updateRol(RolDTO dto) {
        RolEntity entity = persistence.update(RolConverter.fullDTO2Entity(dto));
        return RolConverter.fullEntity2DTO(entity);
    }

    /**
     * @generated
     */
    public void deleteRol(Long id) {
        persistence.delete(id);
    }

    /**
     * @generated
     */
    public List<RolDTO> findByName(String name) {
        return RolConverter.listEntity2DTO(persistence.findByName(name));
    }
}
