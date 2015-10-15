package co.edu.uniandes.csw.marketplace.converters;

import co.edu.uniandes.csw.marketplace.dtos.ServicioDTO;
import co.edu.uniandes.csw.marketplace.entities.ServicioEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * @generated
 */
public abstract class ServicioConverter {

    /**
     * @generated
     */
    private ServicioConverter() {
    }

    /**
     * @param entity
     * @return
     * @generated
     */
    public static ServicioDTO refEntity2DTO(ServicioEntity entity) {
        if (entity != null) {
            ServicioDTO dto = new ServicioDTO();
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
    public static ServicioEntity refDTO2Entity(ServicioDTO dto) {
        if (dto != null) {
            ServicioEntity entity = new ServicioEntity();
            entity.setId(dto.getId());

            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    private static ServicioDTO basicEntity2DTO(ServicioEntity entity) {
        if (entity != null) {
            ServicioDTO dto = new ServicioDTO();
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
    private static ServicioEntity basicDTO2Entity(ServicioDTO dto) {
        if (dto != null) {
            ServicioEntity entity = new ServicioEntity();
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
    public static ServicioDTO fullEntity2DTO(ServicioEntity entity) {
        if (entity != null) {
            ServicioDTO dto = basicEntity2DTO(entity);
            dto.setPrecios(PrecioUnitarioConverter.listEntity2DTO(entity.getPrecios()));
            dto.setPaquetes(PaqueteConverter.listEntity2DTO(entity.getPaquetes()));
            return dto;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    public static ServicioEntity fullDTO2Entity(ServicioDTO dto) {
        if (dto != null) {
            ServicioEntity entity = basicDTO2Entity(dto);
            entity.setPrecios(PrecioUnitarioConverter.childListDTO2Entity(dto.getPrecios(), entity));
            entity.setPaquetes(PaqueteConverter.listDTO2Entity(dto.getPaquetes()));
            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */

    public static List<ServicioDTO> listEntity2DTO(List<ServicioEntity> entities) {
        List<ServicioDTO> dtos = new ArrayList<ServicioDTO>();
        if (entities != null) {
            for (ServicioEntity entity : entities) {
                dtos.add(basicEntity2DTO(entity));
            }
        }
        return dtos;
    }

    /**
     * @generated
     */
    public static List<ServicioEntity> listDTO2Entity(List<ServicioDTO> dtos) {
        List<ServicioEntity> entities = new ArrayList<ServicioEntity>();
        if (dtos != null) {
            for (ServicioDTO dto : dtos) {
                entities.add(basicDTO2Entity(dto));
            }
        }
        return entities;
    }

}
