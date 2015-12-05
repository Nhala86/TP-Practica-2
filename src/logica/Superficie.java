package logica;


import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import celula.Celula;
import celula.CelulaCompleja;
import celula.CelulaSimple;



public class Superficie{
	private Celula[][] superficie;
	private int filas;
	private int columnas;
		
	/**
	 * Constructor de la clase superficie
	 * @param nf valor entero positivo que indica el numero de filas de la superficie
	 * @param nc valor entero positivo que indica el numero de columnas de la superficie
	 */
	public Superficie(int nf, int nc){
		this.filas = nf;
		this.columnas = nc;
		this.superficie = new Celula[this.filas][this.columnas];
        this.reset();         
    }
	
    /**
     * Recorre casilla a casilla la matriz de celulas y las junta en una cadena para mostrar por consola
     * @return La matriz como un string
     */
	public StringBuffer toStringBuffer() {
		StringBuffer matriz = new StringBuffer("");
		for(int i = 0; i < this.filas; i++){
    		for(int j = 0; j < this.columnas; j++){
    			matriz.append(" "); 
    			if(!casillaVacia(i, j)){    				
    				matriz.append(superficie[i][j].toStringBuffer());    				
    			}
    			else
    				matriz.append(" - ");
		    }
    		matriz.append(System.getProperty("line.separator"));
		}
		return matriz;
	}
		
	
	/**
	 * Busco las posiciones vacias que hay alrededor de la celula, las guarda en un array de tipo casilla y elijo aleatoriamente
	 * una de las posiciones de todas las disponibles para devolver
	 * @param f Entero que representa la fila de la celula
	 * @param c Entero que representa la columna de la celula
	 * @return posicion en el que se encuentra la casilla seleccionada aleatoriamente
	 */
	public Casilla ejecutaMovimiento(int f, int c){
		return superficie[f][c].ejecutaMovimiento(f,c, this);
		
	}
	
	/**
	 * Procedimiento que pone a NULL todas las casillas de la superficie
	 */
    public void reset(){
    	for(int i = 0; i < this.filas; i++){
    		for(int j = 0; j < this.columnas; j++){
    			this.superficie[i][j] = null;
		    }
		}		 
	}  
    
	/**
	 * Mira si la casilla pasada por parametro esta vacia
	 * @param f valor entero positivo que indica el numero de filas
	 * @param c valor entero positivo que indica el numero de columnas
	 * @return TRUE si la casilla esta vacia. FALSE para el caso contrario
	 */
	public boolean casillaVacia(int f, int c){
		return this.superficie[f][c] == null;
	}

	/**
	 * Vacia la casilla pasada por parametro si no esta vacia ya y existe
	 * @param f valor entero positivo acotado en un rango valido del numero de filas
	 * @param c valor entero positivo acotado en un rango valido del numero de columnas
	 * @return TRUE si vacio la casilla. FALSE para el caso contrario
	 */
	public boolean vaciarCasilla(int f, int c){
		boolean ok = false;
		if(!casillaVacia(f, c)){
			this.superficie[f][c] = null;
			ok = true;
		}
		return ok;
	}

	/**
	* Metodo que genera una celula nueva si la casilla esta vacia
	* @param f valor entero positivo acotado en un rango valido del numero de filas
	* @param c valor entero positivo acotado en un rango valido del numero de columnas
	* @return TRUE si lleno la casilla. FALSE para el caso contrario
	*/
	public boolean llenarCasilla(int f, int c, Celula celula){
		boolean ok = false;
		if(casillaVacia(f, c)){
			this.superficie[f][c] = celula;
			ok = true;
		}
		return ok;
	}	
	
	/**
	 * Metodo que devuelve el valor entero positivo de las filas de la Superficie
	 * @return valor entero positivo de las filas 
	 */
	public int getFilas(){
		return this.filas;
	}
	
	/**
	 * Metodo que devuelve el valor entero positivo de las columnas de la Superficie
	 * @return valor entero positivo de las columnas 
	 */
	public int getColumnas(){
		return this.columnas;
	}
	
	
	/**
	 * Metodo que llama a la clase Superficie e iguala la posicion actual
	 * a la nueva en la que se encuentra la celula. Y la antigua la vacia
	 * @param f entero positivo que hace referencia a la fila nueva 
	 * @param c entero positivo que hace referencia a la columna nueva
	 * @param i entero positivo que hace referencia a la fila antigua
	 * @param j entero positivo que hace referencia a la columna antigua
	 */
	public void moverCelula(int f, int c, int i, int j){
		this.superficie[f][c] = this.superficie[i][j];
		this.superficie[i][j] = null;
		
	}
	/**
	 * 
	 * @param i entero positivo que hace referencia a la fila nueva 
	 * @param j entero positivo que hace referencia a la columna nueva
	 * @return Si es comestible la celula
	 */
	public boolean esComestible(int i, int j) {
		return superficie[i][j].esComestible();
	}
	
	/**
	 * Abre el fichero juego.txt, carga las dimensiones del tablero del fichero y las celulas que habia en un nuevo mundo
	 * @return 
	 * @return El nuevo mundo que hemos cargado del fichero
	 * @throws IOException
	 */
	public void cargar(Scanner in) throws IOException{
		//Scanner scanner = new Scanner(System.in);
		System.out.print("Introduce el nombre del fichero (sin extension) para el juego: ");
		//String nombre = scanner.nextLine();
		//scanner.close();
		String nombre = in.nextLine();
		File archivo = new File(nombre + ".txt");
		if (archivo.canRead()){
			Scanner entrada = new Scanner(archivo);
			int fila = entrada.nextInt(), columna = entrada.nextInt();
			//Mundo mundo = new Mundo(fila, columna);
			if (this.filas == fila && this.columnas == columna){
				for (int i=0; i < fila; i++){
					for (int j=0; j < columna; j++){
						String cadena = entrada.next();
						if (!cadena.equals("-")){
							//Crear nueva celula
							String [] posicion = cadena.split("-");
							if (posicion.length == 1){
								int explota = Integer.parseInt(cadena);
								this.superficie[i][j] = new CelulaCompleja(explota);
							}
							else{
								int SinMover = Integer.parseInt(posicion[0]);
								int Reproduccion = Integer.parseInt(posicion[1]);
								this.superficie[i][j] = new CelulaSimple (SinMover, Reproduccion);
							}
						}
						else {
							vaciarCasilla(i, j);
						}
					}
				}
			}
			else {
				System.out.println("La dimension del tablero del juego a cargar no es correcta, ajuste la dimension y vuelva a intentarlo");
			}
			entrada.close();
			System.out.println("Partida cargada correctamente");
		}
		else {
			System.out.println("El nombre del fichero especificado no existe");
		}
	}
}
	

	


