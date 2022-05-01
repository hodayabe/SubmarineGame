package submarineGame.gamer;

import java.util.Scanner;

import submarineGame.Submarine.Submarine;
import submarineGame.board.Board;

public class Gamer {
	private final int START_POINTS=1000;
	private final int NUM_OF_GUESSES=100;
	private int gusses;
	private int points;
	private Board board;
	private int goodSubmarine;
	private int hits;
	private int miss;
	boolean flag=false;


	public Gamer() {
		this.board=new Board();	
		this.points=START_POINTS;
		this.gusses=NUM_OF_GUESSES;
		this.goodSubmarine=0;
		this.hits=0;
		this.miss=0;
	}

	public Board getBoard() {
		return board;
	}


	public void makeAllGusses(){
		while(gusses>0 && points>0) {
			 makeGusses();
			}
	}
	
	private void makeGusses(){
		Scanner scan = new Scanner(System.in);
		System.out.println(" 0< X < 10");
		int x= scan.nextInt();
		System.out.println(" 0< Y < 20");
		int y= scan.nextInt();
		flag=checkeGusses(x, y, flag);
		this.board.printBoard(this.board.getUserBoard());
		System.out.println("points: "+ points +" hitts: "+ hits+" miss: "+miss);
	}

		
	private boolean checkeGusses(int x, int y ,boolean flag){
		
		if(flag && this.board.getSubBoard()[x][y]=='s') {
			this.board.setIndexInUserBoard(x,y,'H');
			points+=1000;
		return true;
		}
		
		if(this.board.getSubBoard()[x][y]=='s') {
			this.board.setIndexInUserBoard(x,y,'H');
			points+=200;
			return true;
		}
		

		this.board.setIndexInUserBoard(x,y,'M');
		points-=10;
		return false;
	}
	
	
	

}
