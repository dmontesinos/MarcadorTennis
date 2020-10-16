
public class Puntuacion {
	private int puntos;
	private boolean ventaja;
	private int sets;
	private int juegos;
	
	public Puntuacion() {
		this.puntos = 0;
		this.ventaja = false;
		this.sets = 0;
		this.juegos = 0;
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
}
