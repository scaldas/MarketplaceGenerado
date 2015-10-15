package co.edu.uniandes.csw.marketplace.tests;

import co.edu.uniandes.csw.marketplace.entities.RolEntity;
import co.edu.uniandes.csw.marketplace.persistence.RolPersistence;
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
public class RolPersistenceTest {
    public static final String DEPLOY = "Prueba";

    /**
     * @generated
     */
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(RolEntity.class.getPackage())
                .addPackage(RolPersistence.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * @generated
     */
    @Inject
    private RolPersistence rolPersistence;

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
        em.createQuery("delete from RolEntity").executeUpdate();
    }

    /**
     * @generated
     */
    private List<RolEntity> data = new ArrayList<RolEntity>();

    /**
     * @generated
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            RolEntity entity = new RolEntity();
            entity.setName(generateRandom(String.class));
            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * @generated
     */
    @Test
    public void createRolTest() {
        RolEntity newEntity = new RolEntity();
        newEntity.setName(generateRandom(String.class));

        RolEntity result = rolPersistence.create(newEntity);

        Assert.assertNotNull(result);

        RolEntity entity = em.find(RolEntity.class, result.getId());

        Assert.assertEquals(newEntity.getName(), entity.getName());
    }

    /**
     * @generated
     */
    @Test
    public void getRolsTest() {
        List<RolEntity> list = rolPersistence.findAll(null, null);
        Assert.assertEquals(data.size(), list.size());
        for (RolEntity ent : list) {
            boolean found = false;
            for (RolEntity entity : data) {
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
    public void getRolTest() {
        RolEntity entity = data.get(0);
        RolEntity newEntity = rolPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getName(), newEntity.getName());
    }

    /**
     * @generated
     */
    @Test
    public void deleteRolTest() {
        RolEntity entity = data.get(0);
        rolPersistence.delete(entity.getId());
        RolEntity deleted = em.find(RolEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * @generated
     */
    @Test
    public void updateRolTest() {
        RolEntity entity = data.get(0);

        RolEntity newEntity = new RolEntity();

        newEntity.setId(entity.getId());
        newEntity.setName(generateRandom(String.class));

        rolPersistence.update(newEntity);

        RolEntity resp = em.find(RolEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getName(), resp.getName());
    }

    /**
     * @generated
     */
    @Test
    public void getRolPaginationTest() {
        //Page 1
        List<RolEntity> ent1 = rolPersistence.findAll(1, 2);
        Assert.assertNotNull(ent1);
        Assert.assertEquals(2, ent1.size());
        //Page 2
        List<RolEntity> ent2 = rolPersistence.findAll(2, 2);
        Assert.assertNotNull(ent2);
        Assert.assertEquals(1, ent2.size());

        for (RolEntity ent : ent1) {
            boolean found = false;
            for (RolEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }

        for (RolEntity ent : ent2) {
            boolean found = false;
            for (RolEntity entity : data) {
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
        List<RolEntity> cache = new ArrayList<RolEntity>();
        List<RolEntity> list = rolPersistence.findByName(name);

        for (RolEntity entity : data) {
            if (entity.getName().equals(name)) {
                cache.add(entity);
            }
        }
        Assert.assertEquals(list.size(), cache.size());
        for (RolEntity ent : list) {
            boolean found = false;
            for (RolEntity cacheEntity : cache) {
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
