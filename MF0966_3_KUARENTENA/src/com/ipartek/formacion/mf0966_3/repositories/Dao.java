package com.ipartek.formacion.mf0966_3.repositories;

public interface Dao<T> {
	Iterable<T> obtenerTodos();
	T obtenerPorId(Long id);
	
	int agregar(T objeto);
	void modificar(T objeto);
	void borrar(Long id);
}
