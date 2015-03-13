package co.edu.uniquindio.Analisis2.excepion;


/**
 * Enumeracion que representa los tipos de excepciones a ser usadas en el
 * desarrollo del sistema.
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
public enum TipoException {
	/**
	 * Excepcion generada cuando faltan datos para completar la transaccion 
	 */
	DATOS_FALTANTES("exception.datosfaltante"),
	/**
	 * Excepcion generada cuando el nombre de usuario o clave suministrada son incorrectos
	 */
	ERROR_AUTENTICACION("exception.autenticacion"),
	/**
	 * Excepcion generada cuando existe un error no previsto en el sistema
	 */
	OTRO("exception.errorinesperado");
	
	/**
	 * Metodo que permite inicializar los elementos de la clase TipoException
	 * 
	 * @param keyMessage
	 *            Llave que identifica el mensaje a ser desplegado para el tipo
	 *            de error específico.
	 */
	private TipoException(String keyMessage) {
		this.keyMessage = keyMessage;
	}

	/**
	 * Constante que identifica el archivo de propiedades a ser usado para
	 * extraer los mensajes que corresponden a cada uno de los tipos de
	 * excepcion.
	 */
	public static final String MESSAGE_FILE = "resources.application";
	/**
	 * Variable que representa el atributo keyMessage de cada
	 * {@link TipoException}. Esta llave identifica el mensaje a ser desplegado
	 * del archivo de propiedades que contiene los mensajes asociados a cada
	 * {@link TipoException}
	 */
	private String keyMessage;
	


	/**
	 * Metodo que permite obtener el valor del atributo keyMessage
	 * 
	 * @return El valor del atributo keyMessage
	 */
	public String getKeyMessage() {
		return keyMessage;
	}

	/**
	 * Metodo que permite asignar un valor al atributo keyMessage
	 * 
	 * @param keyMessage
	 *            Valor a ser asignado al atributo keyMessage
	 */
	public void setKeyMessage(String keyMessage) {
		this.keyMessage = keyMessage;
	}

}
