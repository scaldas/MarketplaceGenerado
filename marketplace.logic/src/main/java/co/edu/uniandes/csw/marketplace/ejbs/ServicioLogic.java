package co.edu.uniandes.csw.marketplace.ejbs;

import co.edu.uniandes.csw.marketplace.api.IServicioLogic;
import co.edu.uniandes.csw.marketplace.converters.ServicioConverter;
import co.edu.uniandes.csw.marketplace.dtos.ServicioDTO;
import co.edu.uniandes.csw.marketplace.entities.ServicioEntity;
import co.edu.uniandes.csw.marketplace.persistence.ServicioPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * @generated
 */
@Stateless
public class ServicioLogic implements IServicioLogic {

    @Inject private ServicioPersistence persistence;

    /**
     * @generated
     */
    public int countServicios() {
        return persistence.count();
    }

    /**
     * @generated
     */
    public List<ServicioDTO> getServicios(Integer page, Integer maxRecords) {
        return ServicioConverter.listEntity2DTO(persistence.findAll(page, maxRecords));
    }

    /**
     * @generated
     */
    public ServicioDTO getServicio(Long id) {
        return ServicioConverter.fullEntity2DTO(persistence.find(id));
    }

    /**
     * @generated
     */
    public ServicioDTO createServicio(ServicioDTO dto) {
        ServicioEntity entity = ServicioConverter.fullDTO2Entity(dto);
        persistence.create(entity);
        return ServicioConverter.fullEntity2DTO(entity);
    }

    /**
     * @generated
     */
    public ServicioDTO updateServicio(ServicioDTO dto) {
        ServicioEntity entity = persistence.update(ServicioConverter.fullDTO2Entity(dto));
        return ServicioConverter.fullEntity2DTO(entity);
    }

    /**
     * @generated
     */
    public void deleteServicio(Long id) {
        persistence.delete(id);
    }

    /**
     * @generated
     */
    public List<ServicioDTO> findByName(String name) {
        return ServicioConverter.listEntity2DTO(persistence.findByName(name));
    }
}
