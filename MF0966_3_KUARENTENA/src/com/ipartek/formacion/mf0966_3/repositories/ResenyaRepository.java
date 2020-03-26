package com.ipartek.formacion.mf0966_3.repositories;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.ipartek.formacion.mf0966_3.entities.Resenya;
import com.ipartek.formacion.mf0966_3.entities.Alumno;
import com.ipartek.formacion.mf0966_3.entities.Curso;

public class ResenyaRepository implements DaoResenya {
	
	private static final String sql_get_all = "call mf0966_3.resenyasGetAll();";
	//private static final String sql_getById = "call mf0966_3.resenyasGetByiD(?);";
	private static final String sql_getByIds = "call mf0966_3.resenyasGetByiDs(?,?);";
	private static final String sql_insert = "call mf0966_3.resenyasInsert(?,?,?);";
	private static final String sql_update = "call mf0966_3.resenyasUpdate(?,?,?);";
	//private static final String sql_delete = "call mf0966_3.resenyasDelete(?);";
	private static final String sql_delete_with_ids = "call mf0966_3.resenyasDeleteWithIds(?,?);";
	private static final String sql_get_all_byCursoId = "call mf0966_3.resenyasGetAllByCursoiD(?);";
	
	


	private String url;
	private String usuario;
	private String password;
	
	private static Properties CONFI;

	private static ResenyaRepository INSTANCIA = null;
	
	private ResenyaRepository(String url, String usuario, String password) {
		this.url = url;
		this.usuario = usuario;
		this.password = password;
	}
	
	public static DaoResenya getInstancia (Properties configuracion){
		
		if(INSTANCIA == null) {
			setClassForName();
			INSTANCIA = new ResenyaRepository(configuracion.getProperty("mysql.url"),
					configuracion.getProperty("mysql.usuario"), configuracion.getProperty("mysql.password"));
		}
		CONFI = configuracion;
		return INSTANCIA;
	}
	
	@Override
	public Iterable<Resenya> obtenerTodos() {
		ArrayList<Resenya> resenyas = new ArrayList<>();
		try (Connection con = getConexion()) {
			try (CallableStatement cs = con.prepareCall(sql_get_all)) {
				try (ResultSet rs = cs.executeQuery()) {
					while (rs.next()) {
						Alumno alumno = AlumnoRepository.getInstancia(CONFI).obtenerPorId(rs.getLong("alumno_codigo"));
						Curso curso = CursoRepository.getInstancia(CONFI).obtenerPorId(rs.getLong("curso_codigo"));
						curso.setResenyas(null);
						resenyas.add (new Resenya(alumno,curso, rs.getString("resenya")));
					}
				}
			}
			return resenyas;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AccesoDatosException("Error al obtener todos los registros",e);
		}	
	}
	
	@Override
	public Resenya obtenerPorId(Long id) {
		/*try (Connection con = getConexion()) {
			try (CallableStatement cs = con.prepareCall(sql_getById)) {
				cs.setLong(1, id);
				try (ResultSet rs = cs.executeQuery()) {
					if (rs.next()) {
						Alumno alumno = AlumnoRepository.getInstancia(CONFI).obtenerPorId(rs.getLong("alumno_codigo"));
						Curso curso = CursoRepository.getInstancia(CONFI).obtenerPorId(rs.getLong("curso_codigo"));
						return new Resenya(alumno,curso, rs.getString("resenya"));
					}
				}
			}
			return null;
		} catch (SQLException e) {
			throw new AccesoDatosException("Error al obtener todos los registros",e);
		}*/
		
		//TODO Sin implementar
		
		return null;
	}
	
	@Override
	public Resenya obtenerPorIds(Long idAlumno, Long idCurso) {
		try (Connection con = getConexion()) {
			try (CallableStatement cs = con.prepareCall(sql_getByIds)) {
				cs.setLong(1, idAlumno);
				cs.setLong(2, idCurso);
				
				try (ResultSet rs = cs.executeQuery()) {
					if (rs.next()) {
						Alumno alumno = AlumnoRepository.getInstancia(CONFI).obtenerPorId(idAlumno);
						Curso curso = CursoRepository.getInstancia(CONFI).obtenerPorId(rs.getLong("curso_codigo"));
						curso.setResenyas(null);
						return (new Resenya(alumno,curso, rs.getString("resenya")));
					}
				}
			}
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AccesoDatosException("Error al obtener todos los registros",e);
		}
	}
	
