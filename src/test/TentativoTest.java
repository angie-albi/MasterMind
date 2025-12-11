package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import modello.Tentativo;

public class TentativoTest {

	@Test
	void testCostruttore() {
		Tentativo t = new Tentativo("2345", 0, 0);
		assertEquals("2345", t.getGuess());
		assertEquals(0, t.getNumBulls());
		assertEquals(0, t.getNumMaggots());
		
		Tentativo t1 = new Tentativo("4351", 3, 1);
		assertEquals("4351", t1.getGuess());
		assertEquals(3, t1.getNumBulls());
		assertEquals(1, t1.getNumMaggots());
	}
	
	@Test
	void testToString() {
		Tentativo t = new Tentativo("2345", 2, 1);
		assertEquals(t.toString(), "[guess=2345, numBulls=2, numMaggots=1]");
		
		Tentativo t1 = new Tentativo("4351", 1, 3);
		assertEquals(t1.toString(), "[guess=4351, numBulls=1, numMaggots=3]");
	}
}
