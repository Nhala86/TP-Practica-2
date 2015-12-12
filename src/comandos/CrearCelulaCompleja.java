package comandos;

import java.util.Scanner;

import celula.CelulaCompleja;
import logica.Mundo;

public class CrearCelulaCompleja  implements Comando{
	private int fila;
	private int columna;
	
	/**
	 * Metodo constructor de argumentos
	 * @param fila valor entero positivo de fila
	 * @param columna valor entero positivo de columna
	 */
	public CrearCelulaCompleja(int fila, int columna){
		this.fila = fila;
		this.columna = columna;
	}
	
	@Override
	public String ejecuta(Mundo mundo, Scanner in){
		String mensaje;
		if(mundo.validarDatos(this.fila, this.columna)){
			if (mundo.crearCelulaSuperficie(this.fila, this.columna, new CelulaCompleja())){
				mensaje = "Creamos la celula compleja en: (" + this.fila + "," + 
						this.columna +  ")";
			}
			else {
				mensaje = "Error, la posicion indicada esta ocupada" + System.getProperty("line.separator");
			}
		}
		else {
			mensaje = "Los parametros pasados son incorrectos, la celula no existe. Vuelva a introducirlos"
					+ System.getProperty("line.separator");
		}
		return mensaje;
	}

	@Override
	public Comando parsea(String[] palabras) {
		Comando comando;
		if(palabras[0].equalsIgnoreCase("crearcelulacompleja") && (palabras.length == 3)){
			int f = Integer.parseInt(palabras[1]);
			int c = Integer.parseInt(palabras[2]);
			comando = new CrearCelulaCompleja(f, c);
		}
		else comando = null;			
		return comando;		
	}

	@Override
	public String textoAyuda() {
		return ("CREARCELULACOMPLEJA F C: crea una nueva celula compleja en la posicion (f,c) si es posible" + System.getProperty("line.separator"));
	}


}
