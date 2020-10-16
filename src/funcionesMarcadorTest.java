import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class funcionesMarcadorTest {
	Marcador miMarcadorTest = new Marcador();
	
	@Test
	void incrementarPuntos() {	
		miMarcadorTest.incrementarPuntosJug1(); //15
		miMarcadorTest.incrementarPuntosJug2(); //15
		miMarcadorTest.incrementarPuntosJug2(); //30
		assertEquals(15, miMarcadorTest.getPuntosJug1());
		assertEquals(30, miMarcadorTest.getPuntosJug2());
		
		miMarcadorTest.incrementarPuntosJug2(); //40
		assertEquals(40, miMarcadorTest.getPuntosJug2());
		assertEquals(0, miMarcadorTest.getVentaja()); //No hay ventaja porque no hay empate
		miMarcadorTest.incrementarPuntosJug2(); //Punto
		assertEquals(0, miMarcadorTest.getPuntosJug1()); //Reiniciado
		assertEquals(0, miMarcadorTest.getPuntosJug2()); //Reiniciado
		assertEquals(1, miMarcadorTest.getJuegosJug2()); //+1 Punto Jug2
		
		miMarcadorTest.incrementarPuntosJug1(); //15
		miMarcadorTest.incrementarPuntosJug1(); //30
		miMarcadorTest.incrementarPuntosJug1(); //40
		miMarcadorTest.incrementarPuntosJug1(); //Punto
		assertEquals(0, miMarcadorTest.getPuntosJug1()); //Reiniciado
		assertEquals(1, miMarcadorTest.getJuegosJug1()); //+1 Punto Jug1
	}
	
	@Test
	void comprobarIgualados() {
		assertFalse(miMarcadorTest.comprobarIguales()); //El marcador es igual a 0, pero no están a 40
		miMarcadorTest.incrementarPuntosJug1(); //15
		assertFalse(miMarcadorTest.comprobarIguales());
		miMarcadorTest.incrementarPuntosJug2(); //15
		assertFalse(miMarcadorTest.comprobarIguales());
		miMarcadorTest.incrementarPuntosJug2(); //30
		miMarcadorTest.incrementarPuntosJug2(); //40
		miMarcadorTest.incrementarPuntosJug1(); //30
		miMarcadorTest.incrementarPuntosJug1(); //40
		System.out.println(miMarcadorTest.getPuntosJug1());
		System.out.println(miMarcadorTest.getPuntosJug2());
		assertTrue(miMarcadorTest.comprobarIguales()); //En este caso son iguales a 40
	}
	
	@Test
	void reiniciarPuntuacion() {
		miMarcadorTest.incrementarPuntosJug1();
		assertEquals(15, miMarcadorTest.getPuntosJug1());
		assertEquals(0, miMarcadorTest.getPuntosJug2());
		miMarcadorTest.reiniciarPuntuacion();
		assertEquals(0, miMarcadorTest.getPuntosJug1());
		assertEquals(0, miMarcadorTest.getPuntosJug2());
	}
	
	@Test
	void incrementarJuegos() {
		miMarcadorTest.incrementarJuegosJug1();
		assertEquals(1, miMarcadorTest.getJuegosJug1());
		assertEquals(0, miMarcadorTest.getJuegosJug2());
	}
	
	@Test 
	void reiniciarJuegos(){
		miMarcadorTest.incrementarJuegosJug1();
		assertEquals(1, miMarcadorTest.getJuegosJug1());
		assertEquals(0, miMarcadorTest.getJuegosJug2());
		miMarcadorTest.reiniciarJuegos();
		assertEquals(0, miMarcadorTest.getJuegosJug1());
		assertEquals(0, miMarcadorTest.getJuegosJug2());
	}
	
	@Test
	void incrementarSets() {
		assertEquals(0, miMarcadorTest.getSetsJug1());
		miMarcadorTest.incrementarSetsJug1();
		assertEquals(1, miMarcadorTest.getSetsJug1());
		miMarcadorTest.incrementarSetsJug1();
		miMarcadorTest.incrementarSetsJug1();
		assertEquals(3, miMarcadorTest.getSetsJug1());
	}
	
	@Test
	void reiniciarSets() {
		miMarcadorTest.incrementarSetsJug1();
		miMarcadorTest.incrementarSetsJug1();
		assertEquals(2, miMarcadorTest.getSetsJug1());
		miMarcadorTest.reiniciarSets();
		assertEquals(0, miMarcadorTest.getSetsJug1());
	}
	
	@Test
	void comprobarIgualesVentaja() {
		miMarcadorTest.incrementarPuntosJug1();
		miMarcadorTest.incrementarPuntosJug1();
		miMarcadorTest.incrementarPuntosJug1();
		miMarcadorTest.incrementarPuntosJug2();
		miMarcadorTest.incrementarPuntosJug2();
		miMarcadorTest.incrementarPuntosJug2();
		assertEquals(40, miMarcadorTest.getPuntosJug1());
		assertEquals(40, miMarcadorTest.getPuntosJug2());
		assertEquals(miMarcadorTest.getPuntosJug1(), miMarcadorTest.getPuntosJug2());
		miMarcadorTest.incrementarPuntosJug1();
		assertEquals(1, miMarcadorTest.getVentaja());
		miMarcadorTest.incrementarPuntosJug2();
		assertEquals(0, miMarcadorTest.getVentaja());
		miMarcadorTest.incrementarPuntosJug2();
		assertEquals(2, miMarcadorTest.getVentaja());
	}
	
	@Test
	void comprobarIncrementoJuegos() {
		miMarcadorTest.incrementarPuntosJug1();
		miMarcadorTest.incrementarPuntosJug2(); //15
		miMarcadorTest.incrementarPuntosJug2(); //30
		assertEquals(15, miMarcadorTest.getPuntosJug1());
		assertEquals(30, miMarcadorTest.getPuntosJug2());
		
		miMarcadorTest.incrementarPuntosJug2(); //40
		assertEquals(40, miMarcadorTest.getPuntosJug2());
		miMarcadorTest.incrementarPuntosJug2(); //Punto
		System.out.println(miMarcadorTest.getPuntosJug2());
		assertEquals(0, miMarcadorTest.getVentaja());
		//assertEquals(1, miMarcadorTest.getJuegosJug2());
	}
}
