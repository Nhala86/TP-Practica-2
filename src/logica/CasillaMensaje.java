package logica;

public class CasillaMensaje{
	private Casilla casilla;
	private String mensaje;
	
	/**
	 * Metodo constructor de argumentos de casilla y mensaje
	 * @param casilla array de casillas
	 * @param mensaje string de los textos del juego
	 */
	public CasillaMensaje(Casilla casilla, String mensaje) {
		this.casilla = casilla;
		this.mensaje = mensaje;
	}

	/**
	 * Metodo booleano que pone la casilla a null 
	 * @return true si la casilla no es igual a null y false si es igual a false
	 */
	public boolean infoNovacia(){
		return (this.casilla != null);
	}
	
	/**
	 * Metodo String al que le pasas el mensaje inicializado
	 * @return un string de mensaje de la casilla
	 */
	public String getMensaje(){
		return this.mensaje;
	}

	/**
	 * Metodo al que le pasas la fila inicializada de casilla
	 * @return valor entero positivo de fila
	 */
	public int getFila() {
		return casilla.getFila();
	}
	
	/**
	 * Metodo al que le pasas la columna inicializada de casilla
	 * @return valor entero positivo de fila
	 */
	public int getColumna() {
		return casilla.getColumna();
	}
}
