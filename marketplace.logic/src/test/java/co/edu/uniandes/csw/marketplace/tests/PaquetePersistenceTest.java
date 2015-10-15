package co.edu.uniandes.csw.marketplace.tests;

import co.edu.uniandes.csw.marketplace.entities.PaqueteEntity;
import co.edu.uniandes.csw.marketplace.persistence.PaquetePersistence;
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
public class PaquetePersistenceTest {
    public static final String DEPLOY = "Prueba";

    /**
     * @generated
     */
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(PaqueteEntity.class.getPackage())
                .addPackage(PaquetePersistence.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * @generated
     */
    @Inject
    private PaquetePersistence paquetePersistence;

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
        em.createQuery("delete from PaqueteEntity").executeUpdate();
    }

    /**
     * @generated
     */
    private List<PaqueteEntity> data = new ArrayList<PaqueteEntity>();

    /**
     * @generated
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            PaqueteEntity entity = new PaqueteEntity();
            entity.setName(generateRandom(String.class));
            entity.setDescripcion(generateRandom(String.class));
            entity.setActivo(generateRandom(Boolean.class));
            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * @generated
     */
    @Test
    public void createPaqueteTest() {
        PaqueteEntity newEntity = new PaqueteEntity();
        newEntity.setName(generateRandom(String.class));
        newEntity.setDescripcion(generateRandom(String.class));
        newEntity.setActivo(generateRandom(Boolean.class));

        PaqueteEntity result = paquetePersistence.create(newEntity);

        Assert.assertNotNull(result);

        PaqueteEntity entity = em.find(PaqueteEntity.class, result.getId());

        Assert.assertEquals(newEntity.getName(), entity.getName());
        Assert.assertEquals(newEntity.getDescripcion(), entity.getDescripcion());
        Assert.assertEquals(newEntity.getActivo(), entity.getActivo());
    }

    /**
     * @generated
     */
    @Test
    public void getPaquetesTest() {
        List<PaqueteEntity> list = paquetePersistence.findAll(null, null);
        Assert.assertEquals(data.size(), list.size());
        for (PaqueteEntity ent : list) {
            boolean found = false;
            for (PaqueteEntity entity : data) {
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
    public void getPaqueteTest() {
        PaqueteEntity entity = data.get(0);
        PaqueteEntity newEntity = paquetePersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getName(), newEntity.getName());
        Assert.assertEquals(entity.getDescripcion(), newEntity.getDescripcion());
        Assert.assertEquals(entity.getActivo(), newEntity.getActivo());
    }

    /**
     * @generated
     */
    @Test
    public void deletePaqueteTest() {
        PaqueteEntity entity = data.get(0);
        paquetePersistence.delete(entity.getId());
        PaqueteEntity deleted = em.find(PaqueteEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * @generated
     */
    @Test
    public void updatePaqueteTest() {
        PaqueteEntity entity = data.get(0);

        PaqueteEntity newEntity = new PaqueteEntity();

        newEntity.setId(entity.getId());
        newEntity.setName(generateRandom(String.class));
        newEntity.setDescripcion(generateRandom(String.class));
        newEntity.setActivo(generateRandom(Boolean.class));

        paquetePersistence.update(newEntity);

        PaqueteEntity resp = em.find(PaqueteEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getName(), resp.getName());
        Assert.assertEquals(newEntity.getDescripcion(), resp.getDescripcion());
        Assert.assertEquals(newEntity.getActivo(), resp.getActivo());
    }

    /**
     * @generated
     */
    @Test
    public void getPaquetePaginationTest() {
        //Page 1
        List<PaqueteEntity> ent1 = paquetePersistence.findAll(1, 2);
        Assert.assertNotNull(ent1);
        Assert.assertEquals(2, ent1.size());
        //Page 2
        List<PaqueteEntity> ent2 = paquetePersistence.findAll(2, 2);
        Assert.assertNotNull(ent2);
        Assert.assertEquals(1, ent2.size());

        for (PaqueteEntity ent : ent1) {
            boolean found = false;
            for (PaqueteEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }

        for (PaqueteEntity ent : ent2) {
            boolean found = false;
            for (PaqueteEntity entity : data) {
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
        List<PaqueteEntity> cache = new ArrayList<PaqueteEntity>();
        List<PaqueteEntity> list = paquetePersistence.findByName(name);

        for (PaqueteEntity entity : data) {
            if (entity.getName().equals(name)) {
                cache.add(entity);
            }
        }
        Assert.assertEquals(list.size(), cache.size());
        for (PaqueteEntity ent : list) {
            boolean found = false;
            for (PaqueteEntity cacheEntity : cache) {
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
