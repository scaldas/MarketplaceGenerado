package co.edu.uniandes.csw.marketplace.tests;

import co.edu.uniandes.csw.marketplace.entities.IVAEntity;
import co.edu.uniandes.csw.marketplace.persistence.IVAPersistence;
import static co.edu.uniandes.csw.marketplace.tests._TestUtil.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
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
public class IVAPersistenceTest {
    public static final String DEPLOY = "Prueba";

    /**
     * @generated
     */
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(IVAEntity.class.getPackage())
                .addPackage(IVAPersistence.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * @generated
     */
    @Inject
    private IVAPersistence iVAPersistence;

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
        em.createQuery("delete from IVAEntity").executeUpdate();
    }

    /**
     * @generated
     */
    private List<IVAEntity> data = new ArrayList<IVAEntity>();

    /**
     * @generated
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            IVAEntity entity = new IVAEntity();
            entity.setPorcentajeIVA(generateRandom(Double.class));
            entity.setFechaInicioVigencia(generateRandom(Date.class));
            entity.setFechaFinVigencia(generateRandom(Date.class));
            entity.setName(generateRandom(String.class));
            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * @generated
     */
    @Test
    public void createIVATest() {
        IVAEntity newEntity = new IVAEntity();
        newEntity.setPorcentajeIVA(generateRandom(Double.class));
        newEntity.setFechaInicioVigencia(generateRandom(Date.class));
        newEntity.setFechaFinVigencia(generateRandom(Date.class));
        newEntity.setName(generateRandom(String.class));

        IVAEntity result = iVAPersistence.create(newEntity);

        Assert.assertNotNull(result);

        IVAEntity entity = em.find(IVAEntity.class, result.getId());

        Assert.assertEquals(newEntity.getPorcentajeIVA(), entity.getPorcentajeIVA());
        Assert.assertEquals(newEntity.getFechaInicioVigencia(), entity.getFechaInicioVigencia());
        Assert.assertEquals(newEntity.getFechaFinVigencia(), entity.getFechaFinVigencia());
        Assert.assertEquals(newEntity.getName(), entity.getName());
    }

    /**
     * @generated
     */
    @Test
    public void getIVAsTest() {
        List<IVAEntity> list = iVAPersistence.findAll(null, null);
        Assert.assertEquals(data.size(), list.size());
        for (IVAEntity ent : list) {
            boolean found = false;
            for (IVAEntity entity : data) {
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
    public void getIVATest() {
        IVAEntity entity = data.get(0);
        IVAEntity newEntity = iVAPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getPorcentajeIVA(), newEntity.getPorcentajeIVA());
        Assert.assertEquals(entity.getFechaInicioVigencia(), newEntity.getFechaInicioVigencia());
        Assert.assertEquals(entity.getFechaFinVigencia(), newEntity.getFechaFinVigencia());
        Assert.assertEquals(entity.getName(), newEntity.getName());
    }

    /**
     * @generated
     */
    @Test
    public void deleteIVATest() {
        IVAEntity entity = data.get(0);
        iVAPersistence.delete(entity.getId());
        IVAEntity deleted = em.find(IVAEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * @generated
     */
    @Test
    public void updateIVATest() {
        IVAEntity entity = data.get(0);

        IVAEntity newEntity = new IVAEntity();

        newEntity.setId(entity.getId());
        newEntity.setPorcentajeIVA(generateRandom(Double.class));
        newEntity.setFechaInicioVigencia(generateRandom(Date.class));
        newEntity.setFechaFinVigencia(generateRandom(Date.class));
        newEntity.setName(generateRandom(String.class));

        iVAPersistence.update(newEntity);

        IVAEntity resp = em.find(IVAEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getPorcentajeIVA(), resp.getPorcentajeIVA());
        Assert.assertEquals(newEntity.getFechaInicioVigencia(), resp.getFechaInicioVigencia());
        Assert.assertEquals(newEntity.getFechaFinVigencia(), resp.getFechaFinVigencia());
        Assert.assertEquals(newEntity.getName(), resp.getName());
    }

    /**
     * @generated
     */
    @Test
    public void getIVAPaginationTest() {
        //Page 1
        List<IVAEntity> ent1 = iVAPersistence.findAll(1, 2);
        Assert.assertNotNull(ent1);
        Assert.assertEquals(2, ent1.size());
        //Page 2
        List<IVAEntity> ent2 = iVAPersistence.findAll(2, 2);
        Assert.assertNotNull(ent2);
        Assert.assertEquals(1, ent2.size());

        for (IVAEntity ent : ent1) {
            boolean found = false;
            for (IVAEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }

        for (IVAEntity ent : ent2) {
            boolean found = false;
            for (IVAEntity entity : data) {
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
        List<IVAEntity> cache = new ArrayList<IVAEntity>();
        List<IVAEntity> list = iVAPersistence.findByName(name);

        for (IVAEntity entity : data) {
            if (entity.getName().equals(name)) {
                cache.add(entity);
            }
        }
        Assert.assertEquals(list.size(), cache.size());
        for (IVAEntity ent : list) {
            boolean found = false;
            for (IVAEntity cacheEntity : cache) {
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
