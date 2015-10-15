package co.edu.uniandes.csw.marketplace.converters;

import co.edu.uniandes.csw.marketplace.dtos.UsuarioDTO;
import co.edu.uniandes.csw.marketplace.entities.UsuarioEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * @generated
 */
public abstract class UsuarioConverter {

    /**
     * @generated
     */
    private UsuarioConverter() {
    }

    /**
     * @param entity
     * @return
     * @generated
     */
    public static UsuarioDTO refEntity2DTO(UsuarioEntity entity) {
        if (entity != null) {
            UsuarioDTO dto = new UsuarioDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());

            return dto;
        } else {
            return null;
        }
    }

    /**
     * @param dto
     * @return
     * @generated
     */
    public static UsuarioEntity refDTO2Entity(UsuarioDTO dto) {
        if (dto != null) {
            UsuarioEntity entity = new UsuarioEntity();
            entity.setId(dto.getId());

            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    private static UsuarioDTO basicEntity2DTO(UsuarioEntity entity) {
        if (entity != null) {
            UsuarioDTO dto = new UsuarioDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setCorreoElectronico(entity.getCorreoElectronico());
            dto.setContrasenia(entity.getContrasenia());
            dto.setCargo(entity.getCargo());
            dto.setNombresContacto(entity.getNombresContacto());
            dto.setApellidosContacto(entity.getApellidosContacto());

            return dto;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    private static UsuarioEntity basicDTO2Entity(UsuarioDTO dto) {
        if (dto != null) {
            UsuarioEntity entity = new UsuarioEntity();
            entity.setId(dto.getId());
            entity.setName(dto.getName());
            entity.setCorreoElectronico(dto.getCorreoElectronico());
            entity.setContrasenia(dto.getContrasenia());
            entity.setCargo(dto.getCargo());
            entity.setNombresContacto(dto.getNombresContacto());
            entity.setApellidosContacto(dto.getApellidosContacto());

            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    public static UsuarioDTO fullEntity2DTO(UsuarioEntity entity) {
        if (entity != null) {
            UsuarioDTO dto = basicEntity2DTO(entity);
            dto.setRoles(RolConverter.listEntity2DTO(entity.getRoles()));
            dto.setEmpresas(EmpresaConverter.listEntity2DTO(entity.getEmpresas()));
            return dto;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    public static UsuarioEntity fullDTO2Entity(UsuarioDTO dto) {
        if (dto != null) {
            UsuarioEntity entity = basicDTO2Entity(dto);
            entity.setRoles(RolConverter.listDTO2Entity(dto.getRoles()));
            entity.setEmpresas(EmpresaConverter.childListDTO2Entity(dto.getEmpresas(), entity));
            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */

    public static List<UsuarioDTO> listEntity2DTO(List<UsuarioEntity> entities) {
        List<UsuarioDTO> dtos = new ArrayList<UsuarioDTO>();
        if (entities != null) {
            for (UsuarioEntity entity : entities) {
                dtos.add(basicEntity2DTO(entity));
            }
        }
        return dtos;
    }

    /**
     * @generated
     */
    public static List<UsuarioEntity> listDTO2Entity(List<UsuarioDTO> dtos) {
        List<UsuarioEntity> entities = new ArrayList<UsuarioEntity>();
        if (dtos != null) {
            for (UsuarioDTO dto : dtos) {
                entities.add(basicDTO2Entity(dto));
            }
        }
        return entities;
    }

}
