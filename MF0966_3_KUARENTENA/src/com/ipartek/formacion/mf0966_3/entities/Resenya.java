package com.ipartek.formacion.mf0966_3.entities;

import java.util.Date;

public class Resenya {
	
	private Alumno alumno;
	private Curso curso;
	private String resenya;
	private Date created_at;
	private Date updated_at;
	
	public Resenya(Alumno alumno, Curso curso, String resenya, Date created_at, Date updated_at) {
		this.alumno = alumno;
		this.curso = curso;
		this.resenya = resenya;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}
	
	public Resenya(Alumno alumno, Curso curso, String resenya) {
		this(alumno, curso, resenya, null,null);
	}
	
	public Resenya() {
		this(null,null,null,null,null);
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public String getResenya() {
		return resenya;
	}

	public void setResenya(String resenya) {
		this.resenya = resenya;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alumno == null) ? 0 : alumno.hashCode());
		result = prime * result + ((created_at == null) ? 0 : created_at.hashCode());
		result = prime * result + ((curso == null) ? 0 : curso.hashCode());
		result = prime * result + ((resenya == null) ? 0 : resenya.hashCode());
		result = prime * result + ((updated_at == null) ? 0 : updated_at.hashCode());
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
		Resenya other = (Resenya) obj;
		if (alumno == null) {
			if (other.alumno != null)
				return false;
		} else if (!alumno.equals(other.alumno))
			return false;
		if (created_at == null) {
			if (other.created_at != null)
				return false;
		} else if (!created_at.equals(other.created_at))
			return false;
		if (curso == null) {
			if (other.curso != null)
				return false;
		} else if (!curso.equals(other.curso))
			return false;
		if (resenya == null) {
			if (other.resenya != null)
				return false;
		} else if (!resenya.equals(other.resenya))
			return false;
		if (updated_at == null) {
			if (other.updated_at != null)
				return false;
		} else if (!updated_at.equals(other.updated_at))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Resenya [alumno=" + alumno + ", curso=" + curso + ", resenya=" + resenya + ", created_at=" + created_at
				+ ", updated_at=" + updated_at + "]";
	}
	
	
	

}
