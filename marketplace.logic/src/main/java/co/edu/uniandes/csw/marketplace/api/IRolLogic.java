package co.edu.uniandes.csw.marketplace.api;

import co.edu.uniandes.csw.marketplace.dtos.RolDTO;
import java.util.List;

public interface IRolLogic {
    public int countRols();
    public List<RolDTO> getRols(Integer page, Integer maxRecords);
    public RolDTO getRol(Long id);
    public RolDTO createRol(RolDTO dto);
    public RolDTO updateRol(RolDTO dto);
    public void deleteRol(Long id);
    public List<RolDTO> findByName(String name);
}
