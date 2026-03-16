package main.tictactoe;
import main.extramethods.TwoDHelper;
import main.extramethods.Input;
import main.extramethods.Terminal;

/**
 * A simple implementation of the classic Connect Four game, using the TwoDHelper class to manage the game board and the Input class to handle user input.
 * Built for the TerminalGames app. 
 * @author invisiblekoi
 */
public class ConnectFour{
	private int player;
	private TwoDHelper board;

	public ConnectFour(){}

	/**
	 * Executes Connect Four game with map size of 7 rows * 6 columns
	 */
	public void connectFour(){
		player = 1;
		board = new TwoDHelper(7,6);
		int round = 1;
		boolean hasWon = false;
		while(!hasWon){
			board.printWideMap();
			Terminal.printlnWithFormat("Round "+ round, 2, 4);
			if(player == 1)
				Terminal.printlnWithFormat("It is player 1's turn!", 1, 4);
			else
				Terminal.printlnWithFormat("It is player 2's turn!", 4, 4);
			int Coord = Input.getInt("Enter Coordinate", 1, 7);
			if(!processCoordinate(Coord)){
				Terminal.printlnWithFormat("That column is full! Try again.", 5, 3);
				continue;
			}
			if(round > 3)
			{
				if(checkWin())
				{	
					board.printWideMap();
					hasWon = true;
					if(player == 1)
						Terminal.printlnWithFormat("Player 1 won!", 1, 4);
					else
						Terminal.printlnWithFormat("Player 2 won!", 4, 4);
				}
			}
			if(player == 1) player++;
			else {
				player--;
				round++;
			}
		}
	}

	/**
	 * Processes the coordinate from player's move. Automatically drops piece to lowest possible coordinate to imitate gravity.
	 * @param column The chosen column
	 * @return true if action was possible/successful
	 */
	private boolean processCoordinate(int column){
		if(board.getLocation(column, 1).equals(" ")){
			int row = 1;
			while(row <= 6){
				if(board.getLocation(column, row).equals(" ") && row < 6) 
					row++;
				else if(board.getLocation(column, row).equals(" ") && row == 6){
					if(player == 1){
						board.editCoord(Terminal.RED + "x" + Terminal.CLEAR, column, row);
					}else if(player == 2){
						board.editCoord(Terminal.BLUE + "o" + Terminal.CLEAR, column, row);
					}
					break;
				}
				else{
					if(player == 1){
						board.editCoord(Terminal.RED + "x" + Terminal.CLEAR, column, --row);
					}else if(player == 2){
						board.editCoord(Terminal.BLUE + "o" + Terminal.CLEAR, column, --row);
					}
					break;
				}
			}
		} else return false;
		return true;
	}
	/**
	 * Checks if there is a win in the game.
	 * @return true if a win is found
	 */
	private boolean checkWin(){
		for(int x = 1; x < 8; x++){
			for(int y = 1; y < 7; y++){
				if(!board.getLocation(x, y).equals(" ")){
					if(x < 5){
						if (y > 3){
							if(checkToTopRight(x, y)) return true;
						}
						if (y < 4){
							if(checkToBottomRight(x, y)) return true;
						}
						if(checkToRight(x, y)) return true;
					}
					if (y < 4){
						if(checkToBottom(x, y)) return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * Checks spaces at the top right of original location up to 3 spaces away. Sees if there is a win this way.
	 * @param x the horizontal location of the origin
	 * @param y the vertical location of the origin
	 * @return true if all 3 consecutive spaces to the top right of origin are the same.
	 */
	private boolean checkToTopRight(int x, int y){
		boolean connection = true;
		String origin = board.getLocation(x, y);
		for(int increment = 1; increment < 4; increment++){
			if(!origin.equals(board.getLocation(x+increment,y-increment))){
				connection = false;
				break;
			}
		}
		return connection;
	}

	/**
	 * Checks spaces at the right of original location up to 3 spaces away. Sees if there is a win this way.
	 * @param x the horizontal location of the origin
	 * @param y the vertical location of the origin
	 * @return true if all 3 consecutive spaces to the right of origin are the same.
	 */
	private boolean checkToRight(int x, int y){
		boolean connection = true;
		String origin = board.getLocation(x, y);
		for(int increment = 1; increment < 4; increment++){
			if(!origin.equals(board.getLocation(x+increment, y))){
				connection = false;
				break;
			}
		}
		return connection;
	}

	/**
	 * Checks spaces at the bottom right of original location up to 3 spaces away. Sees if there is a win this way.
	 * @param x the horizontal location of the origin
	 * @param y the vertical location of the origin
	 * @return true if all 3 consecutive spaces to the bottom right of origin are the same.
	 */
	private boolean checkToBottomRight(int x, int y){
		boolean connection = true;
		String origin = board.getLocation(x, y);
		for(int increment = 1; increment < 4; increment++){
			if(!origin.equals(board.getLocation(x+increment, y+increment))){
				connection = false;
				break;
			}
		}
		return connection;
	}

	/**
	 * Checks spaces at the bottom of original location up to 3 spaces away. Sees if there is a win this way.
	 * @param x the horizontal location of the origin
	 * @param y the vertical location of the origin
	 * @return true if all 3 consecutive spaces to the bottom of origin are the same.
	 */
	private boolean checkToBottom(int x, int y){
		boolean connection = true;
		String origin = board.getLocation(x, y);
		for(int increment = 1; increment < 4; increment++){
			if(!origin.equals(board.getLocation(x, y+increment))){
				connection = false;
				break;
			}
		}
		return connection;
	}

	void main(String[] args){
		connectFour();
	}
}
