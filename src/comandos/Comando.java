package comandos;
import logica.Mundo;

public interface Comando {
	
	public abstract void ejecuta(Mundo mundo);
	public abstract Comando parsea(String[] palabras);
	public abstract String textoAyuda();
}
