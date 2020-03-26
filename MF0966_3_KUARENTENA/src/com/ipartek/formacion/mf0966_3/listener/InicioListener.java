package com.ipartek.formacion.mf0966_3.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.ipartek.formacion.mf0966_3.entities.Alumno;
import com.ipartek.formacion.mf0966_3.entities.Curso;
import com.ipartek.formacion.mf0966_3.entities.Profesor;
import com.ipartek.formacion.mf0966_3.repositories.Dao;
import com.ipartek.formacion.mf0966_3.repositories.DaoResenya;
import com.ipartek.formacion.mf0966_3.repositories.FabricaDao;

@WebListener
public class InicioListener implements ServletContextListener {
	
	public static Dao<Alumno> daoAlumnos;
	public static Dao<Profesor> daoProfesores;
	public static Dao<Curso> daoCursos;
	public static DaoResenya daoResenyas;
	
    public void contextDestroyed(ServletContextEvent sce)  {}

    public void contextInitialized(ServletContextEvent sce)  { 
    	 String pathConfiguracion = sce.getServletContext().getRealPath("/WEB-INF/") + "dao.properties";
     	
    	 daoAlumnos = FabricaDao.getAlumnoInstancia(pathConfiguracion);
    	 daoProfesores= FabricaDao.getTrabajadorInstancia(pathConfiguracion);
    	 daoCursos = FabricaDao.getCursoInstancia(pathConfiguracion);
    	 daoResenyas = FabricaDao.getResenyaInstancia(pathConfiguracion);

    	 sce.getServletContext().setAttribute("daoAlumnos", daoAlumnos);
    	 sce.getServletContext().setAttribute("daoProfesores", daoProfesores);
    	 sce.getServletContext().setAttribute("daoCursos", daoCursos);
    	 sce.getServletContext().setAttribute("daoResenyas", daoResenyas);
    }
	
}
