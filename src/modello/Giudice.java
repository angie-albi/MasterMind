package modello;

public class Giudice {

	// VARIABILI STATICHE
	public static final int LUNGHEZZA = 4;
	public static final char[] CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
	public static final int TENTATIVI = 10;
	
	// METODI 
	// Stringa valida
	public static boolean valida(String guess) {
		return guess.length() == LUNGHEZZA && caratteriGiusti(guess)
			   && nonRipetuti(guess);
	}
	
	// Numeri bulls
	public static int numBulls(String target, String guess) {
		int bulls = 0;
		for (int i=0; i<LUNGHEZZA; i++) {
			if(target.charAt(i) == guess.charAt(i)) {
				bulls++;
			}
		}
		return bulls;
	}
	
	// Numeri maggots
	public static int numMaggots(String target, String guess) {
		int maggots = 0;
		for (int i=0; i<LUNGHEZZA; i++) {
			if(target.charAt(i) != guess.charAt(i) && target.indexOf(guess.charAt(i) )!= -1) { // non è bulls	
				maggots++;
			}
		}
		return maggots;
	}
	
	// Generatore di target casuali
	public static String genTarget() {
	    String target = "";
	    
	    while (target.length() < LUNGHEZZA) {
	        int index = (int)(Math.random() * CHARS.length);
	        char c = CHARS[index];
	        
	        // Controllo unicità
	        if (target.indexOf(c) == -1) {
	            target += c;
	        }
	    }
	    return target;
	}
	
	
	// Metodi ausiliari
	private static boolean caratteriGiusti(String guess) {
		for (int i=0; i<LUNGHEZZA; i++) {
			if (!carattereGiusti(guess.charAt(i)))
				return false;
		}
		return true;
	}
	
	private static boolean carattereGiusti(char c) {
		for (char car: CHARS) {
			if(c == car) {
				return true;
			}
		}
		return false;
	}
	
	private static boolean nonRipetuti(String guess) {
	    for (int i = 0; i < LUNGHEZZA; i++) {
	        for (int j = i + 1; j < LUNGHEZZA; j++) {
	            if (guess.charAt(i) == guess.charAt(j)) {
	                return false; 
	            }
	        }
	    }
	    return true;
	}
}