
public class Marcador {
	private boolean sacaJug1;
	private int ventaja;
	private Puntuacion jugador1;
	private Puntuacion jugador2;
	private boolean tie;
	
	public Marcador() {
		this.sacaJug1 = true;
		this.jugador1 = new Puntuacion();
		this.jugador2 = new Puntuacion();
		this.ventaja = 0;
		this.tie = false;
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
		if(this.comprobarPuntosIguales()) {
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
		if(this.comprobarPuntosIguales()) {
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
	
	public boolean comprobarPuntosIguales() {
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
		if(this.jugador1.getJuegos() == 5 && this.jugador2.getJuegos() < 5) {
			this.jugador1.incrementarSets();
			this.reiniciarJuegos();
		} else {
			if(this.jugador1.getJuegos() > 4 
					&& this.jugador2.getJuegos() > 4 
					&& this.comprobarDiferenciaJuegos() == 2) {
				this.jugador1.incrementarSets();
				this.reiniciarJuegos();
			} else {
				if(this.jugador1.getJuegos() > 4 
					&& this.jugador2.getJuegos() > 4 
					&& this.comprobarDiferenciaJuegos() != 2) {
					this.jugador1.incrementarJuegos();
				} else {
				
					if(this.jugador1.getJuegos() == this.jugador2.getJuegos() 
							&& this.jugador1.getJuegos() == 6) {
						this.tie = true;
						//FALTA FUNCIONALIDAD TIE
					} else {
						if(this.jugador1.getJuegos() < 5 && this.jugador2.getJuegos() < 5) {
							this.jugador1.incrementarJuegos();
						}
					}
				}
			}
		}
		if(this.jugador1.getJuegos() == 7) {
			this.reiniciarJuegos();
			this.jugador1.incrementarSets();
		}
	}
	public void incrementarJuegosJug2() {
		if(this.jugador2.getJuegos() == 5 && this.jugador1.getJuegos() < 5) {
			this.jugador2.incrementarSets();
			this.reiniciarJuegos();
		} else {
			if(this.jugador1.getJuegos() > 4 
					&& this.jugador2.getJuegos() > 4 
					&& this.comprobarDiferenciaJuegos() == 2) {
				this.jugador2.incrementarSets();
				this.reiniciarJuegos();
			} else {
				if(this.jugador1.getJuegos() > 4 
					&& this.jugador2.getJuegos() > 4 
					&& this.comprobarDiferenciaJuegos() != 2) {
					this.jugador2.incrementarJuegos();
				} else {
				
					if(this.jugador1.getJuegos() == this.jugador2.getJuegos() 
							&& this.jugador2.getJuegos() == 6) {
						this.tie = true;
						//FALTA FUNCIONALIDAD TIE
					} else {
						if(this.jugador1.getJuegos() < 5 && this.jugador2.getJuegos() < 5) {
							this.jugador2.incrementarJuegos();
						}
					}
				}
			}
		}
		if(this.jugador2.getJuegos() == 7) {
			this.reiniciarJuegos();
			this.jugador2.incrementarSets();
		}
	}
	
	public int comprobarDiferenciaJuegos() {
		return Math.abs(this.jugador1.getJuegos() - this.jugador2.getJuegos());
	}
	
	public int proxyGetJuegosJug1() {
		return this.jugador1.getJuegos();
	}
	
	public int proxyGetJuegosJug2() {
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
	
	public int proxyGetSetsJug1() {
		return this.jugador1.getSets();
	}
	
	public int proxyGetSetsJug2() {
		return this.jugador2.getSets();
	}
	
	public void proxySetVentaja(int valor) {
		this.ventaja = valor;
	}
	
	public int proxyGetVentaja() {
		return this.ventaja;
	}
}
