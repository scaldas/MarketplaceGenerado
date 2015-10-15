package co.edu.uniandes.csw.marketplace.converters;

import co.edu.uniandes.csw.marketplace.dtos.ProductoDTO;
import co.edu.uniandes.csw.marketplace.entities.ProductoEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * @generated
 */
public abstract class ProductoConverter {

    /**
     * @generated
     */
    private ProductoConverter() {
    }

    /**
     * @param entity
     * @return
     * @generated
     */
    public static ProductoDTO refEntity2DTO(ProductoEntity entity) {
        if (entity != null) {
            ProductoDTO dto = new ProductoDTO();
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
    public static ProductoEntity refDTO2Entity(ProductoDTO dto) {
        if (dto != null) {
            ProductoEntity entity = new ProductoEntity();
            entity.setId(dto.getId());

            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    private static ProductoDTO basicEntity2DTO(ProductoEntity entity) {
        if (entity != null) {
            ProductoDTO dto = new ProductoDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setDescripcion(entity.getDescripcion());

            return dto;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    private static ProductoEntity basicDTO2Entity(ProductoDTO dto) {
        if (dto != null) {
            ProductoEntity entity = new ProductoEntity();
            entity.setId(dto.getId());
            entity.setName(dto.getName());
            entity.setDescripcion(dto.getDescripcion());

            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    public static ProductoDTO fullEntity2DTO(ProductoEntity entity) {
        if (entity != null) {
            ProductoDTO dto = basicEntity2DTO(entity);
            dto.setServicios(ServicioConverter.listEntity2DTO(entity.getServicios()));
            return dto;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    public static ProductoEntity fullDTO2Entity(ProductoDTO dto) {
        if (dto != null) {
            ProductoEntity entity = basicDTO2Entity(dto);
            entity.setServicios(ServicioConverter.listDTO2Entity(dto.getServicios()));
            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */

    public static List<ProductoDTO> listEntity2DTO(List<ProductoEntity> entities) {
        List<ProductoDTO> dtos = new ArrayList<ProductoDTO>();
        if (entities != null) {
            for (ProductoEntity entity : entities) {
                dtos.add(basicEntity2DTO(entity));
            }
        }
        return dtos;
    }

    /**
     * @generated
     */
    public static List<ProductoEntity> listDTO2Entity(List<ProductoDTO> dtos) {
        List<ProductoEntity> entities = new ArrayList<ProductoEntity>();
        if (dtos != null) {
            for (ProductoDTO dto : dtos) {
                entities.add(basicDTO2Entity(dto));
            }
        }
        return entities;
    }

}
