import java.util.ArrayList;
import java.util.List;

public class ListaPartidas {
	
	// CAMPOS
    private List<Partida> listaPartidas;
    
    // CONSTRUCTORES
    
    /**
	 * Constructor que llama a un nuevo objeto ListadoProyectos sin inicializar sus campos.
	 */
    public ListaPartidas() {
        super();
        listaPartidas = new ArrayList<Partida>();        
    }
    
    /**
	 * Constructor que crea una instancia del objeto con datos predeterminados.
	 * 
	 * @param listadoProyectos Lista que inicializa la instancia que se cree
	 */
    public ListaPartidas(List<Partida> listaPartidas) {
        super();
        this.listaPartidas = listaPartidas;
    }
    
    /**
	 * Metodo accesor de lectura que nos da el listado de proyectos.
	 * 
	 * @return Nos devuelve el listado de proyectos. 
	 */
    //@XmlElement(name = "proyecto")
    public List<Partida> getListaPartidas() {
        return listaPartidas;
    }
    
    /**
     * Metodo accesor de escritura que asigna el listado de proyectos.
     * 
     * @param listadoDelegaciones El listado de proyectos.
     */
    public void setListadoProyectos(List<Partida> listaPartidas) {
        this.listaPartidas = listaPartidas;
    }
    
    /**
     * Este metodo nos permite agregar un proyecto al listado.
     * 
     * @param d Proyecto.
     */
    public void addPartida(Partida p)
    {
        this.listaPartidas.add(p);
    }
    

}
