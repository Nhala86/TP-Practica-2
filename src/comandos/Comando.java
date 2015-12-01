package comandos;
import logica.Mundo;

public abstract class Comando {
	
	public abstract void ejecuta(Mundo mundo);
	public abstract Comando parsea(String[] palabras);
	public abstract String textoAyuda();
}
