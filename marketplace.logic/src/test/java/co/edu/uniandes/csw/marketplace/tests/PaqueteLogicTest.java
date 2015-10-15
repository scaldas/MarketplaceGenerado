package co.edu.uniandes.csw.marketplace.tests;

import co.edu.uniandes.csw.marketplace.ejbs.PaqueteLogic;
import co.edu.uniandes.csw.marketplace.api.IPaqueteLogic;
import co.edu.uniandes.csw.marketplace.converters.PaqueteConverter;
import co.edu.uniandes.csw.marketplace.dtos.PaqueteDTO;
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
public class PaqueteLogicTest {
    public static final String DEPLOY = "Prueba";

    /**
     * @generated
     */
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(PaqueteEntity.class.getPackage())
                .addPackage(PaqueteDTO.class.getPackage())
                .addPackage(PaqueteConverter.class.getPackage())
                .addPackage(PaqueteLogic.class.getPackage())
                .addPackage(IPaqueteLogic.class.getPackage())
                .addPackage(PaquetePersistence.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * @generated
     */
    @Inject
    private IPaqueteLogic paqueteLogic;

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
        PaqueteDTO dto = new PaqueteDTO();
        dto.setName(generateRandom(String.class));
        dto.setDescripcion(generateRandom(String.class));
        dto.setActivo(generateRandom(Boolean.class));

        PaqueteDTO result = paqueteLogic.createPaquete(dto);

        Assert.assertNotNull(result);

        PaqueteEntity entity = em.find(PaqueteEntity.class, result.getId());

        Assert.assertEquals(dto.getName(), entity.getName());
        Assert.assertEquals(dto.getDescripcion(), entity.getDescripcion());
        Assert.assertEquals(dto.getActivo(), entity.getActivo());
    }

    /**
     * @generated
     */
    @Test
    public void getPaquetesTest() {
        List<PaqueteDTO> list = paqueteLogic.getPaquetes(null, null);
        Assert.assertEquals(data.size(), list.size());
        for (PaqueteDTO dto : list) {
            boolean found = false;
            for (PaqueteEntity entity : data) {
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
    public void getPaqueteTest() {
        PaqueteEntity entity = data.get(0);
        PaqueteDTO dto = paqueteLogic.getPaquete(entity.getId());
        Assert.assertNotNull(dto);
        Assert.assertEquals(entity.getName(), dto.getName());
        Assert.assertEquals(entity.getDescripcion(), dto.getDescripcion());
        Assert.assertEquals(entity.getActivo(), dto.getActivo());
    }

    /**
     * @generated
     */
    @Test
    public void deletePaqueteTest() {
        PaqueteEntity entity = data.get(0);
        paqueteLogic.deletePaquete(entity.getId());
        PaqueteEntity deleted = em.find(PaqueteEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * @generated
     */
    @Test
    public void updatePaqueteTest() {
        PaqueteEntity entity = data.get(0);

        PaqueteDTO dto = new PaqueteDTO();

        dto.setId(entity.getId());
        dto.setName(generateRandom(String.class));
        dto.setDescripcion(generateRandom(String.class));
        dto.setActivo(generateRandom(Boolean.class));

        paqueteLogic.updatePaquete(dto);

        PaqueteEntity resp = em.find(PaqueteEntity.class, entity.getId());

        Assert.assertEquals(dto.getName(), resp.getName());
        Assert.assertEquals(dto.getDescripcion(), resp.getDescripcion());
        Assert.assertEquals(dto.getActivo(), resp.getActivo());
    }

    /**
     * @generated
     */
    @Test
    public void getPaquetePaginationTest() {
        //Page 1
        List<PaqueteDTO> dto1 = paqueteLogic.getPaquetes(1, 2);
        Assert.assertNotNull(dto1);
        Assert.assertEquals(2, dto1.size());
        //Page 2
        List<PaqueteDTO> dto2 = paqueteLogic.getPaquetes(2, 2);
        Assert.assertNotNull(dto2);
        Assert.assertEquals(1, dto2.size());

        for (PaqueteDTO dto : dto1) {
            boolean found = false;
            for (PaqueteEntity entity : data) {
                if (dto.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }

        for (PaqueteDTO dto : dto2) {
            boolean found = false;
            for (PaqueteEntity entity : data) {
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
        List<PaqueteEntity> cache = new ArrayList<PaqueteEntity>();
        List<PaqueteDTO> list = paqueteLogic.findByName(name);

        for (PaqueteEntity entity : data) {
            if (entity.getName().equals(name)) {
                cache.add(entity);
            }
        }
        Assert.assertEquals(cache.size(), list.size());
        for (PaqueteDTO dto : list) {
            boolean found = false;
            for (PaqueteEntity cacheEntity : cache) {
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
