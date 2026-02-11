public class board {
	final boolean[] x;
	final boolean[] y;
	boolean occupied;

	//supposed to be 2d array that only tells if the board is occupied or not. 
	//May need many changes such as making it a array of pieces
	//This board is orientated so that the white pieces are at the bottom and the black are at the top
	public board(int xSize, int ySize){
		x=new boolean[xSize];
		y=new boolean[ySize];
	}
}
