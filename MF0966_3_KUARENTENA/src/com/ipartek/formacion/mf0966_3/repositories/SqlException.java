package com.ipartek.formacion.mf0966_3.repositories;

public class SqlException extends RuntimeException {

	public SqlException() {
		super();
	}

	public SqlException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public SqlException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public SqlException(String arg0) {
		super(arg0);
	}

	public SqlException(Throwable arg0) {
		super(arg0);
	}

	private static final long serialVersionUID = 1L;

}
