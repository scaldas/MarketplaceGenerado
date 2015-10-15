package co.edu.uniandes.csw.marketplace.services;

import co.edu.uniandes.csw.marketplace.api.IEmpresaLogic;
import co.edu.uniandes.csw.marketplace.dtos.EmpresaDTO;
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
@Path("/empresas")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EmpresaService {

    @Inject private IEmpresaLogic empresaLogic;
    @Context private HttpServletResponse response;
    @QueryParam("page") private Integer page;
    @QueryParam("maxRecords") private Integer maxRecords;

    /**
     * @generated
     */
    @POST
    @StatusCreated
    public EmpresaDTO createEmpresa(EmpresaDTO dto) {
        return empresaLogic.createEmpresa(dto);
    }

    /**
     * @generated
     */
    @GET
    public List<EmpresaDTO> getEmpresas() {
        if (page != null && maxRecords != null) {
            this.response.setIntHeader("X-Total-Count", empresaLogic.countEmpresas());
        }
        return empresaLogic.getEmpresas(page, maxRecords);
    }

    /**
     * @generated
     */
    @GET
    @Path("{id: \\d+}")
    public EmpresaDTO getEmpresa(@PathParam("id") Long id) {
        return empresaLogic.getEmpresa(id);
    }

    /**
     * @generated
     */
    @PUT
    @Path("{id: \\d+}")
    public EmpresaDTO updateEmpresa(@PathParam("id") Long id, EmpresaDTO dto) {
        dto.setId(id);
        return empresaLogic.updateEmpresa(dto);
    }

    /**
     * @generated
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteEmpresa(@PathParam("id") Long id) {
        empresaLogic.deleteEmpresa(id);
    }
}
