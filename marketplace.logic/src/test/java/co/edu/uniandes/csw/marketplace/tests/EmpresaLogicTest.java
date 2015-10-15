package co.edu.uniandes.csw.marketplace.tests;

import co.edu.uniandes.csw.marketplace.ejbs.EmpresaLogic;
import co.edu.uniandes.csw.marketplace.api.IEmpresaLogic;
import co.edu.uniandes.csw.marketplace.converters.EmpresaConverter;
import co.edu.uniandes.csw.marketplace.dtos.EmpresaDTO;
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
public class EmpresaLogicTest {
    public static final String DEPLOY = "Prueba";

    /**
     * @generated
     */
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(EmpresaEntity.class.getPackage())
                .addPackage(EmpresaDTO.class.getPackage())
                .addPackage(EmpresaConverter.class.getPackage())
                .addPackage(EmpresaLogic.class.getPackage())
                .addPackage(IEmpresaLogic.class.getPackage())
                .addPackage(EmpresaPersistence.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * @generated
     */
    @Inject
    private IEmpresaLogic empresaLogic;

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
        EmpresaDTO dto = new EmpresaDTO();
        dto.setName(generateRandom(String.class));
        dto.setNit(generateRandom(String.class));
        dto.setActividadEconomica(generateRandom(Integer.class));
        dto.setDireccion(generateRandom(String.class));
        dto.setCiudad(generateRandom(String.class));
        dto.setTelefono(generateRandom(String.class));
        dto.setFax(generateRandom(String.class));
        dto.setPaginaWeb(generateRandom(String.class));
        dto.setNombresRepresentateLegal(generateRandom(String.class));
        dto.setApellidosRepresentanteLegal(generateRandom(String.class));
        dto.setTipoEmpresa(generateRandom(String.class));
        dto.setVigiladaSuperfinanciera(generateRandom(Boolean.class));
        dto.setVigiliadaSupersolidaria(generateRandom(Boolean.class));

        EmpresaDTO result = empresaLogic.createEmpresa(dto);

        Assert.assertNotNull(result);

        EmpresaEntity entity = em.find(EmpresaEntity.class, result.getId());

        Assert.assertEquals(dto.getName(), entity.getName());
        Assert.assertEquals(dto.getNit(), entity.getNit());
        Assert.assertEquals(dto.getActividadEconomica(), entity.getActividadEconomica());
        Assert.assertEquals(dto.getDireccion(), entity.getDireccion());
        Assert.assertEquals(dto.getCiudad(), entity.getCiudad());
        Assert.assertEquals(dto.getTelefono(), entity.getTelefono());
        Assert.assertEquals(dto.getFax(), entity.getFax());
        Assert.assertEquals(dto.getPaginaWeb(), entity.getPaginaWeb());
        Assert.assertEquals(dto.getNombresRepresentateLegal(), entity.getNombresRepresentateLegal());
        Assert.assertEquals(dto.getApellidosRepresentanteLegal(), entity.getApellidosRepresentanteLegal());
        Assert.assertEquals(dto.getTipoEmpresa(), entity.getTipoEmpresa());
        Assert.assertEquals(dto.getVigiladaSuperfinanciera(), entity.getVigiladaSuperfinanciera());
        Assert.assertEquals(dto.getVigiliadaSupersolidaria(), entity.getVigiliadaSupersolidaria());
    }

