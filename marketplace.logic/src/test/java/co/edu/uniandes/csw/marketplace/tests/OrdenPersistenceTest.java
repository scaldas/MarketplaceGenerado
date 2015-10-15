package co.edu.uniandes.csw.marketplace.tests;

import co.edu.uniandes.csw.marketplace.entities.OrdenEntity;
import co.edu.uniandes.csw.marketplace.persistence.OrdenPersistence;
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
public class OrdenPersistenceTest {
    public static final String DEPLOY = "Prueba";

    /**
     * @generated
     */
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(OrdenEntity.class.getPackage())
                .addPackage(OrdenPersistence.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * @generated
     */
    @Inject
    private OrdenPersistence ordenPersistence;

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
        em.createQuery("delete from OrdenEntity").executeUpdate();
    }

    /**
     * @generated
     */
    private List<OrdenEntity> data = new ArrayList<OrdenEntity>();

    /**
     * @generated
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            OrdenEntity entity = new OrdenEntity();
            entity.setName(generateRandom(String.class));
            entity.setManejoCreditoConsumo(generateRandom(Boolean.class));
            entity.setManejoCreditoComercial(generateRandom(Boolean.class));
            entity.setManejoCreditoLibranza(generateRandom(Boolean.class));
            entity.setManejoCreditoHipotecario(generateRandom(Boolean.class));
            entity.setManejoMicrocredito(generateRandom(Boolean.class));
            entity.setFechaRegistroOrden(generateRandom(Date.class));
            entity.setFechaInicioFacturacion(generateRandom(Date.class));
            entity.setEstadoOrden(generateRandom(Integer.class));
            entity.setIdCoreCartera(generateRandom(String.class));
            entity.setUsuarioCoreCartera(generateRandom(String.class));
            entity.setUrlCoreCartera(generateRandom(String.class));
            entity.setNumeroUsuariosInicial(generateRandom(Integer.class));
            entity.setNumeroCreditosInicial(generateRandom(Integer.class));
            entity.setValorCarteraInicial(generateRandom(Integer.class));
            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * @generated
     */
    @Test
    public void createOrdenTest() {
        OrdenEntity newEntity = new OrdenEntity();
        newEntity.setName(generateRandom(String.class));
        newEntity.setManejoCreditoConsumo(generateRandom(Boolean.class));
        newEntity.setManejoCreditoComercial(generateRandom(Boolean.class));
        newEntity.setManejoCreditoLibranza(generateRandom(Boolean.class));
        newEntity.setManejoCreditoHipotecario(generateRandom(Boolean.class));
        newEntity.setManejoMicrocredito(generateRandom(Boolean.class));
        newEntity.setFechaRegistroOrden(generateRandom(Date.class));
        newEntity.setFechaInicioFacturacion(generateRandom(Date.class));
        newEntity.setEstadoOrden(generateRandom(Integer.class));
        newEntity.setIdCoreCartera(generateRandom(String.class));
        newEntity.setUsuarioCoreCartera(generateRandom(String.class));
        newEntity.setUrlCoreCartera(generateRandom(String.class));
        newEntity.setNumeroUsuariosInicial(generateRandom(Integer.class));
        newEntity.setNumeroCreditosInicial(generateRandom(Integer.class));
        newEntity.setValorCarteraInicial(generateRandom(Integer.class));

        OrdenEntity result = ordenPersistence.create(newEntity);

        Assert.assertNotNull(result);

        OrdenEntity entity = em.find(OrdenEntity.class, result.getId());

        Assert.assertEquals(newEntity.getName(), entity.getName());
        Assert.assertEquals(newEntity.getManejoCreditoConsumo(), entity.getManejoCreditoConsumo());
        Assert.assertEquals(newEntity.getManejoCreditoComercial(), entity.getManejoCreditoComercial());
        Assert.assertEquals(newEntity.getManejoCreditoLibranza(), entity.getManejoCreditoLibranza());
        Assert.assertEquals(newEntity.getManejoCreditoHipotecario(), entity.getManejoCreditoHipotecario());
        Assert.assertEquals(newEntity.getManejoMicrocredito(), entity.getManejoMicrocredito());
        Assert.assertEquals(newEntity.getFechaRegistroOrden(), entity.getFechaRegistroOrden());
        Assert.assertEquals(newEntity.getFechaInicioFacturacion(), entity.getFechaInicioFacturacion());
        Assert.assertEquals(newEntity.getEstadoOrden(), entity.getEstadoOrden());
        Assert.assertEquals(newEntity.getIdCoreCartera(), entity.getIdCoreCartera());
        Assert.assertEquals(newEntity.getUsuarioCoreCartera(), entity.getUsuarioCoreCartera());
        Assert.assertEquals(newEntity.getUrlCoreCartera(), entity.getUrlCoreCartera());
        Assert.assertEquals(newEntity.getNumeroUsuariosInicial(), entity.getNumeroUsuariosInicial());
        Assert.assertEquals(newEntity.getNumeroCreditosInicial(), entity.getNumeroCreditosInicial());
        Assert.assertEquals(newEntity.getValorCarteraInicial(), entity.getValorCarteraInicial());
    }

