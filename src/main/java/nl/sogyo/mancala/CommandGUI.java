package nl.sogyo.mancala;

import java.util.Scanner;

public class CommandGUI {
	public static void main(String[] args){
		Mancala spel = new Mancala();
		CommandGUI gui = new CommandGUI();
		boolean einde = false; 
		while (!einde){
			gui.printField(spel);
			einde = gui.turn(spel);
		}
	}
	
	void printField(Mancala spel){
		System.out.print("  |");
		for (int i =12 ; i>6 ; i--){
			System.out.print(spel.getBakje(i)+"|");
		}
		System.out.println(" ");
		
		System.out.println(spel.getBakje(13)+"---------------"+spel.getBakje(6));
		
		System.out.print("  |"+spel.getBakje(0)+"|");
		for (int i =1 ; i<6 ; i++){
			System.out.print(spel.getBakje(i)+"|");
		}
		System.out.println(" ");
	}
	
	boolean turn(Mancala spel){
		if (spel.getSpeler() == 1){
			System.out.println("Speler 1 is aan de Beurt.");
			vraagInput(spel, 1);
			return false;
		}
		else if(spel.getSpeler() == 2){
			System.out.println("Speler 2 is aan de Beurt.");
			vraagInput(spel,2);
			return false;
		}
		else{
			System.out.println("Player 1 score: "+spel.getBakje(7));
			System.out.println("Player 2 score: "+spel.getBakje(13));
			return true;
		}
	}
	
	void vraagInput(Mancala spel, int speler){
		Scanner reader = new Scanner(System.in);
		System.out.print("Kies je bakje! (1-6): ");
		String input = reader.nextLine();
		int answer = Integer.parseInt(input)-1;
		spel.input(answer, speler);
	}
}