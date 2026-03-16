package main.tictactoe;

import main.extramethods.Input;
import main.extramethods.TwoDHelper;

/**
 * A simple implementation of the classic Tic-Tac-Toe game, using the TwoDHelper class to manage the game board and the Input class to handle user input.
 * Built for the TerminalGames app. 
 * @author EmperorGrock
 * @author invisiblekoi
 */
public class TicTacToe{
	private static int player = 1;

	public static TwoDHelper board;

	public static void executeNormalTicTacToe(){
		board = new TwoDHelper(3,3);
		boolean hasWon = false;
		System.out.println("To type coordinates, type two number coordinates in a row, as in: 12");
		while(!hasWon){
			board.printWideMap();
			System.out.println("It is player " + player + "'s turn!");
			int x = Input.getInt("X Coordinate", 1, 3);
			int y = Input.getInt("Y Coordinate", 1, 3);
			try{
				processCoordinates(x, y);
			} catch(IllegalArgumentException e){
				System.out.println("That space is occupied. Try again.");
				continue;
			}
		if(checkForWin()){
			hasWon = true;
			board.printWideMap();
			System.out.println("Player " + player + " has won!");
		}else if(checkForTie()){
			hasWon = !Input.getYesNo("It's a tie! Would you like to play again?");
		}
		if(player == 1) player = 2;
		else if(player == 2) player = 1;
		}
	}

	

	public static void processCoordinates(int first, int second) throws IllegalArgumentException{
		if(board.getLocation(first, second).equals(" ")){
			if(player == 1){
				board.editCoord("x", first, second);
			}else if(player == 2){
				board.editCoord("o", first, second);
			}
		}else throw new IllegalArgumentException();
	}
	
	public static boolean checkForTie(){
		boolean allFull = true;
		for(int i = 1; i < board.getXMax() + 1; i++)
			for(int j = 1; j < board.getYMax() + 1; j++)
				if(board.getLocation(i, j).equals(" "))
					allFull = false;
		if(allFull){
			board.clearMap();
			return true;
		}
		return false;
			
	}


	public static boolean checkForWin(){
		boolean result = false;

		//Check for Horizontal
		for(int i = 1; i <= board.getYMax(); i++){
			if((board.getLocation(1,i).equals(board.getLocation(2,i))&&board.getLocation(1,i).equals(board.getLocation(3,i))) && !(board.getLocation(1,i).equals(" "))){
				result = true;
			}
		}

		//check for Vertical
		for(int i = 1; i <= board.getXMax(); i++){
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