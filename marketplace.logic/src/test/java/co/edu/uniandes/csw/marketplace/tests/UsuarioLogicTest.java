package co.edu.uniandes.csw.marketplace.tests;

import co.edu.uniandes.csw.marketplace.ejbs.UsuarioLogic;
import co.edu.uniandes.csw.marketplace.api.IUsuarioLogic;
import co.edu.uniandes.csw.marketplace.converters.UsuarioConverter;
import co.edu.uniandes.csw.marketplace.dtos.UsuarioDTO;
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
public class UsuarioLogicTest {
    public static final String DEPLOY = "Prueba";

    /**
     * @generated
     */
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(UsuarioEntity.class.getPackage())
                .addPackage(UsuarioDTO.class.getPackage())
                .addPackage(UsuarioConverter.class.getPackage())
                .addPackage(UsuarioLogic.class.getPackage())
                .addPackage(IUsuarioLogic.class.getPackage())
                .addPackage(UsuarioPersistence.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * @generated
     */
    @Inject
    private IUsuarioLogic usuarioLogic;

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
        UsuarioDTO dto = new UsuarioDTO();
        dto.setName(generateRandom(String.class));
        dto.setCorreoElectronico(generateRandom(String.class));
        dto.setContrasenia(generateRandom(String.class));
        dto.setCargo(generateRandom(String.class));
        dto.setNombresContacto(generateRandom(String.class));
        dto.setApellidosContacto(generateRandom(String.class));

        UsuarioDTO result = usuarioLogic.createUsuario(dto);

        Assert.assertNotNull(result);

        UsuarioEntity entity = em.find(UsuarioEntity.class, result.getId());

        Assert.assertEquals(dto.getName(), entity.getName());
        Assert.assertEquals(dto.getCorreoElectronico(), entity.getCorreoElectronico());
        Assert.assertEquals(dto.getContrasenia(), entity.getContrasenia());
        Assert.assertEquals(dto.getCargo(), entity.getCargo());
        Assert.assertEquals(dto.getNombresContacto(), entity.getNombresContacto());
        Assert.assertEquals(dto.getApellidosContacto(), entity.getApellidosContacto());
    }

    /**
     * @generated
     */
    @Test
    public void getUsuariosTest() {
        List<UsuarioDTO> list = usuarioLogic.getUsuarios(null, null);
        Assert.assertEquals(data.size(), list.size());
        for (UsuarioDTO dto : list) {
            boolean found = false;
            for (UsuarioEntity entity : data) {
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
    public void getUsuarioTest() {
        UsuarioEntity entity = data.get(0);
        UsuarioDTO dto = usuarioLogic.getUsuario(entity.getId());
        Assert.assertNotNull(dto);
        Assert.assertEquals(entity.getName(), dto.getName());
        Assert.assertEquals(entity.getCorreoElectronico(), dto.getCorreoElectronico());
        Assert.assertEquals(entity.getContrasenia(), dto.getContrasenia());
        Assert.assertEquals(entity.getCargo(), dto.getCargo());
        Assert.assertEquals(entity.getNombresContacto(), dto.getNombresContacto());
        Assert.assertEquals(entity.getApellidosContacto(), dto.getApellidosContacto());
    }

    /**
     * @generated
     */
    @Test
    public void deleteUsuarioTest() {
        UsuarioEntity entity = data.get(0);
        usuarioLogic.deleteUsuario(entity.getId());
        UsuarioEntity deleted = em.find(UsuarioEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * @generated
     */
    @Test
    public void updateUsuarioTest() {
        UsuarioEntity entity = data.get(0);

        UsuarioDTO dto = new UsuarioDTO();

        dto.setId(entity.getId());
        dto.setName(generateRandom(String.class));
        dto.setCorreoElectronico(generateRandom(String.class));
        dto.setContrasenia(generateRandom(String.class));
        dto.setCargo(generateRandom(String.class));
        dto.setNombresContacto(generateRandom(String.class));
        dto.setApellidosContacto(generateRandom(String.class));

        usuarioLogic.updateUsuario(dto);

        UsuarioEntity resp = em.find(UsuarioEntity.class, entity.getId());

        Assert.assertEquals(dto.getName(), resp.getName());
        Assert.assertEquals(dto.getCorreoElectronico(), resp.getCorreoElectronico());
        Assert.assertEquals(dto.getContrasenia(), resp.getContrasenia());
        Assert.assertEquals(dto.getCargo(), resp.getCargo());
        Assert.assertEquals(dto.getNombresContacto(), resp.getNombresContacto());
        Assert.assertEquals(dto.getApellidosContacto(), resp.getApellidosContacto());
    }

    /**
     * @generated
     */
    @Test
    public void getUsuarioPaginationTest() {
        //Page 1
        List<UsuarioDTO> dto1 = usuarioLogic.getUsuarios(1, 2);
        Assert.assertNotNull(dto1);
        Assert.assertEquals(2, dto1.size());
        //Page 2
        List<UsuarioDTO> dto2 = usuarioLogic.getUsuarios(2, 2);
        Assert.assertNotNull(dto2);
        Assert.assertEquals(1, dto2.size());

        for (UsuarioDTO dto : dto1) {
            boolean found = false;
            for (UsuarioEntity entity : data) {
                if (dto.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }

        for (UsuarioDTO dto : dto2) {
            boolean found = false;
            for (UsuarioEntity entity : data) {
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
        List<UsuarioEntity> cache = new ArrayList<UsuarioEntity>();
        List<UsuarioDTO> list = usuarioLogic.findByName(name);

        for (UsuarioEntity entity : data) {
            if (entity.getName().equals(name)) {
                cache.add(entity);
            }
        }
        Assert.assertEquals(cache.size(), list.size());
        for (UsuarioDTO dto : list) {
            boolean found = false;
            for (UsuarioEntity cacheEntity : cache) {
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
