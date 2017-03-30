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
		this.setEigenaar(eigenaarRij);
		if (counter%6!=0){
			this.setBuurman(new SubBakje(initBakje,counter-1,eigenaarRij));
		}
		else{
			this.setBuurman(new Kalaha(initBakje,counter,eigenaarRij));
		}
	}
	
	public Bakje getOverBuurman() {
		int steps = stepsToKahala(0);
		return getBuurman(steps*2);
	}
	
	public int stepsToKahala(int counter){
		if (getBuurman().isKahala()){
			return counter+1;
		}
		else{
			return (((SubBakje) getBuurman()).stepsToKahala(counter+1));
		}
	}
	
	public void doorgeven(int hand, Speler bron) {
		if (getBuurman().getEigenaar() != bron && getBuurman().isKahala()){
			getBuurman().doorgeven(hand,bron);
		}
		else if (hand==1 && getBuurman().isKahala()){
			wisselBeurt();
			super.doorgeven(hand, bron);
		}
		else{
			super.doorgeven(hand, bron);
		}
		if(hand==0){
			if (getSteentjes()==1){
				hand = leeghalen() + ((SubBakje) getOverBuurman()).leeghalen();
				getBuurman(stepsToKahala(0)).addInhoud(hand);
			}
		}
	}
	


	void setInhoud(int setter){
		setSteentjes(setter);
	}

	public void startBeurt() {
		if (getSteentjes()!=0){
			int hand = leeghalen();
			doorgeven(hand,getEigenaar());
			wisselBeurt();
		}
	}

	
	public int leeghalen() {
		int hand = getSteentjes();
		setInhoud(0);
		return hand;
	}

}
