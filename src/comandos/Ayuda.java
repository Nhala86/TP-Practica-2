package comandos;
import logica.Mundo;

public class Ayuda implements Comando {
	
	public void ejecuta (Mundo mundo){
		System.out.println(ParserComandos.AyudaComandos());
	}

	@Override
	public Comando parsea(String[] palabras) {
		Comando comando;
		if(palabras[0].equals("ayuda")&& (palabras.length == 1))
			comando = new Ayuda();
		else comando = null;	
		return comando;
	}

	@Override
	public String textoAyuda() {
		return ("Ayuda: estás leyendo " + "\n");
	}

}
