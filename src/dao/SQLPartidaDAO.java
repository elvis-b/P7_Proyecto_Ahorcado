package dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import model.ListaPartidas;
import model.Palabra;
import model.Partida;

public class SQLPartidaDAO implements InterfazDAO<Partida>{

	private ListaPartidas listaPartidas;
	
	public void crearElemento(Palabra elemento) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	public void eliminaElemento(Palabra elemento) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	
	public int getMejor(String uid) throws Exception {
		
		SQLConexion con = new SQLConexion();
    	int puntuacion = -1;
		
    	if(con.ConectarBasedeDatos()) {
    		try{
    			Partida par = null;
	    		// Si ya existe Base de Datos
	    		Statement stmt = con.getConnection().createStatement();  
	    		String consulta = "select * from partida WHERE uid=\""+ uid +"\" ORDER BY puntuacion DESC LIMIT 1";
	    		
	    		ResultSet rs=stmt.executeQuery(consulta);
	    		while(rs.next()) {
	    			puntuacion = rs.getInt("puntuacion");
	    		}
    		}
    		catch (Exception e)
    		{ 
    			System.out.println(e);
    		}
    	}
    	else {
    		return -1;
    	}
    	
    	con.DesconectarBasedeDatos();

        return puntuacion;
		
	}
	
	public List<Partida> getTodos() throws Exception {
		
		SQLConexion con = new SQLConexion();
		listaPartidas = new ListaPartidas();
    	
    	if(con.ConectarBasedeDatos()) {
    		try{
    			Partida par = null;
	    		// Si ya existe Base de Datos
	    		Statement stmt = con.getConnection().createStatement();  
	    		ResultSet rs=stmt.executeQuery("select * from partida ORDER BY puntuacion DESC LIMIT 5");
	    		while(rs.next()) {
	    			// Recorro todas las palabras guardadas en persistencia
	    			// Partida(int id, int fallos, int dificultad, String uid,boolean finPartida, int puntuacion )
	    			par = new Partida(rs.getInt("id"),rs.getInt("fallos"),rs.getString("uid"),rs.getInt("puntuacion"));
	    			listaPartidas.addPartida(par);
	    		}
    		}
    		catch (Exception e)
    		{ 
    			System.out.println(e);
    		}
    	}
    	else {
    		return null;
    	}
    	
    	con.DesconectarBasedeDatos();

        return listaPartidas.getListaPartidas();
	}
	
	public void printTodos() throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	public void saveTodos() throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void crearElemento(Partida elemento) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void eliminaElemento(Partida elemento) throws Exception {
		// TODO Auto-generated method stub
		
	}
}