package main.tictactoe;

import main.extramethods.Input;
import main.extramethods.Terminal;
import main.extramethods.ThreeDHelper;

public class Qubic {
	private ThreeDHelper cube;
	private int player;

	public void executeQubic(){
		player = 1;
		cube = new ThreeDHelper(4,4,4);
		boolean hasWon = false;
		Terminal.printlnWithFormat("PAY ATTENTION: ..., X is horizontal, Y is vertical", 5,4);
		while(!hasWon){
			cube.printWideMap();
			if(player == 1)
				Terminal.printlnWithFormat("It is player 1's turn!", 1, 4);
			else
				Terminal.printlnWithFormat("It is player 2's turn!", 2, 4);
			Terminal.textEdit(2,2);
			int z = Input.getInt("Layer number", 1, 4);
			int x = Input.getInt("X Coordinate", 1, 4);
			int y = Input.getInt("Y Coordinate", 1, 4);
			Terminal.clearFormat();
			if(!processCoordinates(x, y, z)){
				Terminal.printlnWithFormat("That space is occupied. Try again.", 5, 4);
				continue;
			}
			if(checkForWin()){
				hasWon = true;
				cube.printWideMap();
				if(player == 1)
					Terminal.printlnWithFormat("Player 1 has won!", 1, 4);
				else
					Terminal.printlnWithFormat("Player 2 has won!", 2, 4);
			}else if(checkForTie()){
				Terminal.textEdit(5,3);
				hasWon = !Input.getYesNo("It's a tie! Would you like to play again?");
				Terminal.clearFormat();
			}
			if(player == 1) player++;
			else player--;
		}
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

	private boolean checkForTie(){
		for(int x = 1; x <= cube.getXMax(); x++)
			for(int y = 1; y <= cube.getYMax(); y++)
				for(int z = 1; z <= cube.getZMax(); z++)
					if(cube.getLocation(x,y,z).equals(" "))
						return false;
		return true;
	}


	private boolean checkXY(){
		for(int z = 1; z <= 4; z++){
			if(TicTacToe.checkForWin(cube.getLayer(1,z)))
				return true;
		}
		return false;
	}

	private boolean checkXZ(){
		for(int y = 1; y <= 4; y++){
			if(TicTacToe.checkForWin(cube.getLayer(2,y)))
				return true;
		}
		return false;
	}

	private boolean checkYZ(){
		for(int x = 1; x <= 4; x++){
			if(TicTacToe.checkForWin(cube.getLayer(3,x)))
				return true;
		}
		return false;
	}

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

	private boolean checkForWin(){
		return (checkXY() || checkXZ() || checkYZ() || checkSuperDiagonals());
	}

	void main(){
		Qubic test = new Qubic();
		test.executeQubic();
	}
}
