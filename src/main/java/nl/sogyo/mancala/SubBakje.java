package nl.sogyo.mancala;

public class SubBakje extends Bakje {

	public SubBakje(){
		super(4);
		this.setBuurman(new SubBakje(this,11));
	}
	
	public SubBakje(int steentjes){
		super(steentjes);
		this.setBuurman(new SubBakje(this,11));
	}
	public SubBakje(SubBakje initBakje,int counter){
		super(4);
		if (counter%7!=0){
			this.setBuurman(new SubBakje(initBakje,counter-1));
		}
		else{
			this.setBuurman(new Kalaha(initBakje,counter-1));
		}
	}
	
	void setInhoud(int setter){
		setSteentjes(setter);
	}


	public void startBeurt() {
		doorgeven(leeghalen());
	}

	public int leeghalen() {
		int hand = getSteentjes();
		setInhoud(0);
		return hand;
	}

}
