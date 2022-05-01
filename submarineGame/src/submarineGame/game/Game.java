package submarineGame.game;

import submarineGame.gamer.Gamer;

public class Game {
	private Gamer gamer;

	
	
	public Game() {
		this.gamer=new Gamer();
	}
	
	public void run() {
		this.gamer.getBoard().putAllSubmarineInBoard();
		
		System.out.println("SubBoard");
		this.gamer.getBoard().printBoard(this.gamer.getBoard().getSubBoard());
		
		System.out.println("\r-------------------------------------------------\r\n");
		
		System.out.println("UserBoard");
		this.gamer.getBoard().printBoard(this.gamer.getBoard().getUserBoard());
		this.gamer.makeAllGusses();
		
		
	}
}
