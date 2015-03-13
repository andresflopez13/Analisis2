package co.edu.uniquindio.Analisis2.persistencia.daos;

import java.util.List;

import javax.persistence.TypedQuery;

import co.edu.uniquindio.Analisis2.entidades.Pais;
import co.edu.uniquindio.Analisis2.persistencia.Dao;

/**
 * Clase utilitaria de la capa de persistencia que permite manipular el acceso a
 * los datos almacenados en la entidad {@link Pais}
 * 
 * @author Christian A. Candela
 * @author Grupo de Investigacion en Redes Informacion y Distribucion - GRID
 * @author Universidad del Quindío
 * @version 1.0
 * @since 2013-08-08
 * 
 */
public class PaisDao extends Dao<Pais> {

	/**
	 * Metodo que permite inicializar los elementos de la clase PaisDao
	 */
	public PaisDao() {
		super(Pais.class);
	}

	/**
	 * Método que permite buscar un pais por medio de su nombre
	 * 
	 * @param nombre
	 *            Nombre del pais que se desea buscar
	 * @return El pais correspondiente al nombre suministrado, o null en caso de
	 *         que el pais no exista.
	 */
	public Pais findByName(String nombre) {
		TypedQuery<Pais> query = entityManager.createQuery("select pais from Pais pais where UPPER(pais.nombre) = UPPER(:nombre) ", Pais.class);
		query.setParameter("nombre",nombre);
		List<Pais> paices = query.getResultList();
		if( paices.size() > 0){
			return paices.get(0);
		}
		return null;
	}
}
