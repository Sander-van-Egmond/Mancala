package nl.sogyo.mancala;

public class SubBakje {
	private int steentjes;
	private SubBakje buurman;
	private static int subBakjeTeller = 0;

	public SubBakje(){
		this.steentjes = 4;
		subBakjeTeller ++;
		if (subBakjeTeller%6!=0){
			this.buurman = new SubBakje();
		}
	}
	
	void setInhoud(int setter){
		steentjes = setter;
	}

	public int getInhoud() {
		return steentjes;
	}

	private void addInhoud(int adder) {
		steentjes += adder;		
	}
	
	public SubBakje getBuurman() {
		return buurman;
	}
	
	public SubBakje getBuurman(int n){
		SubBakje nthBuurman = getBuurman();
		
		while(n>1){
			nthBuurman = nthBuurman.getBuurman();
			n--;
		}
		
		return nthBuurman;
	}

	public void startBeurt() {
		doorgeven(leeghalen());
	}

	private void doorgeven(int hand) {
		buurman.addInhoud(1);
		hand --;
		if (hand>0){
			buurman.doorgeven(hand);
		}
	}
	
	public int leeghalen() {
		int hand = getInhoud();
		setInhoud(0);
		return hand;
	}


}
