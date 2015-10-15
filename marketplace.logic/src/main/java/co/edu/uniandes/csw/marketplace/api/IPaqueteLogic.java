package co.edu.uniandes.csw.marketplace.api;

import co.edu.uniandes.csw.marketplace.dtos.PaqueteDTO;
import java.util.List;

public interface IPaqueteLogic {
    public int countPaquetes();
    public List<PaqueteDTO> getPaquetes(Integer page, Integer maxRecords);
    public PaqueteDTO getPaquete(Long id);
    public PaqueteDTO createPaquete(PaqueteDTO dto);
    public PaqueteDTO updatePaquete(PaqueteDTO dto);
    public void deletePaquete(Long id);
    public List<PaqueteDTO> findByName(String name);
}
