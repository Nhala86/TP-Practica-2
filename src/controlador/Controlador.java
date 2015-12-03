package controlador;

import java.util.Scanner;

import logica.Mundo;

import java.io.*;

import comandos.Comando;
import comandos.ParserComandos;


//OPCIONAL: HACER MENSAJES SOLO EN EL CONTROLADOR, TODO AQUI

public class Controlador {
	private Mundo mundo;
	private Scanner in;
	
	/**
	 * Metodo que inicializa el mundo y el scanner
	 */
	public Controlador(){
		this.mundo = new Mundo();
		this.in = new Scanner(System.in);
	}
	
	/**
	 * Metodo constructor del Controlador que define los parametros mundo e in
	 * @param mundo le pasa el nuevo mundo inicializado
	 * @param in le pasa los controles ya inicializados
	 */
    public Controlador(Mundo mundo, Scanner in){
        this.mundo = mundo;
        this.in = in;
    }
    
    /**
     * Metodo encargado de los controles que el usuario introduce para el funcionamiento del juego
     * y encargado de llamar a las funciones en otras clases para mostrar por pantalla el juego y sus movimientos
     * @throws IOException 
     */
	public void realizaSimulacion(){
		System.out.println("Bienvenido al juego de la vida: ");
        //System.out.println(mundo.toStringBuffer());
		while (!mundo.esSimulacionTerminada()){
			System.out.println(mundo.toStringBuffer());
			System.out.print("Comando > ");
			String string = in.nextLine();
			String[] palabras = string.split(" ");
			Comando comando = ParserComandos.parseaComando(palabras);
			if (comando != null){
				comando.ejecuta(this.mundo);
			}
		}		
	}


}
		
		
		
		
		
		
		
		