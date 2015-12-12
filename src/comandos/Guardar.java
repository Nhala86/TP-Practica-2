package comandos;

import java.io.IOException;
import java.util.Scanner;

import logica.Mundo;

public class Guardar implements Comando {

	@Override
	public String textoAyuda() {
		return ("GUARDAR: guarda en un fichero de texto una partida" + System.getProperty("line.separator"));
	}

	@Override
	public String ejecuta(Mundo mundo, Scanner in) throws IOException{
		return "Introduce el nombre del fichero (sin extension) donde guardar el juego: "
				+ mundo.guardar(in);
	}

	@Override
	public Comando parsea(String[] palabras) {
		Comando comando;
		if(palabras[0].equalsIgnoreCase("guardar")&& (palabras.length == 1))
			comando = new Guardar();
		else comando = null;	
		return comando;	
	}

}
