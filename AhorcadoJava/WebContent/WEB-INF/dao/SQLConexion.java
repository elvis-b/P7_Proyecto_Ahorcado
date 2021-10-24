package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLConexion {
	// CAMPOS
	private static final String url = "jdbc:mysql://localhost:3306/";
	private static final String dbName = "Ahorcado";
	private static final String driver = "com.mysql.cj.jdbc.Driver";
	private static final String userName = "root";
	private static final String password = "";
			
	    public Connection conexion;
	    public PreparedStatement sentencia;
	    public Statement stm;
	    public ResultSet resultado;

		public Boolean ConectarBasedeDatos(){
			String databaseName = "";
			Boolean dbCheck = false;
		 
			try {
				Class.forName( driver );
				conexion = DriverManager.getConnection(url,userName,password);
		 
				resultado = conexion.getMetaData().getCatalogs();
				while (resultado.next() && !dbCheck) {
					// Get the database name, which is at position 1
					databaseName = resultado.getString(1);
					dbCheck = databaseName.equals(dbName);
				}
	
				sentencia = conexion.prepareStatement("USE "+dbName+";");
			    sentencia.executeUpdate();
	
			} catch (Exception ex) {
				 return false;
			}
		 return true;
		}
			
		
	public void DesconectarBasedeDatos() {
		 try {
			 if (conexion != null ) {
				 	if(sentencia != null) {
				 		sentencia.close();
				 	}
				 	conexion.close();
			 }
		 
		 } catch (SQLException ex) {
		 
			 System.exit(1);
		 }
		 }
	
	public Connection getConnection(){
		 return conexion;
	}
}
