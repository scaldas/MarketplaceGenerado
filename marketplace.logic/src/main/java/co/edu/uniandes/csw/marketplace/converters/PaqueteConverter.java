package co.edu.uniandes.csw.marketplace.converters;

import co.edu.uniandes.csw.marketplace.dtos.PaqueteDTO;
import co.edu.uniandes.csw.marketplace.entities.PaqueteEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * @generated
 */
public abstract class PaqueteConverter {

    /**
     * @generated
     */
    private PaqueteConverter() {
    }

    /**
     * @param entity
     * @return
     * @generated
     */
    public static PaqueteDTO refEntity2DTO(PaqueteEntity entity) {
        if (entity != null) {
            PaqueteDTO dto = new PaqueteDTO();
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
    public static PaqueteEntity refDTO2Entity(PaqueteDTO dto) {
        if (dto != null) {
            PaqueteEntity entity = new PaqueteEntity();
            entity.setId(dto.getId());

            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    private static PaqueteDTO basicEntity2DTO(PaqueteEntity entity) {
        if (entity != null) {
            PaqueteDTO dto = new PaqueteDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setDescripcion(entity.getDescripcion());
            dto.setActivo(entity.getActivo());

            return dto;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    private static PaqueteEntity basicDTO2Entity(PaqueteDTO dto) {
        if (dto != null) {
            PaqueteEntity entity = new PaqueteEntity();
            entity.setId(dto.getId());
            entity.setName(dto.getName());
            entity.setDescripcion(dto.getDescripcion());
            entity.setActivo(dto.getActivo());

            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    public static PaqueteDTO fullEntity2DTO(PaqueteEntity entity) {
        if (entity != null) {
            PaqueteDTO dto = basicEntity2DTO(entity);
            dto.setOrdenes(OrdenConverter.listEntity2DTO(entity.getOrdenes()));
            dto.setServicios(ServicioConverter.listEntity2DTO(entity.getServicios()));
            return dto;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    public static PaqueteEntity fullDTO2Entity(PaqueteDTO dto) {
        if (dto != null) {
            PaqueteEntity entity = basicDTO2Entity(dto);
            entity.setOrdenes(OrdenConverter.listDTO2Entity(dto.getOrdenes()));
            entity.setServicios(ServicioConverter.listDTO2Entity(dto.getServicios()));
            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */

    public static List<PaqueteDTO> listEntity2DTO(List<PaqueteEntity> entities) {
        List<PaqueteDTO> dtos = new ArrayList<PaqueteDTO>();
        if (entities != null) {
            for (PaqueteEntity entity : entities) {
                dtos.add(basicEntity2DTO(entity));
            }
        }
        return dtos;
    }

    /**
     * @generated
     */
    public static List<PaqueteEntity> listDTO2Entity(List<PaqueteDTO> dtos) {
        List<PaqueteEntity> entities = new ArrayList<PaqueteEntity>();
        if (dtos != null) {
            for (PaqueteDTO dto : dtos) {
                entities.add(basicDTO2Entity(dto));
            }
        }
        return entities;
    }

}
