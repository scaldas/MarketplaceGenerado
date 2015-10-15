package co.edu.uniandes.csw.marketplace.ejbs;

import co.edu.uniandes.csw.marketplace.api.IEmpresaLogic;
import co.edu.uniandes.csw.marketplace.converters.EmpresaConverter;
import co.edu.uniandes.csw.marketplace.dtos.EmpresaDTO;
import co.edu.uniandes.csw.marketplace.entities.EmpresaEntity;
import co.edu.uniandes.csw.marketplace.persistence.EmpresaPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * @generated
 */
@Stateless
public class EmpresaLogic implements IEmpresaLogic {

    @Inject private EmpresaPersistence persistence;

    /**
     * @generated
     */
    public int countEmpresas() {
        return persistence.count();
    }

    /**
     * @generated
     */
    public List<EmpresaDTO> getEmpresas(Integer page, Integer maxRecords) {
        return EmpresaConverter.listEntity2DTO(persistence.findAll(page, maxRecords));
    }

    /**
     * @generated
     */
    public EmpresaDTO getEmpresa(Long id) {
        return EmpresaConverter.fullEntity2DTO(persistence.find(id));
    }

    /**
     * @generated
     */
    public EmpresaDTO createEmpresa(EmpresaDTO dto) {
        EmpresaEntity entity = EmpresaConverter.fullDTO2Entity(dto);
        persistence.create(entity);
        return EmpresaConverter.fullEntity2DTO(entity);
    }

    /**
     * @generated
     */
    public EmpresaDTO updateEmpresa(EmpresaDTO dto) {
        EmpresaEntity entity = persistence.update(EmpresaConverter.fullDTO2Entity(dto));
        return EmpresaConverter.fullEntity2DTO(entity);
    }

    /**
     * @generated
     */
    public void deleteEmpresa(Long id) {
        persistence.delete(id);
    }

    /**
     * @generated
     */
    public List<EmpresaDTO> findByName(String name) {
        return EmpresaConverter.listEntity2DTO(persistence.findByName(name));
    }
}
