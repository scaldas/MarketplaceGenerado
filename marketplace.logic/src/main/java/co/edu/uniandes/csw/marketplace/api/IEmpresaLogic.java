package co.edu.uniandes.csw.marketplace.api;

import co.edu.uniandes.csw.marketplace.dtos.EmpresaDTO;
import java.util.List;

public interface IEmpresaLogic {
    public int countEmpresas();
    public List<EmpresaDTO> getEmpresas(Integer page, Integer maxRecords);
    public EmpresaDTO getEmpresa(Long id);
    public EmpresaDTO createEmpresa(EmpresaDTO dto);
    public EmpresaDTO updateEmpresa(EmpresaDTO dto);
    public void deleteEmpresa(Long id);
    public List<EmpresaDTO> findByName(String name);
}
