package co.edu.uniandes.csw.marketplace.services;

import co.edu.uniandes.csw.marketplace.api.IPrecioUnitarioLogic;
import co.edu.uniandes.csw.marketplace.dtos.PrecioUnitarioDTO;
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
@Path("/precioUnitarios")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PrecioUnitarioService {

    @Inject private IPrecioUnitarioLogic precioUnitarioLogic;
    @Context private HttpServletResponse response;
    @QueryParam("page") private Integer page;
    @QueryParam("maxRecords") private Integer maxRecords;

    /**
     * @generated
     */
    @POST
    @StatusCreated
    public PrecioUnitarioDTO createPrecioUnitario(PrecioUnitarioDTO dto) {
        return precioUnitarioLogic.createPrecioUnitario(dto);
    }

    /**
     * @generated
     */
    @GET
    public List<PrecioUnitarioDTO> getPrecioUnitarios() {
        if (page != null && maxRecords != null) {
            this.response.setIntHeader("X-Total-Count", precioUnitarioLogic.countPrecioUnitarios());
        }
        return precioUnitarioLogic.getPrecioUnitarios(page, maxRecords);
    }

    /**
     * @generated
     */
    @GET
    @Path("{id: \\d+}")
    public PrecioUnitarioDTO getPrecioUnitario(@PathParam("id") Long id) {
        return precioUnitarioLogic.getPrecioUnitario(id);
    }

    /**
     * @generated
     */
    @PUT
    @Path("{id: \\d+}")
    public PrecioUnitarioDTO updatePrecioUnitario(@PathParam("id") Long id, PrecioUnitarioDTO dto) {
        dto.setId(id);
        return precioUnitarioLogic.updatePrecioUnitario(dto);
    }

    /**
     * @generated
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deletePrecioUnitario(@PathParam("id") Long id) {
        precioUnitarioLogic.deletePrecioUnitario(id);
    }
}
