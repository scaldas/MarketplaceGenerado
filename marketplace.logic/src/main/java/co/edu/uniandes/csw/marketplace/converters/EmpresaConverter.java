package co.edu.uniandes.csw.marketplace.converters;

import co.edu.uniandes.csw.marketplace.dtos.EmpresaDTO;
import co.edu.uniandes.csw.marketplace.entities.EmpresaEntity;
import java.util.ArrayList;
import java.util.List;
import co.edu.uniandes.csw.marketplace.entities.UsuarioEntity;

/**
 * @generated
 */
public abstract class EmpresaConverter {

    /**
     * @generated
     */
    private EmpresaConverter() {
    }

    /**
     * @param entity
     * @return
     * @generated
     */
    public static EmpresaDTO refEntity2DTO(EmpresaEntity entity) {
        if (entity != null) {
            EmpresaDTO dto = new EmpresaDTO();
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
    public static EmpresaEntity refDTO2Entity(EmpresaDTO dto) {
        if (dto != null) {
            EmpresaEntity entity = new EmpresaEntity();
            entity.setId(dto.getId());

            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    private static EmpresaDTO basicEntity2DTO(EmpresaEntity entity) {
        if (entity != null) {
            EmpresaDTO dto = new EmpresaDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setNit(entity.getNit());
            dto.setActividadEconomica(entity.getActividadEconomica());
            dto.setDireccion(entity.getDireccion());
            dto.setCiudad(entity.getCiudad());
            dto.setTelefono(entity.getTelefono());
            dto.setFax(entity.getFax());
            dto.setPaginaWeb(entity.getPaginaWeb());
            dto.setNombresRepresentateLegal(entity.getNombresRepresentateLegal());
            dto.setApellidosRepresentanteLegal(entity.getApellidosRepresentanteLegal());
            dto.setTipoEmpresa(entity.getTipoEmpresa());
            dto.setVigiladaSuperfinanciera(entity.getVigiladaSuperfinanciera());
            dto.setVigiliadaSupersolidaria(entity.getVigiliadaSupersolidaria());
            dto.setUsuario(UsuarioConverter.refEntity2DTO(entity.getUsuario()));

            return dto;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    private static EmpresaEntity basicDTO2Entity(EmpresaDTO dto) {
        if (dto != null) {
            EmpresaEntity entity = new EmpresaEntity();
            entity.setId(dto.getId());
            entity.setName(dto.getName());
            entity.setNit(dto.getNit());
            entity.setActividadEconomica(dto.getActividadEconomica());
            entity.setDireccion(dto.getDireccion());
            entity.setCiudad(dto.getCiudad());
            entity.setTelefono(dto.getTelefono());
            entity.setFax(dto.getFax());
            entity.setPaginaWeb(dto.getPaginaWeb());
            entity.setNombresRepresentateLegal(dto.getNombresRepresentateLegal());
            entity.setApellidosRepresentanteLegal(dto.getApellidosRepresentanteLegal());
            entity.setTipoEmpresa(dto.getTipoEmpresa());
            entity.setVigiladaSuperfinanciera(dto.getVigiladaSuperfinanciera());
            entity.setVigiliadaSupersolidaria(dto.getVigiliadaSupersolidaria());
            entity.setUsuario(UsuarioConverter.refDTO2Entity(dto.getUsuario()));

            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    public static EmpresaDTO fullEntity2DTO(EmpresaEntity entity) {
        if (entity != null) {
            EmpresaDTO dto = basicEntity2DTO(entity);
            dto.setOrdenes(OrdenConverter.listEntity2DTO(entity.getOrdenes()));
            return dto;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    public static EmpresaEntity fullDTO2Entity(EmpresaDTO dto) {
        if (dto != null) {
            EmpresaEntity entity = basicDTO2Entity(dto);
            entity.setOrdenes(OrdenConverter.childListDTO2Entity(dto.getOrdenes(), entity));
            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */

    public static List<EmpresaDTO> listEntity2DTO(List<EmpresaEntity> entities) {
        List<EmpresaDTO> dtos = new ArrayList<EmpresaDTO>();
        if (entities != null) {
            for (EmpresaEntity entity : entities) {
                dtos.add(basicEntity2DTO(entity));
            }
        }
        return dtos;
    }

    /**
     * @generated
     */
    public static List<EmpresaEntity> listDTO2Entity(List<EmpresaDTO> dtos) {
        List<EmpresaEntity> entities = new ArrayList<EmpresaEntity>();
        if (dtos != null) {
            for (EmpresaDTO dto : dtos) {
                entities.add(basicDTO2Entity(dto));
            }
        }
        return entities;
    }

    /**
     * @generated
     */
    public static EmpresaEntity childDTO2Entity(EmpresaDTO dto, UsuarioEntity parent){
        EmpresaEntity entity = basicDTO2Entity(dto);
        entity.setUsuario(parent);
        return entity;
    }

    /**
     * @generated
     */
    public static List<EmpresaEntity> childListDTO2Entity(List<EmpresaDTO> dtos, UsuarioEntity parent) {
        List<EmpresaEntity> entities = new ArrayList<EmpresaEntity>();
        if (dtos != null) {
            for (EmpresaDTO dto : dtos) {
                entities.add(childDTO2Entity(dto, parent));
            }
        }
        return entities;
    }
}
