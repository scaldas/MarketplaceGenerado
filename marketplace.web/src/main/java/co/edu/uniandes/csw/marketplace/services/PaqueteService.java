package co.edu.uniandes.csw.marketplace.services;

import co.edu.uniandes.csw.marketplace.api.IPaqueteLogic;
import co.edu.uniandes.csw.marketplace.dtos.PaqueteDTO;
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
@Path("/paquetes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PaqueteService {

    @Inject private IPaqueteLogic paqueteLogic;
    @Context private HttpServletResponse response;
    @QueryParam("page") private Integer page;
    @QueryParam("maxRecords") private Integer maxRecords;

    /**
     * @generated
     */
    @POST
    @StatusCreated
    public PaqueteDTO createPaquete(PaqueteDTO dto) {
        return paqueteLogic.createPaquete(dto);
    }

    /**
     * @generated
     */
    @GET
    public List<PaqueteDTO> getPaquetes() {
        if (page != null && maxRecords != null) {
            this.response.setIntHeader("X-Total-Count", paqueteLogic.countPaquetes());
        }
        return paqueteLogic.getPaquetes(page, maxRecords);
    }

    /**
     * @generated
     */
    @GET
    @Path("{id: \\d+}")
    public PaqueteDTO getPaquete(@PathParam("id") Long id) {
        return paqueteLogic.getPaquete(id);
    }

    /**
     * @generated
     */
    @PUT
    @Path("{id: \\d+}")
    public PaqueteDTO updatePaquete(@PathParam("id") Long id, PaqueteDTO dto) {
        dto.setId(id);
        return paqueteLogic.updatePaquete(dto);
    }

    /**
     * @generated
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deletePaquete(@PathParam("id") Long id) {
        paqueteLogic.deletePaquete(id);
    }
}
