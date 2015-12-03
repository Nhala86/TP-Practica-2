package comandos;

import java.io.IOException;

import logica.Mundo;

public class Guardar implements Comando {

	@Override
	public String textoAyuda() {
		return ("GUARDAR: guarda en un fichero de texto una partida") + 
				System.getProperty("line.separator");
	}

	@Override
	public void ejecuta(Mundo mundo){
		try {
			mundo.guardar();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Comando parsea(String[] palabras) {
		Comando comando;
		if(palabras[0].equalsIgnoreCase("guardar")&& (palabras.length == 1))
			comando = new Cargar();
		else comando = null;	
		return comando;	
	}

}
