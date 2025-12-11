package modello;

public class Tentativo {
	// VARAIBILI
	private String guess;
	private int numBulls;
	private int numMaggots;
	
	// COSTRUTTORE
	public Tentativo(String guess, int numBulls, int numMaggots) {
		this.guess = guess;
		this.numBulls = numBulls;
		this.numMaggots = numMaggots;
	}
	
	// METODI
	// Getters
	
	public String getGuess() {
		return guess;
	}

	public int getNumBulls() {
		return numBulls;
	}

	public int getNumMaggots() {
		return numMaggots;
	}
	
	// Trasforma i valori in una Stringa
	@Override
	public String toString() {
		return "[guess=" + guess + ", numBulls=" + numBulls + ", numMaggots=" + numMaggots + "]";
	}
	
	
}
