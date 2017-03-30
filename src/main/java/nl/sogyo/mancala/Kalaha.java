package nl.sogyo.mancala;

public class Kalaha extends Bakje {
	
	public Kalaha(SubBakje initBakje, int counter,Speler eigenaarRij){
		super(0);
		this.setEigenaar(eigenaarRij);
		if (counter>3){
			this.setBuurman(new SubBakje(initBakje,counter-1,new Speler(false)));
		}
		else{
			this.setBuurman(initBakje);
		}	
	}
	
	public void doorgeven(int hand, Speler bron) {
		if (getEigenaar() == bron){
			super.doorgeven(hand, bron);
		}
		else{
			getBuurman().doorgeven(hand,bron);
		}
	}
}
