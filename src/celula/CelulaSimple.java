package celula;

import logica.Casilla;
import logica.Superficie;

public class CelulaSimple extends Celula {

	public CelulaSimple(){
		super();
	}
	public CelulaSimple(int SinMover, int Reproduccion){
		super(SinMover,Reproduccion);
		
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
		//Si se mueve la celula, entonces decrementamos sus contadores
		else {
			this.pasosSinMover--;
			
			if (this.pasosReproduccion < 0){
			
			this.pasosReproduccion = PASOS_REPRODUCCION;
			this.crearCelulaSuperficie(i,j);
			System.out.println("Nace nueva celula en (" + i + "," + j + ")" + " cuyo padre ha sido (" + f + "," + c + ")");
		}
			
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
