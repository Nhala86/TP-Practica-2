package comandos;

import java.util.Scanner;

import logica.Mundo;

public class EliminarCelula implements Comando {
	private int fila;
	private int columna;
		
	/**
	 * Metodo constructor de argumentos
	 * @param fila valor entero positivo de fila
	 * @param columna valor entero positivo de columna
	 */
	public EliminarCelula(int fila, int columna){
		this.fila = fila;
		this.columna = columna;
	}
	
	@Override
	public Comando parsea(String[] palabras) {
		Comando comando;
		if(palabras[0].equalsIgnoreCase("eliminarcelula") && (palabras.length == 3)){
			int f = Integer.parseInt(palabras[1]);
			int c = Integer.parseInt(palabras[2]);
			comando = new EliminarCelula(f, c);
		}
		else comando = null;			
		return comando;		
	}

	@Override
	public String textoAyuda() {
		return ("ELIMINARCELULA (F, C): Elimina la celula de la posicion (f, c)" + System.getProperty("line.separator"));
	}
	
	@Override
	public String ejecuta(Mundo mundo, Scanner in){
		if(mundo.eliminarCelulaSuperficie(this.fila, this.columna)){
			return "Se ha eliminado la celula de la posicion(" + this.fila + "," + this.columna + ")" + System.getProperty("line.separator");
		}
		else return "No existe la celula en esa posicion" + System.getProperty("line.separator");
	}
}
