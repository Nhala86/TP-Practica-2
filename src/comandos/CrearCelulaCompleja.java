package comandos;

import celula.CelulaCompleja;
import logica.Mundo;

public class CrearCelulaCompleja  implements Comando{
	private int fila;
	private int columna;
	
	public CrearCelulaCompleja(int fila, int columna){
		this.fila = fila;
		this.columna = columna;
	}
	
	@Override
	public void ejecuta(Mundo mundo) {
		if(mundo.validarDatos(this.fila, this.columna)){
			if (mundo.crearCelulaSuperficie(this.fila, this.columna, new CelulaCompleja())){
				System.out.print("Creamos la celula en: (");
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
