package modello;

public class Computer extends Giocatore{
	
	// COSTRUTTORE
	// Richiama il costruttore della superclasse
	public Computer() {
		super();
	}
	
	// METODI
	// Implementazione del metodo astratto genGuess di Giocatore
	@Override
	public String genGuess() {
		return super.genCombinazioneCasuale();
	}

	//Implementazione del metodo astratto genGuess di Giocatore
	@Override
	public String genTarget() {
		return super.genCombinazioneCasuale();
	}
	
	
}
