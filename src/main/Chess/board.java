public class board {
	final boolean[] x;
	final boolean[] y;
	boolean occupied;

	public board(int xSize, int ySize){
		x=new boolean[xSize];
		y=new boolean[ySize];
	}
}
