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

import com.ipartek.formacion.mf0966_3.entities.Profesor;
import com.ipartek.formacion.mf0966_3.entities.MensajeError;
import com.ipartek.formacion.mf0966_3.repositories.Dao;

@Path("/profesores")
@Produces("application/json")
@Consumes("application/json")
@SuppressWarnings("unchecked")
public class ProfesorJaxRs {
	private static final Logger LOGGER = Logger.getLogger(ProfesorJaxRs.class.getCanonicalName());

	
	@Context
	private ServletContext context;
	Dao<Profesor> profesoresDao;
	static {
		LOGGER.info("Generando JaxRS de profesores");
	}
	@GET
	public Iterable<Profesor> getAll() {
		LOGGER.info("getAll");
		LOGGER.info(context.toString());
		
		profesoresDao = (Dao<Profesor>) context.getAttribute("daoProfesores");
		return  profesoresDao.obtenerTodos();
	}
	
	@GET
	@Path("/{id}")
	public Object getById(@PathParam("id") Long id) {
		LOGGER.info("getById(" + id + ")");
		
		profesoresDao = (Dao<Profesor>) context.getAttribute("daoProfesores");
		Profesor profesor = profesoresDao.obtenerPorId(id);
		if(profesor ==null) {
			LOGGER.warning("No se a encontrado ningun profesor para ese ID: " + id);
			
			MensajeError mensaje = new MensajeError("No se a encontrado ningun profesor para ese ID.",null);
			return Response.status(Status.NOT_FOUND).entity(mensaje).build();
		}
		
		return profesor;
	}
}
