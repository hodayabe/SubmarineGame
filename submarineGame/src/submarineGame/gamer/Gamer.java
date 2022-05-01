package submarineGame.gamer;

import submarineGame.Submarine.Submarine;
import submarineGame.board.Board;

public class Gamer {
	private final int GUESSES=100;
	private int points;
	private Board board;
	
	public Gamer() {
		this.board=new Board();
		Submarine[] submarines= new Submarine[5];
		submarines[0]=new Submarine();
		submarines[1]=new Submarine();
		submarines[2]=new Submarine();
		submarines[3]=new Submarine();
		submarines[4]=new Submarine();

		
	}
	
	
	public void run() {
		this.board.putAllSubmarineInBoard();
		
		System.out.println("SubBoard");
		this.board.printBoard(this.board.getSubBoard());
		
		System.out.println("\r--------------------------\r\n");
		
		System.out.println("UserBoard");
		this.board.printBoard(this.board.getUserBoard());
		
	}

}
