import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class funcionesMarcadorTest {
	Marcador miMarcadorTest = new Marcador();
	
	//@Test
	void incrementarPuntos() {	
		miMarcadorTest.incrementarPuntosJug1();
		miMarcadorTest.incrementarPuntosJug2();
		miMarcadorTest.incrementarPuntosJug2();
		assertEquals(15, miMarcadorTest.getPuntosJug1());
		assertEquals(30, miMarcadorTest.getPuntosJug2());
		
		miMarcadorTest.incrementarPuntosJug2();
		assertEquals(40, miMarcadorTest.getPuntosJug2());
	}
	
	@Test
	void comprobarIgualados() {
		assertFalse(miMarcadorTest.comprobarIguales()); //El marcador es igual a 0, pero no están a 40
		miMarcadorTest.incrementarPuntosJug1();
		assertFalse(miMarcadorTest.comprobarIguales());
		miMarcadorTest.incrementarPuntosJug2();
		assertFalse(miMarcadorTest.comprobarIguales());
		miMarcadorTest.incrementarPuntosJug2();
		miMarcadorTest.incrementarPuntosJug2();
		miMarcadorTest.incrementarPuntosJug1();
		miMarcadorTest.incrementarPuntosJug1();
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
	
}
