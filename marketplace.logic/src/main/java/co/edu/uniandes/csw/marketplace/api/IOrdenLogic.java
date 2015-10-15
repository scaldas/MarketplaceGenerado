package co.edu.uniandes.csw.marketplace.api;

import co.edu.uniandes.csw.marketplace.dtos.OrdenDTO;
import java.util.List;

public interface IOrdenLogic {
    public int countOrdens();
    public List<OrdenDTO> getOrdens(Integer page, Integer maxRecords);
    public OrdenDTO getOrden(Long id);
    public OrdenDTO createOrden(OrdenDTO dto);
    public OrdenDTO updateOrden(OrdenDTO dto);
    public void deleteOrden(Long id);
    public List<OrdenDTO> findByName(String name);
}
