package comandos;
import logica.Mundo;

public class Iniciar implements Comando {
	
	public void ejecuta(Mundo mundo){
		mundo.generarCelulas();
	}

	@Override
	public Comando parsea(String[] palabras) {
		if((palabras.length == 1) && (palabras[0].equals("iniciar"))){
			return new Iniciar();
		}
		else return null;
	}

	@Override
	public String textoAyuda() {
		return "INICIAR:Inicia las celulas aleatoriamente"; 
	}

}
