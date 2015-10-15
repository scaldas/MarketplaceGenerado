package co.edu.uniandes.csw.marketplace.converters;

import co.edu.uniandes.csw.marketplace.dtos.RolDTO;
import co.edu.uniandes.csw.marketplace.entities.RolEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * @generated
 */
public abstract class RolConverter {

    /**
     * @generated
     */
    private RolConverter() {
    }

    /**
     * @param entity
     * @return
     * @generated
     */
    public static RolDTO refEntity2DTO(RolEntity entity) {
        if (entity != null) {
            RolDTO dto = new RolDTO();
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
    public static RolEntity refDTO2Entity(RolDTO dto) {
        if (dto != null) {
            RolEntity entity = new RolEntity();
            entity.setId(dto.getId());

            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    private static RolDTO basicEntity2DTO(RolEntity entity) {
        if (entity != null) {
            RolDTO dto = new RolDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());

            return dto;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    private static RolEntity basicDTO2Entity(RolDTO dto) {
        if (dto != null) {
            RolEntity entity = new RolEntity();
            entity.setId(dto.getId());
            entity.setName(dto.getName());

            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    public static RolDTO fullEntity2DTO(RolEntity entity) {
        if (entity != null) {
            RolDTO dto = basicEntity2DTO(entity);
            dto.setPermisos(PermisoConverter.listEntity2DTO(entity.getPermisos()));
            dto.setUsuarios(UsuarioConverter.listEntity2DTO(entity.getUsuarios()));
            return dto;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    public static RolEntity fullDTO2Entity(RolDTO dto) {
        if (dto != null) {
            RolEntity entity = basicDTO2Entity(dto);
            entity.setPermisos(PermisoConverter.listDTO2Entity(dto.getPermisos()));
            entity.setUsuarios(UsuarioConverter.listDTO2Entity(dto.getUsuarios()));
            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */

    public static List<RolDTO> listEntity2DTO(List<RolEntity> entities) {
        List<RolDTO> dtos = new ArrayList<RolDTO>();
        if (entities != null) {
            for (RolEntity entity : entities) {
                dtos.add(basicEntity2DTO(entity));
            }
        }
        return dtos;
    }

    /**
     * @generated
     */
    public static List<RolEntity> listDTO2Entity(List<RolDTO> dtos) {
        List<RolEntity> entities = new ArrayList<RolEntity>();
        if (dtos != null) {
            for (RolDTO dto : dtos) {
                entities.add(basicDTO2Entity(dto));
            }
        }
        return entities;
    }

}
