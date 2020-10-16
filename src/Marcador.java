
public class Marcador {
	private boolean sacaJug1;
	private Puntuacion jugador1;
	private Puntuacion jugador2;
	
	public Marcador() {
		this.sacaJug1 = true;
		this.jugador1 = new Puntuacion();
		this.jugador2 = new Puntuacion();
	}

	public boolean getSacaJug1() {
		return sacaJug1;
	}

	public void setSacaJug1(boolean sacaJug1) {
		this.sacaJug1 = sacaJug1;
	}
	
	public int getPuntosJug1() {
		return this.jugador1.getPuntos();
	}
	public int getPuntosJug2() {
		return this.jugador2.getPuntos();
	}
	
	public void incrementarPuntosJug1() {
		
		this.jugador1.incrementarPuntos();
	}
	
	public void incrementarPuntosJug2() {
		this.jugador2.incrementarPuntos();	
	}
	
	public boolean comprobarIguales() {
		boolean iguales;
		if((this.getPuntosJug1() == this.getPuntosJug2()) && (this.getPuntosJug1() == 40)) {
			iguales = true;
		} else {
			iguales = false;
		}
		return iguales;
	}
	
	public void reiniciarPuntuacion() {
		this.jugador1.reiniciarPuntos();
		
	}
}
