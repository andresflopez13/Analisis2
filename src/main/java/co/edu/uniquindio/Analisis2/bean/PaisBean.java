package co.edu.uniquindio.Analisis2.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.validation.Valid;

import co.edu.uniquindio.Analisis2.entidades.Pais;
import co.edu.uniquindio.Analisis2.negocio.PaisBO;
import co.edu.uniquindio.Analisis2.util.FacesMessageUtil;

/**
 * Clase Bean que hace las veces de controlador de las páginas JSF que permiten
 * la gestión de la entidad {@link Pais}
 * 
 * @author Christian A. Candela <christiancandela@grid.edu.co>
 * @author Grupo de Investigacion en Redes Informacion y Distribucion - GRID
 * @author Universidad del Quindío
 * @version 1.0
 * @since 2015-02-02
 */
@ManagedBean
public class PaisBean {
	/**
	 * Instancia de la clase de negocio usada para la gestion de la entidad
	 * {@link Pais}
	 */
	@EJB
	private PaisBO paisBo;
	/**
	 * Instancia del pais usada para las operaciones de gestion de dicha entidad
	 */
	@Valid
	private Pais pais;
	/**
	 * Variable que representa los paices almacenados en el sistema
	 */
	private List<Pais> paices;

	@PostConstruct
	private void inicializar(){
		pais = new Pais();
		paices = paisBo.listarPaices();
	}

	/**
	 * Metodo que permite registrar un pais
	 */
	public void registrar() {
		FacesMessage mensaje = null;
		try {
			paisBo.registrar(pais);
			inicializar();
			// Ejemplo de creacion de un mensaje, sin embargo no debería
			// quemarse el texto, en su lugar, deberia extraerde del archivo de
			// propiedades como se hace con las excepciones
			mensaje = new FacesMessage("Pais registrado con exito");
		} catch (Throwable t) {
			mensaje = FacesMessageUtil.createFromException(t);
		}
		FacesContext.getCurrentInstance().addMessage(null, mensaje);
	}

	/**
	 * Metodo que permite registrar un pais
	 */
	public void eliminar(Pais pais) {
		FacesMessage mensaje = null;
		try {
			paisBo.remover(pais);
			inicializar();
			// Ejemplo de creacion de un mensaje, sin embargo no debería
			// quemarse el texto, en su lugar, deberia extraerde del archivo de
			// propiedades como se hace con las excepciones
			mensaje = new FacesMessage("Pais borrado con exito");
		} catch (Throwable t) {
			mensaje = FacesMessageUtil.createFromException(t);
		}
		FacesContext.getCurrentInstance().addMessage(null, mensaje);
	}
	
	public List<Pais> getPaices(){
		return paices;
	}
	/**
	 * Metodo que permite obtener el atributo pais
	 * 
	 * @return El atributo pais
	 */
	public Pais getPais() {
		return pais;
	}

	/**
	 * Metodo que permite asignar un valor al atributo pais
	 * 
	 * @param pais
	 *            Valor a ser asignado al atributo pais
	 */
	public void setPais(Pais pais) {
		this.pais = pais;
	}

}
