import java.util.ArrayList;
import java.util.Date;

import com.controller.Jugador;
import com.controller.Palabra;

public class Partida {
	private int id;
	private Date tiempoInicio;
	private Date tiempoFin;
	private int fallos;
	private int dificultad;
	private String uid;
	private ArrayList<Character> letras;
	private boolean finPartida;
	private Palabra palabra;
	private int puntuacion;
	
	
	public Partida(int id, int fallos, int dificultad, String uid,boolean finPartida, int puntuacion ) {
		this.id = id;
		this.fallos = fallos;
		this.dificultad = dificultad;
		this.uid = uid;
		this.finPartida = finPartida;
		this.puntuacion=puntuacion;
	}
	
	public Partida(int id, String uid, int puntuacion ) {
		this.id = id;
		this.uid = uid;
		this.puntuacion=puntuacion;
	}
	
	public Partida (int id, Date tiempoInicio, Date tiempoFin, int fallos, int dificultad, Jugador jugador, char letras, boolean finPartida) {
		super();
		this.id = id;
		this.tiempoInicio = tiempoInicio;
		this.tiempoFin = tiempoFin;
		this.fallos = fallos;
		this.dificultad = dificultad;
		//this.jugador = jugador;
		//this.letras = letras;
		this.finPartida = finPartida;
	}
	
		public static int[] comprobarLetra(final java.lang.String palabra, final char letra) {
		    if (palabra != null) {
		        final int returned[] = new int[palabra.length()];
		        for (int i = 0; i < palabra.length(); i++) {
		            if (palabra.charAt(i) == letra) {
		                returned[i] = i;
		            } else {
		                returned[i] = -1;
		            }
		        }
		        return returned;
		    }
		    return new int[0];
		}
	
	public void finPartida () {
		
	}
		
	/*private boolean isGuessRight(char chr){
	        for (int i = 0 ; i < word.length() ; i++){
	            if (word.charAt(i) == chr && Letter.getRevealed() == false){
	                Letter.reveal();
	                return true;
	            }
	            else if (word.charAt(i) == chr && Letter.getRevealed()){
	                return false;
	            }
	        }
	    }
	}*/
	
	public void letrasProbadas() {
		
	}
	
	public void generarPalabra() {
		
	}

	@Override
	public String toString() {
		return "Partida [id=" + id + ", uid=" + uid + ", puntuacion=" + puntuacion + "]";
	}
	
	
	
}

}