package co.edu.uniandes.csw.marketplace.services;

import co.edu.uniandes.csw.marketplace.api.IPermisoLogic;
import co.edu.uniandes.csw.marketplace.dtos.PermisoDTO;
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
@Path("/permisos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PermisoService {

    @Inject private IPermisoLogic permisoLogic;
    @Context private HttpServletResponse response;
    @QueryParam("page") private Integer page;
    @QueryParam("maxRecords") private Integer maxRecords;

    /**
     * @generated
     */
    @POST
    @StatusCreated
    public PermisoDTO createPermiso(PermisoDTO dto) {
        return permisoLogic.createPermiso(dto);
    }

    /**
     * @generated
     */
    @GET
    public List<PermisoDTO> getPermisos() {
        if (page != null && maxRecords != null) {
            this.response.setIntHeader("X-Total-Count", permisoLogic.countPermisos());
        }
        return permisoLogic.getPermisos(page, maxRecords);
    }

    /**
     * @generated
     */
    @GET
    @Path("{id: \\d+}")
    public PermisoDTO getPermiso(@PathParam("id") Long id) {
        return permisoLogic.getPermiso(id);
    }

    /**
     * @generated
     */
    @PUT
    @Path("{id: \\d+}")
    public PermisoDTO updatePermiso(@PathParam("id") Long id, PermisoDTO dto) {
        dto.setId(id);
        return permisoLogic.updatePermiso(dto);
    }

    /**
     * @generated
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deletePermiso(@PathParam("id") Long id) {
        permisoLogic.deletePermiso(id);
    }
}
