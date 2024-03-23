package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import objs.Fondos;
import objs.Gastos;
import objs.Ingresos;

public class Conexion {

	private String url = "jdbc:mariadb://127.0.0.1:3306/admon?serverTimezone = UTC";
	private String usuario = "root";
	private String pass = "1234";
	private Connection conexion;
	public Conexion() throws ClassNotFoundException, SQLException {
		
			Class.forName("org.mariadb.jdbc.Driver");
			conexion = DriverManager.getConnection(url,usuario,pass);
			
		
		
	}
	
	public int capitalTotal() throws SQLException {
		String query = " select sum(capital) from fondos;";
		int sumaCapFondos=0;
		
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query); 
		
		rs.next();
		sumaCapFondos = rs.getInt(1);
		
		rs.close();
		st.close();
			
		
		return sumaCapFondos;
	}
	
	public int deudaActiva()  throws SQLException {
		String query = " select sum(monto) from deudas where estado = 1;";
		int sumaDeuda=0;
		
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query); 
		
		rs.next();
		sumaDeuda = rs.getInt(1);
		
		rs.close();
		st.close();
			
		
		return sumaDeuda;
	}
	
	public int estabilidad()  throws SQLException {
		String query = " select sum(monto) - sum(capital) from fondos;";
		int estabilidad=0;
		
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query); 
		
		rs.next();
		estabilidad = rs.getInt(1);
		
		rs.close();
		st.close();
			
		
		return estabilidad;
	}
	
	public ArrayList<Fondos> traerFondos() throws SQLException {
		String query = "SELECT * FROM fondos";
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query);
		ArrayList<Fondos> datos = new ArrayList<>();
		while (rs.next()) {
			datos.add(new Fondos(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4)));
		}
		rs.close();
		st.close();

		return datos;
	}
	
	public void cerrarConexion() throws SQLException {
		conexion.close();
	}

	public void insertarFondo(Fondos fondoAinsertar) throws SQLException {
		String query = "INSERT INTO fondos(monto,nom_fondo,capital) VALUES"
				+ "(?,?,?)";
		PreparedStatement ps = conexion.prepareStatement(query);
		ps.setInt(1, fondoAinsertar.getMontoDeseado());
		ps.setString(2, fondoAinsertar.getNombre());
		ps.setInt(3, fondoAinsertar.getCapitalActual());
		ps.execute();
		ps.close();
	}

	public void updateFondo(int idFondo, String nombre, int parseInt) throws SQLException {
		String query = "update fondos set nom_fondo = ?, monto = ? where id_fondo = ?;";
		PreparedStatement ps = conexion.prepareStatement(query);
		ps.setString(1, nombre);
		ps.setInt(2, parseInt);
		ps.setInt(3, idFondo);
		ps.execute();
		ps.close();
		
	}

	public ArrayList<Ingresos> ingresosDeFondo(int idFondo) throws SQLException{
		String query = "SELECT * FROM ingresos where fondo_destino = " + idFondo;
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query);
		ArrayList<Ingresos> datos = new ArrayList<>();
		while (rs.next()) {
			datos.add(new Ingresos(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5)));
		}
		rs.close();
		st.close();

		return datos;
	}

	public ArrayList<Gastos> gastosDeFondo(int idFondo) throws SQLException{
		String query = "SELECT * FROM gastos where fondo_tomado = " + idFondo;
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query);
		ArrayList<Gastos> datos = new ArrayList<>();
		while (rs.next()) {
			datos.add(new Gastos(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5),rs.getInt(6)));
		}
		rs.close();
		st.close();

		return datos;
	}
	
	
}
