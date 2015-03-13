package co.edu.uniquindio.Analisis2.excepion;

import java.util.Locale;

import co.edu.uniquindio.Analisis2.util.MessageUtil;

/**
 * Clase usada para representar las excepciones logicas generadas en la capa de
 * negocio de la aplicacion
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
public class LogicalException extends RuntimeException {

	/**
	 * Variable que representa el atributo serialVersionUID de la clase
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Variable que representa el tipo de expeccion que se esta generando.
	 */
	private TipoException tipo;

	/**
	 * Metodo que permite inicializar los elementos de la clase LogicalException
	 * 
	 * @param message
	 *            Mensaje descriptivo del motivo por el cual se esta generando
	 *            la excepcion
	 */
	public LogicalException(String message) {
		super(message);
	}

	/**
	 * Metodo que permite inicializar los elementos de la clase LogicalException
	 * 
	 * @param tipo
	 *            Tipo de excepcion que se esta generando
	 */
	public LogicalException(TipoException tipo) {
		super(tipo.getKeyMessage());
		this.tipo = tipo;
	}

	/**
	 * Metodo que permite obtener el mensaje de error correspondiente al tipo de
	 * la excepcion generada segun el {@link Locale} dado
	 * 
	 * @param locale
	 *            {@link Locale} Que indica el idioma en el cual se desea
	 *            obtener el mensaje de error
	 * @return Mensaje de error correspondiente al tipo de excepcion generada
	 */
	public String getMessage(Locale locale) {
		if (tipo != null) {
			return MessageUtil.getInstance().getMessageFromBundle(
					tipo.getKeyMessage(), TipoException.MESSAGE_FILE, locale);
		} else {
			return getMessage();
		}
	}

	/**
	 * Metodo que permite obtener el valor del atributo tipo
	 * 
	 * @return El valor del atributo tipo
	 */
	public TipoException getTipo() {
		return tipo;
	}

	/**
	 * Metodo que permite asignar un valor al atributo tipo
	 * 
	 * @param tipo
	 *            Valor a ser asignado al atributo tipo
	 */
	public void setTipo(TipoException tipo) {
		this.tipo = tipo;
	}

	/**
	 * Metodo que permite crear u obtener una instancia de LogicalException a
	 * partir de un {@link Throwable}. Si la causa original del
	 * {@link Throwable} es una {@link LogicalException} se retormara dicha
	 * excepcion. En caso contrario se creara una con la causa real de la
	 * excepcion
	 * 
	 * @param exception Excepcion de la que se quiere obtener una {@link LogicalException}
	 * @return Una {@link LogicalException} extraida de la excepcion dada.
	 */
	public static LogicalException createFrom(Throwable exception) {
		while (exception.getCause() != null) {
			exception = exception.getCause();
		}
		if (exception instanceof LogicalException) {
			return (LogicalException) exception;
		} else {
			return new LogicalException(exception.getMessage());
		}
	}

}
