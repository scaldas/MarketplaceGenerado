package co.edu.uniandes.csw.marketplace.tests;

import co.edu.uniandes.csw.marketplace.entities.EmpresaEntity;
import co.edu.uniandes.csw.marketplace.persistence.EmpresaPersistence;
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
public class EmpresaPersistenceTest {
    public static final String DEPLOY = "Prueba";

    /**
     * @generated
     */
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(EmpresaEntity.class.getPackage())
                .addPackage(EmpresaPersistence.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * @generated
     */
    @Inject
    private EmpresaPersistence empresaPersistence;

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
        em.createQuery("delete from EmpresaEntity").executeUpdate();
    }

    /**
     * @generated
     */
    private List<EmpresaEntity> data = new ArrayList<EmpresaEntity>();

    /**
     * @generated
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            EmpresaEntity entity = new EmpresaEntity();
            entity.setName(generateRandom(String.class));
            entity.setNit(generateRandom(String.class));
            entity.setActividadEconomica(generateRandom(Integer.class));
            entity.setDireccion(generateRandom(String.class));
            entity.setCiudad(generateRandom(String.class));
            entity.setTelefono(generateRandom(String.class));
            entity.setFax(generateRandom(String.class));
            entity.setPaginaWeb(generateRandom(String.class));
            entity.setNombresRepresentateLegal(generateRandom(String.class));
            entity.setApellidosRepresentanteLegal(generateRandom(String.class));
            entity.setTipoEmpresa(generateRandom(String.class));
            entity.setVigiladaSuperfinanciera(generateRandom(Boolean.class));
            entity.setVigiliadaSupersolidaria(generateRandom(Boolean.class));
            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * @generated
     */
    @Test
    public void createEmpresaTest() {
        EmpresaEntity newEntity = new EmpresaEntity();
        newEntity.setName(generateRandom(String.class));
        newEntity.setNit(generateRandom(String.class));
        newEntity.setActividadEconomica(generateRandom(Integer.class));
        newEntity.setDireccion(generateRandom(String.class));
        newEntity.setCiudad(generateRandom(String.class));
        newEntity.setTelefono(generateRandom(String.class));
        newEntity.setFax(generateRandom(String.class));
        newEntity.setPaginaWeb(generateRandom(String.class));
        newEntity.setNombresRepresentateLegal(generateRandom(String.class));
        newEntity.setApellidosRepresentanteLegal(generateRandom(String.class));
        newEntity.setTipoEmpresa(generateRandom(String.class));
        newEntity.setVigiladaSuperfinanciera(generateRandom(Boolean.class));
        newEntity.setVigiliadaSupersolidaria(generateRandom(Boolean.class));

        EmpresaEntity result = empresaPersistence.create(newEntity);

        Assert.assertNotNull(result);

        EmpresaEntity entity = em.find(EmpresaEntity.class, result.getId());

        Assert.assertEquals(newEntity.getName(), entity.getName());
        Assert.assertEquals(newEntity.getNit(), entity.getNit());
        Assert.assertEquals(newEntity.getActividadEconomica(), entity.getActividadEconomica());
        Assert.assertEquals(newEntity.getDireccion(), entity.getDireccion());
        Assert.assertEquals(newEntity.getCiudad(), entity.getCiudad());
        Assert.assertEquals(newEntity.getTelefono(), entity.getTelefono());
        Assert.assertEquals(newEntity.getFax(), entity.getFax());
        Assert.assertEquals(newEntity.getPaginaWeb(), entity.getPaginaWeb());
        Assert.assertEquals(newEntity.getNombresRepresentateLegal(), entity.getNombresRepresentateLegal());
        Assert.assertEquals(newEntity.getApellidosRepresentanteLegal(), entity.getApellidosRepresentanteLegal());
        Assert.assertEquals(newEntity.getTipoEmpresa(), entity.getTipoEmpresa());
        Assert.assertEquals(newEntity.getVigiladaSuperfinanciera(), entity.getVigiladaSuperfinanciera());
        Assert.assertEquals(newEntity.getVigiliadaSupersolidaria(), entity.getVigiliadaSupersolidaria());
    }

