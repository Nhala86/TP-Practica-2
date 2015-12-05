package celula;

import logica.Casilla;
import logica.Superficie;

public class CelulaCompleja extends Celula {
	private static final int MAX_COMER = 3;
	private int explota;
	
	public CelulaCompleja(){
		explota = MAX_COMER;
	}
	public CelulaCompleja(int explota){
		this.explota = explota;
	}
	
	@Override
	public Casilla ejecutaMovimiento(int f, int c, Superficie superficie){
		int i = (int) (Math.random() * (superficie.getFilas() - 1));
		int j = (int) (Math.random() * (superficie.getColumnas() - 1));
		//Evito que las celulas complejas se muevan a su misma casilla, es decir, que no se muevan
		while (i == f && j == c){
			i = (int) (Math.random() * (superficie.getFilas() - 1));
			j = (int) (Math.random() * (superficie.getColumnas() - 1));
		}
		Casilla casilla = new Casilla(i,j);
		//Si la casilla esta vacia o la celula que hay es comestible, movemos la celula
		if (superficie.casillaVacia(i, j)){
			superficie.moverCelula(i, j, f, c);
			System.out.print("Movimiento de celula compleja de (" + f + "," + c + ") a (" + i + "," + j + ")");
			System.out.println("  NO COME");
		}
		else if (superficie.esComestible(i,j)){
			this.explota--;
			//Si explota, se eliminan las 2 celulas, la comestible y la compleja que movemos
			if (explota == 0){
				superficie.vaciarCasilla(f, c);
				superficie.vaciarCasilla(i, j);
				System.out.print("Explota la celula compleja de la casilla (" + f + "," + c + ") por comerse a (" + i + "," + j + ")");
			}
			else{
				superficie.moverCelula(i, j, f, c);
				System.out.print("Movimiento de celula compleja de (" + f + "," + c + ") a (" + i + "," + j + ")");
			}
			System.out.println("  COME");
		}
		else {
			System.out.println("La celula compleja no se mueve de (" + f + "," + c + ") a (" + i + "," + j + ")" + " porque esta ocupada por otra celula compleja");
			//Si la casilla esta ocupada por otra celula compleja, hay que dejar la casilla a null para que no la marque la matriz de booleanos como que se ha movido
			casilla = null;
		}
		return casilla;
	}
	
	/**
     * Coge los valores numericos de pasosSinMover y pasosReproduccion y los convierte en una cadena para mostrar
     * @return una cadena con los dos parametros numericos de la celula, separados por un guion
     */
	public Object toStringBuffer() {
		return (" " + this.explota + " ");
	}

	@Override
	public boolean esComestible() {
		return false;
	}

}
