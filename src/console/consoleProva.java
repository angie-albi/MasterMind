package console;

import jbook.util.Input;
import modello.Computer;
import modello.Giudice;
import modello.Umano;

// PRIMA VERSIONE
/*
public class giocoConsole {

	public static void main(String[] args) {
		int numGuesses = 0;
		String guess;
		String target = Giudice.genTarget();
		while (numGuesses<=Giudice.TENTATIVI) {
			guess = Input.readString("Indovina la sequenza:");
			if (guess.equals("quit")){
				System.out.println("La risposta e':" + target +"");
				return;	
			}
			if (guess.equals("Mi_arrendo")) {
				System.out.println("La risposta e':" + target +"");
			} else if (!(Giudice.valida(guess))) {
				System.out.println("Stringa non valida");
			} else {
				int bulls = Giudice.numBulls(guess, target);
				int maggots = Giudice.numMaggots(guess, target);
				if (bulls == 4) {
					numGuesses++;
					System.out.println(
							"Hai indovinato in " + numGuesses + " tentativi.  Riprova!"
							);
					target = Giudice.genTarget();
					numGuesses = 0;
				} else {
					numGuesses++;
					System.out.println(bulls + " Bulls  " + maggots + " Maggots");
				}
			}
			if (numGuesses>Giudice.TENTATIVI)
				System.out.println("Hai superato il numero dei tentativi possibili. \nIl target era: " + target + ".  Riprova!");
		}

	}
}*/

// SECONDA VERSIONE

public class consoleProva {
	
	public static Umano umano;
	public static Computer computer;
	public static int numBU, numBC, numMU, numMC;
	public static int guessMax;
	public static String targetU, targetC, guessU, guessC;

	/**
	 * Il main fa giocare umano vs computer;
	 */
	public static void main(String[] args) {
		while (true) {
			int numGuess = 0;
			inizializzaGioco();
			while (numGuess < guessMax) {
				System.out.println("Siamo al guess n: " + (numGuess+1));							
				guessU = umano.genGuess();
				guessC = computer.genGuess();
				System.out.println("Guess del computer:" + guessC);
				aggiornaListaTentativi();
				stampaSituazioneTentativi();
				if ((numBU == 4) || (numBC == 4))
					break;
				numGuess++;
			}
			stampaSituazioneFinale();
		}
	}

	/**
	 * Il metodo inizializzaGioco chiede all'utente se vuole giocare,  il
	 * numero di guess massimo, e inizializza gli oggetti computer e utente.
	 */
	public static void inizializzaGioco() {
		String risposta;
		do
			risposta = Input.readString("Vuoi inziare una partita? (y/n) ");
		while (!(risposta.equals("y")) && !(risposta.equals("n")));
		if (risposta.equals("n"))
			System.exit(1);
		guessMax = Input.readInt("Quale deve essere il numero massimo di guess: ");
		if (umano==null) umano=new Umano();
		else umano.inizializza();
		if (computer==null) computer=new Computer();
		else computer.inizializza();
		targetC = computer.getTarget();
		targetU = umano.getTarget();

	}

	/**
	 * Il metodo aggiornaListaTentativi aggiunge il risultato del guess corrente
	 * (dell'utente e del computer) nelle loro rispettive liste di tentativi.
	 */
	public static void aggiornaListaTentativi() {
		numBU = Giudice.numBulls(guessU, targetC);
		numMU = Giudice.numMaggots(guessU, targetC);
		numBC = Giudice.numBulls(guessC, targetU);
		numMC = Giudice.numMaggots(guessC, targetU);
		computer.addTentativo(guessC, numBC, numMC);
		umano.addTentativo(guessU, numBU, numMU);
	}

	/**
	 * Il metodo stampaSituazioneTentativi stampa le liste di tentativi
	 * dell'utente e del computer.
	 */
	public static void stampaSituazioneTentativi() {
		System.out.println("Situazione tentativi utente: ");
		System.out.println(umano.stringaTentativi());
		System.out.println("****************************");
		System.out.println("Situazione tentativi computer: ");
		System.out.println(computer.stringaTentativi());
		System.out.println("****************************");
	}

	/**
	 * Il metodo stampaSituazioneFinale stampa il risultato del gioco
	 */
	public static void stampaSituazioneFinale() {
		if (numBU != 4 && numBC != 4) {
			System.out.println("Raggiunto il limite massimo dei guess e nessuno ha vinto!");
			System.out.println("La combinazione del computer era: " + computer.getTarget());
		}
		if (numBU == 4 && numBC != 4)
			System.out.println("Bravo hai vinto!");
		if (numBU != 4 && numBC == 4)
			System.out.println("Il computer e' stato piu' bravo di te!");
		if (numBU == 4 && numBC == 4)
			System.out.println("Avete vinto entrambi!");
	}

}

