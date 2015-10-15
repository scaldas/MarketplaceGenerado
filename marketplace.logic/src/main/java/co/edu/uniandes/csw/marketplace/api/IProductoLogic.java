package co.edu.uniandes.csw.marketplace.api;

import co.edu.uniandes.csw.marketplace.dtos.ProductoDTO;
import java.util.List;

public interface IProductoLogic {
    public int countProductos();
    public List<ProductoDTO> getProductos(Integer page, Integer maxRecords);
    public ProductoDTO getProducto(Long id);
    public ProductoDTO createProducto(ProductoDTO dto);
    public ProductoDTO updateProducto(ProductoDTO dto);
    public void deleteProducto(Long id);
    public List<ProductoDTO> findByName(String name);
}
