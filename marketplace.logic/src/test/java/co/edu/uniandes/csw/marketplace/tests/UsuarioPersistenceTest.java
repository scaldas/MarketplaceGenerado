package co.edu.uniandes.csw.marketplace.tests;

import co.edu.uniandes.csw.marketplace.entities.UsuarioEntity;
import co.edu.uniandes.csw.marketplace.persistence.UsuarioPersistence;
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
public class UsuarioPersistenceTest {
    public static final String DEPLOY = "Prueba";

    /**
     * @generated
     */
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(UsuarioEntity.class.getPackage())
                .addPackage(UsuarioPersistence.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * @generated
     */
    @Inject
    private UsuarioPersistence usuarioPersistence;

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
        em.createQuery("delete from UsuarioEntity").executeUpdate();
    }

    /**
     * @generated
     */
    private List<UsuarioEntity> data = new ArrayList<UsuarioEntity>();

    /**
     * @generated
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            UsuarioEntity entity = new UsuarioEntity();
            entity.setName(generateRandom(String.class));
            entity.setCorreoElectronico(generateRandom(String.class));
            entity.setContrasenia(generateRandom(String.class));
            entity.setCargo(generateRandom(String.class));
            entity.setNombresContacto(generateRandom(String.class));
            entity.setApellidosContacto(generateRandom(String.class));
            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * @generated
     */
    @Test
    public void createUsuarioTest() {
        UsuarioEntity newEntity = new UsuarioEntity();
        newEntity.setName(generateRandom(String.class));
        newEntity.setCorreoElectronico(generateRandom(String.class));
        newEntity.setContrasenia(generateRandom(String.class));
        newEntity.setCargo(generateRandom(String.class));
        newEntity.setNombresContacto(generateRandom(String.class));
        newEntity.setApellidosContacto(generateRandom(String.class));

        UsuarioEntity result = usuarioPersistence.create(newEntity);

        Assert.assertNotNull(result);

        UsuarioEntity entity = em.find(UsuarioEntity.class, result.getId());

        Assert.assertEquals(newEntity.getName(), entity.getName());
        Assert.assertEquals(newEntity.getCorreoElectronico(), entity.getCorreoElectronico());
        Assert.assertEquals(newEntity.getContrasenia(), entity.getContrasenia());
        Assert.assertEquals(newEntity.getCargo(), entity.getCargo());
        Assert.assertEquals(newEntity.getNombresContacto(), entity.getNombresContacto());
        Assert.assertEquals(newEntity.getApellidosContacto(), entity.getApellidosContacto());
    }

    /**
     * @generated
     */
    @Test
    public void getUsuariosTest() {
        List<UsuarioEntity> list = usuarioPersistence.findAll(null, null);
        Assert.assertEquals(data.size(), list.size());
        for (UsuarioEntity ent : list) {
            boolean found = false;
            for (UsuarioEntity entity : data) {
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
    public void getUsuarioTest() {
        UsuarioEntity entity = data.get(0);
        UsuarioEntity newEntity = usuarioPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getName(), newEntity.getName());
        Assert.assertEquals(entity.getCorreoElectronico(), newEntity.getCorreoElectronico());
        Assert.assertEquals(entity.getContrasenia(), newEntity.getContrasenia());
        Assert.assertEquals(entity.getCargo(), newEntity.getCargo());
        Assert.assertEquals(entity.getNombresContacto(), newEntity.getNombresContacto());
        Assert.assertEquals(entity.getApellidosContacto(), newEntity.getApellidosContacto());
    }

    /**
     * @generated
     */
    @Test
    public void deleteUsuarioTest() {
        UsuarioEntity entity = data.get(0);
        usuarioPersistence.delete(entity.getId());
        UsuarioEntity deleted = em.find(UsuarioEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * @generated
     */
    @Test
    public void updateUsuarioTest() {
        UsuarioEntity entity = data.get(0);

        UsuarioEntity newEntity = new UsuarioEntity();

        newEntity.setId(entity.getId());
        newEntity.setName(generateRandom(String.class));
        newEntity.setCorreoElectronico(generateRandom(String.class));
        newEntity.setContrasenia(generateRandom(String.class));
        newEntity.setCargo(generateRandom(String.class));
        newEntity.setNombresContacto(generateRandom(String.class));
        newEntity.setApellidosContacto(generateRandom(String.class));

        usuarioPersistence.update(newEntity);

        UsuarioEntity resp = em.find(UsuarioEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getName(), resp.getName());
        Assert.assertEquals(newEntity.getCorreoElectronico(), resp.getCorreoElectronico());
        Assert.assertEquals(newEntity.getContrasenia(), resp.getContrasenia());
        Assert.assertEquals(newEntity.getCargo(), resp.getCargo());
        Assert.assertEquals(newEntity.getNombresContacto(), resp.getNombresContacto());
        Assert.assertEquals(newEntity.getApellidosContacto(), resp.getApellidosContacto());
    }

    /**
     * @generated
     */
    @Test
    public void getUsuarioPaginationTest() {
        //Page 1
        List<UsuarioEntity> ent1 = usuarioPersistence.findAll(1, 2);
        Assert.assertNotNull(ent1);
        Assert.assertEquals(2, ent1.size());
        //Page 2
        List<UsuarioEntity> ent2 = usuarioPersistence.findAll(2, 2);
        Assert.assertNotNull(ent2);
        Assert.assertEquals(1, ent2.size());

        for (UsuarioEntity ent : ent1) {
            boolean found = false;
            for (UsuarioEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }

        for (UsuarioEntity ent : ent2) {
            boolean found = false;
            for (UsuarioEntity entity : data) {
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
        List<UsuarioEntity> cache = new ArrayList<UsuarioEntity>();
        List<UsuarioEntity> list = usuarioPersistence.findByName(name);

        for (UsuarioEntity entity : data) {
            if (entity.getName().equals(name)) {
                cache.add(entity);
            }
        }
        Assert.assertEquals(list.size(), cache.size());
        for (UsuarioEntity ent : list) {
            boolean found = false;
            for (UsuarioEntity cacheEntity : cache) {
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
