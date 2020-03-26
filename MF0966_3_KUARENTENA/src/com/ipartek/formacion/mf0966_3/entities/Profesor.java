package com.ipartek.formacion.mf0966_3.entities;

public class Profesor extends Alumno{

	public Profesor() {
		super();
	}

	public Profesor(Long id, String nombre, String apellidos) {
		super(id, nombre, apellidos);
	}

	public Profesor(String nombre, String apellidos) {
		super(nombre, apellidos);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Profesor []";
	}
	
}
