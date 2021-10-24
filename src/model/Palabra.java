package model;

public class Palabra {
	private int idPalabra;
	private String palabra;
	private int dificultad;
	
	public Palabra(int idPalabra, String palabra, int dificultad) {
		super();
		this.idPalabra = idPalabra;
		this.palabra = palabra;
		this.dificultad = dificultad;
	}

	public int getIdPalabra() {
		return idPalabra;
	}

	public void setIdPalabra(int idPalabra) {
		this.idPalabra = idPalabra;
	}

	public String getPalabra() {
		return palabra;
	}

	public void setPalabra(String palabra) {
		this.palabra = palabra;
	}

	public int getDificultad() {
		return dificultad;
	}

	public void setDificultad(int dificultad) {
		this.dificultad = dificultad;
	}

	@Override
	public String toString() {
		return "Palabra [idPalabra=" + idPalabra + ", palabra=" + palabra + ", dificultad=" + dificultad + "]";
	}
	
	
}
