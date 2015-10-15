package co.edu.uniandes.csw.marketplace.ejbs;

import co.edu.uniandes.csw.marketplace.api.IUsuarioLogic;
import co.edu.uniandes.csw.marketplace.converters.UsuarioConverter;
import co.edu.uniandes.csw.marketplace.dtos.UsuarioDTO;
import co.edu.uniandes.csw.marketplace.entities.UsuarioEntity;
import co.edu.uniandes.csw.marketplace.persistence.UsuarioPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * @generated
 */
@Stateless
public class UsuarioLogic implements IUsuarioLogic {

    @Inject private UsuarioPersistence persistence;

    /**
     * @generated
     */
    public int countUsuarios() {
        return persistence.count();
    }

    /**
     * @generated
     */
    public List<UsuarioDTO> getUsuarios(Integer page, Integer maxRecords) {
        return UsuarioConverter.listEntity2DTO(persistence.findAll(page, maxRecords));
    }

    /**
     * @generated
     */
    public UsuarioDTO getUsuario(Long id) {
        return UsuarioConverter.fullEntity2DTO(persistence.find(id));
    }

    /**
     * @generated
     */
    public UsuarioDTO createUsuario(UsuarioDTO dto) {
        UsuarioEntity entity = UsuarioConverter.fullDTO2Entity(dto);
        persistence.create(entity);
        return UsuarioConverter.fullEntity2DTO(entity);
    }

    /**
     * @generated
     */
    public UsuarioDTO updateUsuario(UsuarioDTO dto) {
        UsuarioEntity entity = persistence.update(UsuarioConverter.fullDTO2Entity(dto));
        return UsuarioConverter.fullEntity2DTO(entity);
    }

    /**
     * @generated
     */
    public void deleteUsuario(Long id) {
        persistence.delete(id);
    }

    /**
     * @generated
     */
    public List<UsuarioDTO> findByName(String name) {
        return UsuarioConverter.listEntity2DTO(persistence.findByName(name));
    }
}
