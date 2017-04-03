package nl.sogyo.mancala;

import java.util.Arrays;

public class SubBakje extends Bakje {

	public SubBakje(){
		this(4);
	}
	
	public SubBakje(int steentjes){
		this(new int[]{steentjes});
	}
	
	public SubBakje(int[] array){
		super(array[0]);
		int[] newArray = Arrays.copyOfRange(array, 1, array.length);
		if (newArray.length == 0){
			newArray = new int[]{4};
		}
		this.setEigenaar(new Speler(true));
		this.setBuurman(new SubBakje(this,10,this.getEigenaar() ,newArray));
	}
	
	public SubBakje(SubBakje initBakje,int counter, Speler eigenaarRij, int[] array){
		super(array[0]);
		this.setEigenaar(eigenaarRij);
		int[] newArray = Arrays.copyOfRange(array, 1, array.length);
		if (counter%6!=0){
			if (newArray.length == 0){
				newArray = new int[]{4};
			}
			this.setBuurman(new SubBakje(initBakje,counter-1,eigenaarRij, newArray));
		}
		else{
			if (newArray.length == 0){
				newArray = new int[]{0};
			}
			this.setBuurman(new Kalaha(initBakje,counter,eigenaarRij, newArray));
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
			if (getSteentjes()==1 && getEigenaar().isBeurt()){
				hand = leeghalen() + ((SubBakje) getOverBuurman()).leeghalen();
				getBuurman(stepsToKahala(0)).addInhoud(hand);
			}
		}
	}
	
	void setInhoud(int setter){
		setSteentjes(setter);
	}

	public void startBeurt() {
		if (getSteentjes()!=0 && getEigenaar().isBeurt()){
			int hand = leeghalen();
			doorgeven(hand,getEigenaar());
			wisselBeurt();
			if (checkEinde(this) && getEigenaar().isBeurt()){
				getEigenaar().switchBeurt();
			}
			if (checkEinde(this) && getOverBuurman().getEigenaar().isBeurt()){
				getOverBuurman().getEigenaar().switchBeurt();
			}
		}
	}
	

	
	public int leeghalen() {
		int hand = getSteentjes();
		setInhoud(0);
		return hand;
	}
}
