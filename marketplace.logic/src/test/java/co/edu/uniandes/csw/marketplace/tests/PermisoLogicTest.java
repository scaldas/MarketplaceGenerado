package co.edu.uniandes.csw.marketplace.tests;

import co.edu.uniandes.csw.marketplace.ejbs.PermisoLogic;
import co.edu.uniandes.csw.marketplace.api.IPermisoLogic;
import co.edu.uniandes.csw.marketplace.converters.PermisoConverter;
import co.edu.uniandes.csw.marketplace.dtos.PermisoDTO;
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
public class PermisoLogicTest {
    public static final String DEPLOY = "Prueba";

    /**
     * @generated
     */
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(PermisoEntity.class.getPackage())
                .addPackage(PermisoDTO.class.getPackage())
                .addPackage(PermisoConverter.class.getPackage())
                .addPackage(PermisoLogic.class.getPackage())
                .addPackage(IPermisoLogic.class.getPackage())
                .addPackage(PermisoPersistence.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * @generated
     */
    @Inject
    private IPermisoLogic permisoLogic;

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
        PermisoDTO dto = new PermisoDTO();
        dto.setName(generateRandom(String.class));
        dto.setUrl(generateRandom(String.class));
        dto.setMetodoRest(generateRandom(String.class));

        PermisoDTO result = permisoLogic.createPermiso(dto);

        Assert.assertNotNull(result);

        PermisoEntity entity = em.find(PermisoEntity.class, result.getId());

        Assert.assertEquals(dto.getName(), entity.getName());
        Assert.assertEquals(dto.getUrl(), entity.getUrl());
        Assert.assertEquals(dto.getMetodoRest(), entity.getMetodoRest());
    }

    /**
     * @generated
     */
    @Test
    public void getPermisosTest() {
        List<PermisoDTO> list = permisoLogic.getPermisos(null, null);
        Assert.assertEquals(data.size(), list.size());
        for (PermisoDTO dto : list) {
            boolean found = false;
            for (PermisoEntity entity : data) {
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
    public void getPermisoTest() {
        PermisoEntity entity = data.get(0);
        PermisoDTO dto = permisoLogic.getPermiso(entity.getId());
        Assert.assertNotNull(dto);
        Assert.assertEquals(entity.getName(), dto.getName());
        Assert.assertEquals(entity.getUrl(), dto.getUrl());
        Assert.assertEquals(entity.getMetodoRest(), dto.getMetodoRest());
    }

    /**
     * @generated
     */
    @Test
    public void deletePermisoTest() {
        PermisoEntity entity = data.get(0);
        permisoLogic.deletePermiso(entity.getId());
        PermisoEntity deleted = em.find(PermisoEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * @generated
     */
    @Test
    public void updatePermisoTest() {
        PermisoEntity entity = data.get(0);

        PermisoDTO dto = new PermisoDTO();

        dto.setId(entity.getId());
        dto.setName(generateRandom(String.class));
        dto.setUrl(generateRandom(String.class));
        dto.setMetodoRest(generateRandom(String.class));

        permisoLogic.updatePermiso(dto);

        PermisoEntity resp = em.find(PermisoEntity.class, entity.getId());

        Assert.assertEquals(dto.getName(), resp.getName());
        Assert.assertEquals(dto.getUrl(), resp.getUrl());
        Assert.assertEquals(dto.getMetodoRest(), resp.getMetodoRest());
    }

    /**
     * @generated
     */
    @Test
    public void getPermisoPaginationTest() {
        //Page 1
        List<PermisoDTO> dto1 = permisoLogic.getPermisos(1, 2);
        Assert.assertNotNull(dto1);
        Assert.assertEquals(2, dto1.size());
        //Page 2
        List<PermisoDTO> dto2 = permisoLogic.getPermisos(2, 2);
        Assert.assertNotNull(dto2);
        Assert.assertEquals(1, dto2.size());

        for (PermisoDTO dto : dto1) {
            boolean found = false;
            for (PermisoEntity entity : data) {
                if (dto.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }

        for (PermisoDTO dto : dto2) {
            boolean found = false;
            for (PermisoEntity entity : data) {
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
        List<PermisoEntity> cache = new ArrayList<PermisoEntity>();
        List<PermisoDTO> list = permisoLogic.findByName(name);

        for (PermisoEntity entity : data) {
            if (entity.getName().equals(name)) {
                cache.add(entity);
            }
        }
        Assert.assertEquals(cache.size(), list.size());
        for (PermisoDTO dto : list) {
            boolean found = false;
            for (PermisoEntity cacheEntity : cache) {
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
