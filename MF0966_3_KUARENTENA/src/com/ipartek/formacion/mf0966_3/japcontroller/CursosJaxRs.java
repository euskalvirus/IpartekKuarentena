package com.ipartek.formacion.mf0966_3.japcontroller;

import java.util.logging.Logger;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.ipartek.formacion.mf0966_3.entities.Curso;
import com.ipartek.formacion.mf0966_3.entities.MensajeError;
import com.ipartek.formacion.mf0966_3.repositories.Dao;

@Path("/cursos")
@Produces("application/json")
@Consumes("application/json")
@SuppressWarnings("unchecked")
public class CursosJaxRs {
	private static final Logger LOGGER = Logger.getLogger(CursosJaxRs.class.getCanonicalName());

	
	@Context
	private ServletContext context;
	Dao<Curso> cursosDao;
	static {
		LOGGER.info("Generando JaxRS de cursos");
	}
	@GET
	public Iterable<Curso> getAll() {
		LOGGER.info("getAll");
		LOGGER.info(context.toString());
		
		cursosDao = (Dao<Curso>) context.getAttribute("daoCursos");
		return  cursosDao.obtenerTodos();
	}
	
	@GET
	@Path("/{id}")
	public Object getById(@PathParam("id") Long id) {
		LOGGER.info("getById(" + id + ")");
		
		cursosDao = (Dao<Curso>) context.getAttribute("daoCursos");
		Curso alumno = cursosDao.obtenerPorId(id);
		if(alumno ==null) {
			LOGGER.warning("No se a encontrado ningun curso para ese ID: " + id);
			
			MensajeError mensaje = new MensajeError("No se a encontrado ningun curso para ese ID.",null);
			return Response.status(Status.NOT_FOUND).entity(mensaje).build();
		}
		
		return alumno;
	}
}
