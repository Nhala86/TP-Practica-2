package comandos;
import logica.Mundo;

public class Vaciar extends Comando {

	@Override
	public Comando parsea(String[] palabras) {
		Comando comando;
		if((palabras.length == 1)&& (palabras[0].equals("vaciar")))
			comando = new Vaciar();
		else comando = null;
		return comando;
	}

	@Override
	public String textoAyuda() {		
		return ("VACIAR: Elimina las celulas del mundo" + '\n');
	}
	
	public void ejecuta(Mundo mundo){
		mundo.vaciar();
	}

}
