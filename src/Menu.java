import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		Marcador miMarcador = new Marcador();
		Scanner sc = new Scanner(System.in);
		int opcion = 0;
		
		while(miMarcador.getGanador() == 0) {
			miMarcador.imprimirMarcador();
			
			System.out.print("Quién ha anotado? [1-2]: ");
			opcion = sc.nextInt();
			
			if(opcion == 1) {
				miMarcador.incrementarPuntosJug1();
			} else {
				if(opcion == 2) {
					miMarcador.incrementarPuntosJug2();
				} else {
					System.out.println("Jugador seleccionado incorrecto! [1-2]");
				}
			}
		}
		
		if(miMarcador.getGanador() == 1) {
			System.out.println("El ganador es el jugador 1");
		} else {
			System.out.println("El ganador es el jugador 2");
		}
	}
}
