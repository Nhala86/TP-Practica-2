package comandos;

import logica.Mundo;

public class Paso implements Comando {

	@Override
	public Comando parsea(String[] palabras) {
		Comando comando;
		if(palabras[0].equals("paso") && (palabras.length == 1))
			comando = new Paso();
		else comando = null;
		return comando;
	}

	@Override
	public String textoAyuda() {
		return ("PASO: mueve las celulas de lugar en el mundo" + '\n');
	}
	
	public void ejecuta(Mundo mundo){
		mundo.evoluciona();
	}

}
