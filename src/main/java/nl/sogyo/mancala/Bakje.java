package nl.sogyo.mancala;

abstract class Bakje {
	private int steentjes;
	private Bakje buurman;
	
	public Bakje(int steentjes){
		this.steentjes = steentjes;
	}
	
	public void doorgeven(int hand) {
		if (hand>0){
			getBuurman().addInhoud(1);
			getBuurman().doorgeven(hand-1);
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
}
