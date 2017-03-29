package nl.sogyo.mancala;

abstract class Bakje {
	int steentjes;
	Bakje buurman;
	
	public void doorgeven(int hand) {
		buurman.addInhoud(1);
		hand --;
		if (hand>0){
			buurman.doorgeven(hand);
		}
	}
	
	public void addInhoud(int adder) {
		steentjes += adder;		
	}
	
	
	public Bakje getBuurman() {
		return buurman;
	}
	
	public int getInhoud() {
		return steentjes;
	}
}
