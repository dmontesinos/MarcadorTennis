import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class funcionesMarcadorTest {
	Marcador miMarcadorTest = new Marcador();
	
	@Test
	void incrementarPuntos() {	
		miMarcadorTest.incrementarPuntosJug1(); //15
		miMarcadorTest.incrementarPuntosJug2(); //15
		miMarcadorTest.incrementarPuntosJug2(); //30
		assertEquals(15, miMarcadorTest.proxyGetPuntosJug1());
		assertEquals(30, miMarcadorTest.proxyGetPuntosJug2());
		
		miMarcadorTest.incrementarPuntosJug2(); //40
		assertEquals(40, miMarcadorTest.proxyGetPuntosJug2());
		assertEquals(0, miMarcadorTest.proxyGetVentaja()); //No hay ventaja porque no hay empate
		miMarcadorTest.incrementarPuntosJug2(); //Punto
		assertEquals(0, miMarcadorTest.proxyGetPuntosJug1()); //Reiniciado
		assertEquals(0, miMarcadorTest.proxyGetPuntosJug2()); //Reiniciado
		assertEquals(1, miMarcadorTest.proxyGetJuegosJug2()); //+1 Punto Jug2
		
		miMarcadorTest.incrementarPuntosJug1(); //15
		miMarcadorTest.incrementarPuntosJug1(); //30
		miMarcadorTest.incrementarPuntosJug1(); //40
		miMarcadorTest.incrementarPuntosJug1(); //Punto
		assertEquals(0, miMarcadorTest.proxyGetPuntosJug1()); //Reiniciado
		assertEquals(1, miMarcadorTest.proxyGetJuegosJug1()); //+1 Punto Jug1
	}
	
	@Test
	void comprobarIgualados() {
		assertFalse(miMarcadorTest.comprobarPuntosIguales()); //El marcador es igual a 0, pero no están a 40
		miMarcadorTest.incrementarPuntosJug1(); //15
		assertFalse(miMarcadorTest.comprobarPuntosIguales());
		miMarcadorTest.incrementarPuntosJug2(); //15
		assertFalse(miMarcadorTest.comprobarPuntosIguales());
		miMarcadorTest.incrementarPuntosJug2(); //30
		miMarcadorTest.incrementarPuntosJug2(); //40
		miMarcadorTest.incrementarPuntosJug1(); //30
		miMarcadorTest.incrementarPuntosJug1(); //40
		assertTrue(miMarcadorTest.comprobarPuntosIguales()); //En este caso son iguales a 40
	}
	
	@Test
	void reiniciarPuntuacion() {
		miMarcadorTest.incrementarPuntosJug1();
		assertEquals(15, miMarcadorTest.proxyGetPuntosJug1());
		assertEquals(0, miMarcadorTest.proxyGetPuntosJug2());
		miMarcadorTest.reiniciarPuntuacion();
		assertEquals(0, miMarcadorTest.proxyGetPuntosJug1());
		assertEquals(0, miMarcadorTest.proxyGetPuntosJug2());
	}
	
	@Test
	void incrementarJuegos() {
		miMarcadorTest.incrementarJuegosJug1();
		assertEquals(1, miMarcadorTest.proxyGetJuegosJug1());
		assertEquals(0, miMarcadorTest.proxyGetJuegosJug2());
	}
	
	@Test 
	void reiniciarJuegos(){
		miMarcadorTest.incrementarJuegosJug1();
		assertEquals(1, miMarcadorTest.proxyGetJuegosJug1());
		assertEquals(0, miMarcadorTest.proxyGetJuegosJug2());
		miMarcadorTest.reiniciarJuegos();
		assertEquals(0, miMarcadorTest.proxyGetJuegosJug1());
		assertEquals(0, miMarcadorTest.proxyGetJuegosJug2());
	}
	
	@Test
	void incrementarSets() {
		assertEquals(0, miMarcadorTest.proxyGetSetsJug1());
		miMarcadorTest.incrementarSetsJug1();
		assertEquals(1, miMarcadorTest.proxyGetSetsJug1());
		miMarcadorTest.incrementarSetsJug1();
		miMarcadorTest.incrementarSetsJug1();
		assertEquals(3, miMarcadorTest.proxyGetSetsJug1());
	}
	
	@Test
	void reiniciarSets() {
		miMarcadorTest.incrementarSetsJug1();
		miMarcadorTest.incrementarSetsJug1();
		assertEquals(2, miMarcadorTest.proxyGetSetsJug1());
		miMarcadorTest.reiniciarSets();
		assertEquals(0, miMarcadorTest.proxyGetSetsJug1());
	}
	
	@Test
	void comprobarIgualesVentaja() {
		for(int i =0; i<3; i++) {
			miMarcadorTest.incrementarPuntosJug1();
			miMarcadorTest.incrementarPuntosJug2();
		}

		assertEquals(40, miMarcadorTest.proxyGetPuntosJug1());
		assertEquals(40, miMarcadorTest.proxyGetPuntosJug2());
		assertEquals(miMarcadorTest.proxyGetPuntosJug1(), miMarcadorTest.proxyGetPuntosJug2());
		miMarcadorTest.incrementarPuntosJug1();
		assertEquals(1, miMarcadorTest.proxyGetVentaja());
		miMarcadorTest.incrementarPuntosJug2();
		assertEquals(0, miMarcadorTest.proxyGetVentaja());
		miMarcadorTest.incrementarPuntosJug2();
		assertEquals(2, miMarcadorTest.proxyGetVentaja());
	}
	
	@Test
	void comprobarIncrementoJuegos() {
		miMarcadorTest.incrementarPuntosJug1();
		miMarcadorTest.incrementarPuntosJug2(); //15
		miMarcadorTest.incrementarPuntosJug2(); //30
		assertEquals(15, miMarcadorTest.proxyGetPuntosJug1());
		assertEquals(30, miMarcadorTest.proxyGetPuntosJug2());
		
		miMarcadorTest.incrementarPuntosJug2(); //40
		assertEquals(40, miMarcadorTest.proxyGetPuntosJug2());
		miMarcadorTest.incrementarPuntosJug2(); //Punto
		assertEquals(0, miMarcadorTest.proxyGetVentaja());
		assertEquals(1, miMarcadorTest.proxyGetJuegosJug2());
	}
	
	@Test
	void comprobarIncrementoSetsJug1() {
		//Incremento de Set de 0 a 6 juegos (normal)
		for(int i=0; i<6; i++) {
			miMarcadorTest.incrementarJuegosJug1();
		}
		assertEquals(1, miMarcadorTest.proxyGetSetsJug1());
		assertEquals(0, miMarcadorTest.proxyGetJuegosJug1());
		
		for(int i=0; i<6; i++) {
			miMarcadorTest.incrementarJuegosJug1();
		}
		
		assertEquals(2, miMarcadorTest.proxyGetSetsJug1());
		assertEquals(0, miMarcadorTest.proxyGetJuegosJug1());
	}
	
	@Test
	void comprobarIncrementoSetsJug2() {
		//Incremento de Set de 0 a 6 juegos (normal)
		for(int i=0; i<6; i++) {
			miMarcadorTest.incrementarJuegosJug2();
		}
		
		assertEquals(1, miMarcadorTest.proxyGetSetsJug2());
		assertEquals(0, miMarcadorTest.proxyGetJuegosJug2());
		
		for(int i=0; i<6; i++) {
			miMarcadorTest.incrementarJuegosJug2();
		}
		
		assertEquals(2, miMarcadorTest.proxyGetSetsJug2());
	}
	
	@Test
	void comprobarIncrementoSetsDiferenciaDe2() {
		//Incremento de Set de 5 a 5 juegos (diferencia de 2)
		for(int i = 0; i<5; i++) {
			miMarcadorTest.incrementarJuegosJug1();
		}
		
		for(int i = 0; i<5; i++) {
			miMarcadorTest.incrementarJuegosJug2();
		}
		
		miMarcadorTest.incrementarJuegosJug1();
		miMarcadorTest.incrementarJuegosJug1();
		assertEquals(0, miMarcadorTest.proxyGetPuntosJug1());
		assertEquals(0, miMarcadorTest.proxyGetPuntosJug2());
		assertEquals(1, miMarcadorTest.proxyGetSetsJug1());
	}
	
	@Test
	void comprobarIncrementoSetsDiferenciaDe2Multiple() {
		for(int i=0; i<18; i++) {
			miMarcadorTest.incrementarJuegosJug2();
		}
		
		assertEquals(3, miMarcadorTest.proxyGetSetsJug2());
		assertEquals(0, miMarcadorTest.proxyGetJuegosJug1());
		assertEquals(0, miMarcadorTest.proxyGetJuegosJug2());
	}
	
	
	@Test
	void comprobarIncrementoSetsTIE() {
		//Se fuerza el TIE y primero lo gana el jugador 1, posteriormente
		//lo gana el jugador 2. Los sets finalizan en 1/1
		for(int i =0; i<6; i++) {
			miMarcadorTest.incrementarJuegosJug1();
			miMarcadorTest.incrementarJuegosJug2();
		}
		
		assertEquals(6, miMarcadorTest.proxyGetJuegosJug1());
		assertEquals(6, miMarcadorTest.proxyGetJuegosJug2());
		assertTrue(miMarcadorTest.getTie());
		
		for(int i = 0; i<6; i++) {
			miMarcadorTest.incrementarPuntosJug1();
		}
		
		assertEquals(6, miMarcadorTest.proxyGetJuegosTIEJug1());
		miMarcadorTest.incrementarPuntosJug1();
		
		assertEquals(1, miMarcadorTest.proxyGetSetsJug1());
		assertEquals(0, miMarcadorTest.proxyGetPuntosJug1());
		assertEquals(0, miMarcadorTest.proxyGetJuegosJug1());
		
		assertEquals(0, miMarcadorTest.proxyGetSetsJug2());
		assertEquals(0, miMarcadorTest.proxyGetPuntosJug2());
		assertEquals(0, miMarcadorTest.proxyGetJuegosJug2());
		
		assertFalse(miMarcadorTest.getTie());
		
		for(int i =0; i<6; i++) {
			miMarcadorTest.incrementarJuegosJug1();
			miMarcadorTest.incrementarJuegosJug2();
		}
		
		assertEquals(6, miMarcadorTest.proxyGetJuegosJug1());
		assertEquals(6, miMarcadorTest.proxyGetJuegosJug2());
		assertTrue(miMarcadorTest.getTie());
		
		for(int i = 0; i<6; i++) {
			miMarcadorTest.incrementarPuntosJug2();
		}
		
		miMarcadorTest.incrementarPuntosJug2();
		
		assertEquals(1, miMarcadorTest.proxyGetSetsJug1());
		assertEquals(0, miMarcadorTest.proxyGetPuntosJug1());
		assertEquals(0, miMarcadorTest.proxyGetJuegosJug1());
		
		assertEquals(1, miMarcadorTest.proxyGetSetsJug2());
		assertEquals(0, miMarcadorTest.proxyGetPuntosJug2());
		assertEquals(0, miMarcadorTest.proxyGetJuegosJug2());
		
		assertFalse(miMarcadorTest.getTie());
		
	}
	
	@Test
	void comprobarIncrementoJuegoAJuego() {
		for(int i=0; i<48; i++) {
			miMarcadorTest.incrementarPuntosJug1();
		}
		
		for(int i=0; i<24; i++) {
			miMarcadorTest.incrementarPuntosJug2();
		}
		
		assertEquals(0, miMarcadorTest.proxyGetPuntosJug1());
		assertEquals(0, miMarcadorTest.proxyGetJuegosJug1());
		assertEquals(2, miMarcadorTest.proxyGetSetsJug1());
		
		assertEquals(0, miMarcadorTest.proxyGetPuntosJug2());
		assertEquals(0, miMarcadorTest.proxyGetJuegosJug2());
		assertEquals(1, miMarcadorTest.proxyGetSetsJug2());
	}
	
	@Test
	void comprobarIncrementoTIEmediantePuntos(){
		for(int i=0; i<20; i++) {
			miMarcadorTest.incrementarPuntosJug1();
		}
		for(int i=0; i<20; i++) {
			miMarcadorTest.incrementarPuntosJug2();
		}
		
		
		assertFalse(miMarcadorTest.getTie());
		
		for(int i=0; i<4; i++) {
			miMarcadorTest.incrementarPuntosJug1();
		}
		for(int i=0; i<4; i++) {
			miMarcadorTest.incrementarPuntosJug2();
		}
		for(int i=0; i<7; i++) {
			miMarcadorTest.incrementarPuntosJug1();
		}
		
		//Comprobación de Set+1 y reinicio de variables.
		assertEquals(1, miMarcadorTest.proxyGetSetsJug1());
		assertEquals(0, miMarcadorTest.proxyGetJuegosJug1());
		assertEquals(0, miMarcadorTest.proxyGetJuegosJug2());
		assertEquals(0, miMarcadorTest.proxyGetJuegosTIEJug1());
		assertEquals(0, miMarcadorTest.proxyGetJuegosTIEJug2());
		assertEquals(0, miMarcadorTest.proxyGetPuntosJug1());
		assertEquals(0, miMarcadorTest.proxyGetPuntosJug2());
		assertEquals(0, miMarcadorTest.proxyGetJuegosTIEJug1());
		assertEquals(0, miMarcadorTest.proxyGetJuegosTIEJug2());
		assertFalse(miMarcadorTest.getTie());
	}
	
	@Test
	void comprobacionFinalPartido() {
		for(int i=0; i<18; i++) {
			miMarcadorTest.incrementarJuegosJug1();
		}
		assertEquals(3, miMarcadorTest.proxyGetSetsJug1());
		assertEquals(1,miMarcadorTest.getGanador());
	}
	
	//@Test
	//COMPROBAR CAMBIOS DE PISTA Y BANDO
}
