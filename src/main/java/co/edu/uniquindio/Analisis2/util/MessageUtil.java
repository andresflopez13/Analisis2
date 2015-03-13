package co.edu.uniquindio.Analisis2.util;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Clase utilitaria usada para obtenes los mensajes almacenados en archivos de
 * propiedades usando un {@link Locale} específico
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
public class MessageUtil {
	/**
	 * Locale a ser usado por defecto para la obtención de los datos regionales
	 * a ser usados en la interacción con el usuario
	 */
	private Locale defaultLocale = Locale.getDefault();
	/**
	 * Map con los diferentes Bundles usados en la aplicación, es usado a modo
	 * de cache para evitar su carga múltiple
	 */
	private Map<String, ResourceBundle> bundles = new HashMap<String, ResourceBundle>();
	/**
	 * Instancia estatica de la clase usada para la implementación del patron
	 * singleton en esta clase.
	 * 
	 */
	private static final MessageUtil instance = new MessageUtil();

	/**
	 * Constructor privado para la implementación del patron singleton, lo cual
	 * permite limitar el acceso de otras clases a la construcción de instacias
	 * del MessageUtil
	 */
	private MessageUtil() {
	}

	/**
	 * Permite obtener el Locale por defecto a ser usado
	 * 
	 * @return El locale por usado por defecto
	 */
	public Locale getDefaultLocale() {
		return defaultLocale;
	}

	/**
	 * Permite asignar el locale a ser usado por defecto
	 * 
	 * @param defaultLocale
	 */
	public void setDefaultLocale(Locale defaultLocale) {
		this.defaultLocale = defaultLocale;
	}

	/**
	 * Permite obtener la instacia de {@link MessageUtil} a ser usada
	 * externamente
	 * 
	 * @return Una instancia de {@link MessageUtil}
	 */
	public static MessageUtil getInstance() {
		return instance;
	}

	/**
	 * Permite obtener un mensaje de un bundle dada una llave especifica
	 * 
	 * @param key
	 *            Llave del mensaje que se desea obtener
	 * @param nameBundle
	 *            Nombre del bundle del cual se desea obtener el mensaje
	 * @return El mensaje obtenido
	 */
	public String getMessageFromBundle(String key, String nameBundle) {
		return getMessageFromBundle(key, nameBundle, defaultLocale);
	}

	/**
	 * Permite obtener un mensaje de un bundle dada una llave especifica
	 * 
	 * @param key
	 *            Llave del mensaje que se desea obtener
	 * @param nameBundle
	 *            Nombre del bundle del cual se desea obtener el mensaje
	 * @param locale
	 *            Configuración regional a ser usada en la obtención del mensaje
	 * @return El mensaje obtenido
	 */
	public String getMessageFromBundle(String key, String nameBundle,
			Locale locale) {
		ResourceBundle bundle = getBundle(nameBundle, locale);
		return bundle.getString(key);
	}

	/**
	 * Permite obtener un {@link ResourceBundle} a partir de su nombre y la
	 * configuración regional deseada
	 * 
	 * @param nameBundle
	 *            Nombre del bundle
	 * @param locale
	 *            Configuración regional a ser usada
	 * @return El {@link ResourceBundle} correspondiente al nombre y
	 *         configuración regional dados.
	 */
	private ResourceBundle getBundle(String nameBundle, Locale locale) {
		String fullBundleNameKey = nameBundle;
		if (locale != null) {
			fullBundleNameKey = fullBundleNameKey + "_"
					+ locale.toLanguageTag();
		}
		if (!bundles.containsKey(fullBundleNameKey)) {
			bundles.put(fullBundleNameKey,
					ResourceBundle.getBundle(nameBundle, locale));
		}
		return bundles.get(fullBundleNameKey);
	}

}
