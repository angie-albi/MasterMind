package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modello.Computer;
import modello.Giocatore;
import modello.Giudice;
import modello.Umano;

class GiocatoreTest {
	
	private Giocatore g, gC, gU;
	
	@BeforeEach
	void setUp() {
		g = new Computer();
		gC = new Computer();
		gU = new Umano();
	}
	
	@Test
	void testCostruttore() {
		String target = gC.getTarget();
		assertTrue(Giudice.valida(target));
		assertEquals(0, gC.tentativi.size());

		String target1 = gU.getTarget();
		assertTrue(Giudice.valida(target1));
		assertEquals(0,gU.tentativi.size());
	}

	@Test
	void testAddTentativi() {
		String test = g.genGuess();
		int numBulls = Giudice.numBulls(test, g.getTarget());
		int numMaggots = Giudice.numMaggots(test, g.getTarget());

		assertTrue(g.addTentativo(test, numBulls, numMaggots));
		assertEquals(1, g.tentativi.size());
	}

	@Test
	void testStringaTentativi() {
		gC.inizializza();
		assertTrue(gC.addTentativo("1234", 2, 1));
		assertTrue(gC.addTentativo("6790", 0, 0));
		assertEquals("[\n[guess=1234, numBulls=2, numMaggots=1], \n[guess=6790, numBulls=0, numMaggots=0]]",
				gC.stringaTentativi());

		gU.inizializza();
		assertTrue(gU.addTentativo("1234", 3, 0));
		assertTrue(gU.addTentativo("5678", 0, 0));
		assertEquals("[\n[guess=1234, numBulls=3, numMaggots=0], \n[guess=5678, numBulls=0, numMaggots=0]]",
				gU.stringaTentativi());
	}
}
