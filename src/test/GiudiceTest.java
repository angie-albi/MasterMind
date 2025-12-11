package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modello.Giudice;

class GiudiceTest {

	@Test 
	void testValidaLunghezza() {
		assertTrue(Giudice.valida("3617"));
		assertFalse(Giudice.valida("361789"));
		assertFalse(Giudice.valida("36"));
		assertFalse(Giudice.valida(""));
		assertTrue(Giudice.valida("3124"));
	}
	
	@Test
	void testValidaCaratteri() {
		assertTrue(Giudice.valida("3617"));
		assertFalse(Giudice.valida("567!"));
		assertFalse(Giudice.valida("ab%t"));
		assertTrue(Giudice.valida("3124"));
	}
	
	@Test
	void testValidaNonRipetuti() {
		assertTrue(Giudice.valida("3617"));
		assertFalse(Giudice.valida("9923"));
		assertFalse(Giudice.valida("5667"));
		assertFalse(Giudice.valida("1233"));
	}
	
	@Test
	void testValidaNumBulls() {
		assertEquals(0, Giudice.numBulls("1234", "5678"));
		assertEquals(1, Giudice.numBulls("1234", "1876"));
		assertEquals(1, Giudice.numBulls("1234", "9874"));
		assertEquals(1, Giudice.numBulls("1234", "9243"));
		assertEquals(1, Giudice.numBulls("9876", "5573"));
		assertEquals(2, Giudice.numBulls("1234", "1256"));
		assertEquals(2, Giudice.numBulls("1234", "1537"));
		assertEquals(2, Giudice.numBulls("1234", "1764"));
		assertEquals(2, Giudice.numBulls("1234", "8237"));
		assertEquals(2, Giudice.numBulls("1234", "9834"));
		assertEquals(3, Giudice.numBulls("9264", "9261"));
		assertEquals(3, Giudice.numBulls("9264", "9284"));
		assertEquals(3, Giudice.numBulls("9264", "9764"));
		assertEquals(3, Giudice.numBulls("9264", "5264"));
		assertEquals(4, Giudice.numBulls("9264", "9264"));
		assertEquals(4, Giudice.numBulls("8725", "8725"));
	}
	
	@Test
	void testValidaNumMaggots() {
		assertEquals(0, Giudice.numMaggots("1234", "5678"));
		assertEquals(0, Giudice.numMaggots("1234", "1876"));
		assertEquals(0, Giudice.numMaggots("1234", "9874"));
		assertEquals(0, Giudice.numMaggots("1234", "9278"));
		assertEquals(1, Giudice.numMaggots("9876", "3285"));
		assertEquals(1, Giudice.numMaggots("1234", "1397"));
		assertEquals(1, Giudice.numMaggots("1234", "3598"));
		assertEquals(2, Giudice.numMaggots("1234", "9431"));
		assertEquals(2, Giudice.numMaggots("1234", "3478"));
		assertEquals(2, Giudice.numMaggots("1234", "2165"));
		assertEquals(2, Giudice.numMaggots("9264", "4728"));
		assertEquals(3, Giudice.numMaggots("9264", "4623"));
		assertEquals(3, Giudice.numMaggots("9264", "2956"));
		assertEquals(3, Giudice.numMaggots("9264", "6947"));
		assertEquals(4, Giudice.numMaggots("9264", "4629"));
		assertEquals(4, Giudice.numMaggots("8725", "5278"));
		
		assertEquals(4, Giudice.numMaggots("1234", "4321")); 
		assertEquals(4, Giudice.numMaggots("1234", "2143")); 
		assertEquals(4, Giudice.numMaggots("1234", "2341")); 
		assertEquals(2, Giudice.numMaggots("1234", "1243")); 
		assertEquals(3, Giudice.numMaggots("1234", "1342"));
		assertEquals(2, Giudice.numMaggots("1234", "3189"));
		assertEquals(0, Giudice.numMaggots("1234", "1234"));
		assertEquals(0, Giudice.numMaggots("0123", "4567"));
		assertEquals(2, Giudice.numMaggots("1234", "5612"));
	}
	
	@Test
	void testGenTarget() {
		assertTrue(Giudice.valida(Giudice.genTarget()));
		assertTrue(Giudice.valida(Giudice.genTarget()));
		assertTrue(Giudice.valida(Giudice.genTarget()));
		assertTrue(Giudice.valida(Giudice.genTarget()));
		assertTrue(Giudice.valida(Giudice.genTarget()));
		assertTrue(Giudice.valida(Giudice.genTarget()));
		assertTrue(Giudice.valida(Giudice.genTarget()));
		assertTrue(Giudice.valida(Giudice.genTarget()));
		assertTrue(Giudice.valida(Giudice.genTarget()));
		assertTrue(Giudice.valida(Giudice.genTarget()));
		assertTrue(Giudice.valida(Giudice.genTarget()));
		assertTrue(Giudice.valida(Giudice.genTarget()));
		assertTrue(Giudice.valida(Giudice.genTarget()));
		assertTrue(Giudice.valida(Giudice.genTarget()));
		assertTrue(Giudice.valida(Giudice.genTarget()));
		assertTrue(Giudice.valida(Giudice.genTarget()));
		assertTrue(Giudice.valida(Giudice.genTarget()));
		assertTrue(Giudice.valida(Giudice.genTarget()));
		assertTrue(Giudice.valida(Giudice.genTarget()));
		assertTrue(Giudice.valida(Giudice.genTarget()));
	}

}
