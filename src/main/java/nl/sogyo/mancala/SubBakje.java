package nl.sogyo.mancala;

public class SubBakje extends Bakje {

	public SubBakje(){
		this(4);
	}
	
	public SubBakje(int steentjes){
		super(steentjes);
		this.setEigenaar(new Speler(true));
		this.setBuurman(new SubBakje(this,10,this.getEigenaar()));
	}
	
	public SubBakje(SubBakje initBakje,int counter, Speler eigenaarRij){
		super(4);
		if (counter%6!=0){
			this.setBuurman(new SubBakje(initBakje,counter-1,eigenaarRij));
		}
		else{
			this.setBuurman(new Kalaha(initBakje,counter-1,eigenaarRij));
		}
	}
	
	void setInhoud(int setter){
		setSteentjes(setter);
	}

	public void startBeurt() {
		doorgeven(leeghalen(),getEigenaar());
	}

	public int leeghalen() {
		int hand = getSteentjes();
		setInhoud(0);
		return hand;
	}

}
