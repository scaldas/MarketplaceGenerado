package co.edu.uniandes.csw.marketplace.tests;

import co.edu.uniandes.csw.marketplace.ejbs.IVALogic;
import co.edu.uniandes.csw.marketplace.api.IIVALogic;
import co.edu.uniandes.csw.marketplace.converters.IVAConverter;
import co.edu.uniandes.csw.marketplace.dtos.IVADTO;
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
public class IVALogicTest {
    public static final String DEPLOY = "Prueba";

    /**
     * @generated
     */
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(IVAEntity.class.getPackage())
                .addPackage(IVADTO.class.getPackage())
                .addPackage(IVAConverter.class.getPackage())
                .addPackage(IVALogic.class.getPackage())
                .addPackage(IIVALogic.class.getPackage())
                .addPackage(IVAPersistence.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * @generated
     */
    @Inject
    private IIVALogic iVALogic;

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
        IVADTO dto = new IVADTO();
        dto.setPorcentajeIVA(generateRandom(Double.class));
        dto.setFechaInicioVigencia(generateRandom(Date.class));
        dto.setFechaFinVigencia(generateRandom(Date.class));
        dto.setName(generateRandom(String.class));

        IVADTO result = iVALogic.createIVA(dto);

        Assert.assertNotNull(result);

        IVAEntity entity = em.find(IVAEntity.class, result.getId());

        Assert.assertEquals(dto.getPorcentajeIVA(), entity.getPorcentajeIVA());
        Assert.assertEquals(dto.getFechaInicioVigencia(), entity.getFechaInicioVigencia());
        Assert.assertEquals(dto.getFechaFinVigencia(), entity.getFechaFinVigencia());
        Assert.assertEquals(dto.getName(), entity.getName());
    }

    /**
     * @generated
     */
    @Test
    public void getIVAsTest() {
        List<IVADTO> list = iVALogic.getIVAs(null, null);
        Assert.assertEquals(data.size(), list.size());
        for (IVADTO dto : list) {
            boolean found = false;
            for (IVAEntity entity : data) {
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
    public void getIVATest() {
        IVAEntity entity = data.get(0);
        IVADTO dto = iVALogic.getIVA(entity.getId());
        Assert.assertNotNull(dto);
        Assert.assertEquals(entity.getPorcentajeIVA(), dto.getPorcentajeIVA());
        Assert.assertEquals(entity.getFechaInicioVigencia(), dto.getFechaInicioVigencia());
        Assert.assertEquals(entity.getFechaFinVigencia(), dto.getFechaFinVigencia());
        Assert.assertEquals(entity.getName(), dto.getName());
    }

    /**
     * @generated
     */
    @Test
    public void deleteIVATest() {
        IVAEntity entity = data.get(0);
        iVALogic.deleteIVA(entity.getId());
        IVAEntity deleted = em.find(IVAEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * @generated
     */
    @Test
    public void updateIVATest() {
        IVAEntity entity = data.get(0);

        IVADTO dto = new IVADTO();

        dto.setId(entity.getId());
        dto.setPorcentajeIVA(generateRandom(Double.class));
        dto.setFechaInicioVigencia(generateRandom(Date.class));
        dto.setFechaFinVigencia(generateRandom(Date.class));
        dto.setName(generateRandom(String.class));

        iVALogic.updateIVA(dto);

        IVAEntity resp = em.find(IVAEntity.class, entity.getId());

        Assert.assertEquals(dto.getPorcentajeIVA(), resp.getPorcentajeIVA());
        Assert.assertEquals(dto.getFechaInicioVigencia(), resp.getFechaInicioVigencia());
        Assert.assertEquals(dto.getFechaFinVigencia(), resp.getFechaFinVigencia());
        Assert.assertEquals(dto.getName(), resp.getName());
    }

    /**
     * @generated
     */
    @Test
    public void getIVAPaginationTest() {
        //Page 1
        List<IVADTO> dto1 = iVALogic.getIVAs(1, 2);
        Assert.assertNotNull(dto1);
        Assert.assertEquals(2, dto1.size());
        //Page 2
        List<IVADTO> dto2 = iVALogic.getIVAs(2, 2);
        Assert.assertNotNull(dto2);
        Assert.assertEquals(1, dto2.size());

        for (IVADTO dto : dto1) {
            boolean found = false;
            for (IVAEntity entity : data) {
                if (dto.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }

        for (IVADTO dto : dto2) {
            boolean found = false;
            for (IVAEntity entity : data) {
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
        List<IVAEntity> cache = new ArrayList<IVAEntity>();
        List<IVADTO> list = iVALogic.findByName(name);

        for (IVAEntity entity : data) {
            if (entity.getName().equals(name)) {
                cache.add(entity);
            }
        }
        Assert.assertEquals(cache.size(), list.size());
        for (IVADTO dto : list) {
            boolean found = false;
            for (IVAEntity cacheEntity : cache) {
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
