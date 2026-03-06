package main.chess;

import java.util.*;

import main.extramethods.*;
public class Pawn extends Piece{
	//creates a pawn at given location. Make sure it is not illegal
	private boolean enPassentPossible;
	private boolean doubleStep;
	private int moveCount;

	public Pawn(int x, int y, boolean start){
		super(x,y,start);
		enPassentPossible=true;
		doubleStep=true;
	}

	//kills the pawn when captured
	public void kill(){
		super.kill();
	}

	//The normal move
	public void move(){
		if (this.isWhite){
			yLocation+=1;
			moveCount+=1;
			this.doubleStep=false;
		} else {
			yLocation-=1;
			moveCount+=1;
			this.doubleStep=false;
		}
	}

	//Double move
	public void doubleMove(){
		if (this.isWhite){
			yLocation+=2;
			moveCount+=1;
			this.doubleStep=false;
		} else {
			yLocation-=2;
			moveCount+=1;
			this.doubleStep=false;
		}
	}

	//true is for right and false is left. Dont ask me why. Thats how it is.
	public void capture(Piece victim, boolean direction){
		if (this.isWhite){
			yLocation+=1; //Moves up the board
			if (direction){ //Then moves either left or right
				xLocation+=1;
			} else {
				xLocation-=1;
			}
		} else {
			yLocation-=1; //Comes down the board
			if (direction){
				xLocation-=1; //Moves oppsite of what white would due to flipped orientation
			} else {
				xLocation+=1;
			}
		}
		victim.kill(); //The victim pawn is killed and its space is cleared on the board
		Board.setPiece(this, this.xLocation,this.yLocation);//Moves the chess piece to the location desired
	}

	public void promotion(){
		this.kill();//Kills the existing pawn
		String[] options={"Queen","Rook","Bishop","Knight"};
		int choice=Input.advancedAsk("What do you wish to promote your pawn to?",options); //returns user choice between the options

		if (choice==1){
			//calls constructor for queen and stores location information of pawn
			//calls method that switches the pawn in the board array
		} else if (choice==2){
			//calls constructor for rook and stores location information of pawn
			//calls method that switches the pawn in the board array
		}else if(choice==3){
			//calls constructor for bishop and stores locaiton information of pawn
			//calls method that switches the pawn in the board array
		}else if(choice==4){
			//calls constructor for knight and stores location information of pawn
			//calls method that switches the pawn in the board array
		}
		
	}

	public boolean getEnPassent(){
		return enPassentPossible;
	}

	public boolean getDoubleStep(){
		return doubleStep;
	}

	public boolean getAlive(){
		return alive;
	}

	public boolean checkWhite(){
		return isWhite;
	}

	public int getXLoc(){
		return xLocation;
	}

	public int getYLoc(){
		return yLocation;
	}

	public int getMoveCount(){
		return moveCount;
	}

}
