package co.edu.uniandes.csw.marketplace.tests;

import co.edu.uniandes.csw.marketplace.ejbs.OrdenLogic;
import co.edu.uniandes.csw.marketplace.api.IOrdenLogic;
import co.edu.uniandes.csw.marketplace.converters.OrdenConverter;
import co.edu.uniandes.csw.marketplace.dtos.OrdenDTO;
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
public class OrdenLogicTest {
    public static final String DEPLOY = "Prueba";

    /**
     * @generated
     */
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(OrdenEntity.class.getPackage())
                .addPackage(OrdenDTO.class.getPackage())
                .addPackage(OrdenConverter.class.getPackage())
                .addPackage(OrdenLogic.class.getPackage())
                .addPackage(IOrdenLogic.class.getPackage())
                .addPackage(OrdenPersistence.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * @generated
     */
    @Inject
    private IOrdenLogic ordenLogic;

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
        OrdenDTO dto = new OrdenDTO();
        dto.setName(generateRandom(String.class));
        dto.setManejoCreditoConsumo(generateRandom(Boolean.class));
        dto.setManejoCreditoComercial(generateRandom(Boolean.class));
        dto.setManejoCreditoLibranza(generateRandom(Boolean.class));
        dto.setManejoCreditoHipotecario(generateRandom(Boolean.class));
        dto.setManejoMicrocredito(generateRandom(Boolean.class));
        dto.setFechaRegistroOrden(generateRandom(Date.class));
        dto.setFechaInicioFacturacion(generateRandom(Date.class));
        dto.setEstadoOrden(generateRandom(Integer.class));
        dto.setIdCoreCartera(generateRandom(String.class));
        dto.setUsuarioCoreCartera(generateRandom(String.class));
        dto.setUrlCoreCartera(generateRandom(String.class));
        dto.setNumeroUsuariosInicial(generateRandom(Integer.class));
        dto.setNumeroCreditosInicial(generateRandom(Integer.class));
        dto.setValorCarteraInicial(generateRandom(Integer.class));

        OrdenDTO result = ordenLogic.createOrden(dto);

        Assert.assertNotNull(result);

        OrdenEntity entity = em.find(OrdenEntity.class, result.getId());

        Assert.assertEquals(dto.getName(), entity.getName());
        Assert.assertEquals(dto.getManejoCreditoConsumo(), entity.getManejoCreditoConsumo());
        Assert.assertEquals(dto.getManejoCreditoComercial(), entity.getManejoCreditoComercial());
        Assert.assertEquals(dto.getManejoCreditoLibranza(), entity.getManejoCreditoLibranza());
        Assert.assertEquals(dto.getManejoCreditoHipotecario(), entity.getManejoCreditoHipotecario());
        Assert.assertEquals(dto.getManejoMicrocredito(), entity.getManejoMicrocredito());
        Assert.assertEquals(dto.getFechaRegistroOrden(), entity.getFechaRegistroOrden());
        Assert.assertEquals(dto.getFechaInicioFacturacion(), entity.getFechaInicioFacturacion());
        Assert.assertEquals(dto.getEstadoOrden(), entity.getEstadoOrden());
        Assert.assertEquals(dto.getIdCoreCartera(), entity.getIdCoreCartera());
        Assert.assertEquals(dto.getUsuarioCoreCartera(), entity.getUsuarioCoreCartera());
        Assert.assertEquals(dto.getUrlCoreCartera(), entity.getUrlCoreCartera());
        Assert.assertEquals(dto.getNumeroUsuariosInicial(), entity.getNumeroUsuariosInicial());
        Assert.assertEquals(dto.getNumeroCreditosInicial(), entity.getNumeroCreditosInicial());
        Assert.assertEquals(dto.getValorCarteraInicial(), entity.getValorCarteraInicial());
    }

