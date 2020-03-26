package com.ipartek.formacion.mf0966_3.repositories;

public class ResenyaException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ResenyaException() {super();}

	public ResenyaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ResenyaException(String message, Throwable cause) {
		super(message, cause);
	}

	public ResenyaException(String message) {
		super(message);
	}

	public ResenyaException(Throwable cause) {
		super(cause);
	}

}
