package submarineGame.board;


import java.util.Random;

import submarineGame.Submarine.Submarine;

public class Board {
	//fields
	private final int X_SIZE_OF_BOARD=10;
	private final int Y_SIZE_OF_BOARD=20;
	private final int NUM_OF_SUBMARINE=5;
	private char[][] userBoard;
	private char[][] subBoard;
	private Submarine[] submarines;


	//Constructor
	public Board() {
		initSubBoard();
		initUserBoard();
		initSubmarines();
	}

	//getters and setters

	public char[][] getUserBoard() {
		return userBoard;
	}

	public char[][] getSubBoard() {
		return subBoard;
	}
	
	
	public void setIndexInUserBoard(int x, int y,char c) {
		this.userBoard[x][y]=c;
	}
	
	

	private void initSubBoard() {
		subBoard=new char[X_SIZE_OF_BOARD+2][Y_SIZE_OF_BOARD+2];
		for (int i = 0; i < subBoard.length; i++) {
			for (int j = 0; j < subBoard[i].length; j++) {
				//make frame
				if( i==0 || i==subBoard.length-1 || j==0 || j==subBoard[i].length-1) 
					subBoard[i][j] ='-';
				else
					subBoard[i][j] =' ';
			}
		}
	}
	
	private void initUserBoard() {
		userBoard=new char[X_SIZE_OF_BOARD+2][Y_SIZE_OF_BOARD+2];
		for (int i = 0; i < userBoard.length; i++) {
			for (int j = 0; j < userBoard[i].length; j++) {
				//make frame
				if( i==0 || i==userBoard.length-1 || j==0 || j==userBoard[i].length-1) 
					userBoard[i][j] ='*';
				else
					userBoard[i][j] =' ';
			}
		}
	}


	private void initSubmarines() {
		submarines=new Submarine[NUM_OF_SUBMARINE];
		for (int i = 0; i < submarines.length; i++) {
			submarines[i]=new Submarine();
		}
	}


	public void printBoard(char [][]b) {
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[i].length; j++) {
				System.out.print(b[i][j]);
				System.out.print(' ');
			}
			System.out.println("");
		}
	}


	public void putAllSubmarineInBoard(){
		for (int i = 0; i < this.submarines.length; i++) {
			putSubmarineInBoard(this.submarines[i]);
		}
	}

	private void putSubmarineInBoard(Submarine submarine){
		int i,j;
//		 System.out.println("size: "+submarine.getSize());
		do {
			submarine.createRandomStartIndex(X_SIZE_OF_BOARD,Y_SIZE_OF_BOARD);
			i=submarine.getxIndex()[0];
			j=submarine.getyIndex()[0];
		}while(!isOk(i,j));
		
		this.subBoard[i][j]='c';
		if(submarine.getSize()<=1) {
			markSubmarine(submarine);
			return;
		}
			
		for (int k = 1; k < submarine.getSize(); k++) {
			int next=randomPlase();
			switch (next) {
			case 0: i++;//down
				break;
			case 1: i--;//up 
				break;
			case 2: j++; //right	
				break;
			case 3: j--;//left
				break;
			}

			if(isOk(i,j)){
				this.subBoard[i][j]='c';
				submarine.putValueInIndex(k,i,j);
			}
			else {
				deleteSubmarine(submarine,k);
				submarine.initIndexes();
				System.out.println("canot crate");
				putSubmarineInBoard(submarine);
			}
		}
		markSubmarine(submarine);
	}
	
	
	
	private void markSubmarine(Submarine submarine) {
		int i,j;
		for (int k = 0; k <submarine.getSize() ; k++) {
			i=submarine.getxIndex()[k];
			j=submarine.getyIndex()[k];
			subBoard[i][j] ='s';
			if(subBoard[i+1][j] !='s' && subBoard[i+1][j] !='#' && subBoard[i+1][j] !='-')//down
				subBoard[i+1][j] ='#';
			
			if(subBoard[i-1][j] !='s'&& subBoard[i+1][j] !='-')//up
				subBoard[i-1][j] ='#';
			
			if(subBoard[i][j+1] !='s'&& subBoard[i+1][j] !='-')//right
				subBoard[i][j+1] ='#';
			
			if(subBoard[i][j-1] !='s'&& subBoard[i+1][j] !='-')
				subBoard[i][j-1] ='#';//left
			
		}
	}
	
	
	private void deleteSubmarine(Submarine submarine,int k) {
		for (int i = 0; i <k ; i++) {
			if(submarine.getxIndex()[i]!=-1 &&submarine.getyIndex()[i]!=-1)
			subBoard[submarine.getxIndex()[i]][submarine.getyIndex()[i]] =' ';
		}
	}
	
	
	private int randomPlase() {
		Random random = new Random();
		int plase = random.nextInt(3);
		return plase;
	}


	private boolean isOk(int i,int j) {
		if(this.subBoard[i][j]=='s' || this.subBoard[i][j]=='#' || this.subBoard[i][j]=='-')//s-for submarine, f for submarine frame, - -for frame
			return false;
		return isUpOk(i,j) && isdownOk(i,j) && isRightOk(i,j) && isLeftOk(i,j) ;
	}


	private boolean isdownOk(int i,int j) {
		if(this.subBoard[i-1][j]=='s'|| this.subBoard[i-1][j]=='#'|| this.subBoard[i-1][j]=='-')
			return false;
		return true;
	}


	private boolean isUpOk (int i,int j) {
		if(this.subBoard[i+1][j]=='s'|| this.subBoard[i+1][j]=='#'|| this.subBoard[i+1][j]=='-')
			return false;
		return true;
	}


	private boolean isRightOk(int i,int j) {
		if(this.subBoard[i][j+1]=='s'|| this.subBoard[i][j+1]=='#'||this.subBoard[i][j+1]=='-')
			return false;
		return true;
	}

	private boolean isLeftOk(int i,int j) {
		if(this.subBoard[i][j-1]=='s'|| this.subBoard[i][j-1]=='#' || this.subBoard[i][j-1]=='-')
			return false;

		return true;
	}
}
