package modello;

import java.util.ArrayList;

public abstract class Giocatore implements InterfacciaGiocatore{
	// VARIABILI
	private String target;
	public ArrayList<Tentativo> tentativi;
	
	// COSTRUTTORE
	public Giocatore() {
		inizializza();
	}
	
	// METODI
	// Inizializzazione del giocatore
	public void inizializza() {
		target = genTarget();
		tentativi = new ArrayList<Tentativo>();
	}
		
	// Getter
	public String getTarget() {
		return target;
	}
	
	// Inserimento del tentativo
	public boolean addTentativo(String guess,int bulls,int maggots) {
		Tentativo t = new Tentativo(guess, bulls, maggots);
		return tentativi.add(t);
	}
	
	// Trasforma la lista dei tentativi in una stringa
	public String stringaTentativi() {
		return tentativi.toString();
	}
	
	// Ritorna il guess del giocatore
	public abstract String genGuess();
	
	// Ritorna il guess del giocatore
	public abstract String genTarget();
	
	// Ritorna una combinazione valida casuale
	protected String genCombinazioneCasuale() {
		return Giudice.genTarget();
	}
	
}
