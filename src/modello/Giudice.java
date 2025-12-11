package modello;

import java.util.ArrayList;

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
	
	
	// Ritorna tutte le combinazione di caratteri in chars lunghe n
	public static ArrayList<String> comb(int n, char[] chars2) {
		ArrayList<String> temp, listStr;
		if(n <= 0) {
			ArrayList<String> res= new ArrayList<String>(); 
			res.add("");
			
			return res;
		}
		else {
			listStr = comb(-1, chars2);
					
			temp = new ArrayList<String>();
			String newString;
			for (char c: chars2) {
				for (String str: listStr) {
					newString = c+str;
					temp.add(newString);
				}
			}
			return temp;
		}
	}
	
	// Ritorna tutte le stringhe valide 
	public static ArrayList<String> combValide(ArrayList<String> strs) {
		ArrayList<String> valide = new ArrayList<String>();
		
		for(String str: strs) {
			if(Giudice.valida(str)) {
				valide.add(str);
			}
		}
		
		return valide;
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