package co.edu.uniandes.csw.marketplace.tests;

import co.edu.uniandes.csw.marketplace.ejbs.ServicioLogic;
import co.edu.uniandes.csw.marketplace.api.IServicioLogic;
import co.edu.uniandes.csw.marketplace.converters.ServicioConverter;
import co.edu.uniandes.csw.marketplace.dtos.ServicioDTO;
import co.edu.uniandes.csw.marketplace.entities.ServicioEntity;
import co.edu.uniandes.csw.marketplace.persistence.ServicioPersistence;
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
public class ServicioLogicTest {
    public static final String DEPLOY = "Prueba";

    /**
     * @generated
     */
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(ServicioEntity.class.getPackage())
                .addPackage(ServicioDTO.class.getPackage())
                .addPackage(ServicioConverter.class.getPackage())
                .addPackage(ServicioLogic.class.getPackage())
                .addPackage(IServicioLogic.class.getPackage())
                .addPackage(ServicioPersistence.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * @generated
     */
    @Inject
    private IServicioLogic servicioLogic;

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
        em.createQuery("delete from ServicioEntity").executeUpdate();
    }

    /**
     * @generated
     */
    private List<ServicioEntity> data = new ArrayList<ServicioEntity>();

    /**
     * @generated
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            ServicioEntity entity = new ServicioEntity();
        	entity.setName(generateRandom(String.class));
            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * @generated
     */
    @Test
    public void createServicioTest() {
        ServicioDTO dto = new ServicioDTO();
        dto.setName(generateRandom(String.class));

        ServicioDTO result = servicioLogic.createServicio(dto);

        Assert.assertNotNull(result);

        ServicioEntity entity = em.find(ServicioEntity.class, result.getId());

        Assert.assertEquals(dto.getName(), entity.getName());
    }

    /**
     * @generated
     */
    @Test
    public void getServiciosTest() {
        List<ServicioDTO> list = servicioLogic.getServicios(null, null);
        Assert.assertEquals(data.size(), list.size());
        for (ServicioDTO dto : list) {
            boolean found = false;
            for (ServicioEntity entity : data) {
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
    public void getServicioTest() {
        ServicioEntity entity = data.get(0);
        ServicioDTO dto = servicioLogic.getServicio(entity.getId());
        Assert.assertNotNull(dto);
        Assert.assertEquals(entity.getName(), dto.getName());
    }

    /**
     * @generated
     */
    @Test
    public void deleteServicioTest() {
        ServicioEntity entity = data.get(0);
        servicioLogic.deleteServicio(entity.getId());
        ServicioEntity deleted = em.find(ServicioEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * @generated
     */
    @Test
    public void updateServicioTest() {
        ServicioEntity entity = data.get(0);

        ServicioDTO dto = new ServicioDTO();

        dto.setId(entity.getId());
        dto.setName(generateRandom(String.class));

        servicioLogic.updateServicio(dto);

        ServicioEntity resp = em.find(ServicioEntity.class, entity.getId());

        Assert.assertEquals(dto.getName(), resp.getName());
    }

    /**
     * @generated
     */
    @Test
    public void getServicioPaginationTest() {
        //Page 1
        List<ServicioDTO> dto1 = servicioLogic.getServicios(1, 2);
        Assert.assertNotNull(dto1);
        Assert.assertEquals(2, dto1.size());
        //Page 2
        List<ServicioDTO> dto2 = servicioLogic.getServicios(2, 2);
        Assert.assertNotNull(dto2);
        Assert.assertEquals(1, dto2.size());

        for (ServicioDTO dto : dto1) {
            boolean found = false;
            for (ServicioEntity entity : data) {
                if (dto.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }

        for (ServicioDTO dto : dto2) {
            boolean found = false;
            for (ServicioEntity entity : data) {
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
        List<ServicioEntity> cache = new ArrayList<ServicioEntity>();
        List<ServicioDTO> list = servicioLogic.findByName(name);

        for (ServicioEntity entity : data) {
            if (entity.getName().equals(name)) {
                cache.add(entity);
            }
        }
        Assert.assertEquals(cache.size(), list.size());
        for (ServicioDTO dto : list) {
            boolean found = false;
            for (ServicioEntity cacheEntity : cache) {
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
