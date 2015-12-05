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
	 * Metodo que valida que los valores de fila y columna que pasa el usuario son validos
	 * @param f valores enteros positivos de fila
	 * @param c valores enteros positivos de columna
	 * @return TRUE si los valores de fila y columna es valido
	 * FALSE si los valores de fila y columna no son correctos, no estan dentro de los parametros definidos
	 */
	private boolean validarDatos(int f, int c){
		boolean valido = false;
		if(f >= 0 && f < this.mundo.getFilas()){
			if(c >= 0 && c < this.mundo.getColumnas()){
				valido = true;
			}
		}
		return valido;
	}
    
    private String[] crearComando(Scanner in){
    	String[] palabras = null;
    	System.out.println(mundo.toStringBuffer());
		System.out.print("Comando > ");
		String string = in.nextLine();
		String stringlower = string.toLowerCase();
		palabras = stringlower.split(" ");
		if(palabras.length == 3){ // Protege de que el usuario meta chorradas junto con el comando o meta una fila y columna incorrecta
			if(!this.validarDatos(Integer.parseInt(palabras[1]),Integer.parseInt(palabras[2]))){
				System.out.println("Valores de fila y columna no validos");
				this.crearComando(in);
			}
		}
		return  palabras;
    	
    }
    
    /**
     * Metodo encargado de los controles que el usuario introduce para el funcionamiento del juego
     * y encargado de llamar a las funciones en otras clases para mostrar por pantalla el juego y sus movimientos
     * @throws IOException 
     */
	public void realizaSimulacion() throws IOException{
		System.out.println("Bienvenido al juego de la vida: ");      
		while (!mundo.esSimulacionTerminada()){
			String [] palabras = crearComando(this.in);			
			Comando comando = ParserComandos.parseaComando(palabras);
			if (comando != null){
				comando.ejecuta(this.mundo, this.in);
			}
			else {
				System.out.println("El comando introducido no es valido, introduzca otro");
			}
		}		
	}


}
		
		
		
		
		
		
		
		