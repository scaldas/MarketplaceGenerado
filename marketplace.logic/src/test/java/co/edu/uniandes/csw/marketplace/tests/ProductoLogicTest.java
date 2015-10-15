package co.edu.uniandes.csw.marketplace.tests;

import co.edu.uniandes.csw.marketplace.ejbs.ProductoLogic;
import co.edu.uniandes.csw.marketplace.api.IProductoLogic;
import co.edu.uniandes.csw.marketplace.converters.ProductoConverter;
import co.edu.uniandes.csw.marketplace.dtos.ProductoDTO;
import co.edu.uniandes.csw.marketplace.entities.ProductoEntity;
import co.edu.uniandes.csw.marketplace.persistence.ProductoPersistence;
import static co.edu.uniandes.csw.marketplace.tests._TestUtil.*;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.junit.Assert;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class ProductoLogicTest {
    public static final String DEPLOY = "Prueba";

    /**
     * @generated
     */
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(ProductoEntity.class.getPackage())
                .addPackage(ProductoDTO.class.getPackage())
                .addPackage(ProductoConverter.class.getPackage())
                .addPackage(ProductoLogic.class.getPackage())
                .addPackage(IProductoLogic.class.getPackage())
                .addPackage(ProductoPersistence.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * @generated
     */
    @Inject
    private IProductoLogic productoLogic;

    /**
     * @generated
     */
    @PersistenceContext
    private EntityManager em;

    /**
     * @generated
     */
    @Inject
    UserTransaction utx;

    /**
     * @generated
     */
    @Before
    public void configTest() {
        try {
            utx.begin();
            clearData();
            insertData();
            utx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                utx.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    /**
     * @generated
     */
    private void clearData() {
        em.createQuery("delete from ProductoEntity").executeUpdate();
    }

    /**
     * @generated
     */
    private List<ProductoEntity> data = new ArrayList<ProductoEntity>();

    /**
     * @generated
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            ProductoEntity entity = new ProductoEntity();
        	entity.setName(generateRandom(String.class));
        	entity.setDescripcion(generateRandom(String.class));
            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * @generated
     */
    @Test
    public void createProductoTest() {
        ProductoDTO dto = new ProductoDTO();
        dto.setName(generateRandom(String.class));
        dto.setDescripcion(generateRandom(String.class));

        ProductoDTO result = productoLogic.createProducto(dto);

        Assert.assertNotNull(result);

        ProductoEntity entity = em.find(ProductoEntity.class, result.getId());

        Assert.assertEquals(dto.getName(), entity.getName());
        Assert.assertEquals(dto.getDescripcion(), entity.getDescripcion());
    }

    /**
     * @generated
     */
    @Test
    public void getProductosTest() {
        List<ProductoDTO> list = productoLogic.getProductos(null, null);
        Assert.assertEquals(data.size(), list.size());
        for (ProductoDTO dto : list) {
            boolean found = false;
            for (ProductoEntity entity : data) {
                if (dto.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    /**
     * @generated
     */
    @Test
    public void getProductoTest() {
        ProductoEntity entity = data.get(0);
        ProductoDTO dto = productoLogic.getProducto(entity.getId());
        Assert.assertNotNull(dto);
        Assert.assertEquals(entity.getName(), dto.getName());
        Assert.assertEquals(entity.getDescripcion(), dto.getDescripcion());
    }

    /**
     * @generated
     */
    @Test
    public void deleteProductoTest() {
        ProductoEntity entity = data.get(0);
        productoLogic.deleteProducto(entity.getId());
        ProductoEntity deleted = em.find(ProductoEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * @generated
     */
    @Test
    public void updateProductoTest() {
        ProductoEntity entity = data.get(0);

        ProductoDTO dto = new ProductoDTO();

        dto.setId(entity.getId());
        dto.setName(generateRandom(String.class));
        dto.setDescripcion(generateRandom(String.class));

        productoLogic.updateProducto(dto);

        ProductoEntity resp = em.find(ProductoEntity.class, entity.getId());

        Assert.assertEquals(dto.getName(), resp.getName());
        Assert.assertEquals(dto.getDescripcion(), resp.getDescripcion());
    }

    /**
     * @generated
     */
    @Test
    public void getProductoPaginationTest() {
        //Page 1
        List<ProductoDTO> dto1 = productoLogic.getProductos(1, 2);
        Assert.assertNotNull(dto1);
        Assert.assertEquals(2, dto1.size());
        //Page 2
        List<ProductoDTO> dto2 = productoLogic.getProductos(2, 2);
        Assert.assertNotNull(dto2);
        Assert.assertEquals(1, dto2.size());

        for (ProductoDTO dto : dto1) {
            boolean found = false;
            for (ProductoEntity entity : data) {
                if (dto.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }

        for (ProductoDTO dto : dto2) {
            boolean found = false;
            for (ProductoEntity entity : data) {
                if (dto.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    /**
     * @generated
     */
    @Test
    public void findByName() {
        String name = data.get(0).getName();
        List<ProductoEntity> cache = new ArrayList<ProductoEntity>();
        List<ProductoDTO> list = productoLogic.findByName(name);

        for (ProductoEntity entity : data) {
            if (entity.getName().equals(name)) {
                cache.add(entity);
            }
        }
        Assert.assertEquals(cache.size(), list.size());
        for (ProductoDTO dto : list) {
            boolean found = false;
            for (ProductoEntity cacheEntity : cache) {
                if (cacheEntity.getName().equals(dto.getName())) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                Assert.fail();
            }
        }
    }
}
