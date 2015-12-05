package comandos;
import java.io.IOException;
import java.util.Scanner;

import logica.Mundo;

public class Ayuda implements Comando {
	
	@Override
	public Comando parsea(String[] palabras) {
		Comando comando;
		if(palabras[0].equalsIgnoreCase("ayuda") && (palabras.length == 1))
			comando = new Ayuda();
		else comando = null;	
		return comando;
	}

	@Override
	public String textoAyuda() {
		return ("Ayuda: POSIBLES COMANDOS: " + System.getProperty("line.separator"));
	}

	@Override
	public void ejecuta(Mundo mundo, Scanner in) throws IOException {
		System.out.println(ParserComandos.AyudaComandos());
		
	}

}
