package com.ipartek.formacion.mf0966_3.repositories;

import com.ipartek.formacion.mf0966_3.entities.Resenya;

public interface DaoResenya extends Dao<Resenya> {
	Resenya obtenerPorIds(Long idAlumno, Long idCurso);
	Iterable<Resenya> obtenerResenyasCurso(Long idCurso);

	void borrarPorIds(Long idAlumno, Long idCurso);
}
