package comandos;

import java.io.IOException;

import logica.Mundo;

public class Cargar implements Comando {

	@Override
	public String textoAyuda() {
		return ("CARGAR: cargar de un fichero de texto una partida guardada" + '\n');
	}

	@Override
	public void ejecuta(Mundo mundo) {
		try {
			mundo = mundo.cargar();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Comando parsea(String[] palabras) {
		Comando comando;
		if(palabras[0].equals("cargar")&& (palabras.length == 1))
			comando = new Cargar();
		else comando = null;	
		return comando;		
	}

}
