package nl.sogyo.mancala;

public class SubBakje extends Bakje {
	private static int subBakjeTeller = 0;

	public SubBakje(){
		this.steentjes = 4;
		subBakjeTeller ++;
		if (subBakjeTeller%6!=0){
			this.buurman = new SubBakje();
		}
		else{
			this.buurman = new Kalaha();
		}
	}
	
	void setInhoud(int setter){
		steentjes = setter;
	}

	public Bakje getBuurman(int n){
		Bakje nthBuurman = getBuurman();
		
		while(n>1){
			nthBuurman = nthBuurman.getBuurman();
			n--;
		}
		return nthBuurman;
	}

	public void startBeurt() {
		doorgeven(leeghalen());
	}

	public int leeghalen() {
		int hand = getInhoud();
		setInhoud(0);
		return hand;
	}

}
