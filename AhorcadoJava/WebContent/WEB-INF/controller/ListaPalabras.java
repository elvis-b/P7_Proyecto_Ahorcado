/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.List;

//import javax.xml.bind.annotation.XmlElement;
//import javax.xml.bind.annotation.XmlRootElement;



/**
*
* @author Elvis, Elena, Victor, Alain
*/

//@XmlRootElement(name = "proyectos")
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
    //@XmlElement(name = "proyecto")
    public List<Palabra> getListaPalabras() {
        return listaPalabras;
    }
    
    /**
     * Metodo accesor de escritura que asigna el listado de proyectos.
     * 
     * @param listadoDelegaciones El listado de proyectos.
     */
    public void setListadoProyectos(List<Palabra> listaPalabras) {
        this.listaPalabras = listaPalabras;
    }
    
    /**
     * Este metodo nos permite agregar un proyecto al listado.
     * 
     * @param d Proyecto.
     */
    public void addPalabra(Palabra p)
    {
        this.listaPalabras.add(p);
    }
    

    
}
