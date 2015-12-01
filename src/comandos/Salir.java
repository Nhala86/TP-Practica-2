package comandos;
import logica.Mundo;

public class Salir extends Comando {

	/**
	 * 
	 */
	@Override
	public Comando parsea(String[] palabras) {
		Comando comando;
		if(palabras[0].equals("salir") && (palabras.length == 1))
			return comando = new Salir();
		else comando = null;
		return comando;
	}

	/**
	 * 
	 */
	@Override
	public String textoAyuda() {
		return ("SALIR: Es una instruccion que nos saca de la simulación" + '\n');
	}
 /**
  * 
  */
	@Override
	public void ejecuta(Mundo mundo) {
		mundo.esSimulacionTerminada(false);		
	}

}
