import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import com.controller.ListaPartidas;
import com.controller.Palabra;
import com.controller.Partida;

import dao.InterfazDAO;
import dao.SQLConexion;

public class SQLPartidaDAO implements InterfazDAO<Partida>{

	private ListaPartidas listaPartidas;
	
	public void crearElemento(Palabra elemento) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	public void eliminaElemento(Palabra elemento) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	public List<Partida> getTodos() throws Exception {
		System.out.println("GET TODAS LAS PARTIDAS");
		
		SQLConexion con = new SQLConexion();
		listaPartidas = new ListaPartidas();
    	
    	if(con.ConectarBasedeDatos()) {
    		try{
    			Partida par = null;
	    		// Si ya existe Base de Datos
	    		Statement stmt = con.getConnection().createStatement();  
	    		ResultSet rs=stmt.executeQuery("select * from partida");
	    		while(rs.next()) {
	    			// Recorro todas las palabras guardadas en persistencia
	    			par = new Partida(rs.getInt("idPalabra"));
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