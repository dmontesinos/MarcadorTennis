public class Puntuacion {
	private int puntos;
	private int juegos;
	private int sets;
	private int puntosTIE;
	
	
	public Puntuacion() {
		this.puntos = 0;
		this.sets = 0;
		this.juegos = 0;
		this.puntosTIE = 0;
	}
	
	public int getJuegos() {
		return juegos;
	}
	public void setJuegos(int juegos) {
		this.juegos = juegos;
	}
	public int getPuntos() {
		return puntos;
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	public int getSets() {
		return sets;
	}
	public void setSets(int sets) {
		this.sets = sets;
	}
	public int getPuntosTIE() {
		return this.puntosTIE;
	}
	public void setPuntosTIE(int valor) {
		this.puntosTIE = valor;
	}
	
	public void incrementarPuntos() {
		switch(this.puntos) {
		case 0:
			this.puntos += 15;
			break;
		case 15:
			this.puntos += 15;
			break;
		case 30:
			this.puntos += 10;
			break;
		}
	}
	
	public void decrementarPuntos() {
		switch(this.puntos) {
		case 15:
			this.puntos -= 15;
			break;
		case 30:
			this.puntos -= 15;
			break;
		case 40:
			this.puntos -= 10;
			break;
		}
	}
	
	public void reiniciarPuntos() {
		this.puntos = 0;
	}
	
	public void incrementarJuegos() {
		this.juegos += 1;
	}
	
	public void reiniciarJuegos() {
		this.juegos = 0;
	}
	
	public void incrementarSets() {
		this.sets += 1;
	}
	
	public void reiniciarSets() {
		this.sets = 0;
	}
	
	public void incrementarTIE() {
		this.puntosTIE += 1;
	}
	
	public void reiniciarTIE() {
		this.puntosTIE = 0;
	}
}
