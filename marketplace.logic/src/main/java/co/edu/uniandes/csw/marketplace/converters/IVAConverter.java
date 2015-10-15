package co.edu.uniandes.csw.marketplace.converters;

import co.edu.uniandes.csw.marketplace.dtos.IVADTO;
import co.edu.uniandes.csw.marketplace.entities.IVAEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * @generated
 */
public abstract class IVAConverter {

    /**
     * @generated
     */
    private IVAConverter() {
    }

    /**
     * @param entity
     * @return
     * @generated
     */
    public static IVADTO refEntity2DTO(IVAEntity entity) {
        if (entity != null) {
            IVADTO dto = new IVADTO();
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
    public static IVAEntity refDTO2Entity(IVADTO dto) {
        if (dto != null) {
            IVAEntity entity = new IVAEntity();
            entity.setId(dto.getId());

            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    private static IVADTO basicEntity2DTO(IVAEntity entity) {
        if (entity != null) {
            IVADTO dto = new IVADTO();
            dto.setPorcentajeIVA(entity.getPorcentajeIVA());
            dto.setFechaInicioVigencia(entity.getFechaInicioVigencia());
            dto.setFechaFinVigencia(entity.getFechaFinVigencia());
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
    private static IVAEntity basicDTO2Entity(IVADTO dto) {
        if (dto != null) {
            IVAEntity entity = new IVAEntity();
            entity.setPorcentajeIVA(dto.getPorcentajeIVA());
            entity.setFechaInicioVigencia(dto.getFechaInicioVigencia());
            entity.setFechaFinVigencia(dto.getFechaFinVigencia());
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
    public static IVADTO fullEntity2DTO(IVAEntity entity) {
        if (entity != null) {
            IVADTO dto = basicEntity2DTO(entity);
            return dto;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    public static IVAEntity fullDTO2Entity(IVADTO dto) {
        if (dto != null) {
            IVAEntity entity = basicDTO2Entity(dto);
            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */

    public static List<IVADTO> listEntity2DTO(List<IVAEntity> entities) {
        List<IVADTO> dtos = new ArrayList<IVADTO>();
        if (entities != null) {
            for (IVAEntity entity : entities) {
                dtos.add(basicEntity2DTO(entity));
            }
        }
        return dtos;
    }

    /**
     * @generated
     */
    public static List<IVAEntity> listDTO2Entity(List<IVADTO> dtos) {
        List<IVAEntity> entities = new ArrayList<IVAEntity>();
        if (dtos != null) {
            for (IVADTO dto : dtos) {
                entities.add(basicDTO2Entity(dto));
            }
        }
        return entities;
    }

}
