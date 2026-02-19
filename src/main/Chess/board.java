package main.Chess;

import java.util.InputMismatchException;

import main.extraMethods.input;

public class board {
	final static piece[][] location= new piece[8][8]; //chess is 8x8 fixed. Does not need a method to initialize

	//supposed to be 2d array that only tells if the board is occupied or not. 
	//May need many changes such as making it a array of pieces
	//This board is orientated so that the white pieces are at the bottom and the black are at the to

	public static void clear(int x, int y){
		location[x][y]=null;
	}

	public static setPiece(){
		String answer;
		try {
			answer=System.console().readLine().toLowerCase();
		} catch (InputMismatchException e){
			System.out.println("That is not an option");
		}
	}
}
