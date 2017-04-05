package nl.sogyo.mancala;

public class Mancala{
	private SubBakje initBakje;
	
	public Mancala(){
		initBakje = new SubBakje();
	}
	
	public int getSpeler(){
		if (initBakje.getEigenaar().isBeurt()){
			return 1;
		}
		else if (initBakje.getOverBuurman().getEigenaar().isBeurt()){
			return 2;
		}
		else{
			return -1;
		}
	}

	public void input(int answer, int speler) {
		SubBakje bakje;
		if (speler == 2){
			bakje = (SubBakje) initBakje.getBuurman(7);
		}
		else{
			bakje = initBakje;
		}
		if(answer==0){
			bakje.startBeurt();
			}
		else{
			((SubBakje) bakje.getBuurman(answer)).startBeurt();
			}
		}

	public int getBakje(int nummer) {
		Bakje bakje;
		if (nummer ==0){
			bakje = initBakje;
		}
		else{
			bakje =  initBakje.getBuurman(nummer);
			}
		return bakje.getSteentjes();
	}
}
