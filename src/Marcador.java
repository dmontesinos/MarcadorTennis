public class Marcador {
	private boolean sacaJug1;
	private boolean cambioPista;
	private int ventaja;
	private Puntuacion jugador1;
	private Puntuacion jugador2;
	private boolean tie;
	private int ganador;
	
	public Marcador() {
		this.sacaJug1 = true;
		this.jugador1 = new Puntuacion();
		this.jugador2 = new Puntuacion();
		this.ventaja = 0;
		this.tie = false;
		this.ganador = 0;
		this.cambioPista = true;
	}

	public boolean getSacaJug1() {
		return sacaJug1;
	}

	public void setSacaJug1(boolean sacaJug1) {
		this.sacaJug1 = sacaJug1;
	}
	
	public int proxyGetPuntosJug1() {
		return this.jugador1.getPuntos();
	}
	
	public int proxyGetPuntosJug2() {
		return this.jugador2.getPuntos();
	}
	
	public void incrementarPuntosJug1() {
		if(!this.tie) {
			if(this.comprobarPuntosIguales()) {
				if(this.ventaja == 0) {
					this.ventaja = 1;
				} else {
					if(this.ventaja == 1) {
						this.incrementarJuegosJug1();
						this.reiniciarPuntuacion();
						this.ventaja = 0;
					} else {
						this.ventaja = 0;
					}
				}
			} else {
				if(this.jugador1.getPuntos() == 40) {
					this.incrementarJuegosJug1();
					this.reiniciarPuntuacion();
				} else {
					this.jugador1.incrementarPuntos();
				}
			}	
		} else {
			if(this.jugador1.getPuntosTIE() == 6 && this.jugador2.getPuntosTIE() < 6) {
				this.incrementarSetsJug1();
				this.cambiarDePista();
				this.reiniciarJuegos();
				this.reiniciarTIE();
			} else {
				if(this.jugador1.getPuntosTIE() > 4 
					&& this.jugador2.getPuntosTIE() > 4 
					&& this.comprobarDiferenciaJuegosTIE() != 2) {
					this.jugador1.incrementarTIE();
				} else {
					if(this.jugador1.getPuntosTIE() <= 5 && this.jugador2.getPuntosTIE() <= 5) {
						this.jugador1.incrementarTIE();
					}
				}
			}
			this.comprobarCambioDePistaTIE();
			this.comprobarTieGanadoJug1();
		}
	}
	
	public void comprobarTieGanadoJug1() {
		if(this.jugador1.getPuntosTIE() > 5 
						&& this.jugador2.getPuntosTIE() > 5 
						&& this.comprobarDiferenciaJuegosTIE() == 2) {
			this.tie = false;
			this.incrementarSetsJug1();
		}
	}
	
	public void incrementarPuntosJug2() {
		if(!this.tie) {
			if(this.comprobarPuntosIguales()) {
				if(this.ventaja == 0) {
					this.ventaja = 2;
				} else {
					if(this.ventaja == 2) {
						this.incrementarJuegosJug2();
						this.reiniciarPuntuacion();
						this.ventaja = 0;
					} else {
						this.ventaja = 0;
					}
				}
			} else {
				if(this.jugador2.getPuntos() == 40) {
					this.incrementarJuegosJug2();
					this.reiniciarPuntuacion();
				} else {
					this.jugador2.incrementarPuntos();
				}
			}
		} else {
			if(this.jugador2.getPuntosTIE() == 6 && this.jugador1.getPuntosTIE() < 6) {
				this.incrementarSetsJug2();
				this.reiniciarJuegos();
				this.reiniciarTIE();
			} else {
				if(this.jugador1.getPuntosTIE() > 5 
						&& this.jugador2.getPuntosTIE() > 5 
						&& this.comprobarDiferenciaJuegosTIE() == 2) {
					this.tie = false;
					this.incrementarSetsJug2();
				} else {
					if(this.jugador1.getPuntosTIE() > 4 
						&& this.jugador2.getPuntosTIE() > 4 
						&& this.comprobarDiferenciaJuegosTIE() != 2) {
						this.jugador2.incrementarTIE();
					} else {
						if(this.jugador1.getPuntosTIE() <= 5 && this.jugador2.getPuntosTIE() <= 5) {
							this.jugador2.incrementarTIE();
						}
					}
				}
			}
			this.comprobarCambioDePistaTIE();
			this.comprobarTieGanadoJug2();
		}
	}
	
	public void comprobarTieGanadoJug2() {
		if(this.jugador1.getPuntosTIE() > 5 
						&& this.jugador2.getPuntosTIE() > 5 
						&& this.comprobarDiferenciaJuegosTIE() == 2) {
			this.tie = false;
			this.incrementarSetsJug2();
		}
	}
	
	public boolean comprobarPuntosIguales() {
		if((this.jugador1.getPuntos() == this.jugador2.getPuntos()) && (this.jugador1.getPuntos() == 40)) {
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
			this.incrementarSetsJug1();
			this.reiniciarJuegos();
		} else {
			if(this.jugador1.getJuegos() > 4 
					&& this.jugador2.getJuegos() > 4 
					&& this.comprobarDiferenciaJuegos() == 2) {
				this.incrementarSetsJug1();
				this.cambiarDePista();
				this.reiniciarJuegos();
			} else {
				if(this.jugador1.getJuegos() > 4 
					&& this.jugador2.getJuegos() > 4 
					&& this.comprobarDiferenciaJuegos() != 2) {
					this.jugador1.incrementarJuegos();
					this.cambioDeServicio();
				} else {
					if(this.jugador1.getJuegos() <= 5 && this.jugador2.getJuegos() <= 5) {
						this.jugador1.incrementarJuegos();
						this.cambioDeServicio();
					}
				}
			}
		}
		this.comprobarJuegoGanado();
		this.comprobarTIE();
		this.comprobarFinPartido();
	}

	public void incrementarJuegosJug2() {
		if(this.jugador2.getJuegos() == 5 && this.jugador1.getJuegos() < 5) {
			this.incrementarSetsJug2();
			this.reiniciarJuegos();
		} else {
			if(this.jugador1.getJuegos() > 4 
					&& this.jugador2.getJuegos() > 4 
					&& this.comprobarDiferenciaJuegos() == 2) {
				this.incrementarSetsJug2();
				this.cambiarDePista();
				this.reiniciarJuegos();
			} else {
				if(this.jugador1.getJuegos() > 4 
					&& this.jugador2.getJuegos() > 4 
					&& this.comprobarDiferenciaJuegos() != 2) {
					this.jugador2.incrementarJuegos();
					this.cambioDeServicio();
				} else {
					if(this.jugador1.getJuegos() <= 5 && this.jugador2.getJuegos() <= 5) {
						this.jugador2.incrementarJuegos();
						this.cambioDeServicio();
					}
				}
			}
		}
		this.comprobarJuegoGanado();
		this.comprobarTIE();
		this.comprobarFinPartido();
	}
	
	private void comprobarCambioDePistaTIE() {
		if((this.jugador1.getPuntosTIE() + this.jugador2.getPuntosTIE())%6 == 0 
			&& this.jugador1.getPuntosTIE() != 0) {
			this.cambiarDePista();
		}
	}
	
	private void cambiarDePista() {
		if(this.cambioPista) {
			this.cambioPista = false;
		} else {
			this.cambioPista = true;
		}
	}
	
	private boolean comprobarFinPartido() {
		if(this.jugador1.getSets() == 3) {
			this.setGanador(1);
			return true;
		} else {
			if(this.jugador2.getSets() == 3) {
				this.setGanador(2);
				return true;
			} else {
				return false;
			}
		}
	}
	
	private void comprobarJuegoGanado() {
		if(this.jugador1.getJuegos() == 7) {
			this.reiniciarJuegos();
			this.incrementarSetsJug1();
		}
		if(this.jugador2.getJuegos() == 7) {
			this.reiniciarJuegos();
			this.incrementarSetsJug2();
		}
	}
	
	public void cambioDeServicio() {
		if(this.sacaJug1) {
			this.sacaJug1 = false;
		} else {
			this.sacaJug1 = true;
		}
	}
	
	private void comprobarTIE() {
		if(this.jugador1.getJuegos() == this.jugador2.getJuegos() 
				&& this.jugador1.getJuegos() == 6) {
			this.tie = true;
		}
	}
	
	public int comprobarDiferenciaJuegos() {
		return Math.abs(this.jugador1.getJuegos() - this.jugador2.getJuegos());
	}
	
	public int comprobarDiferenciaJuegosTIE() {
		return Math.abs(this.jugador1.getPuntosTIE() - this.jugador2.getPuntosTIE());
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
		this.cambiarDePista();
		this.reiniciarJuegos();
		this.reiniciarPuntuacion();
		this.reiniciarTIE();
		this.jugador1.incrementarSets();
	}
	
	public void incrementarSetsJug2() {
		this.cambiarDePista();
		this.reiniciarJuegos();
		this.reiniciarPuntuacion();
		this.reiniciarTIE();
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
	
	public boolean getTie() {
		return this.tie;
	}
	
	public void incrementarTIEjug1() {
		this.jugador1.incrementarTIE();
	}
	
	public void incrementarTIEjug2() {
		this.jugador2.incrementarTIE();
	}
	
	public void reiniciarTIE() {
		this.tie = false;
		this.jugador1.reiniciarTIE();
		this.jugador2.reiniciarTIE();
	}
	
	public int proxyGetJuegosTIEJug1() {
		return this.jugador1.getPuntosTIE();
	}
	
	public int proxyGetJuegosTIEJug2() {
		return this.jugador2.getPuntosTIE();
	}
	
	public int getGanador() {
		return this.ganador;
	}
	
	public void setGanador(int valor) {
		this.ganador = valor;
	}
	
	public void imprimirMarcador() {
		if(this.tie) {
			System.out.println("TIE BREAK");
		}
		
		if(!this.tie) {
			if(this.ventaja == 1) {
				System.out.println("Puntos: A|"+this.jugador2.getPuntos());
			} else {
				if(this.ventaja == 2) {
					System.out.println("Puntos: "+ this.jugador1.getPuntos() + "|A");
				} else {
					System.out.println("Puntos: "+ this.jugador1.getPuntos() + "|"+this.jugador2.getPuntos());
				}
			}
		} else {
			System.out.println("Puntos: "+ this.jugador1.getPuntosTIE() + "|"+this.jugador2.getPuntosTIE());
		}
		
		System.out.println("Juegos: "+ this.jugador1.getJuegos()+"|"+this.jugador2.getJuegos());
		System.out.println("Sets: "+ this.jugador1.getSets()+"|"+this.jugador2.getSets());
		
		if(this.cambioPista) {
			System.out.println("Pista A");
		} else {
			System.out.println("Pista B");
		}
		
		if(this.sacaJug1) {
			System.out.println("Servicio del jugador 1");
		} else {
			System.out.println("Servicio del jugador 2");
		}	
	}
}
