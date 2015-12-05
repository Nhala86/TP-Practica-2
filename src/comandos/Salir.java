package comandos;
import java.util.Scanner;

import logica.Mundo;

public class Salir implements Comando {

	/**
	 * 
	 */
	@Override
	public Comando parsea(String[] palabras) {
		Comando comando;
		if(palabras[0].equalsIgnoreCase("salir") && (palabras.length == 1))
			return comando = new Salir();
		else comando = null;
		return comando;
	}

	/**
	 * 
	 */
	@Override
	public String textoAyuda() {
		return ("SALIR: Es una instruccion que nos saca de la simulación" + System.getProperty("line.separator"));
	}
 /**
  * 
  */
	@Override

	public void ejecuta(Mundo mundo, Scanner in){
		mundo.terminaSimulacion();

	}

}
