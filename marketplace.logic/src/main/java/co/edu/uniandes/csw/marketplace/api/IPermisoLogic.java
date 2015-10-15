package co.edu.uniandes.csw.marketplace.api;

import co.edu.uniandes.csw.marketplace.dtos.PermisoDTO;
import java.util.List;

public interface IPermisoLogic {
    public int countPermisos();
    public List<PermisoDTO> getPermisos(Integer page, Integer maxRecords);
    public PermisoDTO getPermiso(Long id);
    public PermisoDTO createPermiso(PermisoDTO dto);
    public PermisoDTO updatePermiso(PermisoDTO dto);
    public void deletePermiso(Long id);
    public List<PermisoDTO> findByName(String name);
}
