package model;

import java.util.ArrayList;
import java.util.Date;

public class Partida 
{
	
//CAMPOS
	
	private int id;
	private Date tiempoInicio;
	private Date tiempoFin;
	private int fallos;
	private String uid;
	private int dificultad;

	private ArrayList<Character> letras;
	private boolean finPartida;
	private Palabra palabra;
	private int puntuacion;
	
//constructor
	
	public Partida(int id, int fallos, int dificultad, String uid,boolean finPartida, int puntuacion ) {
		this.id = id;
		this.fallos = fallos;
		this.dificultad = dificultad;
		this.uid = uid;
		this.finPartida = finPartida;
		this.puntuacion=puntuacion;
		
		generarPalabra();
	}
	
	public Partida(int id, int fallos, String uid, int puntuacion ) {
		this.id = id;
		this.fallos=fallos;
		this.uid = uid;
		this.puntuacion=puntuacion;
		
		generarPalabra();
	}
	
	public Partida (int id, Date tiempoInicio, Date tiempoFin, int fallos, int dificultad, char letras, boolean finPartida) {
		super();
		this.id = id;
		this.tiempoInicio = tiempoInicio;
		this.tiempoFin = tiempoFin;
		this.fallos = fallos;
		this.dificultad = dificultad;
		//this.jugador = jugador;
		//this.letras = letras;
		this.finPartida = finPartida;
		
		generarPalabra();
	}
	
	public void comprobarLetra(final java.lang.String palabra, final char letra) {
		    if (palabra != null) {
		        final int returned[] = new int[palabra.length()];
		        for (int i = 0; i < palabra.length(); i++) {
		            if (palabra.charAt(i) == letra) {
		                returned[i] = i;
		            } else {
		                returned[i] = -1;
		            }
		        }
		        //return returned;
		    }
		    //return new int[0];
		}
	
	public boolean finPartida () {
		return finPartida;
		
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
	

	public ArrayList<Character> letrasProbadas(){
		return letras;
	}

	
	private void generarPalabra() {
		// Conexion con la BBDD y elegir palabra aleatorio
	}
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFallos() {
		return fallos;
	}

	public void setFallos(int fallos) {
		this.fallos = fallos;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}

	@Override
	public String toString() {
		return "Partida [id=" + id + ", fallos="+ fallos+",uid=" + uid + ", puntuacion=" + puntuacion + "]";
	}
	
	
	
	
}