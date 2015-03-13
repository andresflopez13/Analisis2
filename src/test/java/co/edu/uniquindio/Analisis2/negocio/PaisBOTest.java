package co.edu.uniquindio.Analisis2.negocio;

import javax.ejb.EJB;
import javax.inject.Inject;

import junit.framework.TestCase;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.transaction.api.annotation.TransactionMode;
import org.jboss.arquillian.transaction.api.annotation.Transactional;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import co.edu.uniquindio.Analisis2.entidades.Pais;
import co.edu.uniquindio.Analisis2.excepion.LogicalException;
import co.edu.uniquindio.Analisis2.excepion.TipoException;
import co.edu.uniquindio.Analisis2.persistencia.Dao;
import co.edu.uniquindio.Analisis2.persistencia.daos.PaisDao;
import co.edu.uniquindio.Analisis2.util.MessageUtil;
import co.edu.uniquindio.Analisis2.util.Resources;

/**
 * Clase que prueba el correcto funcionamiento de la clase {@link PaisBO}
 * 
 * @author Christian A. Candela
 * @author Grupo de Investigacion en Redes Informacion y Distribucion - GRID
 * @author Universidad del Quindío
 * @version 1.0
 * @since 2013-08-15
 *
 */
@RunWith(Arquillian.class)
public class PaisBOTest extends TestCase {

	/**
	 * Variable que representa el atributo paisDao de la clase.
	 */
	@Inject
	private PaisDao paisDao;

	/**
	 * Variable que representa la instancia del EJB a ser probada
	 */
	@EJB
	private PaisBO paisBo;
	/**
	 * Metodo encargado de construir el archivo a ser desplegado para la prueba
	 * 
	 * @return Archivo a ser desplegado
	 */
	@Deployment
	public static Archive<?> createTestArchive() {
		return ShrinkWrap
				.create(WebArchive.class, "test.war")
				.addClasses(Pais.class, Dao.class, PaisDao.class, PaisBO.class,
						PaisBORemote.class, LogicalException.class,
						TipoException.class, MessageUtil.class, Resources.class)
				.addAsResource("META-INF/persistence.xml",
						"META-INF/persistence.xml")
				.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
	}

	/**
	 * Metodo que prueba el funcionamiento del metodo
	 * {@link PaisBO#registrar(Pais)}
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	public void testRegistrar() {
		Pais pais = new Pais();
		pais.setCodigo("co");
		pais.setNombre("Colombia");
		paisBo.registrar(pais);

		Pais almacenado = paisDao.findByKey("co");

		Assert.assertEquals(pais, almacenado);
	}


}
