package comandos;
import java.io.IOException;
import java.util.Scanner;

import logica.Mundo;

public interface Comando {
	//Añado el Scanner en la cabecera para poder permitir al usuario ponerle nombre al
	//fichero que quiera cargar o guardar
	public abstract void ejecuta(Mundo mundo, Scanner in) throws IOException;
	public abstract Comando parsea(String[] palabras);
	public abstract String textoAyuda();
	
}
