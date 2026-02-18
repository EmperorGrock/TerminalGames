package main.Chess;

import java.util.*;
import main.extraMethods.*;
public class pawn extends piece{
	//creates a pawn at given location. Make sure it is not illegal
	private boolean enPassentPossible;
	private boolean doubleStep;
	private int moveCount;

	public pawn(int x, int y, boolean start){
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
	public void enPassent(pawn victim, boolean direction){
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
			} else{
				xLocation+=1;
			}
		}
		victim.kill(); //The victim pawn is killed
	}

	public void capture(piece victim, boolean direction){
		if (this.isWhite){
			yLocation+=1;
			if (direction){
				xLocation+=1;
			} else {
				xLocation-=1;
			}
		} else {
			yLocation-=1;
			if (direction){
				xLocation-=1;
			} else {
				xLocation+=1;
			}
		}
		victim.kill(); //The victim pawn is killed
	}

	public void promotion(){
		this.kill();//Kills the existing pawn
		Scanner promotion=new Scanner(System.in);//creates scanner that checks user input
		int choice=-1;//This stores the user choice. Initialized to impossible value

		//prompts user to choose type of promotion
		System.out.println("""
			
			What do you wish to promote your pawn to?
			1. Queen
			2. Rook
			3. Bishop
			4. Knight

		""");
		//Loops until the user inputs correct type
		while (true){
			try{
				choice=promotion.nextInt();
				if (choice<1||choice>4){
					System.out.println("Please enter a number between 1~4");
					System.out.println("""
			
						What do you wish to promote your pawn to?
						1. Queen
						2. Rook
						3. Bishop
						4. Knight

					""");
					promotion.nextLine();
					continue; //if it is a undesired value it reprompts the user again and restarts the loop
				}
				break;
			} catch (InputMismatchException e) {//if the user inputs invalid value(ie string) it loops back
				System.out.println("That is an invalid chocie");
				System.out.println("""
			
					What do you wish to promote your pawn to?
					1. Queen
					2. Rook
					3. Bishop
					4. Knight

				""");
			promotion.nextLine();
			}
		}
		promotion.close();//close scanner

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
			//calls constructor for kniight and stores location information of pawn
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
