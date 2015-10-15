package co.edu.uniandes.csw.marketplace.services;

import co.edu.uniandes.csw.marketplace.api.IProductoLogic;
import co.edu.uniandes.csw.marketplace.dtos.ProductoDTO;
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
@Path("/productos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProductoService {

    @Inject private IProductoLogic productoLogic;
    @Context private HttpServletResponse response;
    @QueryParam("page") private Integer page;
    @QueryParam("maxRecords") private Integer maxRecords;

    /**
     * @generated
     */
    @POST
    @StatusCreated
    public ProductoDTO createProducto(ProductoDTO dto) {
        return productoLogic.createProducto(dto);
    }

    /**
     * @generated
     */
    @GET
    public List<ProductoDTO> getProductos() {
        if (page != null && maxRecords != null) {
            this.response.setIntHeader("X-Total-Count", productoLogic.countProductos());
        }
        return productoLogic.getProductos(page, maxRecords);
    }

    /**
     * @generated
     */
    @GET
    @Path("{id: \\d+}")
    public ProductoDTO getProducto(@PathParam("id") Long id) {
        return productoLogic.getProducto(id);
    }

    /**
     * @generated
     */
    @PUT
    @Path("{id: \\d+}")
    public ProductoDTO updateProducto(@PathParam("id") Long id, ProductoDTO dto) {
        dto.setId(id);
        return productoLogic.updateProducto(dto);
    }

    /**
     * @generated
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteProducto(@PathParam("id") Long id) {
        productoLogic.deleteProducto(id);
    }
}
