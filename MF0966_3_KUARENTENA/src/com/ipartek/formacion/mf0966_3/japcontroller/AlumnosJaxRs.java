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

import com.ipartek.formacion.mf0966_3.entities.Alumno;
import com.ipartek.formacion.mf0966_3.entities.MensajeError;
import com.ipartek.formacion.mf0966_3.repositories.Dao;

@Path("/clientes")
@Produces("application/json")
@Consumes("application/json")
@SuppressWarnings("unchecked")
public class AlumnosJaxRs {
	private static final Logger LOGGER = Logger.getLogger(AlumnosJaxRs.class.getCanonicalName());

	
	@Context
	private ServletContext context;
	Dao<Alumno> alumnosDao;
	static {
		LOGGER.info("Generando JaxRS de clientes");
	}
	@GET
	public Iterable<Alumno> getAll() {
		LOGGER.info("getAll");
		LOGGER.info(context.toString());
		
		alumnosDao = (Dao<Alumno>) context.getAttribute("daoAlumnos");
		return  alumnosDao.obtenerTodos();
	}
	
	@GET
	@Path("/{id}")
	public Object getById(@PathParam("id") Long id) {
		LOGGER.info("getById(" + id + ")");
		
		alumnosDao = (Dao<Alumno>) context.getAttribute("daoAlumnos");
		Alumno alumno = alumnosDao.obtenerPorId(id);
		if(alumno ==null) {
			MensajeError mensaje = new MensajeError("No se a encontrado ningun alumno para ese ID.",null);
			return Response.status(Status.NOT_FOUND).entity(mensaje).build();
		}
		
		return alumno;
	}
}
