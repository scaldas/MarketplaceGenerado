package co.edu.uniandes.csw.marketplace.ejbs;

import co.edu.uniandes.csw.marketplace.api.IPermisoLogic;
import co.edu.uniandes.csw.marketplace.converters.PermisoConverter;
import co.edu.uniandes.csw.marketplace.dtos.PermisoDTO;
import co.edu.uniandes.csw.marketplace.entities.PermisoEntity;
import co.edu.uniandes.csw.marketplace.persistence.PermisoPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * @generated
 */
@Stateless
public class PermisoLogic implements IPermisoLogic {

    @Inject private PermisoPersistence persistence;

    /**
     * @generated
     */
    public int countPermisos() {
        return persistence.count();
    }

    /**
     * @generated
     */
    public List<PermisoDTO> getPermisos(Integer page, Integer maxRecords) {
        return PermisoConverter.listEntity2DTO(persistence.findAll(page, maxRecords));
    }

    /**
     * @generated
     */
    public PermisoDTO getPermiso(Long id) {
        return PermisoConverter.fullEntity2DTO(persistence.find(id));
    }

    /**
     * @generated
     */
    public PermisoDTO createPermiso(PermisoDTO dto) {
        PermisoEntity entity = PermisoConverter.fullDTO2Entity(dto);
        persistence.create(entity);
        return PermisoConverter.fullEntity2DTO(entity);
    }

    /**
     * @generated
     */
    public PermisoDTO updatePermiso(PermisoDTO dto) {
        PermisoEntity entity = persistence.update(PermisoConverter.fullDTO2Entity(dto));
        return PermisoConverter.fullEntity2DTO(entity);
    }

    /**
     * @generated
     */
    public void deletePermiso(Long id) {
        persistence.delete(id);
    }

    /**
     * @generated
     */
    public List<PermisoDTO> findByName(String name) {
        return PermisoConverter.listEntity2DTO(persistence.findByName(name));
    }
}
