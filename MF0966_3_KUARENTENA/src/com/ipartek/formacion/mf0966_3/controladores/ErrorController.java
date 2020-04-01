package com.ipartek.formacion.mf0966_3.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;
import com.google.gson.JsonObject;

@WebServlet("/error")
public class ErrorController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pathAnterior = request.getAttribute("javax.servlet.error.request_uri").toString();
		String[] splitPathAnterior = pathAnterior.split("/");
		
		if (splitPathAnterior[2].equals("api")) {
			
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			response.setContentType(MediaType.APPLICATION_JSON);
			
			JsonObject jsonString = new JsonObject();
			
			jsonString.addProperty("error", "Ruta o datos incorrectos");

			response.getWriter().write(jsonString.toString());
		} else {

			String error = request.getParameter("error");
			if (error == null) {
				request.getRequestDispatcher("/WEB-INF/vistas/error.jsp").forward(request, response);
			} else {
				response.sendRedirect(request.getContextPath() + "/index");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
