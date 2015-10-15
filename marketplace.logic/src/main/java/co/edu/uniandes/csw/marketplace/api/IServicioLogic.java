package co.edu.uniandes.csw.marketplace.api;

import co.edu.uniandes.csw.marketplace.dtos.ServicioDTO;
import java.util.List;

public interface IServicioLogic {
    public int countServicios();
    public List<ServicioDTO> getServicios(Integer page, Integer maxRecords);
    public ServicioDTO getServicio(Long id);
    public ServicioDTO createServicio(ServicioDTO dto);
    public ServicioDTO updateServicio(ServicioDTO dto);
    public void deleteServicio(Long id);
    public List<ServicioDTO> findByName(String name);
}
