package co.edu.uniandes.csw.marketplace.tests;

import co.edu.uniandes.csw.marketplace.entities.PermisoEntity;
import co.edu.uniandes.csw.marketplace.persistence.PermisoPersistence;
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
public class PermisoPersistenceTest {
    public static final String DEPLOY = "Prueba";

    /**
     * @generated
     */
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(PermisoEntity.class.getPackage())
                .addPackage(PermisoPersistence.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * @generated
     */
    @Inject
    private PermisoPersistence permisoPersistence;

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
        em.createQuery("delete from PermisoEntity").executeUpdate();
    }

    /**
     * @generated
     */
    private List<PermisoEntity> data = new ArrayList<PermisoEntity>();

    /**
     * @generated
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            PermisoEntity entity = new PermisoEntity();
            entity.setName(generateRandom(String.class));
            entity.setUrl(generateRandom(String.class));
            entity.setMetodoRest(generateRandom(String.class));
            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * @generated
     */
    @Test
    public void createPermisoTest() {
        PermisoEntity newEntity = new PermisoEntity();
        newEntity.setName(generateRandom(String.class));
        newEntity.setUrl(generateRandom(String.class));
        newEntity.setMetodoRest(generateRandom(String.class));

        PermisoEntity result = permisoPersistence.create(newEntity);

        Assert.assertNotNull(result);

        PermisoEntity entity = em.find(PermisoEntity.class, result.getId());

        Assert.assertEquals(newEntity.getName(), entity.getName());
        Assert.assertEquals(newEntity.getUrl(), entity.getUrl());
        Assert.assertEquals(newEntity.getMetodoRest(), entity.getMetodoRest());
    }

    /**
     * @generated
     */
    @Test
    public void getPermisosTest() {
        List<PermisoEntity> list = permisoPersistence.findAll(null, null);
        Assert.assertEquals(data.size(), list.size());
        for (PermisoEntity ent : list) {
            boolean found = false;
            for (PermisoEntity entity : data) {
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
    public void getPermisoTest() {
        PermisoEntity entity = data.get(0);
        PermisoEntity newEntity = permisoPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getName(), newEntity.getName());
        Assert.assertEquals(entity.getUrl(), newEntity.getUrl());
        Assert.assertEquals(entity.getMetodoRest(), newEntity.getMetodoRest());
    }

    /**
     * @generated
     */
    @Test
    public void deletePermisoTest() {
        PermisoEntity entity = data.get(0);
        permisoPersistence.delete(entity.getId());
        PermisoEntity deleted = em.find(PermisoEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * @generated
     */
    @Test
    public void updatePermisoTest() {
        PermisoEntity entity = data.get(0);

        PermisoEntity newEntity = new PermisoEntity();

        newEntity.setId(entity.getId());
        newEntity.setName(generateRandom(String.class));
        newEntity.setUrl(generateRandom(String.class));
        newEntity.setMetodoRest(generateRandom(String.class));

        permisoPersistence.update(newEntity);

        PermisoEntity resp = em.find(PermisoEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getName(), resp.getName());
        Assert.assertEquals(newEntity.getUrl(), resp.getUrl());
        Assert.assertEquals(newEntity.getMetodoRest(), resp.getMetodoRest());
    }

    /**
     * @generated
     */
    @Test
    public void getPermisoPaginationTest() {
        //Page 1
        List<PermisoEntity> ent1 = permisoPersistence.findAll(1, 2);
        Assert.assertNotNull(ent1);
        Assert.assertEquals(2, ent1.size());
        //Page 2
        List<PermisoEntity> ent2 = permisoPersistence.findAll(2, 2);
        Assert.assertNotNull(ent2);
        Assert.assertEquals(1, ent2.size());

        for (PermisoEntity ent : ent1) {
            boolean found = false;
            for (PermisoEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }

        for (PermisoEntity ent : ent2) {
            boolean found = false;
            for (PermisoEntity entity : data) {
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
        List<PermisoEntity> cache = new ArrayList<PermisoEntity>();
        List<PermisoEntity> list = permisoPersistence.findByName(name);

        for (PermisoEntity entity : data) {
            if (entity.getName().equals(name)) {
                cache.add(entity);
            }
        }
        Assert.assertEquals(list.size(), cache.size());
        for (PermisoEntity ent : list) {
            boolean found = false;
            for (PermisoEntity cacheEntity : cache) {
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
