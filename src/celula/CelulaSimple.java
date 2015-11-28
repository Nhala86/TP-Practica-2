package celula;

import logica.Casilla;
import logica.Superficie;

public class CelulaSimple extends Celula {

	public CelulaSimple(){
		this.esComestible = true;
	}
	public CelulaSimple(int SinMover, int Reproduccion){
		super(SinMover,Reproduccion);
		this.esComestible = true;
	}
	
	@Override
	public Casilla ejecutaMovimiento(int f, int c, Superficie superficie){
		int cont = 0;
		int [] fila = {-1, 0, 1};
		Casilla[] casilla = new Casilla[8];
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				int nf = f + fila[i];
				int nc = c + fila[j];
				if (nf < 0 || nf >= superficie.getFilas()){
					nf = f;
				}
				if (nc < 0 || nc >= superficie.getColumnas()){
					nc = c;
				}
				if(superficie.casillaVacia(nf,nc)){
					casilla[cont] = new Casilla(nf, nc);
					cont++;
				}	
		 	}
		}
		//Indica que no hay casillas vacias
		if (cont == 0){
			return null;
		}
		return casilla[(int) (Math.random() * cont)]; 
	}
		

	@Override
	public boolean esComestible() {
		return true;
	}
	
	@Override
	public void evoluciona(int f, int c){
		
		
	}

}
