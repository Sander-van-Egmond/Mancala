package nl.sogyo.mancala;

abstract class Bakje {
	private int steentjes;
	private Bakje buurman;
	private Speler eigenaar;
	private boolean kahala;
	
	Bakje(int steentjes){
		this.steentjes = steentjes;
		this.setKahala(false);
	}
	
	void doorgeven(int hand, Speler bron) {
		if (hand>0){
			getBuurman().addInhoud(1);
			getBuurman().doorgeven(hand-1,bron);
		}
	}
	
	void addInhoud(int adder) {
		setSteentjes(getSteentjes() + adder);		
	}
	
	Bakje getBuurman(int n){
		if (n==1){
			return buurman;
		}
		else{
			return buurman.getBuurman(n-1);
		}
	}
	
	void wisselBeurt(){
		getOverBuurman().getEigenaar().switchBeurt();
		getEigenaar().switchBeurt();
	}
	
	boolean checkEinde(Bakje bron){
		boolean einde = true;
		if (getEigenaar().isBeurt() && getSteentjes() != 0 && !isKahala()){
			return false;
		}
		if (getBuurman() != bron){
			einde =  getBuurman().checkEinde(bron);
		}
		return einde;
	}
	
	abstract Bakje getOverBuurman();
	
	Bakje getBuurman(){
		return buurman;
	}

	int getSteentjes() {
		return steentjes;
	}

	void setSteentjes(int steentjes) {
		this.steentjes = steentjes;
	}

	void setBuurman(Bakje buurman) {
		this.buurman = buurman;
	}

	Speler getEigenaar() {
		return eigenaar;
	}

	void setEigenaar(Speler eigenaar) {
		this.eigenaar = eigenaar;
	}

	boolean isKahala() {
		return kahala;
	}

	void setKahala(boolean kahala) {
		this.kahala = kahala;
	}
}
