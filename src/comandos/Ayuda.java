package comandos;
import logica.Mundo;
public class Ayuda extends Comando {
	
	public void ejecuta (Mundo mundo){
		System.out.println(ParserComandos.AyudaComandos());
	}

	@Override
	public Comando parsea(String cadenaComando) {
		
		return null;
	}

	@Override
	public String textoAyuda() {
		return ("Ayuda: estás leyendo " + "\n");
	}

}
