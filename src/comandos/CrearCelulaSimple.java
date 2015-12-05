package comandos;

import java.util.Scanner;

import logica.Mundo;
import celula.CelulaSimple;

public class CrearCelulaSimple implements Comando {
	private int fila;
	private int columna;
	
	public CrearCelulaSimple(int fila, int columna){
		this.fila = fila;
		this.columna = columna;
	}
	
	@Override
	public void ejecuta(Mundo mundo, Scanner in){
		if(mundo.validarDatos(this.fila, this.columna)){
			if (mundo.crearCelulaSuperficie(this.fila, this.columna, new CelulaSimple())){
				System.out.print("Creamos la celula simple en: (");
				System.out.print(this.fila);  System.out.print(",");
				System.out.print(this.columna);  System.out.println(")");
			}
			else {
				System.out.println("Error, la posicion indicada esta ocupada");
			}
		}
		else {
			System.out.println("Los parametros pasados son incorrectos, la celula no existe. Vuelva a introducirlos");
		}
	}
	@Override
	public Comando parsea(String[] palabras) {
		Comando comando;
		if(palabras[0].equalsIgnoreCase("crearcelulasimple") && (palabras.length == 3)){
			int f = Integer.parseInt(palabras[1]);
			int c = Integer.parseInt(palabras[2]);
			comando = new CrearCelulaSimple(f, c);
		}
		else comando = null;			
		return comando;		
	}

	@Override
	public String textoAyuda() {
		return ("CREARCELULASIMPLE F C: crea una nueva celula simple en la posicion (f,c) si es posible" + System.getProperty("line.separator"));
	}
	
}
