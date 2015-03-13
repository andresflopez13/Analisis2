package co.edu.uniquindio.Analisis2.negocio;

import java.util.List;

import javax.ejb.Remote;

import co.edu.uniquindio.Analisis2.entidades.Pais;

/**
 * Interfaz de negocio remota que define operaciones para la gestion de la
 * entidad {@link Pais} que podrán ser accedidos de forma remota por los
 * clientes.
 * 
 * 
 * @author Christian A. Candela <christiancandela@grid.edu.co>
 * @author Grupo de Investigacion en Redes Informacion y Distribucion - GRID
 * @author Universidad del Quindío
 * @version 1.0
 * @since 2015-02-02
 */
@Remote
public interface PaisBORemote {
	/**
	 * Metodo que permite registrar un pais en el sistema
	 * 
	 * @param pais
	 *            Pais a ser registrado
	 * @return El pais registrado
	 */
	public Pais registrar(Pais pais);
	/**
	 * Permite obtener un {@link List} de los paices registrados en el sistema
	 * 
	 * @return {@link List} de los paices registrados en el sistema
	 */
	public List<Pais> listarPaices();
	
	/**
	 * Permite borrar un pais del sistema
	 * 
	 * @param pais Pais a ser borrado
	 */
	public void remover(Pais pais);	

}
