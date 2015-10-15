package co.edu.uniandes.csw.marketplace.ejbs;

import co.edu.uniandes.csw.marketplace.api.IProductoLogic;
import co.edu.uniandes.csw.marketplace.converters.ProductoConverter;
import co.edu.uniandes.csw.marketplace.dtos.ProductoDTO;
import co.edu.uniandes.csw.marketplace.entities.ProductoEntity;
import co.edu.uniandes.csw.marketplace.persistence.ProductoPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * @generated
 */
@Stateless
public class ProductoLogic implements IProductoLogic {

    @Inject private ProductoPersistence persistence;

    /**
     * @generated
     */
    public int countProductos() {
        return persistence.count();
    }

    /**
     * @generated
     */
    public List<ProductoDTO> getProductos(Integer page, Integer maxRecords) {
        return ProductoConverter.listEntity2DTO(persistence.findAll(page, maxRecords));
    }

    /**
     * @generated
     */
    public ProductoDTO getProducto(Long id) {
        return ProductoConverter.fullEntity2DTO(persistence.find(id));
    }

    /**
     * @generated
     */
    public ProductoDTO createProducto(ProductoDTO dto) {
        ProductoEntity entity = ProductoConverter.fullDTO2Entity(dto);
        persistence.create(entity);
        return ProductoConverter.fullEntity2DTO(entity);
    }

    /**
     * @generated
     */
    public ProductoDTO updateProducto(ProductoDTO dto) {
        ProductoEntity entity = persistence.update(ProductoConverter.fullDTO2Entity(dto));
        return ProductoConverter.fullEntity2DTO(entity);
    }

    /**
     * @generated
     */
    public void deleteProducto(Long id) {
        persistence.delete(id);
    }

    /**
     * @generated
     */
    public List<ProductoDTO> findByName(String name) {
        return ProductoConverter.listEntity2DTO(persistence.findByName(name));
    }
}
