package co.edu.uniandes.csw.marketplace.services;

import co.edu.uniandes.csw.marketplace.api.IOrdenLogic;
import co.edu.uniandes.csw.marketplace.dtos.OrdenDTO;
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
@Path("/ordens")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class OrdenService {

    @Inject private IOrdenLogic ordenLogic;
    @Context private HttpServletResponse response;
    @QueryParam("page") private Integer page;
    @QueryParam("maxRecords") private Integer maxRecords;

    /**
     * @generated
     */
    @POST
    @StatusCreated
    public OrdenDTO createOrden(OrdenDTO dto) {
        return ordenLogic.createOrden(dto);
    }

    /**
     * @generated
     */
    @GET
    public List<OrdenDTO> getOrdens() {
        if (page != null && maxRecords != null) {
            this.response.setIntHeader("X-Total-Count", ordenLogic.countOrdens());
        }
        return ordenLogic.getOrdens(page, maxRecords);
    }

    /**
     * @generated
     */
    @GET
    @Path("{id: \\d+}")
    public OrdenDTO getOrden(@PathParam("id") Long id) {
        return ordenLogic.getOrden(id);
    }

    /**
     * @generated
     */
    @PUT
    @Path("{id: \\d+}")
    public OrdenDTO updateOrden(@PathParam("id") Long id, OrdenDTO dto) {
        dto.setId(id);
        return ordenLogic.updateOrden(dto);
    }

    /**
     * @generated
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteOrden(@PathParam("id") Long id) {
        ordenLogic.deleteOrden(id);
    }
}
