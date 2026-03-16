package main.tictactoe;

import main.extramethods.Input;
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
		while(!hasWon){
			cube.printWideMap();
			System.out.println("It is player " + player + "'s turn!");
			int x = Input.getInt("X Coordinate", 1, 4);
			int y = Input.getInt("Y Coordinate", 1, 4);
			int z = Input.getInt("Z Coordinate", 1, 4);
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
		
		return false;
	}

}
