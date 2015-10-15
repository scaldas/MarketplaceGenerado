package co.edu.uniandes.csw.marketplace.tests;

import co.edu.uniandes.csw.marketplace.entities.PrecioUnitarioEntity;
import co.edu.uniandes.csw.marketplace.persistence.PrecioUnitarioPersistence;
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
public class PrecioUnitarioPersistenceTest {
    public static final String DEPLOY = "Prueba";

    /**
     * @generated
     */
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(PrecioUnitarioEntity.class.getPackage())
                .addPackage(PrecioUnitarioPersistence.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * @generated
     */
    @Inject
    private PrecioUnitarioPersistence precioUnitarioPersistence;

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
        em.createQuery("delete from PrecioUnitarioEntity").executeUpdate();
    }

    /**
     * @generated
     */
    private List<PrecioUnitarioEntity> data = new ArrayList<PrecioUnitarioEntity>();

    /**
     * @generated
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            PrecioUnitarioEntity entity = new PrecioUnitarioEntity();
            entity.setName(generateRandom(String.class));
            entity.setPrecioUnidad(generateRandom(Double.class));
            entity.setRangoInicial(generateRandom(Integer.class));
            entity.setRangoFinal(generateRandom(Integer.class));
            entity.setFechaInicioValidez(generateRandom(Date.class));
            entity.setFechaFinValidez(generateRandom(Date.class));
            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * @generated
     */
    @Test
    public void createPrecioUnitarioTest() {
        PrecioUnitarioEntity newEntity = new PrecioUnitarioEntity();
        newEntity.setName(generateRandom(String.class));
        newEntity.setPrecioUnidad(generateRandom(Double.class));
        newEntity.setRangoInicial(generateRandom(Integer.class));
        newEntity.setRangoFinal(generateRandom(Integer.class));
        newEntity.setFechaInicioValidez(generateRandom(Date.class));
        newEntity.setFechaFinValidez(generateRandom(Date.class));

        PrecioUnitarioEntity result = precioUnitarioPersistence.create(newEntity);

        Assert.assertNotNull(result);

        PrecioUnitarioEntity entity = em.find(PrecioUnitarioEntity.class, result.getId());

        Assert.assertEquals(newEntity.getName(), entity.getName());
        Assert.assertEquals(newEntity.getPrecioUnidad(), entity.getPrecioUnidad());
        Assert.assertEquals(newEntity.getRangoInicial(), entity.getRangoInicial());
        Assert.assertEquals(newEntity.getRangoFinal(), entity.getRangoFinal());
        Assert.assertEquals(newEntity.getFechaInicioValidez(), entity.getFechaInicioValidez());
        Assert.assertEquals(newEntity.getFechaFinValidez(), entity.getFechaFinValidez());
    }

    /**
     * @generated
     */
    @Test
    public void getPrecioUnitariosTest() {
        List<PrecioUnitarioEntity> list = precioUnitarioPersistence.findAll(null, null);
        Assert.assertEquals(data.size(), list.size());
        for (PrecioUnitarioEntity ent : list) {
            boolean found = false;
            for (PrecioUnitarioEntity entity : data) {
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
    public void getPrecioUnitarioTest() {
        PrecioUnitarioEntity entity = data.get(0);
        PrecioUnitarioEntity newEntity = precioUnitarioPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getName(), newEntity.getName());
        Assert.assertEquals(entity.getPrecioUnidad(), newEntity.getPrecioUnidad());
        Assert.assertEquals(entity.getRangoInicial(), newEntity.getRangoInicial());
        Assert.assertEquals(entity.getRangoFinal(), newEntity.getRangoFinal());
        Assert.assertEquals(entity.getFechaInicioValidez(), newEntity.getFechaInicioValidez());
        Assert.assertEquals(entity.getFechaFinValidez(), newEntity.getFechaFinValidez());
    }

    /**
     * @generated
     */
    @Test
    public void deletePrecioUnitarioTest() {
        PrecioUnitarioEntity entity = data.get(0);
        precioUnitarioPersistence.delete(entity.getId());
        PrecioUnitarioEntity deleted = em.find(PrecioUnitarioEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * @generated
     */
    @Test
    public void updatePrecioUnitarioTest() {
        PrecioUnitarioEntity entity = data.get(0);

        PrecioUnitarioEntity newEntity = new PrecioUnitarioEntity();

        newEntity.setId(entity.getId());
        newEntity.setName(generateRandom(String.class));
        newEntity.setPrecioUnidad(generateRandom(Double.class));
        newEntity.setRangoInicial(generateRandom(Integer.class));
        newEntity.setRangoFinal(generateRandom(Integer.class));
        newEntity.setFechaInicioValidez(generateRandom(Date.class));
        newEntity.setFechaFinValidez(generateRandom(Date.class));

        precioUnitarioPersistence.update(newEntity);

        PrecioUnitarioEntity resp = em.find(PrecioUnitarioEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getName(), resp.getName());
        Assert.assertEquals(newEntity.getPrecioUnidad(), resp.getPrecioUnidad());
        Assert.assertEquals(newEntity.getRangoInicial(), resp.getRangoInicial());
        Assert.assertEquals(newEntity.getRangoFinal(), resp.getRangoFinal());
        Assert.assertEquals(newEntity.getFechaInicioValidez(), resp.getFechaInicioValidez());
        Assert.assertEquals(newEntity.getFechaFinValidez(), resp.getFechaFinValidez());
    }

    /**
     * @generated
     */
    @Test
    public void getPrecioUnitarioPaginationTest() {
        //Page 1
        List<PrecioUnitarioEntity> ent1 = precioUnitarioPersistence.findAll(1, 2);
        Assert.assertNotNull(ent1);
        Assert.assertEquals(2, ent1.size());
        //Page 2
        List<PrecioUnitarioEntity> ent2 = precioUnitarioPersistence.findAll(2, 2);
        Assert.assertNotNull(ent2);
        Assert.assertEquals(1, ent2.size());

        for (PrecioUnitarioEntity ent : ent1) {
            boolean found = false;
            for (PrecioUnitarioEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }

        for (PrecioUnitarioEntity ent : ent2) {
            boolean found = false;
            for (PrecioUnitarioEntity entity : data) {
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
        List<PrecioUnitarioEntity> cache = new ArrayList<PrecioUnitarioEntity>();
        List<PrecioUnitarioEntity> list = precioUnitarioPersistence.findByName(name);

        for (PrecioUnitarioEntity entity : data) {
            if (entity.getName().equals(name)) {
                cache.add(entity);
            }
        }
        Assert.assertEquals(list.size(), cache.size());
        for (PrecioUnitarioEntity ent : list) {
            boolean found = false;
            for (PrecioUnitarioEntity cacheEntity : cache) {
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
