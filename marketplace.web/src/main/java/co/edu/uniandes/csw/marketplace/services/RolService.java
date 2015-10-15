package co.edu.uniandes.csw.marketplace.services;

import co.edu.uniandes.csw.marketplace.api.IRolLogic;
import co.edu.uniandes.csw.marketplace.dtos.RolDTO;
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
@Path("/rols")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RolService {

    @Inject private IRolLogic rolLogic;
    @Context private HttpServletResponse response;
    @QueryParam("page") private Integer page;
    @QueryParam("maxRecords") private Integer maxRecords;

    /**
     * @generated
     */
    @POST
    @StatusCreated
    public RolDTO createRol(RolDTO dto) {
        return rolLogic.createRol(dto);
    }

    /**
     * @generated
     */
    @GET
    public List<RolDTO> getRols() {
        if (page != null && maxRecords != null) {
            this.response.setIntHeader("X-Total-Count", rolLogic.countRols());
        }
        return rolLogic.getRols(page, maxRecords);
    }

    /**
     * @generated
     */
    @GET
    @Path("{id: \\d+}")
    public RolDTO getRol(@PathParam("id") Long id) {
        return rolLogic.getRol(id);
    }

    /**
     * @generated
     */
    @PUT
    @Path("{id: \\d+}")
    public RolDTO updateRol(@PathParam("id") Long id, RolDTO dto) {
        dto.setId(id);
        return rolLogic.updateRol(dto);
    }

    /**
     * @generated
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteRol(@PathParam("id") Long id) {
        rolLogic.deleteRol(id);
    }
}
