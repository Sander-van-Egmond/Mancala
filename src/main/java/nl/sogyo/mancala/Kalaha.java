package nl.sogyo.mancala;

import java.util.Arrays;

public class Kalaha extends Bakje {
	
	public Kalaha(SubBakje initBakje, int counter,Speler eigenaarRij, int[] array){
		super(array[0]);
		int[] newArray = Arrays.copyOfRange(array, 1, array.length);
		if (newArray.length == 0) {
			newArray = new int[]{4};			
		}
		this.setEigenaar(eigenaarRij);
		this.setKahala(true);
		if (counter>3){
			this.setBuurman(new SubBakje(initBakje,counter-1,new Speler(false), newArray));
		}
		else{
			this.setBuurman(initBakje);
		}	
	}
	
	public Bakje getOverBuurman() {
		return getBuurman(7);
	}
}