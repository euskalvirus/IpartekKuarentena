package com.ipartek.formacion.mf0966_3.repositories;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.ipartek.formacion.mf0966_3.entities.Alumno;
import com.ipartek.formacion.mf0966_3.entities.Curso;
import com.ipartek.formacion.mf0966_3.entities.Profesor;

public class FabricaDao {
	
	public static Dao<Alumno> getAlumnoInstancia(String pathConfiguracion) {
		Properties configuracion =getConfiguracion(pathConfiguracion);
		return AlumnoRepository.getInstancia(configuracion);
	}
	
	public static Dao<Profesor> getTrabajadorInstancia(String pathConfiguracion) {
		Properties configuracion =getConfiguracion(pathConfiguracion);
		return ProfesorRepository.getInstancia(configuracion);
		/*String tipo =configuracion.getProperty("dao");
		switch(tipo) {
		case "memoria": return TrabajadorRepository.getInstancia();
		case "mysql": return TrabajadorRepository.getInstancia(configuracion);
		default: throw new AccesoDatosException("No conozco el tipo " + tipo);
		}*/
	}
	
	public static DaoResenya getResenyaInstancia(String pathConfiguracion) {
		Properties configuracion =getConfiguracion(pathConfiguracion);
		return ResenyaRepository.getInstancia(configuracion);
		/*String tipo =configuracion.getProperty("dao");
		switch(tipo) {
		case "memoria": return ServicioRepository.getInstancia();
		case "mysql": return ServicioRepository.getInstancia(configuracion);
		default: throw new AccesoDatosException("No conozco el tipo " + tipo);
		}*/
	}
	
	private static Properties getConfiguracion(String pathConfiguracion){
		Properties configuracion = new Properties();
		try {	
			configuracion.load(new FileInputStream(pathConfiguracion));
		} catch (FileNotFoundException e) {
			throw new AccesoDatosException("Fichero de configuración no encontrado", e);
		} catch (IOException e) {
			throw new AccesoDatosException("Fallo de lectura/escritura al fichero", e);
		}
		return configuracion;
	}
	
	public static Dao<Curso> getCursoInstancia(String pathConfiguracion) {
		Properties configuracion =getConfiguracion(pathConfiguracion);
		return CursoRepository.getInstancia(configuracion);
		/*String tipo =configuracion.getProperty("dao");
		switch(tipo) {
		case "memoria": return ActuacionRepository.getInstancia();
		case "mysql": return ActuacionRepository.getInstancia(configuracion);
		default: throw new AccesoDatosException("No conozco el tipo " + tipo);
		}*/
	}
	
	public static boolean verificarUsuarioPassword(String usuario, String password) {
		if(usuario.trim().equals("admin@admin.com") && password.trim().matches("admin")) {
			return true;
		}else {
			return false;
		}
		
	}
	
}
