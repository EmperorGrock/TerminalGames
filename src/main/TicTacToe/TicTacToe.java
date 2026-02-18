package main.TicTacToe;

import main.extraMethods.TwoDHelper;
import main.extraMethods.Input;
public class TicTacToe{
	private static int player = 1;

	public static TwoDHelper board = new TwoDHelper(3,3);

	public static void executeNormalTicTacToe(){
		boolean hasWon = false;
		int inputNum;
		System.out.println("To type coordinates, type two number coordinates in a row, as in: 12");
		while(!hasWon){
			board.printMap();
			System.out.println("It is player " + player + "'s turn!");
			inputNum = Input.getInt("Enter Coords");
			placeMarker(inputNum);
			if(checkForWin()){
				hasWon = true;
				board.printMap();
				System.out.println("Player " + player + " has won!");
			}
			if(player == 1) player = 2;
			else if(player == 2) player = 1;
		}
	}

	public static void placeMarker(int input){
		int y = input % 10;
		int x = input / 10;
		processCoordinates(x,y);
	}

	public static void processCoordinates(int first, int second) throws IllegalArgumentException{
		if(board.getLocation(first, second).equals(" ")){
			if(player == 1){
				board.editCoord("x", first, second);
			}else if(player == 2){
				board.editCoord("o", first, second);
			}
		}else throw new IllegalArgumentException("That space is occupied");
	}

	public static boolean checkForWin(){
		boolean result = false;
		//Check for Vertical
		
		for(int i = 1; i <= board.getYMax(); i++){
			if(board.getLocation*)
			for(int j = 1; j <= board.getXMax(); j++){
				
			}
		}
		//check for Horizontaf
		for(int i = 1; i <= 3; i++){
			if((board.getLocation(i,1).equals(board.getLocation(i,2))&&board.getLocation(i,1).equals(board.getLocation(i,3))) && !(board.getLocation(i,1).equals(" "))){
				result = true;
			}
		}
		//Check for Diagonals
		if((board.getLocation(1,1).equals(board.getLocation(2,2))&&board.getLocation(1,1).equals(board.getLocation(3,3)))&&!(board.getLocation(1,1).equals(" "))){
			result = true;
		}else if((board.getLocation(1,3).equals(board.getLocation(2,2))&&board.getLocation(1,3).equals(board.getLocation(3,1)))&&!(board.getLocation(1,3).equals(" "))){
			result = true;
		}

		return result;
	}

	public static void main(String[] args){
		executeNormalTicTacToe();
	}
}