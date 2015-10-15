package co.edu.uniandes.csw.marketplace.api;

import co.edu.uniandes.csw.marketplace.dtos.PrecioUnitarioDTO;
import java.util.List;

public interface IPrecioUnitarioLogic {
    public int countPrecioUnitarios();
    public List<PrecioUnitarioDTO> getPrecioUnitarios(Integer page, Integer maxRecords);
    public PrecioUnitarioDTO getPrecioUnitario(Long id);
    public PrecioUnitarioDTO createPrecioUnitario(PrecioUnitarioDTO dto);
    public PrecioUnitarioDTO updatePrecioUnitario(PrecioUnitarioDTO dto);
    public void deletePrecioUnitario(Long id);
    public List<PrecioUnitarioDTO> findByName(String name);
}
