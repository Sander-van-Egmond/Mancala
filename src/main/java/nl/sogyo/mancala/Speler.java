package nl.sogyo.mancala;

public class Speler {
	private boolean beurt;

	Speler(boolean beurt){
		this.beurt = beurt;
	}
	
	boolean isBeurt() {
		return beurt;
	}
	
	void setBeurt(boolean beurt) {
		this.beurt = beurt;
	}

	void switchBeurt(){
		this.beurt = !this.beurt;
	}
}
