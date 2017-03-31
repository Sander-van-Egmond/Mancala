package nl.sogyo.mancala;

abstract class Bakje {
	private int steentjes;
	private Bakje buurman;
	private Speler eigenaar;
	private boolean kahala;
	
	public Bakje(int steentjes){
		this.steentjes = steentjes;
		this.setKahala(false);
	}
	
	public void doorgeven(int hand, Speler bron) {
		if (hand>0){
			getBuurman().addInhoud(1);
			getBuurman().doorgeven(hand-1,bron);
		}
	}
	
	public void addInhoud(int adder) {
		setSteentjes(getSteentjes() + adder);		
	}
	
	public Bakje getBuurman(int n){
		if (n==1){
			return buurman;
		}
		else{
			return buurman.getBuurman(n-1);
		}
	}
	
	public void wisselBeurt(){
		getOverBuurman().getEigenaar().switchBeurt();
		getEigenaar().switchBeurt();
	}
	
	public boolean checkEinde(Bakje bron){
		boolean einde = true;
		if (getEigenaar().getBeurt() && getSteentjes() != 0 && !isKahala()){
			return false;
		}
		if (getBuurman() != bron){
			einde =  getBuurman().checkEinde(bron);
		}
		return einde;
	}
	
	public Bakje getOverBuurman() {
		return null; // overridden
	}
	
	public Bakje getBuurman(){
		return buurman;
	}
	
	public void startBeurt(){	}

	public int getSteentjes() {
		return steentjes;
	}

	public void setSteentjes(int steentjes) {
		this.steentjes = steentjes;
	}

	public void setBuurman(Bakje buurman) {
		this.buurman = buurman;
	}

	public Speler getEigenaar() {
		return eigenaar;
	}

	public void setEigenaar(Speler eigenaar) {
		this.eigenaar = eigenaar;
	}

	public boolean isKahala() {
		return kahala;
	}

	public void setKahala(boolean kahala) {
		this.kahala = kahala;
	}
}
