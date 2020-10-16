
public class Marcador {
	private boolean sacaJug1;
	private int ventaja;
	private Puntuacion jugador1;
	private Puntuacion jugador2;
	
	public Marcador() {
		this.sacaJug1 = true;
		this.jugador1 = new Puntuacion();
		this.jugador2 = new Puntuacion();
		this.ventaja = 0;
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
		if(this.comprobarIguales()) {
			if(this.ventaja == 0) {
				this.ventaja = 1;
			} else {
				if(this.ventaja == 1) {
					this.jugador1.incrementarJuegos();
					this.jugador1.reiniciarPuntos();
				} else {
					this.ventaja = 0;
				}
			}
		} else {
			if(this.jugador1.getPuntos() == 40) {
				this.jugador1.incrementarJuegos();
				this.reiniciarPuntuacion();
			} else {
				this.jugador1.incrementarPuntos();
			}
		}	
	}
	
	public void incrementarPuntosJug2() {
		if(this.comprobarIguales()) {
			if(this.ventaja == 0) {
				this.ventaja = 2;
			} else {
				if(this.ventaja == 2) {
					this.jugador2.incrementarJuegos();
					this.jugador2.reiniciarPuntos();
				} else {
					this.ventaja = 0;
				}
			}
		} else {
			if(this.jugador2.getPuntos() == 40) {
				this.jugador2.incrementarJuegos();
				this.reiniciarPuntuacion();
			} else {
				this.jugador2.incrementarPuntos();
			}
		}
	}
	
	public boolean comprobarIguales() {
		if((this.getPuntosJug1() == this.getPuntosJug2()) && (this.getPuntosJug1() == 40)) {
			return true;
		} else {
			return false;
		}
	}
	
	public void reiniciarPuntuacion() {
		this.jugador1.reiniciarPuntos();
		this.jugador2.reiniciarPuntos();
	}
	
	public void incrementarJuegosJug1() {
		this.jugador1.incrementarJuegos();
	}
	public void incrementarJuegosJug2() {
		this.jugador2.incrementarJuegos();
	}
	
	public int getJuegosJug1() {
		return this.jugador1.getJuegos();
	}
	
	public int getJuegosJug2() {
		return this.jugador2.getJuegos();
	}
	
	public void reiniciarJuegos() {
		this.jugador1.reiniciarJuegos();
		this.jugador2.reiniciarJuegos();
	}
	
	public void incrementarSetsJug1() {
		this.jugador1.incrementarSets();
	}
	public void incrementarSetsJug2() {
		this.jugador2.incrementarSets();
	}
	
	public void reiniciarSets() {
		this.jugador1.reiniciarSets();
		this.jugador2.reiniciarSets();
	}
	
	public int getSetsJug1() {
		return this.jugador1.getSets();
	}
	
	public int getSetsJug2() {
		return this.jugador2.getSets();
	}
	
	public void setVentaja(int valor) {
		this.ventaja = valor;
	}
	
	public int getVentaja() {
		return this.ventaja;
	}
}
