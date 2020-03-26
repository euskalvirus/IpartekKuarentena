package com.ipartek.formacion.mf0966_3.entities;

import java.util.ArrayList;

public class Curso {
	private Long id;
	private String nombre;
	private Integer nHoras;
	private Profesor profesor;
	private ArrayList<Resenya> resenyas;
	
	
	public Curso(Long id, String nombre, Integer nHoras, Profesor profesor, ArrayList<Resenya> resenyas) {
		this.id = id;
		this.nombre = nombre;
		this.nHoras = nHoras;
		this.profesor = profesor;
		this.resenyas = resenyas;
	}

	public Curso(Long id, String nombre, Integer nHoras, Profesor profesor) {
		this(id, nombre,nHoras, profesor, null);
	}
	
	public Curso() {
		this(null,null,null,null,null);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getnHoras() {
		return nHoras;
	}

	public void setnHoras(Integer nHoras) {
		this.nHoras = nHoras;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public ArrayList<Resenya> getResenyas() {
		return resenyas;
	}

	public void setResenyas(ArrayList<Resenya> resenyas) {
		this.resenyas = resenyas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nHoras == null) ? 0 : nHoras.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((profesor == null) ? 0 : profesor.hashCode());
		result = prime * result + ((resenyas == null) ? 0 : resenyas.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curso other = (Curso) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nHoras == null) {
			if (other.nHoras != null)
				return false;
		} else if (!nHoras.equals(other.nHoras))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (profesor == null) {
			if (other.profesor != null)
				return false;
		} else if (!profesor.equals(other.profesor))
			return false;
		if (resenyas == null) {
			if (other.resenyas != null)
				return false;
		} else if (!resenyas.equals(other.resenyas))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Curso [id=" + id + ", nombre=" + nombre + ", nHoras=" + nHoras + ", profesor=" + profesor
				+ ", resenyas=" + resenyas + "]";
	}
	
}
