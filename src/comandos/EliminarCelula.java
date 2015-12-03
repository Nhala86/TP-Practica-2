package comandos;

import logica.Mundo;

public class EliminarCelula implements Comando {
	private int fila;
	private int columna;
	
	public EliminarCelula(int fila, int columna){
		this.fila = fila;
		this.columna = columna;
	}
	@Override
	public Comando parsea(String[] palabras) {
		Comando comando;
		if(palabras[0].equals("eliminarcelula") && (palabras.length == 3)){
			int f = Integer.parseInt(palabras[1]);
			int c = Integer.parseInt(palabras[2]);
			comando = new EliminarCelula(f, c);
		}
		else comando = null;			
		return comando;		
	}

	@Override
	public String textoAyuda() {
		return ("ELIMINARCELULA (F, C): Elimina la celula de la posicion (f, c)" + '\n');
	}
	
	public void ejecuta(Mundo mundo){
		if(mundo.eliminarCelulaSuperficie(this.fila, this.columna)){
			System.out.println("se ha eliminado la celula de la posicion(" + this.fila + "," + this.columna + ")");
		}
		else System.out.println("No existe la celula en esa posicion");
	}
}
