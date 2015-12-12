package logica;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.StringBuffer;
import java.util.Scanner;

import celula.Celula;
import celula.CelulaCompleja;
import celula.CelulaSimple;

public class Mundo{
	
	private static final int NUMEROCELULASSIMPLES = 50;
	private static final int NUMEROCELULASCOMPLEJAS = 15;
	private static final int NUMEROFILAS = 10;
	private static final int NUMEROCOLUMNAS = 10;
	private boolean simulacionTerminada = false;
	private Superficie superficie;

		
	/**
	 * La clase constructor de Mundo, genera una superficie con una longitud
	 * especifica de filas y columnas, y genera NUMEROCELULAS en posiciones
	 * aleatorias para esa superficie.
	 */	
	public Mundo(){
		this.superficie = new Superficie(NUMEROFILAS, NUMEROCOLUMNAS);
		this.generarCelulas();
	}
	
	/**
	 * Mundo vacio de dimensiones pasadas por parametro usado para cargar de fichero
	 * @param f Numero de filas que tiene la matriz
	 * @param c Numero de columnas que tiene la matriz
	 */	
	public Mundo(int f, int c) {
		this.superficie = new Superficie(f, c);
		vaciar();
	}

	/**
	 * Metodo que aleatoriamente coloca las celulas en las casillas
	 */	
	public void generarCelulas(){
		int contCelulas = 0;
		while (contCelulas < NUMEROCELULASSIMPLES){
			int f = (int) (Math.random()* getFilas());
			int c = (int) (Math.random()* getColumnas());
			if (this.superficie.casillaVacia(f, c)) {
				this.superficie.llenarCasilla(f, c, new CelulaSimple());
				contCelulas++;
			}
		}
		contCelulas = 0;
		while (contCelulas < NUMEROCELULASCOMPLEJAS){
			int f = (int) (Math.random()* getFilas());
			int c = (int) (Math.random()* getColumnas());
			if (this.superficie.casillaVacia(f, c)) {
				this.superficie.llenarCasilla(f, c, new CelulaCompleja());
				contCelulas++;
			}
		}
	}
	
	/**
	 * Metodo String que llama a la clase Superficie para generar la matriz del juego
	 * @return la matriz de la superficie
	 */
	public StringBuffer toStringBuffer(){
		return superficie.toStringBuffer();
	}
	
	/**
	 * Metodo que evoluciona segun las reglas de la vida.
	 * Si la celula se puede mover a otra casilla aleatoria colindante a ella, entonces deja una nueva celula
	 * Si no puede moverse, tiene un maximo de paso para poder hacerlo, si no muere
	 * @return el paso de las celulas
	 */
	public String evoluciona(){
		String mensaje = null;
		boolean movido[][] = matriz();
		for(int i = 0; i < this.getFilas(); i++){
    		for(int j = 0; j < this.getColumnas(); j++){
    			if (!superficie.casillaVacia(i, j) && !movido[i][j]){
    				CasillaMensaje casillaMensaje = this.superficie.ejecutaMovimiento(i, j);
    				//Si no se puede mover la celula, no se toca la matriz
    				if (casillaMensaje.infoNovacia()){
    					movido[casillaMensaje.getFila()][casillaMensaje.getColumna()] = true;
    				}
    				mensaje += casillaMensaje.getMensaje() + System.getProperty("line.separator");
    			}
    		}
		}
		return mensaje;
	}
	
	/**
	 * Crea e inicializa una matriz de booleanos con el tamaño de la matriz de celulas, para saber que posicion se ha movido durante el juego
	 * @return La matriz booleana de dimension del tablero, con todas las posiciones inicializadas a falso
	 */	
	private boolean[][] matriz(){
		boolean [][] movido = new boolean [this.getFilas()][this.getColumnas()];
		for(int i = 0; i < this.getFilas(); i++){
    		for(int j = 0; j < this.getColumnas(); j++){
    			movido[i][j] = false;
		    }
		}
		return movido;
	}

	/**
	 * Metodo que reinicia la matriz del tablero dejando las casillas vacias
	 */	
	public void vaciar(){
		superficie.reset();
	}
	
	/**
	 * Crea una celula en la posicion (f,c) de la superficie
	 * @param f Valor entero positivo fila de la matriz
	 * @param c Valor entero positivo columna de la matriz
	 * @param celula pasa las celulas ya inicializadas
	 * @return TRUE se ha hecho el proceso de crear la celula
	 */	
	public boolean crearCelulaSuperficie(int f, int c, Celula celula){ 
		return superficie.llenarCasilla(f, c, celula);  
	}	
	
	/**
	 * Elimina la celula en la posicion (f,c) de la superficie
	 * @param f Valor entero positivo fila de la matriz
	 * @param c Valor entero positivo columna de la matriz
	 * @return TRUE si se ha hecho el proceso de eliminar la celula. False para los demás casos
	 */
	public boolean eliminarCelulaSuperficie(int f, int c){
		return superficie.vaciarCasilla(f,c);
	}
	
	/**
	 * Metodo que devuelve el valor entero positivo de las filas de la superficie
	 * @return valor entero positivo de las filas de la Superficie en el Mundo
	 */
	public int getFilas(){
		return this.superficie.getFilas();
	}
	
	/**
	 * Metodo que devuelve el valor entero positivo de las columnas de la superficie
	 * @return valor entero positivo de las columnas de la Superficie en el Mundo
	 */
	public int getColumnas(){
		return this.superficie.getColumnas();
	}	

	/**
	 * Metodo booleano que llama a simulacionTerminada de la Superficie
	 * @return true si está finalizada o false si no lo está
	 */
	public boolean getSimulacionTerminada(){
		return simulacionTerminada;
	}
	
	/**
	 * Se encarga de guardar las dimensiones del tablero y luego todo el tablero con el estado actual del juego en juego.txt
	 * @param in los controles inicializados
	 * @return un fichero de texto con el Mundo guardado
	 * @throws IOException  para evitar los errores del guardado y el cargado
	 */
	public String guardar(Scanner in) throws IOException{
		String nombre = in.nextLine();
		File archivo = new File(nombre + ".txt");
		FileWriter escribir = new FileWriter(archivo);
		String dim = this.getFilas() + " " + this.getColumnas() + System.getProperty("line.separator");
		escribir.append(dim);
		escribir.append(this.toStringBuffer());
		escribir.close();
		return "Partida guardada correctamente" + System.getProperty("line.separator");
	}	
	
	/**
	 * Metodo que valida que los valores de fila y columna que pasa el usuario son validos
	 * @param f valores enteros positivos de fila
	 * @param c valores enteros positivos de columna
	 * @return TRUE si los valores de fila y columna es valido
	 * FALSE si los valores de fila y columna no son correctos, no estan dentro de los parametros definidos
	 */
	public boolean validarDatos(int f, int c){
		boolean valido = false;
		if(f >= 0 && f < getFilas()){
			if(c >= 0 && c < getColumnas()){
				valido = true;
			}
		}
		return valido;
	}
	
	/**
	 * Metodo que iguala a true la simulacionTerminada
	 */
	public void terminaSimulacion() {
		this.simulacionTerminada = true;
	}

	/**
	 * Metodo que llama a cargar un string de un fichero de Superficie
	 * @param in le pasa los controles inicializados
	 * @return un string de Mundo
	 * @throws IOException para evitar los errores del guardado y cargado
	 */
	public String cargar(Scanner in) throws IOException {
		return superficie.cargar(in);
	}	
	
}

