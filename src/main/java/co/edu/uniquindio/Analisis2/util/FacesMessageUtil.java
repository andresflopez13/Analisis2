package co.edu.uniquindio.Analisis2.util;

import java.util.Locale;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import co.edu.uniquindio.Analisis2.excepion.LogicalException;

/**
 * Clase utilitaria que permite crear {@link FacesMessage} a ser mostrados al
 * usuario
 *
 * @author Christian A. Candela <christiancandela@grid.edu.co>
 * @author Luis E. Sepúlveda <lesepulveda@grid.edu.co>
 * @author Paola A. Acero <pacerof@grid.edu.co>
 * @author Grupo de Investigacion en Redes Informacion y Distribucion - GRID
 * @author Universidad del Quindío
 * @version 1.0
 * @since 2014-12-02
 *
 */
public class FacesMessageUtil {
	/**
	 * Metodo que permite crear un mensaje de error a partir de una
	 * {@link LogicalException}
	 * 
	 * @param exception
	 *            Excepcion para la que se desea crear el mensaje de error
	 * @return El {@link FacesMessage} creado a partir de la excepcion con
	 *         severidad FacesMessage.SEVERITY_ERROR
	 */
	public static FacesMessage createFromLogicalException(
			LogicalException exception) {
		String mensajeError = exception.getMessage(getDefaultLocale());
		return new FacesMessage(FacesMessage.SEVERITY_ERROR, mensajeError,
				mensajeError);
	}

	/**
	 * Metodo que retorna el {@link Locale} usado por el usuario
	 * 
	 * @return retorna el {@link Locale} usado por la vista de usuario
	 */
	private static Locale getDefaultLocale() {
		return FacesContext.getCurrentInstance().getViewRoot().getLocale();
	}

	/**
	 * Metodo que permite crear un mensaje de error a partir de una
	 * {@link Throwable}
	 * 
	 * @param exception
	 *            Excepcion para la que se desea crear el mensaje de error
	 * @return El {@link FacesMessage} creado a partir de la excepcion con
	 *         severidad FacesMessage.SEVERITY_ERROR
	 */
	public static FacesMessage createFromException(Throwable exception) {
		return createFromLogicalException(LogicalException
				.createFrom(exception));
	}
}
