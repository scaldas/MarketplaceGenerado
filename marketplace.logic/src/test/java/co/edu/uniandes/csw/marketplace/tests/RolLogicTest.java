package co.edu.uniandes.csw.marketplace.tests;

import co.edu.uniandes.csw.marketplace.ejbs.RolLogic;
import co.edu.uniandes.csw.marketplace.api.IRolLogic;
import co.edu.uniandes.csw.marketplace.converters.RolConverter;
import co.edu.uniandes.csw.marketplace.dtos.RolDTO;
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
public class RolLogicTest {
    public static final String DEPLOY = "Prueba";

    /**
     * @generated
     */
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(RolEntity.class.getPackage())
                .addPackage(RolDTO.class.getPackage())
                .addPackage(RolConverter.class.getPackage())
                .addPackage(RolLogic.class.getPackage())
                .addPackage(IRolLogic.class.getPackage())
                .addPackage(RolPersistence.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * @generated
     */
    @Inject
    private IRolLogic rolLogic;

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
        RolDTO dto = new RolDTO();
        dto.setName(generateRandom(String.class));

        RolDTO result = rolLogic.createRol(dto);

        Assert.assertNotNull(result);

        RolEntity entity = em.find(RolEntity.class, result.getId());

        Assert.assertEquals(dto.getName(), entity.getName());
    }

    /**
     * @generated
     */
    @Test
    public void getRolsTest() {
        List<RolDTO> list = rolLogic.getRols(null, null);
        Assert.assertEquals(data.size(), list.size());
        for (RolDTO dto : list) {
            boolean found = false;
            for (RolEntity entity : data) {
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
    public void getRolTest() {
        RolEntity entity = data.get(0);
        RolDTO dto = rolLogic.getRol(entity.getId());
        Assert.assertNotNull(dto);
        Assert.assertEquals(entity.getName(), dto.getName());
    }

    /**
     * @generated
     */
    @Test
    public void deleteRolTest() {
        RolEntity entity = data.get(0);
        rolLogic.deleteRol(entity.getId());
        RolEntity deleted = em.find(RolEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * @generated
     */
    @Test
    public void updateRolTest() {
        RolEntity entity = data.get(0);

        RolDTO dto = new RolDTO();

        dto.setId(entity.getId());
        dto.setName(generateRandom(String.class));

        rolLogic.updateRol(dto);

        RolEntity resp = em.find(RolEntity.class, entity.getId());

        Assert.assertEquals(dto.getName(), resp.getName());
    }

    /**
     * @generated
     */
    @Test
    public void getRolPaginationTest() {
        //Page 1
        List<RolDTO> dto1 = rolLogic.getRols(1, 2);
        Assert.assertNotNull(dto1);
        Assert.assertEquals(2, dto1.size());
        //Page 2
        List<RolDTO> dto2 = rolLogic.getRols(2, 2);
        Assert.assertNotNull(dto2);
        Assert.assertEquals(1, dto2.size());

        for (RolDTO dto : dto1) {
            boolean found = false;
            for (RolEntity entity : data) {
                if (dto.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }

        for (RolDTO dto : dto2) {
            boolean found = false;
            for (RolEntity entity : data) {
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
        List<RolEntity> cache = new ArrayList<RolEntity>();
        List<RolDTO> list = rolLogic.findByName(name);

        for (RolEntity entity : data) {
            if (entity.getName().equals(name)) {
                cache.add(entity);
            }
        }
        Assert.assertEquals(cache.size(), list.size());
        for (RolDTO dto : list) {
            boolean found = false;
            for (RolEntity cacheEntity : cache) {
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
