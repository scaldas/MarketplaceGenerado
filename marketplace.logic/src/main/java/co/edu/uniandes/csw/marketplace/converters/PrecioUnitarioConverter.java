package co.edu.uniandes.csw.marketplace.converters;

import co.edu.uniandes.csw.marketplace.dtos.PrecioUnitarioDTO;
import co.edu.uniandes.csw.marketplace.entities.PrecioUnitarioEntity;
import java.util.ArrayList;
import java.util.List;
import co.edu.uniandes.csw.marketplace.entities.ServicioEntity;

/**
 * @generated
 */
public abstract class PrecioUnitarioConverter {

    /**
     * @generated
     */
    private PrecioUnitarioConverter() {
    }

    /**
     * @param entity
     * @return
     * @generated
     */
    public static PrecioUnitarioDTO refEntity2DTO(PrecioUnitarioEntity entity) {
        if (entity != null) {
            PrecioUnitarioDTO dto = new PrecioUnitarioDTO();
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
    public static PrecioUnitarioEntity refDTO2Entity(PrecioUnitarioDTO dto) {
        if (dto != null) {
            PrecioUnitarioEntity entity = new PrecioUnitarioEntity();
            entity.setId(dto.getId());

            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    private static PrecioUnitarioDTO basicEntity2DTO(PrecioUnitarioEntity entity) {
        if (entity != null) {
            PrecioUnitarioDTO dto = new PrecioUnitarioDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setPrecioUnidad(entity.getPrecioUnidad());
            dto.setRangoInicial(entity.getRangoInicial());
            dto.setRangoFinal(entity.getRangoFinal());
            dto.setFechaInicioValidez(entity.getFechaInicioValidez());
            dto.setFechaFinValidez(entity.getFechaFinValidez());
            dto.setPaquete(ServicioConverter.refEntity2DTO(entity.getPaquete()));

            return dto;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    private static PrecioUnitarioEntity basicDTO2Entity(PrecioUnitarioDTO dto) {
        if (dto != null) {
            PrecioUnitarioEntity entity = new PrecioUnitarioEntity();
            entity.setId(dto.getId());
            entity.setName(dto.getName());
            entity.setPrecioUnidad(dto.getPrecioUnidad());
            entity.setRangoInicial(dto.getRangoInicial());
            entity.setRangoFinal(dto.getRangoFinal());
            entity.setFechaInicioValidez(dto.getFechaInicioValidez());
            entity.setFechaFinValidez(dto.getFechaFinValidez());
            entity.setPaquete(ServicioConverter.refDTO2Entity(dto.getPaquete()));

            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    public static PrecioUnitarioDTO fullEntity2DTO(PrecioUnitarioEntity entity) {
        if (entity != null) {
            PrecioUnitarioDTO dto = basicEntity2DTO(entity);
            return dto;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    public static PrecioUnitarioEntity fullDTO2Entity(PrecioUnitarioDTO dto) {
        if (dto != null) {
            PrecioUnitarioEntity entity = basicDTO2Entity(dto);
            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */

    public static List<PrecioUnitarioDTO> listEntity2DTO(List<PrecioUnitarioEntity> entities) {
        List<PrecioUnitarioDTO> dtos = new ArrayList<PrecioUnitarioDTO>();
        if (entities != null) {
            for (PrecioUnitarioEntity entity : entities) {
                dtos.add(basicEntity2DTO(entity));
            }
        }
        return dtos;
    }

    /**
     * @generated
     */
    public static List<PrecioUnitarioEntity> listDTO2Entity(List<PrecioUnitarioDTO> dtos) {
        List<PrecioUnitarioEntity> entities = new ArrayList<PrecioUnitarioEntity>();
        if (dtos != null) {
            for (PrecioUnitarioDTO dto : dtos) {
                entities.add(basicDTO2Entity(dto));
            }
        }
        return entities;
    }

    /**
     * @generated
     */
    public static PrecioUnitarioEntity childDTO2Entity(PrecioUnitarioDTO dto, ServicioEntity parent){
        PrecioUnitarioEntity entity = basicDTO2Entity(dto);
        entity.setPaquete(parent);
        return entity;
    }

    /**
     * @generated
     */
    public static List<PrecioUnitarioEntity> childListDTO2Entity(List<PrecioUnitarioDTO> dtos, ServicioEntity parent) {
        List<PrecioUnitarioEntity> entities = new ArrayList<PrecioUnitarioEntity>();
        if (dtos != null) {
            for (PrecioUnitarioDTO dto : dtos) {
                entities.add(childDTO2Entity(dto, parent));
            }
        }
        return entities;
    }
}
