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
		Casilla casillaMovimiento;
		if (this.pasosSinMover != 0){
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
			//Indica que no hay casillas vacias, por lo que no se puede mover
			if (cont == 0){
				casillaMovimiento = null;
				//Si no se puede mover y esta por reproducirse, la celula muere
				if (this.pasosReproduccion < 0){
					superficie.vaciarCasilla(f, c);
					System.out.println("Muere la celula de la casilla (" + f + "," + c + ") por no poder reproducirse");
				}
				else {
					this.pasosSinMover--;
				}
			}
			//Si se mueve la celula, entonces decrementamos sus contadores
			else {
				casillaMovimiento = casilla[(int) (Math.random() * cont)];
				int k = casillaMovimiento.getFila(), l = casillaMovimiento.getColumna();
				this.pasosReproduccion--;
				System.out.println("Movimiento de (" + f + "," + c + ") a (" + k + "," + l + ")");
				if (this.pasosReproduccion < 0){
					this.pasosReproduccion = PASOS_REPRODUCCION;
					superficie.moverCelula(k, l, f, c);
					superficie.llenarCasilla(f, c, new CelulaSimple());
					System.out.println("Nace nueva celula en (" + f + "," + c + ")" + " cuyo padre ha sido (" + k + "," + l + ")");
				}
			}
		}
		else {
			casillaMovimiento = null;
			superficie.vaciarCasilla(f, c);
			System.out.println("Muere la celula de la casilla (" + f + "," + c + ") por inactividad");
		}
		return casillaMovimiento;
	}
	
	/**
     * Coge los valores numericos de pasosSinMover y pasosReproduccion y los convierte en una cadena para mostrar
     * @return una cadena con los dos parametros numericos de la celula, separados por un guion
     */
	public Object toStringBuffer() {
		return this.pasosSinMover + "-" + this.pasosReproduccion;
	}
	
	@Override
	public boolean esComestible() {
		return true;
	}
	
	

}
