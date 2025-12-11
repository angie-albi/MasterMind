package modello;

import jbook.util.Input;

public class Umano extends Giocatore{
	
	// COSTRUTTORE
	// Richiama il costruttore della superclasse
	public Umano() {
		super();
	}
	
	// METODI
	// Implementazione del metodo astratto genGuess di Giocatore
	@Override
	public String genGuess() {
		int ris;
		String guess;
		do {
			ris = Input.readInt("Vuoi inserire un guess o generarlo casualmente?(1/2) ");
		} while(ris != 1 && ris != 2);
		
		if(ris == 1) {
			do {
				guess = Input.readString("Inserisci il guess: ");
				
				if(!Giudice.valida(guess)) {
					System.out.println("Guess non valido, riprova!");
				}
			} while(!Giudice.valida(guess));
			return guess;
		}
		else {
			return super.genCombinazioneCasuale();
		}
	}

	//Implementazione del metodo astratto genGuess di Giocatore
	@Override
	public String genTarget() {
		int ris;
		String target;
		do {
			ris = Input.readInt("Vuoi inserire un target o generarlo casualmente? (1/2) ");
		} while(ris != 1 && ris != 2);
		
		if(ris == 1) {
			do {
				target = Input.readString("Inserisci il target: ");
				
				if(!Giudice.valida(target)) {
					System.out.println("Target non valido, riprova!");
				}
			} while(!Giudice.valida(target));
			return target;
		}
		else {
			return super.genCombinazioneCasuale();
		}
	}

}
