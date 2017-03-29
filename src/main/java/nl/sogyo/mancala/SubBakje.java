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
	
	public int leeghalen() {
		int hand = getInhoud();
		setInhoud(0);
		return hand;

	}
	
	void setInhoud(int setter){
		steentjes = setter;
	}

	public int getInhoud() {
		return steentjes;
	}


	public SubBakje getBuurman() {
		return buurman;
	}

	public void startBeurt() {
		doorgeven(leeghalen());
	}

	private void doorgeven(int hand) {
		buurman.ontvangen(hand);
	}

	private void ontvangen(int hand) {
		addInhoud(1);
	}

	private void addInhoud(int adder) {
		steentjes += adder;		
	}
}
