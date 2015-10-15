package co.edu.uniandes.csw.marketplace.services;

import co.edu.uniandes.csw.marketplace.api.IUsuarioLogic;
import co.edu.uniandes.csw.marketplace.dtos.UsuarioDTO;
import co.edu.uniandes.csw.marketplace.providers.StatusCreated;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 * @generated
 */
@Path("/usuarios")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioService {

    @Inject private IUsuarioLogic usuarioLogic;
    @Context private HttpServletResponse response;
    @QueryParam("page") private Integer page;
    @QueryParam("maxRecords") private Integer maxRecords;

    /**
     * @generated
     */
    @POST
    @StatusCreated
    public UsuarioDTO createUsuario(UsuarioDTO dto) {
        return usuarioLogic.createUsuario(dto);
    }

    /**
     * @generated
     */
    @GET
    public List<UsuarioDTO> getUsuarios() {
        if (page != null && maxRecords != null) {
            this.response.setIntHeader("X-Total-Count", usuarioLogic.countUsuarios());
        }
        return usuarioLogic.getUsuarios(page, maxRecords);
    }

    /**
     * @generated
     */
    @GET
    @Path("{id: \\d+}")
    public UsuarioDTO getUsuario(@PathParam("id") Long id) {
        return usuarioLogic.getUsuario(id);
    }

    /**
     * @generated
     */
    @PUT
    @Path("{id: \\d+}")
    public UsuarioDTO updateUsuario(@PathParam("id") Long id, UsuarioDTO dto) {
        dto.setId(id);
        return usuarioLogic.updateUsuario(dto);
    }

    /**
     * @generated
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteUsuario(@PathParam("id") Long id) {
        usuarioLogic.deleteUsuario(id);
    }
}
