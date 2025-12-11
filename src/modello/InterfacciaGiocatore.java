package modello;

public interface InterfacciaGiocatore {

	public void inizializza();
	
	public boolean addTentativo(String guess, int bulls, int maggots);
	
	public String stringaTentativi();
	
	public  String genGuess();
	public  String genTarget();
	
	public String getTarget();

	
}
