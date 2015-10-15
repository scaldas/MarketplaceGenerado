package co.edu.uniandes.csw.marketplace.api;

import co.edu.uniandes.csw.marketplace.dtos.IVADTO;
import java.util.List;

public interface IIVALogic {
    public int countIVAs();
    public List<IVADTO> getIVAs(Integer page, Integer maxRecords);
    public IVADTO getIVA(Long id);
    public IVADTO createIVA(IVADTO dto);
    public IVADTO updateIVA(IVADTO dto);
    public void deleteIVA(Long id);
    public List<IVADTO> findByName(String name);
}
