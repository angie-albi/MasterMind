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
		ArrayList<String> targetsRemove = new ArrayList<>();
		
		for (String candidato : targetPossibili) {
			if(!ckTargetTnts(candidato)) {
				targetsRemove.add(candidato);
			}
		}
		targetPossibili.removeAll(targetsRemove);
		
		if (targetPossibili.isEmpty()) {
	        System.out.println("Errore: nessun target possibile rimasto!");
	        return null; 
	    }
		
		int index = (int)(Math.random() * targetPossibili.size());
	    String guess = targetPossibili.get(index);
	    
	    return guess;
	}
	
	// Metodi ausiliari
	private boolean ckTargetTnts(String str) {
		for(Tentativo tnt: tentativi) {
			int bulls = Giudice.numBulls(tnt.getGuess(), str);
			int maggots =  Giudice.numMaggots(tnt.getGuess(), str);
			
			if(bulls != tnt.getNumBulls() || maggots != tnt.getNumMaggots()) {
				return false;
			}
		}
		return true;
	}
}
