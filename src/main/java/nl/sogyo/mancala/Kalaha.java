package nl.sogyo.mancala;

public class Kalaha extends Bakje {
	
	public Kalaha(SubBakje initBakje, int counter){
		super(0);
		if (counter>3){
			this.setBuurman(new SubBakje(initBakje,counter-1));
		}
		else{
			this.setBuurman(initBakje);
		}
		
	}
}
