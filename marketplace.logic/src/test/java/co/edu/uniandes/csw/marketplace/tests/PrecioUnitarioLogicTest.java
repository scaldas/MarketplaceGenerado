package co.edu.uniandes.csw.marketplace.tests;

import co.edu.uniandes.csw.marketplace.ejbs.PrecioUnitarioLogic;
import co.edu.uniandes.csw.marketplace.api.IPrecioUnitarioLogic;
import co.edu.uniandes.csw.marketplace.converters.PrecioUnitarioConverter;
import co.edu.uniandes.csw.marketplace.dtos.PrecioUnitarioDTO;
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
public class PrecioUnitarioLogicTest {
    public static final String DEPLOY = "Prueba";

    /**
     * @generated
     */
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(PrecioUnitarioEntity.class.getPackage())
                .addPackage(PrecioUnitarioDTO.class.getPackage())
                .addPackage(PrecioUnitarioConverter.class.getPackage())
                .addPackage(PrecioUnitarioLogic.class.getPackage())
                .addPackage(IPrecioUnitarioLogic.class.getPackage())
                .addPackage(PrecioUnitarioPersistence.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * @generated
     */
    @Inject
    private IPrecioUnitarioLogic precioUnitarioLogic;

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
        PrecioUnitarioDTO dto = new PrecioUnitarioDTO();
        dto.setName(generateRandom(String.class));
        dto.setPrecioUnidad(generateRandom(Double.class));
        dto.setRangoInicial(generateRandom(Integer.class));
        dto.setRangoFinal(generateRandom(Integer.class));
        dto.setFechaInicioValidez(generateRandom(Date.class));
        dto.setFechaFinValidez(generateRandom(Date.class));

        PrecioUnitarioDTO result = precioUnitarioLogic.createPrecioUnitario(dto);

        Assert.assertNotNull(result);

        PrecioUnitarioEntity entity = em.find(PrecioUnitarioEntity.class, result.getId());

        Assert.assertEquals(dto.getName(), entity.getName());
        Assert.assertEquals(dto.getPrecioUnidad(), entity.getPrecioUnidad());
        Assert.assertEquals(dto.getRangoInicial(), entity.getRangoInicial());
        Assert.assertEquals(dto.getRangoFinal(), entity.getRangoFinal());
        Assert.assertEquals(dto.getFechaInicioValidez(), entity.getFechaInicioValidez());
        Assert.assertEquals(dto.getFechaFinValidez(), entity.getFechaFinValidez());
    }

    /**
     * @generated
     */
    @Test
    public void getPrecioUnitariosTest() {
        List<PrecioUnitarioDTO> list = precioUnitarioLogic.getPrecioUnitarios(null, null);
        Assert.assertEquals(data.size(), list.size());
        for (PrecioUnitarioDTO dto : list) {
            boolean found = false;
            for (PrecioUnitarioEntity entity : data) {
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
    public void getPrecioUnitarioTest() {
        PrecioUnitarioEntity entity = data.get(0);
        PrecioUnitarioDTO dto = precioUnitarioLogic.getPrecioUnitario(entity.getId());
        Assert.assertNotNull(dto);
        Assert.assertEquals(entity.getName(), dto.getName());
        Assert.assertEquals(entity.getPrecioUnidad(), dto.getPrecioUnidad());
        Assert.assertEquals(entity.getRangoInicial(), dto.getRangoInicial());
        Assert.assertEquals(entity.getRangoFinal(), dto.getRangoFinal());
        Assert.assertEquals(entity.getFechaInicioValidez(), dto.getFechaInicioValidez());
        Assert.assertEquals(entity.getFechaFinValidez(), dto.getFechaFinValidez());
    }

    /**
     * @generated
     */
    @Test
    public void deletePrecioUnitarioTest() {
        PrecioUnitarioEntity entity = data.get(0);
        precioUnitarioLogic.deletePrecioUnitario(entity.getId());
        PrecioUnitarioEntity deleted = em.find(PrecioUnitarioEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * @generated
     */
    @Test
    public void updatePrecioUnitarioTest() {
        PrecioUnitarioEntity entity = data.get(0);

        PrecioUnitarioDTO dto = new PrecioUnitarioDTO();

        dto.setId(entity.getId());
        dto.setName(generateRandom(String.class));
        dto.setPrecioUnidad(generateRandom(Double.class));
        dto.setRangoInicial(generateRandom(Integer.class));
        dto.setRangoFinal(generateRandom(Integer.class));
        dto.setFechaInicioValidez(generateRandom(Date.class));
        dto.setFechaFinValidez(generateRandom(Date.class));

        precioUnitarioLogic.updatePrecioUnitario(dto);

        PrecioUnitarioEntity resp = em.find(PrecioUnitarioEntity.class, entity.getId());

        Assert.assertEquals(dto.getName(), resp.getName());
        Assert.assertEquals(dto.getPrecioUnidad(), resp.getPrecioUnidad());
        Assert.assertEquals(dto.getRangoInicial(), resp.getRangoInicial());
        Assert.assertEquals(dto.getRangoFinal(), resp.getRangoFinal());
        Assert.assertEquals(dto.getFechaInicioValidez(), resp.getFechaInicioValidez());
        Assert.assertEquals(dto.getFechaFinValidez(), resp.getFechaFinValidez());
    }

    /**
     * @generated
     */
    @Test
    public void getPrecioUnitarioPaginationTest() {
        //Page 1
        List<PrecioUnitarioDTO> dto1 = precioUnitarioLogic.getPrecioUnitarios(1, 2);
        Assert.assertNotNull(dto1);
        Assert.assertEquals(2, dto1.size());
        //Page 2
        List<PrecioUnitarioDTO> dto2 = precioUnitarioLogic.getPrecioUnitarios(2, 2);
        Assert.assertNotNull(dto2);
        Assert.assertEquals(1, dto2.size());

        for (PrecioUnitarioDTO dto : dto1) {
            boolean found = false;
            for (PrecioUnitarioEntity entity : data) {
                if (dto.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }

        for (PrecioUnitarioDTO dto : dto2) {
            boolean found = false;
            for (PrecioUnitarioEntity entity : data) {
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
        List<PrecioUnitarioEntity> cache = new ArrayList<PrecioUnitarioEntity>();
        List<PrecioUnitarioDTO> list = precioUnitarioLogic.findByName(name);

        for (PrecioUnitarioEntity entity : data) {
            if (entity.getName().equals(name)) {
                cache.add(entity);
            }
        }
        Assert.assertEquals(cache.size(), list.size());
        for (PrecioUnitarioDTO dto : list) {
            boolean found = false;
            for (PrecioUnitarioEntity cacheEntity : cache) {
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
