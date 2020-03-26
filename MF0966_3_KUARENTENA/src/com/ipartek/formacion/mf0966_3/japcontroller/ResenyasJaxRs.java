package com.ipartek.formacion.mf0966_3.japcontroller;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.ipartek.formacion.mf0966_3.entities.Resenya;
import com.ipartek.formacion.mf0966_3.entities.MensajeError;
import com.ipartek.formacion.mf0966_3.repositories.DaoResenya;

@Path("/resenyas")
@Produces("application/json")
@Consumes("application/json")
public class ResenyasJaxRs {

	@Context
	private ServletContext context;
	DaoResenya resenyasDao;
	
	@GET
	public Iterable<Resenya> getAll(){
		resenyasDao = (DaoResenya) context.getAttribute("daoResenyas");
		return resenyasDao.obtenerTodos();
	}
	
	@GET
	@Path("/{idAlumno}/{idCurso}")
	public Object getById(@PathParam("idAlumno") Long idAlumno, @PathParam("idCurso") Long idCurso) {
		resenyasDao = (DaoResenya) context.getAttribute("daoResenyas");
		Resenya resenya = resenyasDao.obtenerPorIds(idAlumno, idCurso);
		if(resenya == null) {
			MensajeError mensajeError = new MensajeError("No se ha encontrado ninguna reseña para esos parametros.", resenya);
			return Response.status(Status.NOT_FOUND).entity(mensajeError).build();
		}
		return resenya;
	}
	
	@POST
	public Object add(Resenya resenya) {
		resenyasDao = (DaoResenya) context.getAttribute("daoResenyas");
		if(resenyasDao.obtenerPorIds(resenya.getAlumno().getId(), resenya.getCurso().getId())!=null) {
			MensajeError mensajeError = new MensajeError("Ya existe una reseña con esos datos", resenya);
			return Response.status(Status.CONFLICT).entity(mensajeError).build();
			//return mensajeError;
			
		}
		resenyasDao.agregar(resenya);
		
		return resenyasDao.obtenerPorIds(resenya.getAlumno().getId(), resenya.getCurso().getId());
		
	}
	
	@PUT
	@Path("/{idAlumno}/{idCurso}")
	public Object modify(Resenya resenyaModificada, @PathParam("idAlumno") Long idAlumno, @PathParam("idCurso") Long idCurso) {
		resenyasDao = (DaoResenya) context.getAttribute("daoResenyas");

		if(resenyaModificada.getAlumno().getId()!= idAlumno || resenyaModificada.getCurso().getId()!=idCurso) {
			MensajeError mensajeError = new MensajeError("Los id's de la reseña no coinciden", resenyaModificada);
			return Response.status(Status.BAD_REQUEST).entity(mensajeError).build();
		}
		if(resenyasDao.obtenerPorIds(idAlumno,idCurso)==null) {
			MensajeError mensajeError = new MensajeError("No existe una reseña a modificar", resenyaModificada);
			return Response.status(Status.CONFLICT).entity(mensajeError).build();
		}
		
		resenyasDao.modificar(resenyaModificada);
		return resenyasDao.obtenerPorIds(resenyaModificada.getAlumno().getId(), resenyaModificada.getCurso().getId());
		
	}
	
	@DELETE
	@Path("/{idAlumno}/{idCurso}")
	public Object delete(@PathParam("idAlumno") Long idAlumno, @PathParam("idCurso") Long idCurso) {
		resenyasDao = (DaoResenya) context.getAttribute("daoResenyas");
		
		if(resenyasDao.obtenerPorIds(idAlumno,idCurso)==null) {
			MensajeError mensajeError = new MensajeError("No se ha encontrado ninguna reseña para esos parametros.", null);
			return Response.status(Status.CONFLICT).entity(mensajeError).build();
		}
		
		resenyasDao.borrarPorIds(idAlumno, idCurso);
		return "{}";
	}

}