    /**
     * @generated
     */
    @Test
    public void getOrdensTest() {
        List<OrdenEntity> list = ordenPersistence.findAll(null, null);
        Assert.assertEquals(data.size(), list.size());
        for (OrdenEntity ent : list) {
            boolean found = false;
            for (OrdenEntity entity : data) {
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
    public void getOrdenTest() {
        OrdenEntity entity = data.get(0);
        OrdenEntity newEntity = ordenPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getName(), newEntity.getName());
        Assert.assertEquals(entity.getManejoCreditoConsumo(), newEntity.getManejoCreditoConsumo());
        Assert.assertEquals(entity.getManejoCreditoComercial(), newEntity.getManejoCreditoComercial());
        Assert.assertEquals(entity.getManejoCreditoLibranza(), newEntity.getManejoCreditoLibranza());
        Assert.assertEquals(entity.getManejoCreditoHipotecario(), newEntity.getManejoCreditoHipotecario());
        Assert.assertEquals(entity.getManejoMicrocredito(), newEntity.getManejoMicrocredito());
        Assert.assertEquals(entity.getFechaRegistroOrden(), newEntity.getFechaRegistroOrden());
        Assert.assertEquals(entity.getFechaInicioFacturacion(), newEntity.getFechaInicioFacturacion());
        Assert.assertEquals(entity.getEstadoOrden(), newEntity.getEstadoOrden());
        Assert.assertEquals(entity.getIdCoreCartera(), newEntity.getIdCoreCartera());
        Assert.assertEquals(entity.getUsuarioCoreCartera(), newEntity.getUsuarioCoreCartera());
        Assert.assertEquals(entity.getUrlCoreCartera(), newEntity.getUrlCoreCartera());
        Assert.assertEquals(entity.getNumeroUsuariosInicial(), newEntity.getNumeroUsuariosInicial());
        Assert.assertEquals(entity.getNumeroCreditosInicial(), newEntity.getNumeroCreditosInicial());
        Assert.assertEquals(entity.getValorCarteraInicial(), newEntity.getValorCarteraInicial());
    }

    /**
     * @generated
     */
    @Test
    public void deleteOrdenTest() {
        OrdenEntity entity = data.get(0);
        ordenPersistence.delete(entity.getId());
        OrdenEntity deleted = em.find(OrdenEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * @generated
     */
    @Test
    public void updateOrdenTest() {
        OrdenEntity entity = data.get(0);

        OrdenEntity newEntity = new OrdenEntity();

        newEntity.setId(entity.getId());
        newEntity.setName(generateRandom(String.class));
        newEntity.setManejoCreditoConsumo(generateRandom(Boolean.class));
        newEntity.setManejoCreditoComercial(generateRandom(Boolean.class));
        newEntity.setManejoCreditoLibranza(generateRandom(Boolean.class));
        newEntity.setManejoCreditoHipotecario(generateRandom(Boolean.class));
        newEntity.setManejoMicrocredito(generateRandom(Boolean.class));
        newEntity.setFechaRegistroOrden(generateRandom(Date.class));
        newEntity.setFechaInicioFacturacion(generateRandom(Date.class));
        newEntity.setEstadoOrden(generateRandom(Integer.class));
        newEntity.setIdCoreCartera(generateRandom(String.class));
        newEntity.setUsuarioCoreCartera(generateRandom(String.class));
        newEntity.setUrlCoreCartera(generateRandom(String.class));
        newEntity.setNumeroUsuariosInicial(generateRandom(Integer.class));
        newEntity.setNumeroCreditosInicial(generateRandom(Integer.class));
        newEntity.setValorCarteraInicial(generateRandom(Integer.class));

        ordenPersistence.update(newEntity);

        OrdenEntity resp = em.find(OrdenEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getName(), resp.getName());
        Assert.assertEquals(newEntity.getManejoCreditoConsumo(), resp.getManejoCreditoConsumo());
        Assert.assertEquals(newEntity.getManejoCreditoComercial(), resp.getManejoCreditoComercial());
        Assert.assertEquals(newEntity.getManejoCreditoLibranza(), resp.getManejoCreditoLibranza());
        Assert.assertEquals(newEntity.getManejoCreditoHipotecario(), resp.getManejoCreditoHipotecario());
        Assert.assertEquals(newEntity.getManejoMicrocredito(), resp.getManejoMicrocredito());
        Assert.assertEquals(newEntity.getFechaRegistroOrden(), resp.getFechaRegistroOrden());
        Assert.assertEquals(newEntity.getFechaInicioFacturacion(), resp.getFechaInicioFacturacion());
        Assert.assertEquals(newEntity.getEstadoOrden(), resp.getEstadoOrden());
        Assert.assertEquals(newEntity.getIdCoreCartera(), resp.getIdCoreCartera());
        Assert.assertEquals(newEntity.getUsuarioCoreCartera(), resp.getUsuarioCoreCartera());
        Assert.assertEquals(newEntity.getUrlCoreCartera(), resp.getUrlCoreCartera());
        Assert.assertEquals(newEntity.getNumeroUsuariosInicial(), resp.getNumeroUsuariosInicial());
        Assert.assertEquals(newEntity.getNumeroCreditosInicial(), resp.getNumeroCreditosInicial());
        Assert.assertEquals(newEntity.getValorCarteraInicial(), resp.getValorCarteraInicial());
    }

    /**
     * @generated
     */
    @Test
    public void getOrdenPaginationTest() {
        //Page 1
        List<OrdenEntity> ent1 = ordenPersistence.findAll(1, 2);
        Assert.assertNotNull(ent1);
        Assert.assertEquals(2, ent1.size());
        //Page 2
        List<OrdenEntity> ent2 = ordenPersistence.findAll(2, 2);
        Assert.assertNotNull(ent2);
        Assert.assertEquals(1, ent2.size());

        for (OrdenEntity ent : ent1) {
            boolean found = false;
            for (OrdenEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }

        for (OrdenEntity ent : ent2) {
            boolean found = false;
            for (OrdenEntity entity : data) {
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
        List<OrdenEntity> cache = new ArrayList<OrdenEntity>();
        List<OrdenEntity> list = ordenPersistence.findByName(name);

        for (OrdenEntity entity : data) {
            if (entity.getName().equals(name)) {
                cache.add(entity);
            }
        }
        Assert.assertEquals(list.size(), cache.size());
        for (OrdenEntity ent : list) {
            boolean found = false;
            for (OrdenEntity cacheEntity : cache) {
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
