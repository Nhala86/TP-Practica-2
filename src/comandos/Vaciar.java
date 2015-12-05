package comandos;
import java.util.Scanner;

import logica.Mundo;

public class Vaciar implements Comando {

	@Override
	public Comando parsea(String[] palabras) {
		Comando comando;
		if((palabras.length == 1)&& (palabras[0].equalsIgnoreCase("vaciar")))
			comando = new Vaciar();
		else comando = null;
		return comando;
	}

	@Override
	public String textoAyuda() {		
		return ("VACIAR: Elimina las celulas del mundo" + System.getProperty("line.separator"));
	}
	
	public void ejecuta(Mundo mundo, Scanner in){
		mundo.vaciar();
		System.out.println("Vaciando el tablero de celulas");
	}

}
