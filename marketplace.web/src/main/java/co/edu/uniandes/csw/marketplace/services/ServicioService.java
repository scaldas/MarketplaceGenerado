package co.edu.uniandes.csw.marketplace.services;

import co.edu.uniandes.csw.marketplace.api.IServicioLogic;
import co.edu.uniandes.csw.marketplace.dtos.ServicioDTO;
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
@Path("/servicios")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ServicioService {

    @Inject private IServicioLogic servicioLogic;
    @Context private HttpServletResponse response;
    @QueryParam("page") private Integer page;
    @QueryParam("maxRecords") private Integer maxRecords;

    /**
     * @generated
     */
    @POST
    @StatusCreated
    public ServicioDTO createServicio(ServicioDTO dto) {
        return servicioLogic.createServicio(dto);
    }

    /**
     * @generated
     */
    @GET
    public List<ServicioDTO> getServicios() {
        if (page != null && maxRecords != null) {
            this.response.setIntHeader("X-Total-Count", servicioLogic.countServicios());
        }
        return servicioLogic.getServicios(page, maxRecords);
    }

    /**
     * @generated
     */
    @GET
    @Path("{id: \\d+}")
    public ServicioDTO getServicio(@PathParam("id") Long id) {
        return servicioLogic.getServicio(id);
    }

    /**
     * @generated
     */
    @PUT
    @Path("{id: \\d+}")
    public ServicioDTO updateServicio(@PathParam("id") Long id, ServicioDTO dto) {
        dto.setId(id);
        return servicioLogic.updateServicio(dto);
    }

    /**
     * @generated
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteServicio(@PathParam("id") Long id) {
        servicioLogic.deleteServicio(id);
    }
}
