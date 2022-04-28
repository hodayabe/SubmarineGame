package submarineGame.gamer;

import submarineGame.Submarine.Submarine;
import submarineGame.board.Board;

public class Gamer {
	
	public void run() {
		Board b=new Board();
		Submarine sub=new Submarine();
		
		b.putSubmarineInBoard(sub);
		
		System.out.println("SubBoard");
//		System.out.println("--------------------------\r\n");
		b.printBoard(b.getSubBoard());
		System.out.println("--------------------------\r\n");
		
		System.out.println("UserBoard");
		b.printBoard(b.getUserBoard());
		
	}

}
