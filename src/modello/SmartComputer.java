package modello;

import java.util.ArrayList;

public class SmartComputer extends Computer {
	// VARIABILI
	private ArrayList<String> targetPossibili;

	// COSTRUTTORE
	public SmartComputer(){
		super();
		targetPossibili = Giudice.combValide(Giudice.comb(Giudice.LUNGHEZZA, Giudice.CHARS));
	}
	
	// METODI 
	// Getter
	public ArrayList<String> getTargetPossibili() {
		return targetPossibili;
	}
	
	// Ritorna la dimensione di targetPossibili
	public int numTargetPossibili() {
		return targetPossibili.size();
	}
	
	// Controlla se il target è tra i targetPossibili
	public boolean isTargetPossibile(String str) {
		if(targetPossibili.contains(str)) {
			return true;
		}
		return false;
	}
	
	@Override 
	public String genGuess() {
		for(Tentativo t: tentativi) {
			if(!ckTargetTnts(t.getGuess())) {
				targetPossibili.remove(t.getGuess());
			}
		}
		
		String target;
		do {
			target = super.genCombinazioneCasuale();
		} while(!targetPossibili.contains(target));
		
		return target;
	}
	
	// Metodi ausiliari
	private boolean ckTargetTnts(String str) {
		int cont = 0;
		for(Tentativo tnt: tentativi) {
			if(Giudice.numBulls(tnt.getGuess(), str) == tnt.getNumBulls() &&
			   Giudice.numMaggots(tnt.getGuess(), str) == tnt.getNumMaggots()) {
				cont ++;
			}
		}
		
		if(cont == tentativi.size()) {
			return true;
		}
		return false;
	}
}
