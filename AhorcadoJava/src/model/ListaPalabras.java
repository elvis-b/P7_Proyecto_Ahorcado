package model;

import java.util.ArrayList;
import java.util.List;

/**
*
* @author Elvis, Elena, Victor y Alain
*/

public class ListaPalabras {
    
	// CAMPOS
    private List<Palabra> listaPalabras;
    
    // CONSTRUCTORES
    
    /**
	 * Constructor que llama a un nuevo objeto ListadoProyectos sin inicializar sus campos.
	 */
    public ListaPalabras() {
        super();
        listaPalabras = new ArrayList<Palabra>();        
    }
    
    /**
	 * Constructor que crea una instancia del objeto con datos predeterminados.
	 * 
	 * @param listadoProyectos Lista que inicializa la instancia que se cree
	 */
    public ListaPalabras(List<Palabra> listaPalabras) {
        super();
        this.listaPalabras = listaPalabras;
    }
    
    /**
	 * Metodo accesor de lectura que nos da el listado de proyectos.
	 * 
	 * @return Nos devuelve el listado de proyectos. 
	 */
    public List<Palabra> getListaPalabras() {
        return listaPalabras;
    }
    
    /**
     * Metodo accesor de escritura que asigna el listado de palabras.
     * 
     * @param listadoPalabras El listado de palabras.
     */
    public void setListadoPalabras(List<Palabra> listaPalabras) {
        this.listaPalabras = listaPalabras;
    }
    
    /**
     * Este metodo nos permite agregar una palabra al listado.
     * 
     * @param p Palabra.
     */
    public void addPalabra(Palabra p)
    {
        this.listaPalabras.add(p);
    }
    
    public int size() {
    	return this.listaPalabras.size();
    }
    
    public Palabra getPalabra(int index) {
    	return this.listaPalabras.get(index);
    }
   
}
