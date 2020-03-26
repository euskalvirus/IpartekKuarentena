package com.ipartek.formacion.mf0966_3.entities;

public class MensajeError {
	private String error;
	private Object objeto;
	
	public MensajeError(String error, Object objeto) {
		setError(error);
		setObject(objeto);
	}
	public MensajeError() {
		this(null, null);
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public Object getObject() {
		return objeto;
	}
	public void setObject(Object objeto) {
		this.objeto = objeto;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((error == null) ? 0 : error.hashCode());
		result = prime * result + ((objeto == null) ? 0 : objeto.hashCode());
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
		MensajeError other = (MensajeError) obj;
		if (error == null) {
			if (other.error != null)
				return false;
		} else if (!error.equals(other.error))
			return false;
		if (objeto == null) {
			if (other.objeto != null)
				return false;
		} else if (!objeto.equals(other.objeto))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "MensajeError [error=" + error + ", objeto=" + objeto + "]";
	}

}
