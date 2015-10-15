package co.edu.uniandes.csw.marketplace.tests;

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
public class ProductoPersistenceTest {
    public static final String DEPLOY = "Prueba";

    /**
     * @generated
     */
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(ProductoEntity.class.getPackage())
                .addPackage(ProductoPersistence.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * @generated
     */
    @Inject
    private ProductoPersistence productoPersistence;

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
        ProductoEntity newEntity = new ProductoEntity();
        newEntity.setName(generateRandom(String.class));
        newEntity.setDescripcion(generateRandom(String.class));

        ProductoEntity result = productoPersistence.create(newEntity);

        Assert.assertNotNull(result);

        ProductoEntity entity = em.find(ProductoEntity.class, result.getId());

        Assert.assertEquals(newEntity.getName(), entity.getName());
        Assert.assertEquals(newEntity.getDescripcion(), entity.getDescripcion());
    }

    /**
     * @generated
     */
    @Test
    public void getProductosTest() {
        List<ProductoEntity> list = productoPersistence.findAll(null, null);
        Assert.assertEquals(data.size(), list.size());
        for (ProductoEntity ent : list) {
            boolean found = false;
            for (ProductoEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
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
        ProductoEntity newEntity = productoPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getName(), newEntity.getName());
        Assert.assertEquals(entity.getDescripcion(), newEntity.getDescripcion());
    }

    /**
     * @generated
     */
    @Test
    public void deleteProductoTest() {
        ProductoEntity entity = data.get(0);
        productoPersistence.delete(entity.getId());
        ProductoEntity deleted = em.find(ProductoEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * @generated
     */
    @Test
    public void updateProductoTest() {
        ProductoEntity entity = data.get(0);

        ProductoEntity newEntity = new ProductoEntity();

        newEntity.setId(entity.getId());
        newEntity.setName(generateRandom(String.class));
        newEntity.setDescripcion(generateRandom(String.class));

        productoPersistence.update(newEntity);

        ProductoEntity resp = em.find(ProductoEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getName(), resp.getName());
        Assert.assertEquals(newEntity.getDescripcion(), resp.getDescripcion());
    }

    /**
     * @generated
     */
    @Test
    public void getProductoPaginationTest() {
        //Page 1
        List<ProductoEntity> ent1 = productoPersistence.findAll(1, 2);
        Assert.assertNotNull(ent1);
        Assert.assertEquals(2, ent1.size());
        //Page 2
        List<ProductoEntity> ent2 = productoPersistence.findAll(2, 2);
        Assert.assertNotNull(ent2);
        Assert.assertEquals(1, ent2.size());

        for (ProductoEntity ent : ent1) {
            boolean found = false;
            for (ProductoEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }

        for (ProductoEntity ent : ent2) {
            boolean found = false;
            for (ProductoEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
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
        List<ProductoEntity> list = productoPersistence.findByName(name);

        for (ProductoEntity entity : data) {
            if (entity.getName().equals(name)) {
                cache.add(entity);
            }
        }
        Assert.assertEquals(list.size(), cache.size());
        for (ProductoEntity ent : list) {
            boolean found = false;
            for (ProductoEntity cacheEntity : cache) {
                if (cacheEntity.getName().equals(ent.getName())) {
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
