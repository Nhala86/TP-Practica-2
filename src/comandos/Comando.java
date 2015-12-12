package comandos;
import java.io.IOException;
import java.util.Scanner;

import logica.Mundo;

public interface Comando {
	
	/**
	 * Metodo que permite al usuario ejecutar el mundo y a la vez decidir cual fichero quiero o no cargar o guardar
	 * @param mundo le pasa el Mundo para poder empezar la partida
	 * @param in el Scanner para cargar o guardar un fichero
	 * @return un string del mundo con sus celulas y casillas vacias
	 * @throws IOException para evitar problemas en el cargado y guardado del fichero
	 */
	public abstract String ejecuta(Mundo mundo, Scanner in) throws IOException;//Añado el Scanner en la cabecera para poder permitir al usuario ponerle nombre al fichero que quiera cargar o guardar
	
	/**
	 * Metodo que compara lo que el usuario a metido por consola con los comandos, evita que el usuario meta comandos incorrectos
	 * @param palabras array de longitud de palabras
	 * @return el comando elejido por el usuario
	 */
	public abstract Comando parsea(String[] palabras);
	
	/**
	 * Metodo que devuelve los textos del comando AYUDA
	 * @return un string por pantalla para ayudar al usuario a poner correctamente el nombre de los comandos 
	 */
	public abstract String textoAyuda();
	
}
