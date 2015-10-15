package co.edu.uniandes.csw.marketplace.converters;

import co.edu.uniandes.csw.marketplace.dtos.PermisoDTO;
import co.edu.uniandes.csw.marketplace.entities.PermisoEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * @generated
 */
public abstract class PermisoConverter {

    /**
     * @generated
     */
    private PermisoConverter() {
    }

    /**
     * @param entity
     * @return
     * @generated
     */
    public static PermisoDTO refEntity2DTO(PermisoEntity entity) {
        if (entity != null) {
            PermisoDTO dto = new PermisoDTO();
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
    public static PermisoEntity refDTO2Entity(PermisoDTO dto) {
        if (dto != null) {
            PermisoEntity entity = new PermisoEntity();
            entity.setId(dto.getId());

            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    private static PermisoDTO basicEntity2DTO(PermisoEntity entity) {
        if (entity != null) {
            PermisoDTO dto = new PermisoDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setUrl(entity.getUrl());
            dto.setMetodoRest(entity.getMetodoRest());

            return dto;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    private static PermisoEntity basicDTO2Entity(PermisoDTO dto) {
        if (dto != null) {
            PermisoEntity entity = new PermisoEntity();
            entity.setId(dto.getId());
            entity.setName(dto.getName());
            entity.setUrl(dto.getUrl());
            entity.setMetodoRest(dto.getMetodoRest());

            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    public static PermisoDTO fullEntity2DTO(PermisoEntity entity) {
        if (entity != null) {
            PermisoDTO dto = basicEntity2DTO(entity);
            dto.setRoles(RolConverter.listEntity2DTO(entity.getRoles()));
            return dto;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    public static PermisoEntity fullDTO2Entity(PermisoDTO dto) {
        if (dto != null) {
            PermisoEntity entity = basicDTO2Entity(dto);
            entity.setRoles(RolConverter.listDTO2Entity(dto.getRoles()));
            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */

    public static List<PermisoDTO> listEntity2DTO(List<PermisoEntity> entities) {
        List<PermisoDTO> dtos = new ArrayList<PermisoDTO>();
        if (entities != null) {
            for (PermisoEntity entity : entities) {
                dtos.add(basicEntity2DTO(entity));
            }
        }
        return dtos;
    }

    /**
     * @generated
     */
    public static List<PermisoEntity> listDTO2Entity(List<PermisoDTO> dtos) {
        List<PermisoEntity> entities = new ArrayList<PermisoEntity>();
        if (dtos != null) {
            for (PermisoDTO dto : dtos) {
                entities.add(basicDTO2Entity(dto));
            }
        }
        return entities;
    }

}
