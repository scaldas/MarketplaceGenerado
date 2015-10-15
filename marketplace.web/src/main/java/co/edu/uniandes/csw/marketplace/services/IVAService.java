package co.edu.uniandes.csw.marketplace.services;

import co.edu.uniandes.csw.marketplace.api.IIVALogic;
import co.edu.uniandes.csw.marketplace.dtos.IVADTO;
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
@Path("/iVAs")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class IVAService {

    @Inject private IIVALogic iVALogic;
    @Context private HttpServletResponse response;
    @QueryParam("page") private Integer page;
    @QueryParam("maxRecords") private Integer maxRecords;

    /**
     * @generated
     */
    @POST
    @StatusCreated
    public IVADTO createIVA(IVADTO dto) {
        return iVALogic.createIVA(dto);
    }

    /**
     * @generated
     */
    @GET
    public List<IVADTO> getIVAs() {
        if (page != null && maxRecords != null) {
            this.response.setIntHeader("X-Total-Count", iVALogic.countIVAs());
        }
        return iVALogic.getIVAs(page, maxRecords);
    }

    /**
     * @generated
     */
    @GET
    @Path("{id: \\d+}")
    public IVADTO getIVA(@PathParam("id") Long id) {
        return iVALogic.getIVA(id);
    }

    /**
     * @generated
     */
    @PUT
    @Path("{id: \\d+}")
    public IVADTO updateIVA(@PathParam("id") Long id, IVADTO dto) {
        dto.setId(id);
        return iVALogic.updateIVA(dto);
    }

    /**
     * @generated
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteIVA(@PathParam("id") Long id) {
        iVALogic.deleteIVA(id);
    }
}