    /**
     * @generated
     */
    @Test
    public void getOrdensTest() {
        List<OrdenDTO> list = ordenLogic.getOrdens(null, null);
        Assert.assertEquals(data.size(), list.size());
        for (OrdenDTO dto : list) {
            boolean found = false;
            for (OrdenEntity entity : data) {
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
    public void getOrdenTest() {
        OrdenEntity entity = data.get(0);
        OrdenDTO dto = ordenLogic.getOrden(entity.getId());
        Assert.assertNotNull(dto);
        Assert.assertEquals(entity.getName(), dto.getName());
        Assert.assertEquals(entity.getManejoCreditoConsumo(), dto.getManejoCreditoConsumo());
        Assert.assertEquals(entity.getManejoCreditoComercial(), dto.getManejoCreditoComercial());
        Assert.assertEquals(entity.getManejoCreditoLibranza(), dto.getManejoCreditoLibranza());
        Assert.assertEquals(entity.getManejoCreditoHipotecario(), dto.getManejoCreditoHipotecario());
        Assert.assertEquals(entity.getManejoMicrocredito(), dto.getManejoMicrocredito());
        Assert.assertEquals(entity.getFechaRegistroOrden(), dto.getFechaRegistroOrden());
        Assert.assertEquals(entity.getFechaInicioFacturacion(), dto.getFechaInicioFacturacion());
        Assert.assertEquals(entity.getEstadoOrden(), dto.getEstadoOrden());
        Assert.assertEquals(entity.getIdCoreCartera(), dto.getIdCoreCartera());
        Assert.assertEquals(entity.getUsuarioCoreCartera(), dto.getUsuarioCoreCartera());
        Assert.assertEquals(entity.getUrlCoreCartera(), dto.getUrlCoreCartera());
        Assert.assertEquals(entity.getNumeroUsuariosInicial(), dto.getNumeroUsuariosInicial());
        Assert.assertEquals(entity.getNumeroCreditosInicial(), dto.getNumeroCreditosInicial());
        Assert.assertEquals(entity.getValorCarteraInicial(), dto.getValorCarteraInicial());
    }

    /**
     * @generated
     */
    @Test
    public void deleteOrdenTest() {
        OrdenEntity entity = data.get(0);
        ordenLogic.deleteOrden(entity.getId());
        OrdenEntity deleted = em.find(OrdenEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * @generated
     */
    @Test
    public void updateOrdenTest() {
        OrdenEntity entity = data.get(0);

        OrdenDTO dto = new OrdenDTO();

        dto.setId(entity.getId());
        dto.setName(generateRandom(String.class));
        dto.setManejoCreditoConsumo(generateRandom(Boolean.class));
        dto.setManejoCreditoComercial(generateRandom(Boolean.class));
        dto.setManejoCreditoLibranza(generateRandom(Boolean.class));
        dto.setManejoCreditoHipotecario(generateRandom(Boolean.class));
        dto.setManejoMicrocredito(generateRandom(Boolean.class));
        dto.setFechaRegistroOrden(generateRandom(Date.class));
        dto.setFechaInicioFacturacion(generateRandom(Date.class));
        dto.setEstadoOrden(generateRandom(Integer.class));
        dto.setIdCoreCartera(generateRandom(String.class));
        dto.setUsuarioCoreCartera(generateRandom(String.class));
        dto.setUrlCoreCartera(generateRandom(String.class));
        dto.setNumeroUsuariosInicial(generateRandom(Integer.class));
        dto.setNumeroCreditosInicial(generateRandom(Integer.class));
        dto.setValorCarteraInicial(generateRandom(Integer.class));

        ordenLogic.updateOrden(dto);

        OrdenEntity resp = em.find(OrdenEntity.class, entity.getId());

        Assert.assertEquals(dto.getName(), resp.getName());
        Assert.assertEquals(dto.getManejoCreditoConsumo(), resp.getManejoCreditoConsumo());
        Assert.assertEquals(dto.getManejoCreditoComercial(), resp.getManejoCreditoComercial());
        Assert.assertEquals(dto.getManejoCreditoLibranza(), resp.getManejoCreditoLibranza());
        Assert.assertEquals(dto.getManejoCreditoHipotecario(), resp.getManejoCreditoHipotecario());
        Assert.assertEquals(dto.getManejoMicrocredito(), resp.getManejoMicrocredito());
        Assert.assertEquals(dto.getFechaRegistroOrden(), resp.getFechaRegistroOrden());
        Assert.assertEquals(dto.getFechaInicioFacturacion(), resp.getFechaInicioFacturacion());
        Assert.assertEquals(dto.getEstadoOrden(), resp.getEstadoOrden());
        Assert.assertEquals(dto.getIdCoreCartera(), resp.getIdCoreCartera());
        Assert.assertEquals(dto.getUsuarioCoreCartera(), resp.getUsuarioCoreCartera());
        Assert.assertEquals(dto.getUrlCoreCartera(), resp.getUrlCoreCartera());
        Assert.assertEquals(dto.getNumeroUsuariosInicial(), resp.getNumeroUsuariosInicial());
        Assert.assertEquals(dto.getNumeroCreditosInicial(), resp.getNumeroCreditosInicial());
        Assert.assertEquals(dto.getValorCarteraInicial(), resp.getValorCarteraInicial());
    }

    /**
     * @generated
     */
    @Test
    public void getOrdenPaginationTest() {
        //Page 1
        List<OrdenDTO> dto1 = ordenLogic.getOrdens(1, 2);
        Assert.assertNotNull(dto1);
        Assert.assertEquals(2, dto1.size());
        //Page 2
        List<OrdenDTO> dto2 = ordenLogic.getOrdens(2, 2);
        Assert.assertNotNull(dto2);
        Assert.assertEquals(1, dto2.size());

        for (OrdenDTO dto : dto1) {
            boolean found = false;
            for (OrdenEntity entity : data) {
                if (dto.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }

        for (OrdenDTO dto : dto2) {
            boolean found = false;
            for (OrdenEntity entity : data) {
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
        List<OrdenEntity> cache = new ArrayList<OrdenEntity>();
        List<OrdenDTO> list = ordenLogic.findByName(name);

        for (OrdenEntity entity : data) {
            if (entity.getName().equals(name)) {
                cache.add(entity);
            }
        }
        Assert.assertEquals(cache.size(), list.size());
        for (OrdenDTO dto : list) {
            boolean found = false;
            for (OrdenEntity cacheEntity : cache) {
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
