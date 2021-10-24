/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import model.ListaPalabras;
import model.Palabra;


public class SQLPalabraDAO implements InterfazDAO<Palabra>{
	
    private ListaPalabras listaPalabras;
    
    // CONSTRUCTORES
    
 	/**
 	 * Constructor que crea una instancia de patrón DAO.
 	 * Al inicializarse obtiene los datos provenientes de la persistencia
 	 */
    public SQLPalabraDAO(){
    	
        try {
        	// Rescata Datos de la persistencia
        	getTodos();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}        
    }
    
    /**
 	 * Constructor que crea una instancia de patrón DAO con una lista de palabras predeterminada.
 	 * 
 	 * @param listaPalabras lista de palabras predeterminada
 	 */
    public SQLPalabraDAO(ListaPalabras listaPalabras) {
    	super();
    	this.listaPalabras = listaPalabras;
    }
    
    /**
	 * Metodo accesor de lectura que nos da el listado de palabras.
	 * 
	 * @return Nos devuelve el listado de palabras. 
	 */
    public ListaPalabras getListaPalabras() {
    	return listaPalabras;
    }
    
    /**
	 * Metodo accesor de escritura que añade una delegación a la lista
	 * 
	 * @param elemento Palabra a añadir 
	 */
    public void crearElemento(Palabra elemento) throws SQLException 
    {
    	// Añado al listado
        listaPalabras.addPalabra(elemento);
        // Guardo en la persistencia
        SQLConexion con = new SQLConexion();
    	
    	if(con.ConectarBasedeDatos()) {
    		try{
	    		// Si ya existe Base de Datos
	    		//PreparedStatement stmt = con.getConnection().prepareStatement("INSERT INTO DELEGACION VALUES(?,?,?,?)");
	    		//stmt.setInt(1, elemento.getIdDelegacion());
	    		//stmt.setString(2, elemento.getNombre());
	    		//stmt.setString(3, elemento.getDireccion());
	    		//stmt.setString(4, elemento.getCiudad());
	    		//stmt.executeUpdate();
    		}
    		catch(Exception e)
    		{ 
    			System.out.println(e);
    		}  
    	}
    	else {
    		System.out.println("Problema de conexión a la Base de Datos");
    	}
    	
    	con.DesconectarBasedeDatos();
       
        //System.out.println("Se ha creado una nueva palabra: "+elemento.getNombre());
    }
    
    public Palabra getPalabraAleatorio(int dificultad) throws SQLException {
    	
    	SQLConexion con = new SQLConexion();
       	listaPalabras = new ListaPalabras();
    	
    	if(con.ConectarBasedeDatos()) {
    		try{
    			Palabra pal = null;
	    		// Si ya existe Base de Datos
	    		Statement stmt = con.getConnection().createStatement();
	    		String consulta = "select * from palabra WHERE dificultad=\""+ dificultad+"\""; 
	    		ResultSet rs=stmt.executeQuery(consulta);
	    		while(rs.next()) {
	    			// Recorro todas las palabras guardadas en persistencia
	    			pal = new Palabra(rs.getInt("idPalabra"), rs.getString("palabra"), rs.getInt("dificultad"));
	    			listaPalabras.addPalabra(pal);
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
    	int rand = (int) (Math.random() * listaPalabras.size());

    	// Del listado de palabras escogemos una aleatoria de 0 .. size-1
        return listaPalabras.getPalabra(rand);	
    }
    
    
    
    /**
	 * Metodo accesor de lectura que se encarga de obtener los datos desde la persistencia
	 * 
	 * @return devuelve una lista de los datos recuperados. O en caso de no existir datos, devuelve una lista vacía
	 */
    public List<Palabra> getTodos() throws SQLException {
    	SQLConexion con = new SQLConexion();
       	listaPalabras = new ListaPalabras();
    	
    	if(con.ConectarBasedeDatos()) {
    		try{
    			Palabra pal = null;
	    		// Si ya existe Base de Datos
	    		Statement stmt = con.getConnection().createStatement();  
	    		ResultSet rs=stmt.executeQuery("select * from palabra");
	    		while(rs.next()) {
	    			// Recorro todas las palabras guardadas en persistencia
	    			pal = new Palabra(rs.getInt("idPalabra"), rs.getString("palabra"), rs.getInt("dificultad"));
	    			listaPalabras.addPalabra(pal);
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

        return listaPalabras.getListaPalabras();
    }
    
    /**
	 * Imprime la lista de palabras
	 */
    public void printTodos() throws SQLException {
        
        if (listaPalabras.getListaPalabras().size() > 0) 
        {
            System.out.println("La BBDD cuenta con " + listaPalabras.getListaPalabras().size() + " palabras:");
	    
            for (Palabra p : listaPalabras.getListaPalabras()) {
	    	System.out.println(p.toString());
            //}
		    
	    }
        } else {
	    	System.out.println("La BBDD no tiene palabras.");
	    }
    }
    
    /**
	 * Guarda todas las palabras en la persistencia
	 */
    public void saveTodos() throws SQLException {
        // No aplica        
    }

	public void eliminaElemento(Palabra elemento) throws Exception {
        // Elimino de la persistencia
        SQLConexion con = new SQLConexion();
    	
    	if(con.ConectarBasedeDatos()) {
    		try{
	    		// Si ya existe Base de Datos
	    		//PreparedStatement stmt = con.getConnection().prepareStatement("DELETE FROM DELEGACION WHERE idDelegacion = ?");
	    		//stmt.setInt(1, elemento.getIdDelegacion());
	    		//stmt.executeUpdate();
    		}
    		catch(Exception e)
    		{ 
    			System.out.println(e);
    		}  
    	}
    	else {
    		System.out.println("Problema de conexión a la Base de Datos");
    	}
    	
    	con.DesconectarBasedeDatos();
		
	}




}