    /**
     * @generated
     */
    @Test
    public void getEmpresasTest() {
        List<EmpresaDTO> list = empresaLogic.getEmpresas(null, null);
        Assert.assertEquals(data.size(), list.size());
        for (EmpresaDTO dto : list) {
            boolean found = false;
            for (EmpresaEntity entity : data) {
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
    public void getEmpresaTest() {
        EmpresaEntity entity = data.get(0);
        EmpresaDTO dto = empresaLogic.getEmpresa(entity.getId());
        Assert.assertNotNull(dto);
        Assert.assertEquals(entity.getName(), dto.getName());
        Assert.assertEquals(entity.getNit(), dto.getNit());
        Assert.assertEquals(entity.getActividadEconomica(), dto.getActividadEconomica());
        Assert.assertEquals(entity.getDireccion(), dto.getDireccion());
        Assert.assertEquals(entity.getCiudad(), dto.getCiudad());
        Assert.assertEquals(entity.getTelefono(), dto.getTelefono());
        Assert.assertEquals(entity.getFax(), dto.getFax());
        Assert.assertEquals(entity.getPaginaWeb(), dto.getPaginaWeb());
        Assert.assertEquals(entity.getNombresRepresentateLegal(), dto.getNombresRepresentateLegal());
        Assert.assertEquals(entity.getApellidosRepresentanteLegal(), dto.getApellidosRepresentanteLegal());
        Assert.assertEquals(entity.getTipoEmpresa(), dto.getTipoEmpresa());
        Assert.assertEquals(entity.getVigiladaSuperfinanciera(), dto.getVigiladaSuperfinanciera());
        Assert.assertEquals(entity.getVigiliadaSupersolidaria(), dto.getVigiliadaSupersolidaria());
    }

    /**
     * @generated
     */
    @Test
    public void deleteEmpresaTest() {
        EmpresaEntity entity = data.get(0);
        empresaLogic.deleteEmpresa(entity.getId());
        EmpresaEntity deleted = em.find(EmpresaEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * @generated
     */
    @Test
    public void updateEmpresaTest() {
        EmpresaEntity entity = data.get(0);

        EmpresaDTO dto = new EmpresaDTO();

        dto.setId(entity.getId());
        dto.setName(generateRandom(String.class));
        dto.setNit(generateRandom(String.class));
        dto.setActividadEconomica(generateRandom(Integer.class));
        dto.setDireccion(generateRandom(String.class));
        dto.setCiudad(generateRandom(String.class));
        dto.setTelefono(generateRandom(String.class));
        dto.setFax(generateRandom(String.class));
        dto.setPaginaWeb(generateRandom(String.class));
        dto.setNombresRepresentateLegal(generateRandom(String.class));
        dto.setApellidosRepresentanteLegal(generateRandom(String.class));
        dto.setTipoEmpresa(generateRandom(String.class));
        dto.setVigiladaSuperfinanciera(generateRandom(Boolean.class));
        dto.setVigiliadaSupersolidaria(generateRandom(Boolean.class));

        empresaLogic.updateEmpresa(dto);

        EmpresaEntity resp = em.find(EmpresaEntity.class, entity.getId());

        Assert.assertEquals(dto.getName(), resp.getName());
        Assert.assertEquals(dto.getNit(), resp.getNit());
        Assert.assertEquals(dto.getActividadEconomica(), resp.getActividadEconomica());
        Assert.assertEquals(dto.getDireccion(), resp.getDireccion());
        Assert.assertEquals(dto.getCiudad(), resp.getCiudad());
        Assert.assertEquals(dto.getTelefono(), resp.getTelefono());
        Assert.assertEquals(dto.getFax(), resp.getFax());
        Assert.assertEquals(dto.getPaginaWeb(), resp.getPaginaWeb());
        Assert.assertEquals(dto.getNombresRepresentateLegal(), resp.getNombresRepresentateLegal());
        Assert.assertEquals(dto.getApellidosRepresentanteLegal(), resp.getApellidosRepresentanteLegal());
        Assert.assertEquals(dto.getTipoEmpresa(), resp.getTipoEmpresa());
        Assert.assertEquals(dto.getVigiladaSuperfinanciera(), resp.getVigiladaSuperfinanciera());
        Assert.assertEquals(dto.getVigiliadaSupersolidaria(), resp.getVigiliadaSupersolidaria());
    }

    /**
     * @generated
     */
    @Test
    public void getEmpresaPaginationTest() {
        //Page 1
        List<EmpresaDTO> dto1 = empresaLogic.getEmpresas(1, 2);
        Assert.assertNotNull(dto1);
        Assert.assertEquals(2, dto1.size());
        //Page 2
        List<EmpresaDTO> dto2 = empresaLogic.getEmpresas(2, 2);
        Assert.assertNotNull(dto2);
        Assert.assertEquals(1, dto2.size());

        for (EmpresaDTO dto : dto1) {
            boolean found = false;
            for (EmpresaEntity entity : data) {
                if (dto.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }

        for (EmpresaDTO dto : dto2) {
            boolean found = false;
            for (EmpresaEntity entity : data) {
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
        List<EmpresaEntity> cache = new ArrayList<EmpresaEntity>();
        List<EmpresaDTO> list = empresaLogic.findByName(name);

        for (EmpresaEntity entity : data) {
            if (entity.getName().equals(name)) {
                cache.add(entity);
            }
        }
        Assert.assertEquals(cache.size(), list.size());
        for (EmpresaDTO dto : list) {
            boolean found = false;
            for (EmpresaEntity cacheEntity : cache) {
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