    /**
     * @generated
     */
    @Test
    public void getEmpresasTest() {
        List<EmpresaEntity> list = empresaPersistence.findAll(null, null);
        Assert.assertEquals(data.size(), list.size());
        for (EmpresaEntity ent : list) {
            boolean found = false;
            for (EmpresaEntity entity : data) {
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
    public void getEmpresaTest() {
        EmpresaEntity entity = data.get(0);
        EmpresaEntity newEntity = empresaPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getName(), newEntity.getName());
        Assert.assertEquals(entity.getNit(), newEntity.getNit());
        Assert.assertEquals(entity.getActividadEconomica(), newEntity.getActividadEconomica());
        Assert.assertEquals(entity.getDireccion(), newEntity.getDireccion());
        Assert.assertEquals(entity.getCiudad(), newEntity.getCiudad());
        Assert.assertEquals(entity.getTelefono(), newEntity.getTelefono());
        Assert.assertEquals(entity.getFax(), newEntity.getFax());
        Assert.assertEquals(entity.getPaginaWeb(), newEntity.getPaginaWeb());
        Assert.assertEquals(entity.getNombresRepresentateLegal(), newEntity.getNombresRepresentateLegal());
        Assert.assertEquals(entity.getApellidosRepresentanteLegal(), newEntity.getApellidosRepresentanteLegal());
        Assert.assertEquals(entity.getTipoEmpresa(), newEntity.getTipoEmpresa());
        Assert.assertEquals(entity.getVigiladaSuperfinanciera(), newEntity.getVigiladaSuperfinanciera());
        Assert.assertEquals(entity.getVigiliadaSupersolidaria(), newEntity.getVigiliadaSupersolidaria());
    }

    /**
     * @generated
     */
    @Test
    public void deleteEmpresaTest() {
        EmpresaEntity entity = data.get(0);
        empresaPersistence.delete(entity.getId());
        EmpresaEntity deleted = em.find(EmpresaEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * @generated
     */
    @Test
    public void updateEmpresaTest() {
        EmpresaEntity entity = data.get(0);

        EmpresaEntity newEntity = new EmpresaEntity();

        newEntity.setId(entity.getId());
        newEntity.setName(generateRandom(String.class));
        newEntity.setNit(generateRandom(String.class));
        newEntity.setActividadEconomica(generateRandom(Integer.class));
        newEntity.setDireccion(generateRandom(String.class));
        newEntity.setCiudad(generateRandom(String.class));
        newEntity.setTelefono(generateRandom(String.class));
        newEntity.setFax(generateRandom(String.class));
        newEntity.setPaginaWeb(generateRandom(String.class));
        newEntity.setNombresRepresentateLegal(generateRandom(String.class));
        newEntity.setApellidosRepresentanteLegal(generateRandom(String.class));
        newEntity.setTipoEmpresa(generateRandom(String.class));
        newEntity.setVigiladaSuperfinanciera(generateRandom(Boolean.class));
        newEntity.setVigiliadaSupersolidaria(generateRandom(Boolean.class));

        empresaPersistence.update(newEntity);

        EmpresaEntity resp = em.find(EmpresaEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getName(), resp.getName());
        Assert.assertEquals(newEntity.getNit(), resp.getNit());
        Assert.assertEquals(newEntity.getActividadEconomica(), resp.getActividadEconomica());
        Assert.assertEquals(newEntity.getDireccion(), resp.getDireccion());
        Assert.assertEquals(newEntity.getCiudad(), resp.getCiudad());
        Assert.assertEquals(newEntity.getTelefono(), resp.getTelefono());
        Assert.assertEquals(newEntity.getFax(), resp.getFax());
        Assert.assertEquals(newEntity.getPaginaWeb(), resp.getPaginaWeb());
        Assert.assertEquals(newEntity.getNombresRepresentateLegal(), resp.getNombresRepresentateLegal());
        Assert.assertEquals(newEntity.getApellidosRepresentanteLegal(), resp.getApellidosRepresentanteLegal());
        Assert.assertEquals(newEntity.getTipoEmpresa(), resp.getTipoEmpresa());
        Assert.assertEquals(newEntity.getVigiladaSuperfinanciera(), resp.getVigiladaSuperfinanciera());
        Assert.assertEquals(newEntity.getVigiliadaSupersolidaria(), resp.getVigiliadaSupersolidaria());
    }

    /**
     * @generated
     */
    @Test
    public void getEmpresaPaginationTest() {
        //Page 1
        List<EmpresaEntity> ent1 = empresaPersistence.findAll(1, 2);
        Assert.assertNotNull(ent1);
        Assert.assertEquals(2, ent1.size());
        //Page 2
        List<EmpresaEntity> ent2 = empresaPersistence.findAll(2, 2);
        Assert.assertNotNull(ent2);
        Assert.assertEquals(1, ent2.size());

        for (EmpresaEntity ent : ent1) {
            boolean found = false;
            for (EmpresaEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }

        for (EmpresaEntity ent : ent2) {
            boolean found = false;
            for (EmpresaEntity entity : data) {
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
        List<EmpresaEntity> cache = new ArrayList<EmpresaEntity>();
        List<EmpresaEntity> list = empresaPersistence.findByName(name);

        for (EmpresaEntity entity : data) {
            if (entity.getName().equals(name)) {
                cache.add(entity);
            }
        }
        Assert.assertEquals(list.size(), cache.size());
        for (EmpresaEntity ent : list) {
            boolean found = false;
            for (EmpresaEntity cacheEntity : cache) {
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
