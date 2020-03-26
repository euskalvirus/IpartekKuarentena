package com.ipartek.formacion.mf0966_3.repositories;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.ipartek.formacion.mf0966_3.entities.Profesor;

public class ProfesorRepository implements Dao<Profesor> {
	
	private static final String sql_get_all = "call mf0966_3.profesoresGetAll();";
	private static final String sql_getById = "call mf0966_3.profesoresGetByiD(?);";
	/*private static final String sql_insert = "call mf0966_3.profesoresInsert(?,?,?);";
	private static final String sql_update = "call mf0966_3.profesoresUpdate(?,?,?);";
	private static final String sql_delete = "call mf0966_3.profesoresDelete(?);";*/


	private String url;
	private String usuario;
	private String password;

	private static ProfesorRepository INSTANCIA = null;
	
	private ProfesorRepository(String url, String usuario, String password) {
		this.url = url;
		this.usuario = usuario;
		this.password = password;
	}
	
	public static Dao<Profesor> getInstancia (Properties configuracion){
		if(INSTANCIA == null) {
			setClassForName();
			INSTANCIA = new ProfesorRepository(configuracion.getProperty("mysql.url"),
					configuracion.getProperty("mysql.usuario"), configuracion.getProperty("mysql.password"));
		}
		return INSTANCIA;
	}
	
	@Override
	public Iterable<Profesor> obtenerTodos() {
		ArrayList<Profesor> alumnos = new ArrayList<>();
		try (Connection con = getConexion()) {
			try (CallableStatement cs = con.prepareCall(sql_get_all)) {
				try (ResultSet rs = cs.executeQuery()) {
					while (rs.next()) {
						alumnos.add (new Profesor(rs.getLong("codigo"), rs.getString("nombre"), rs.getString("apellidos")));
					}
				}
			}
			return alumnos;
		} catch (SQLException e) {
			throw new AccesoDatosException("Error al obtener todos los registros",e);
		}	
	}
	
	@Override
	public Profesor obtenerPorId(Long id) {
		try (Connection con = getConexion()) {
			try (CallableStatement cs = con.prepareCall(sql_getById)) {
				cs.setLong(1, id);
				try (ResultSet rs = cs.executeQuery()) {
					if (rs.next()) {
						return (new Profesor(rs.getLong("codigo"), rs.getString("nombre"), rs.getString("apellidos")));
					}
				}
			}
			return null;
		} catch (SQLException e) {
			throw new AccesoDatosException("Error al obtener todos los registros",e);
		}
	}
	
	@Override
	public int agregar(Profesor profesor) {
		/*try (Connection con = getConexion()) {
			try (CallableStatement cs = con.prepareCall(sql_insert)) {
				cs.setString(1, profesor.getNombre());
				cs.setString(2, profesor.getApellidos());
				
				cs.registerOutParameter(3, java.sql.Types.INTEGER);
				
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
	public void modificar(Profesor profesor) {
		/*try (Connection con = getConexion()) {
			try (CallableStatement cs = con.prepareCall(sql_update)) {
				cs.setLong(1, profesor.getId());
				cs.setString(2, profesor.getNombre());
				cs.setString(3, profesor.getApellidos());
				
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
					throw new AccesoDatosException("No se Eliminado ningun registro para el Profesor=" + id + ".");
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

}
