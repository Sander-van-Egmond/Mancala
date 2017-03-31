package nl.sogyo.mancala;

public class Speler {
	private boolean beurt;

	public Speler(boolean beurt){
		this.beurt = beurt;
	}
	
	public boolean getBeurt() {
		return beurt;
	}
	
	public void setBeurt(boolean beurt) {
		this.beurt = beurt;
	}

	public void switchBeurt(){
		this.beurt = !this.beurt;
	}
}
