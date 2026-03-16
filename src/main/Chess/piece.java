package main.chess;
import main.extramethods.*;

//base attributes and methods for all chess pieces
//import extraMethods.Input;
public class Piece{
	protected int xLocation;
	protected int yLocation;
	protected boolean alive;
	protected boolean isWhite;
	protected String look;

	public Piece(int x, int y, boolean start){
		xLocation=x;
		yLocation=y;
		alive=true;
		isWhite=start;
	}

	public void kill(){
		alive=false;
		Board.clear(getXLoc(),getYLoc());
	}

	public int getXLoc(){
		return xLocation;
	}

	public int getYLoc(){
		return yLocation;
	}
}
