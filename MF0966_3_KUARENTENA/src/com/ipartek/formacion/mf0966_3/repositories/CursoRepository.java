package com.ipartek.formacion.mf0966_3.repositories;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.ipartek.formacion.mf0966_3.entities.Curso;
import com.ipartek.formacion.mf0966_3.entities.Profesor;
import com.ipartek.formacion.mf0966_3.entities.Resenya;

public class CursoRepository implements Dao<Curso> {
	
	private static final String sql_get_all = "call mf0966_3.cursosGetAll();";
	private static final String sql_getById = "call mf0966_3.cursosGetByiD(?);";
	/*private static final String sql_insert = "call mf0966_3.cursosInsert(?,?,?,?);";
	private static final String sql_update = "call mf0966_3.cursosUpdate(?,?,?,?);";
	private static final String sql_delete = "call mf0966_3.cursosDelete(?);";*/


	private String url;
	private String usuario;
	private String password;
	
	private static Properties CONFI;

	private static CursoRepository INSTANCIA = null;
	
	private CursoRepository(String url, String usuario, String password) {
		this.url = url;
		this.usuario = usuario;
		this.password = password;
	}
	
	public static Dao<Curso> getInstancia (Properties configuracion){
		
		if(INSTANCIA == null) {
			setClassForName();
			INSTANCIA = new CursoRepository(configuracion.getProperty("mysql.url"),
					configuracion.getProperty("mysql.usuario"), configuracion.getProperty("mysql.password"));
		}
		CONFI = configuracion;
		return INSTANCIA;
	}
	
	@Override
	public Iterable<Curso> obtenerTodos() {
		ArrayList<Curso> cursos = new ArrayList<>();
		try (Connection con = getConexion()) {
			try (CallableStatement cs = con.prepareCall(sql_get_all)) {
				try (ResultSet rs = cs.executeQuery()) {
					while (rs.next()) {
						Profesor profesor = ProfesorRepository.getInstancia(CONFI).obtenerPorId(rs.getLong("profesor_codigo"));
						cursos.add (new Curso(rs.getLong("codigo"), rs.getString("nombre"), rs.getInt("nHoras"), profesor ));
					}
				}
			}
			return cursos;
		} catch (SQLException e) {
			throw new AccesoDatosException("Error al obtener todos los registros",e);
		}	
	}
	
	@Override
	public Curso obtenerPorId(Long id) {
		try (Connection con = getConexion()) {
			try (CallableStatement cs = con.prepareCall(sql_getById)) {
				cs.setLong(1, id);
				try (ResultSet rs = cs.executeQuery()) {
					if (rs.next()) {
						ArrayList<Resenya> resenyas = (ArrayList<Resenya>) this.obtenerResenyas(id);
						Profesor profesor = ProfesorRepository.getInstancia(CONFI).obtenerPorId(rs.getLong("profesor_codigo"));
						return (new Curso(rs.getLong("codigo"), rs.getString("nombre"), rs.getInt("nHoras"), profesor, resenyas));
					}
				}
			}
			return null;
		} catch (SQLException e) {
			throw new AccesoDatosException("Error al obtener todos los registros",e);
		}
	}
	
	@Override
	public int agregar(Curso curso) {
		/*try (Connection con = getConexion()) {
			try (CallableStatement cs = con.prepareCall(sql_insert)) {
				cs.setString(1, curso.getNombre());
				cs.setInt(2, curso.getnHoras());
				cs.setLong(3,curso.getProfesor().getId());
				
				cs.registerOutParameter(4, java.sql.Types.INTEGER);
				
				int numeroRegistrosModificados = cs.executeUpdate();
				
				
				if (numeroRegistrosModificados != 1) {
					throw new AccesoDatosException("Resultado no esperado en la INSERT: " + numeroRegistrosModificados);
				}
				return cs.getInt(4);
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("Error al obtener conexion", e);
		}*/
		
		//TODO SIN IMPLEMENTAR
		return 0;
		
	}
	
	@Override
	public void modificar(Curso curso) {
		/*try (Connection con = getConexion()) {
			try (CallableStatement cs = con.prepareCall(sql_update)) {
				cs.setLong(1,curso.getId());
				cs.setString(2, curso.getNombre());
				cs.setInt(3, curso.getnHoras());
				cs.setLong(4,curso.getProfesor().getId());
				
				int numeroRegistrosModificados = cs.executeUpdate();
				
				if (numeroRegistrosModificados != 1) {
					throw new AccesoDatosException("Resultado no esperado en la UPDATE: " + numeroRegistrosModificados);
				}
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("Error al obtener conexion", e);
		}*/
		
		//TODO sin implementar
		
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

	private Iterable<Resenya> obtenerResenyas(Long idCurso){
		
		return ResenyaRepository.getInstancia(CONFI).obtenerResenyasCurso(idCurso);
		
	}
}
