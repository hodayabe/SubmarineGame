package submarineGame.Submarine;

import java.util.Random;

public class Submarine {
	private final int MAX_SIZE=4;
	private int size;
	protected int[] xIndex;
	private int[] yIndex;


	//Constructor
	public Submarine() {
		this.size =createRandomSize(MAX_SIZE-1)+1;
//		this.size =4;
		this.xIndex=new int[size];
		this.yIndex=new int[size];
	}

	//getters and setters
	
	public int getSize() {
		return size;
	}
	
	public int[] getxIndex() {
		return xIndex;
	}
	
	public int[] getyIndex() {
		return yIndex;
	}

	//methods
	private int createRandomSize(int maxSize) {
		Random random = new Random();
		int size = random.nextInt(maxSize);
		return size;
	}


	public void createRandomStartIndex(int xSize,int YSize) {
		this.xIndex[0]= createRandomSize(xSize);
		this.yIndex[0]= createRandomSize(YSize);
	}

	
	public void putValueInIndex(int k, int i, int j) {
		this.xIndex[k]=i;
		this.yIndex[k]=j;
	}



}



