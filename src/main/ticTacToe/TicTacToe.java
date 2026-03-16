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
			System.out.println("It is player " + player + "'s turn!");
			int x = Input.getInt("X Coordinate", 1, size);
			int y = Input.getInt("Y Coordinate", 1, size);
			if(!processCoordinates(x, y)){
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

	private boolean checkDiagonal(){
		//Get the top corners
		String topLeft = board.getLocation(1,1);
		String topRight = board.getLocation(board.getXMax(), 1);

		//If the top left corner has been played, check the diagonal until one doesnt match, then break. 
		//If it goes all teh way through, return true
		if(!topLeft.equals(" ")){
			int coord = 2;
			while(coord <= board.getXMax()){
				if(!topLeft.equals(board.getLocation(coord, coord))){
					break;
				}
				if(coord == board.getXMax())
					return true;
				coord++;
			}
		}

		//Same as the other, but adapted for the top right corner, so the x coordinate is calculated differently
		if(!topRight.equals(" ")){
			int coord = 2;
			while(coord <= board.getXMax()){
				if(!topRight.equals(board.getLocation(board.getXMax()+1-coord, coord))){
					break;
				}
				if(coord == board.getXMax())
					return true;
				coord++;
			}
		}
		return false;
	}

	private boolean checkHorizontal(){
		for(int y = 1; y <= board.getYMax(); y++){
			String spaceOne = board.getLocation(1,y);
			if(!spaceOne.equals(" ")){
				for(int x = 2; x <= board.getXMax(); x++){
					if(!spaceOne.equals(board.getLocation(x,y))){
						break;
					}
					if(x == board.getXMax())
						return true;
				}

			}
		}
		return false;
	}

	private boolean checkVertical(){
		for(int x = 1; x <= board.getXMax(); x++){
			String spaceOne = board.getLocation(x,1);
			if(!spaceOne.equals(" ")){
				for(int y = 2; y <= board.getYMax(); y++){
					if(!spaceOne.equals(board.getLocation(x,y))){
						break;
					}
					if(y == board.getYMax())
						return true;
				}

			}
		}
		return false;
	}

	private boolean checkForWin(){
		if(checkDiagonal()||checkHorizontal()||checkVertical())
			return true;
		return false;
	}

	void main(){
		int tictac = Input.getInt("Which size tictactoe do you want?", 3, 5);
		TicTacToe test = new TicTacToe();
		test.executeTicTacToe(tictac);
	}
}