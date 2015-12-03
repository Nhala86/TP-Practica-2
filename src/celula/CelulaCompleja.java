package celula;

import logica.Casilla;
import logica.Superficie;

public class CelulaCompleja extends Celula {
	private static final int MAX_COMER = 3;
	private int explota;
	public CelulaCompleja(){
		super();
		explota = MAX_COMER;
	}
	public CelulaCompleja(int SinMover, int Reproduccion){
		super(SinMover,Reproduccion);
		explota = MAX_COMER;
	}
	
	@Override
	public Casilla ejecutaMovimiento(int f, int c, Superficie superficie){
		int i = (int) Math.random() * (superficie.getFilas() - 1);
		int j = (int) Math.random() * (superficie.getColumnas() - 1);
		Casilla casilla = new Casilla(i,j);
		//Si la casilla esta vacia o la celula que hay es comestible, movemos la celula
		if (superficie.casillaVacia(i, j)){
			superficie.moverCelula(i, j, f, c);
			System.out.println("Movimiento de celula compleja de (" + f + "," + c + ") a (" + i + "," + j + ")");
			System.out.println("  NO COME");
		}
		else if (superficie.esComestible(i,j)){
			this.explota--;
			//Si explota, se eliminan las 2 celulas, la comestible y la compleja que movemos
			if (explota == 0){
				superficie.vaciarCasilla(f, c);
				superficie.vaciarCasilla(i, j);
				System.out.println("Explota la celula compleja de la casilla (" + f + "," + c + ")");
			}
			else{
				superficie.moverCelula(i, j, f, c);
				System.out.println("Movimiento de celula compleja de (" + f + "," + c + ") a (" + i + "," + j + ")");
			}
			System.out.println("  COME");
		}
		return casilla;
	}

	@Override
	public boolean esComestible() {
		return false;
	}
	
	@Override
	public void evoluciona(int f, int c) {
		
		
		
		
	}

}
