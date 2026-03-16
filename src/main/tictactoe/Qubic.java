package main.tictactoe;

import main.extramethods.Input;
import main.extramethods.Terminal;
import main.extramethods.ThreeDHelper;

public class Qubic {
	private ThreeDHelper cube;
	private int player;

	public void executeQubic(){
		System.out.println("Qubic has not been written yet.");
	}

	public void testExecuteQubic(){
		player = 1;
		cube = new ThreeDHelper(4,4,4);
		boolean hasWon = false;
		Terminal.printlnWithFormat("PAY ATTENTION: ..., X is horizontal, Y is vertical", 5,4);
		while(!hasWon){
			cube.printWideMap();
			System.out.println("It is player " + player + "'s turn!");
			int z = Input.getInt("Board number", 1, 4);
			int x = Input.getInt("X Coordinate", 1, 4);
			int y = Input.getInt("Y Coordinate", 1, 4);
			
			if(!processCoordinates(x, y, z)){
				System.out.println("That space is occupied. Try again.");
				continue;
			}
			if(checkForWin()){
				hasWon = true;
				cube.printWideMap();
				System.out.println("Player " + player + " has won!");
			}else if(checkForTie()){
				hasWon = !Input.getYesNo("It's a tie! Would you like to play again?");
			}
			if(player == 1) player++;
			else player--;
		}
	}

	private boolean checkForTie(){
		return false;
	}

	private boolean checkForWin(){
		return false;
	}

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

	void main(){
		Qubic test = new Qubic();
		test.testExecuteQubic();
	}
}
