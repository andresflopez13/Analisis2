package co.edu.uniquindio.Analisis2.entidades;

import java.io.Serializable;
import java.lang.String;

import javax.persistence.*;


import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * Clase que implementa la entidad Pais.
 * 
 * @author Christian A. Candela
 * @author Grupo de Investigacion en Redes Informacion y Distribucion - GRID
 * @author Universidad del Quindío
 * @version 1.0
 * @since 2013-08-08
 * 
 */
// Anotación usada para indicar que la clase Pais es una entidad
@Entity
// Anotación usada para indicar la clase puede ser usada como noto raiz de una
// estructura XML, generalmente se adiciona la anotación cuando la clase será
// usada como retorno de web service, esta anotación es opcional
@XmlRootElement
public class Pais implements Serializable {

	/**
	 * Variable que representa el atributo codigo de la clase
	 */
	@Id
	@NotNull
	@Column(nullable=false,unique=true,length=4)
	@Size(min=2,max=4)
	private String codigo;
	/**
	 * Variable que representa el atributo nombre de la clase
	 */
	@NotNull
	@Column(nullable=false,unique=true,length=150)
	@Size(min=2,max=150,message="{pais.sizeLeng}")
	private String nombre;
	/**
	 * Variable que representa el atributo serialVersionUID de la clase
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * Metodo que permite obtener el valor del atributo codigo
	 * 
	 * @return El valor del atributo codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * Metodo que permite asignar un valor al atributo codigo
	 * 
	 * @param codigo
	 *            Valor a ser asignado al atributo codigo
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * Metodo que permite obtener el valor del atributo nombre
	 * 
	 * @return El valor del atributo nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Metodo que permite asignar un valor al atributo nombre
	 * 
	 * @param nombre
	 *            Valor a ser asignado al atributo nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pais other = (Pais) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