	@Override
	public int agregar(Resenya resenya) {
		try (Connection con = getConexion()) {
			try (CallableStatement cs = con.prepareCall(sql_insert)) {
				cs.setLong(1, resenya.getAlumno().getId());
				cs.setLong(2, resenya.getCurso().getId());
				cs.setString(3,resenya.getResenya());
				
				int numeroRegistrosModificados = cs.executeUpdate();
				
				
				if (numeroRegistrosModificados != 1) {
					throw new AccesoDatosException("Resultado no esperado en la INSERT: " + numeroRegistrosModificados);
				}
				return 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AccesoDatosException("Error al obtener conexion", e);
		}
		
	}
	
	@Override
	public void modificar(Resenya resenya) {
		try (Connection con = getConexion()) {
			try (CallableStatement cs = con.prepareCall(sql_update)) {
				cs.setLong(1, resenya.getAlumno().getId());
				cs.setLong(2, resenya.getCurso().getId());
				cs.setString(3,resenya.getResenya());
				
				int numeroRegistrosModificados = cs.executeUpdate();
				
				if (numeroRegistrosModificados != 1) {
					throw new AccesoDatosException("Resultado no esperado en la UPDATE: " + numeroRegistrosModificados);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AccesoDatosException("Error al obtener conexion", e);
		}
		
	}

	@Override
	public void borrar(Long id) {
		/*try (Connection con = getConexion()) {
			try (CallableStatement cs = con.prepareCall(sql_delete)) {
				cs.setLong(1, id);
				int numeroRegistrosModificados = cs.executeUpdate();
				if (numeroRegistrosModificados != 1) {
					throw new AccesoDatosException("No se Eliminado ningun registro para el Curso=" + id + ".");
				}
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("Error al obtener todos los registros",e);
		}*/
		
		//TODO sin implementar
	}
	
	@Override
	public void borrarPorIds(Long idAlumno, Long idCurso) {
		try (Connection con = getConexion()) {
			try (CallableStatement cs = con.prepareCall(sql_delete_with_ids)) {
				cs.setLong(1, idAlumno);
				cs.setLong(2, idCurso);
				int numeroRegistrosModificados = cs.executeUpdate();
				if (numeroRegistrosModificados != 1) {
					throw new AccesoDatosException("No se Eliminado ningun registro para la Resenya= " + idAlumno + ", " + idCurso  +".");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AccesoDatosException("Error al obtener todos los registros",e);
		}
	}
	
	
	private Connection getConexion() throws SQLException {
		return DriverManager.getConnection(url, usuario, password);
	}
	
	private static void setClassForName() {
		try {
		    Class.forName("com.mysql.cj.jdbc.Driver");
		} 
		catch (ClassNotFoundException e) {
			throw new AccesoDatosException("Error al crear el Class del JDBC",e);
		} 
	}

	@Override
	public Iterable<Resenya> obtenerResenyasCurso(Long idCurso) {
		ArrayList<Resenya> cursos = new ArrayList<>();
		try (Connection con = getConexion()) {
			try (CallableStatement cs = con.prepareCall(sql_get_all_byCursoId)) {
				cs.setLong(1, idCurso);
				try (ResultSet rs = cs.executeQuery()) {
					while (rs.next()) {
						Alumno alumno = AlumnoRepository.getInstancia(CONFI).obtenerPorId(rs.getLong("alumno_codigo"));
						Curso curso = new Curso(idCurso,null,null,null);
						cursos.add (new Resenya(alumno,curso, rs.getString("resenya")));
					}
				}
			}
			return cursos;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AccesoDatosException("Error al obtener todos los registros",e);
		}	
	}

}
