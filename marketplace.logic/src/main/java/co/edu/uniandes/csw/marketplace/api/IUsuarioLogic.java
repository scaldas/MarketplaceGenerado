package co.edu.uniandes.csw.marketplace.api;

import co.edu.uniandes.csw.marketplace.dtos.UsuarioDTO;
import java.util.List;

public interface IUsuarioLogic {
    public int countUsuarios();
    public List<UsuarioDTO> getUsuarios(Integer page, Integer maxRecords);
    public UsuarioDTO getUsuario(Long id);
    public UsuarioDTO createUsuario(UsuarioDTO dto);
    public UsuarioDTO updateUsuario(UsuarioDTO dto);
    public void deleteUsuario(Long id);
    public List<UsuarioDTO> findByName(String name);
}
