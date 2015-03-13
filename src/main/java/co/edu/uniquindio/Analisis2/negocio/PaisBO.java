package co.edu.uniquindio.Analisis2.negocio;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import co.edu.uniquindio.Analisis2.entidades.Pais;
import co.edu.uniquindio.Analisis2.excepion.LogicalException;
import co.edu.uniquindio.Analisis2.excepion.TipoException;
import co.edu.uniquindio.Analisis2.persistencia.daos.PaisDao;

/**
 * Clase de negocio encargada de proporcionar operaciones para la gestion de la
 * entidad {@link Pais}
 * 
 * @author Christian A. Candela <christiancandela@grid.edu.co>
 * @author Grupo de Investigacion en Redes Informacion y Distribucion - GRID
 * @author Universidad del Quindío
 * @version 1.0
 * @since 2015-02-02
 */
@Stateless
@LocalBean
public class PaisBO implements PaisBORemote {

	/**
	 * Instancia de la clase {@link PaisDao} usada para la persistencia de la
	 * entidad {@link Pais}
	 */
	@Inject
	private PaisDao paisDao;

	/**
	 * Metodo que permite registrar un pais en el sistema
	 * 
	 * @param pais
	 *            Pais a ser registrado
	 * @return El pais registrado
	 */
	public Pais registrar(Pais pais) {
		// Se verifica que se tengan los datos necesarios para registrar un pais
		if (pais == null || pais.getCodigo() == null
				|| pais.getNombre() == null
				|| "".equals(pais.getCodigo().trim())
				|| "".equals(pais.getNombre().trim())) {
			throw new LogicalException(TipoException.DATOS_FALTANTES);
		}

		// Verificamos que no exista ya un pais registrado con el mismo código
		Pais registrado = paisDao.findByKey(pais.getCodigo());
		if (registrado != null) {
			// Ya existe un pais registrado con el código proporcionado, deberia
			// lanzarce una excepción particula, pero para ilustración se
			// lanzara una genérica
			throw new LogicalException(TipoException.OTRO);
		}

		registrado = paisDao.findByName(pais.getNombre());
		// Adicionalmente, se debería verificar que no exista un pais con el
		// mismo nombre
		if (registrado != null) {
			// Ya existe un pais registrado con el código proporcionado, deberia
			// lanzarce una excepción particula, pero para ilustración se
			// lanzara una genérica
			throw new LogicalException(TipoException.OTRO);
		}
		return paisDao.insert(pais);
	}

	/**
	 * Permite obtener un {@link List} de los paices registrados en el sistema
	 * 
	 * @return {@link List} de los paices registrados en el sistema
	 */
	public List<Pais> listarPaices() {
		return paisDao.getAll();
	}

	/**
	 * Permite borrar un pais del sistema
	 * 
	 * @param pais Pais a ser borrado
	 */
	public void remover(Pais pais) {
		// TODO Falta realizar las correspondientes validaciones de negocio
		
		paisDao.remove(pais);
	}
}
