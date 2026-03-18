package main.tictactoe;

import main.extramethods.Input;
import main.extramethods.Terminal;
import main.extramethods.ThreeDHelper;

/**
 * Represents a 3D Tic-Tac-Toe game called Qubic.
 * @author EmperorGrock
 */
public class Qubic {
	private ThreeDHelper cube;
	private int player;

	/**
	 * Executes the main game loop for Qubic.
	 */
	public void executeQubic(){
		player = 1;
		cube = new ThreeDHelper(4,4,4);
		boolean hasWon = false;
		Terminal.printlnWithFormat("PAY ATTENTION: ..., X is horizontal, Y is vertical", 5,4);
		while(!hasWon){
			cube.printWideMap();
			String turnStatement = (player == 1)
									? "Player 1's turn!"
									: "Player 2's turn!";
			int clr = (player == 1) ? 1 : 4;
			Terminal.printlnWithFormat(turnStatement, clr, 4);
			int z = Input.getInt("Layer number", 1, 4);
			int x = Input.getInt("X Coordinate", 1, 4);
			int y = Input.getInt("Y Coordinate", 1, 4);
			if(!processCoordinates(x, y, z)){
				Terminal.printlnWithFormat("Occupied! Try again.", 5, 4);
				continue;
			}
			if(checkForWin()){
				hasWon = true;
				cube.printWideMap();
				String winStatement = (player == 1)
									? "Player 1 won!"
									: "Player 2 won!";
				Terminal.printlnWithFormat(winStatement, clr, 4);
			}else if(checkForTie()){
				Terminal.textEdit(5,3);
				hasWon = !Input.getYesNo("It's a tie! Play again?");
				Terminal.clearFormat();
			}
			if(player == 1) player++;
			else player--;
		}
	}

	/**
	 * Processes the coordinates for a player's move.
	 * @param x the x coordinate
	 * @param y the y coordinate
	 * @param z the z coordinate
	 * @return true if the move was successful, false otherwise
	 */
	private boolean processCoordinates(int x, int y, int z){
		if(cube.getLocation(x, y, z).equals(" ")){
			if(player == 1){
				cube.editCoord(Terminal.RED + "x" + Terminal.CLEAR, x, y, z);
				return true;
			}else if(player == 2){
				cube.editCoord(Terminal.BLUE + "o" + Terminal.CLEAR, x, y, z);
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks if the game is a tie.
	 * @return true if it's a tie, false otherwise
	 */
	private boolean checkForTie(){
		for(int x = 1; x <= cube.getXMax(); x++)
			for(int y = 1; y <= cube.getYMax(); y++)
				for(int z = 1; z <= cube.getZMax(); z++)
					if(cube.getLocation(x,y,z).equals(" "))
						return false;
		cube.clearMap();
		return true;
	}


	/**
	 * Checks for wins in XY planes.
	 * @return true if there's a win, false otherwise
	 */
	private boolean checkXY(){
		for(int z = 1; z <= 4; z++){
			if(TicTacToe.checkForWin(cube.getLayer(1,z)))
				return true;
		}
		return false;
	}

	/**
	 * Checks for wins in XZ planes.
	 * @return true if there's a win, false otherwise
	 */
	private boolean checkXZ(){
		for(int y = 1; y <= 4; y++){
			if(TicTacToe.checkForWin(cube.getLayer(2,y)))
				return true;
		}
		return false;
	}

	/**
	 * Checks for wins in YZ planes.
	 * @return true if there's a win, false otherwise
	 */
	private boolean checkYZ(){
		for(int x = 1; x <= 4; x++){
			if(TicTacToe.checkForWin(cube.getLayer(3,x)))
				return true;
		}
		return false;
	}

	/**
	 * Checks for wins in space diagonals.
	 * @return true if there's a win, false otherwise
	 */
	private boolean checkSuperDiagonals(){
		if((!cube.getLocation(1,1,1).equals(" "))&&cube.getLocation(1,1,1).equals(cube.getLocation(2,2,2))
			&&cube.getLocation(1,1,1).equals(cube.getLocation(3,3,3))
			&&cube.getLocation(1,1,1).equals(cube.getLocation(4,4,4)))
				return true;
		if((!cube.getLocation(1,4,1).equals(" "))&&cube.getLocation(1,4,1).equals(cube.getLocation(2,3,2))
			&&cube.getLocation(1,4,1).equals(cube.getLocation(3,2,3))
			&&cube.getLocation(1,4,1).equals(cube.getLocation(4,1,4)))
				return true;
		if((!cube.getLocation(4,1,1).equals(" "))&&cube.getLocation(4,1,1).equals(cube.getLocation(3,2,2))
			&&cube.getLocation(4,1,1).equals(cube.getLocation(2,3,3))
			&&cube.getLocation(4,1,1).equals(cube.getLocation(1,4,4)))
				return true;
		if((!cube.getLocation(4,4,1).equals(" "))&&cube.getLocation(4,4,1).equals(cube.getLocation(3,3,2))
			&&cube.getLocation(4,4,1).equals(cube.getLocation(2,2,3))
			&&cube.getLocation(4,4,1).equals(cube.getLocation(1,1,4)))
				return true;
		return false;
	}

	/**
	 * Checks if there's a win in the game.
	 * @return true if there's a win, false otherwise
	 */
	private boolean checkForWin(){
		return (checkXY() || checkXZ() || checkYZ() || checkSuperDiagonals());
	}

	/**
	 * Main method for testing the Qubic game.
	 */
	public static void main(String[] args){
		Qubic test = new Qubic();
		test.executeQubic();
	}
}
