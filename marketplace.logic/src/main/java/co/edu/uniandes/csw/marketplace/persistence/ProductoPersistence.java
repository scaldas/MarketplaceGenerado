package co.edu.uniandes.csw.marketplace.persistence;

import co.edu.uniandes.csw.marketplace.entities.ProductoEntity;
import javax.ejb.Stateless;

/**
 * @generated
 */
@Stateless
public class ProductoPersistence extends CrudPersistence<ProductoEntity> {

    /**
     * @generated
     */
    public ProductoPersistence() {
        this.entityClass = ProductoEntity.class;
    }
}
