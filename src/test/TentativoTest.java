package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modello.Tentativo;

class TentativoTest {
	
	private Tentativo t, t1;
	
	@BeforeEach
	void setUp() {
		t = new Tentativo("2345", 0, 0);
		t1 = new Tentativo("4351", 3, 1);
	}

	@Test
	void testCostruttore() {
		assertEquals("2345", t.getGuess());
		assertEquals(0, t.getNumBulls());
		assertEquals(0, t.getNumMaggots());
		
		assertEquals("4351", t1.getGuess());
		assertEquals(3, t1.getNumBulls());
		assertEquals(1, t1.getNumMaggots());
	}
	
	@Test
	void testToString() {
		assertEquals(t.toString(), "\n[guess=2345, numBulls=0, numMaggots=0]");
		
		assertEquals(t1.toString(), "\n[guess=4351, numBulls=3, numMaggots=1]");
	}
}
