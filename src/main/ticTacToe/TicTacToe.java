package main.tictactoe;

import main.extramethods.Input;
import main.extramethods.TwoDHelper;
import main.extramethods.Terminal;

/**
 * A simple implementation of the classic Tic-Tac-Toe game, using the TwoDHelper class to manage the game board and the Input class to handle user input.
 * Built for the TerminalGames app. 
 * @author EmperorGrock
 * @author invisiblekoi
 */
public class TicTacToe{
	private int player;
	private TwoDHelper board;

	public TicTacToe(){}

	public void executeTicTacToe(int size){
		player = 1;
		board = new TwoDHelper(size, size);
		boolean hasWon = false;
		while(!hasWon){
			board.printWideMap();
			if(player == 1)
				Terminal.printlnWithFormat("It is player 1's turn!", 1, 4);
			else
				Terminal.printlnWithFormat("It is player 2's turn!", 4, 4);
			Terminal.textEdit(2,1);
			int x = Input.getInt("X Coordinate", 1, size);
			int y = Input.getInt("Y Coordinate", 1, size);
			Terminal.clearFormat();
			if(!processCoordinates(x, y)){
				Terminal.printlnWithFormat("That space is occupied. Try again.", 5, 3);
				continue;
			}
			if(checkForWin(board)){
				hasWon = true;
				board.printWideMap();
				if(player == 1)
					Terminal.printlnWithFormat("Player 1 has won!", 1, 4);
				else
					Terminal.printlnWithFormat("Player 2 has won!", 4, 4);
			}else if(checkForTie()){
				hasWon = !Input.getYesNo("It's a tie! Would you like to play again?");
			}
			if(player == 1) player++;
			else player--;
		}
	}

	private boolean processCoordinates(int first, int second){
		if(board.getLocation(first, second).equals(" ")){
			if(player == 1){
				board.editCoord(Terminal.RED + "x" + Terminal.CLEAR, first, second);
				return true;
			}else if(player == 2){
				board.editCoord(Terminal.BLUE + "o" + Terminal.CLEAR, first, second);
				return true;
			}
		}
		return false;
	}
	
	private boolean checkForTie(){
		boolean allFull = true;
		for(int i = 1; i <= board.getXMax(); i++)
			for(int j = 1; j <= board.getYMax(); j++)
				if(board.getLocation(i, j).equals(" "))
					allFull = false;
		if(allFull){
			board.clearMap();
			return true;
		}
		return false;
			
	}

	private static boolean checkDiagonal(TwoDHelper array){
		//Get the top corners
		String topLeft = array.getLocation(1,1);
		String topRight = array.getLocation(array.getXMax(), 1);

		//If the top left corner has been played, check the diagonal until one doesnt match, then break. 
		//If it goes all teh way through, return true
		if(!topLeft.equals(" ")){
			int coord = 2;
			while(coord <= array.getXMax()){
				if(!topLeft.equals(array.getLocation(coord, coord))){
					break;
				}
				if(coord == array.getXMax())
					return true;
				coord++;
			}
		}

		//Same as the other, but adapted for the top right corner, so the x coordinate is calculated differently
		if(!topRight.equals(" ")){
			int coord = 2;
			while(coord <= array.getXMax()){
				if(!topRight.equals(array.getLocation(array.getXMax()+1-coord, coord))){
					break;
				}
				if(coord == array.getXMax())
					return true;
				coord++;
			}
		}
		return false;
	}

	private static boolean checkHorizontal(TwoDHelper array){
		for(int y = 1; y <= array.getYMax(); y++){
			String spaceOne = array.getLocation(1,y);
			if(!spaceOne.equals(" ")){
				for(int x = 2; x <= array.getXMax(); x++){
					if(!spaceOne.equals(array.getLocation(x,y))){
						break;
					}
					if(x == array.getXMax())
						return true;
				}

			}
		}
		return false;
	}

	private static boolean checkVertical(TwoDHelper array){
		for(int x = 1; x <= array.getXMax(); x++){
			String spaceOne = array.getLocation(x,1);
			if(!spaceOne.equals(" ")){
				for(int y = 2; y <= array.getYMax(); y++){
					if(!spaceOne.equals(array.getLocation(x,y))){
						break;
					}
					if(y == array.getYMax())
						return true;
				}

			}
		}
		return false;
	}

	public static boolean checkForWin(TwoDHelper array){
		if(checkDiagonal(array)||checkHorizontal(array)||checkVertical(array))
			return true;
		return false;
	}

	void main(){
		int tictac = Input.getInt("Which size tictactoe do you want? (3-5)", 3, 5);
		TicTacToe test = new TicTacToe();
		test.executeTicTacToe(tictac);
	}
}