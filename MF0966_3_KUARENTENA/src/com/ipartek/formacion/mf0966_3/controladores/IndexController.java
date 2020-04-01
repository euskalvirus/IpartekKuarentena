package com.ipartek.formacion.mf0966_3.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.mf0966_3.repositories.CursoRepository;

@WebServlet("/index")
public class IndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//@SuppressWarnings("unchecked")
		//Dao<Objeto> daoObjetos = (Dao<Objeto>) getServletContext().getAttribute("daoObjetos");
		//request.setAttribute("objetos", daoObjetos.obtenerTodos());
		CursoRepository cursos = (CursoRepository) getServletContext().getAttribute("daoCursos");
		
		request.setAttribute("cursos", cursos.obtenerTodos());
		request.getRequestDispatcher("/WEB-INF/vistas/admin/cursos.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
