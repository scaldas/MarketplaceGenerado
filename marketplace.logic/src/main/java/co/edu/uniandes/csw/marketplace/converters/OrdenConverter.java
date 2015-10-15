package co.edu.uniandes.csw.marketplace.converters;

import co.edu.uniandes.csw.marketplace.dtos.OrdenDTO;
import co.edu.uniandes.csw.marketplace.entities.OrdenEntity;
import java.util.ArrayList;
import java.util.List;
import co.edu.uniandes.csw.marketplace.entities.EmpresaEntity;

/**
 * @generated
 */
public abstract class OrdenConverter {

    /**
     * @generated
     */
    private OrdenConverter() {
    }

    /**
     * @param entity
     * @return
     * @generated
     */
    public static OrdenDTO refEntity2DTO(OrdenEntity entity) {
        if (entity != null) {
            OrdenDTO dto = new OrdenDTO();
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
    public static OrdenEntity refDTO2Entity(OrdenDTO dto) {
        if (dto != null) {
            OrdenEntity entity = new OrdenEntity();
            entity.setId(dto.getId());

            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    private static OrdenDTO basicEntity2DTO(OrdenEntity entity) {
        if (entity != null) {
            OrdenDTO dto = new OrdenDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setManejoCreditoConsumo(entity.getManejoCreditoConsumo());
            dto.setManejoCreditoComercial(entity.getManejoCreditoComercial());
            dto.setManejoCreditoLibranza(entity.getManejoCreditoLibranza());
            dto.setManejoCreditoHipotecario(entity.getManejoCreditoHipotecario());
            dto.setManejoMicrocredito(entity.getManejoMicrocredito());
            dto.setFechaRegistroOrden(entity.getFechaRegistroOrden());
            dto.setFechaInicioFacturacion(entity.getFechaInicioFacturacion());
            dto.setEstadoOrden(entity.getEstadoOrden());
            dto.setIdCoreCartera(entity.getIdCoreCartera());
            dto.setUsuarioCoreCartera(entity.getUsuarioCoreCartera());
            dto.setUrlCoreCartera(entity.getUrlCoreCartera());
            dto.setNumeroUsuariosInicial(entity.getNumeroUsuariosInicial());
            dto.setNumeroCreditosInicial(entity.getNumeroCreditosInicial());
            dto.setValorCarteraInicial(entity.getValorCarteraInicial());
            dto.setEmpresa(EmpresaConverter.refEntity2DTO(entity.getEmpresa()));

            return dto;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    private static OrdenEntity basicDTO2Entity(OrdenDTO dto) {
        if (dto != null) {
            OrdenEntity entity = new OrdenEntity();
            entity.setId(dto.getId());
            entity.setName(dto.getName());
            entity.setManejoCreditoConsumo(dto.getManejoCreditoConsumo());
            entity.setManejoCreditoComercial(dto.getManejoCreditoComercial());
            entity.setManejoCreditoLibranza(dto.getManejoCreditoLibranza());
            entity.setManejoCreditoHipotecario(dto.getManejoCreditoHipotecario());
            entity.setManejoMicrocredito(dto.getManejoMicrocredito());
            entity.setFechaRegistroOrden(dto.getFechaRegistroOrden());
            entity.setFechaInicioFacturacion(dto.getFechaInicioFacturacion());
            entity.setEstadoOrden(dto.getEstadoOrden());
            entity.setIdCoreCartera(dto.getIdCoreCartera());
            entity.setUsuarioCoreCartera(dto.getUsuarioCoreCartera());
            entity.setUrlCoreCartera(dto.getUrlCoreCartera());
            entity.setNumeroUsuariosInicial(dto.getNumeroUsuariosInicial());
            entity.setNumeroCreditosInicial(dto.getNumeroCreditosInicial());
            entity.setValorCarteraInicial(dto.getValorCarteraInicial());
            entity.setEmpresa(EmpresaConverter.refDTO2Entity(dto.getEmpresa()));

            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    public static OrdenDTO fullEntity2DTO(OrdenEntity entity) {
        if (entity != null) {
            OrdenDTO dto = basicEntity2DTO(entity);
            return dto;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    public static OrdenEntity fullDTO2Entity(OrdenDTO dto) {
        if (dto != null) {
            OrdenEntity entity = basicDTO2Entity(dto);
            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */

    public static List<OrdenDTO> listEntity2DTO(List<OrdenEntity> entities) {
        List<OrdenDTO> dtos = new ArrayList<OrdenDTO>();
        if (entities != null) {
            for (OrdenEntity entity : entities) {
                dtos.add(basicEntity2DTO(entity));
            }
        }
        return dtos;
    }

    /**
     * @generated
     */
    public static List<OrdenEntity> listDTO2Entity(List<OrdenDTO> dtos) {
        List<OrdenEntity> entities = new ArrayList<OrdenEntity>();
        if (dtos != null) {
            for (OrdenDTO dto : dtos) {
                entities.add(basicDTO2Entity(dto));
            }
        }
        return entities;
    }

    /**
     * @generated
     */
    public static OrdenEntity childDTO2Entity(OrdenDTO dto, EmpresaEntity parent){
        OrdenEntity entity = basicDTO2Entity(dto);
        entity.setEmpresa(parent);
        return entity;
    }

    /**
     * @generated
     */
    public static List<OrdenEntity> childListDTO2Entity(List<OrdenDTO> dtos, EmpresaEntity parent) {
        List<OrdenEntity> entities = new ArrayList<OrdenEntity>();
        if (dtos != null) {
            for (OrdenDTO dto : dtos) {
                entities.add(childDTO2Entity(dto, parent));
            }
        }
        return entities;
    }
}
