package main.Chess;

//base attributes and methods for all chess pieces
//import extraMethods.Input;
public class piece{
	protected int xLocation;
	protected int yLocation;
	protected boolean alive;
	protected boolean isWhite;

	public piece(int x, int y, boolean start){
		xLocation=x;
		yLocation=y;
		alive=true;
		isWhite=start;
	}

	public void kill(){
		alive=false;
		board.clear(getXLoc(),getYLoc());
	}

	public int getXLoc(){
		return xLocation;
	}

	public int getYLoc(){
		return yLocation;
	}
}
