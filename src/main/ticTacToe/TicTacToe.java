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

	/**
	 * Default constructor.
	 */
	public TicTacToe(){}

	/**
	 * Executes the Tic-Tac-Toe game with the given board size.
	 * @param size the size of the board
	 */
	public void executeTicTacToe(int size){
		player = 1;
		board = new TwoDHelper(size, size);
		boolean hasWon = false;
		int round = 1;
		while(!hasWon){
			board.printWideMap();
			Terminal.printlnWithFormat("Round "+ round, 3, 4);
			if(player == 1)
				Terminal.printlnWithFormat("Player 1's turn!", 1, 4);
			else
				Terminal.printlnWithFormat("Player 2's turn!", 4, 4);
			Terminal.textEdit(2,1);
			int x = Input.getInt("X Coordinate", 1, size);
			int y = Input.getInt("Y Coordinate", 1, size);
			Terminal.clearFormat();
			if(!processCoordinates(x, y)){
				Terminal.printlnWithFormat("Occupied! Try again.", 5, 3);
				continue;
			}
			if(round > 3 && checkForWin(board)){
				hasWon = true;
				board.printWideMap();
				if(player == 1)
					Terminal.printlnWithFormat("Player 1 won!", 1, 4);
				else
					Terminal.printlnWithFormat("Player 2 won!", 4, 4);
			}else if(round == size * size){
				hasWon = !Input.getYesNo("It's a tie! Play again?");
				board.clearMap();
				round = 0;
			}
			round++;
			if(player == 1) player++;
			else player--;
		}
	}

	/**
	 * Processes the coordinates for a player's move.
	 * @param first the x coordinate
	 * @param second the y coordinate
	 * @return true if the move was successful, false otherwise
	 */
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

	/**
	 * Checks for wins in diagonals.
	 * @param array the game board
	 * @return true if there's a win, false otherwise
	 */
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

	/**
	 * Checks for wins in horizontal lines.
	 * @param array the game board
	 * @return true if there's a win, false otherwise
	 */
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

	/**
	 * Checks for wins in vertical lines.
	 * @param array the game board
	 * @return true if there's a win, false otherwise
	 */
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

	/**
	 * Checks if there's a win in the game.
	 * @param array the game board
	 * @return true if there's a win, false otherwise
	 */
	public static boolean checkForWin(TwoDHelper array){
		if(checkDiagonal(array)||checkHorizontal(array)||checkVertical(array))
			return true;
		return false;
	}

	public TwoDHelper getBoard(){
		return board;
	}

	public void setBoard(int size){
		board = new TwoDHelper(size, size);
	}

	/**
	 * Main method for testing the Tic-Tac-Toe game.
	 */
	void main(){
		int tictac = Input.getInt("Which size tictactoe do you want? (3-5)", 3, 5);
		TicTacToe test = new TicTacToe();
		test.executeTicTacToe(tictac);
	}
}