package comandos;

import java.io.IOException;
import java.util.Scanner;

import logica.Mundo;

public class Cargar implements Comando {

	@Override
	public String textoAyuda() {
		return ("CARGAR: cargar de un fichero de texto una partida guardada" + System.getProperty("line.separator"));
	}

	@Override
	public String ejecuta(Mundo mundo, Scanner in) throws IOException {
		return "Introduce el nombre del fichero (sin extension) para el juego: " + mundo.cargar(in);
	}

	@Override
	public Comando parsea(String[] palabras) {
		Comando comando;
		if(palabras[0].equalsIgnoreCase("cargar") && (palabras.length == 1))
			comando = new Cargar();
		else comando = null;	
		return comando;		
	}

}
