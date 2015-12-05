package celula;

import logica.Casilla;
import logica.Superficie;

abstract public class Celula {
	
	public abstract Casilla ejecutaMovimiento(int f, int c, Superficie superficie);
	public abstract boolean esComestible();
	public abstract Object toStringBuffer();
}
