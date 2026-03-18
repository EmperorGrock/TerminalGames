package main.tictactoe;

import main.extramethods.Terminal;
import main.extramethods.TwoDHelper;
import main.extramethods.Input;

public class UltimateTacToe {
	private TicTacToe[][] superMap;
	private int[][] wonSuperMap;
	private int player;

	public void executeUltimateTacToe(){
		Terminal.printlnWithFormat("Unfortunately, Ultimate Tic Tac Toe hasn't been programmed yet!", 5, 3);
	}

	public void executeTestUltimateTacToe(){
		player = 1;
		superMap = new TicTacToe[3][3];
		wonSuperMap = new int[3][3];
		cleanSuperMap();
		boolean hasWon = false;
		boolean freeMove = true;
		int whichMiniBoard = 0;
		Terminal.printlnWithFormat("NOTE: miniboards are numbered 1-9, left to right, top down. ", 5, 3);
		while(!hasWon){
			printToes();
			String turnStatement = (player == 1)
									? "Player 1's turn!"
									: "Player 2's turn!";
			int clr = (player == 1) ? 1 : 4;
			Terminal.printlnWithFormat(turnStatement, clr, 1);
			if(freeMove)
				while(wonSuperMap[(whichMiniBoard-1)/3][(whichMiniBoard-1)%3]!=0){
					whichMiniBoard = Input.getInt("Which miniBoard are you playing on", 1, 9);
				}
			
			int x = Input.getInt("X Coordinate", 1, 3);
			int y = Input.getInt("Y Coordinate", 1, 3);
			/*if(!processCoordinates(x, y)){
				Terminal.printlnWithFormat("Occupied! Try again.", 5, 3);
				continue;
			}
			if(checkForWin(board)){
				hasWon = true;
				printToes();
				if(player == 1)
					Terminal.printlnWithFormat("Player 1 won!", 1, 4);
				else
					Terminal.printlnWithFormat("Player 2 won!", 4, 4);
			}else if(checkForTie()){
				hasWon = !Input.getYesNo("It's a tie! Play again?");
			}
			if(player == 1) player++;
			else player--;*/
		}
	}

	private boolean processCoordinates(int board, int x, int y){
		TicTacToe miniBoard = superMap[(board-1)/3][(board-1)%3];
		if(miniBoard != null && miniBoard.getBoard().getLocation(x,y).equals(" ")){
			String playerMarker = (player == 1)
								? Terminal.RED + "x" + Terminal.CLEAR
								: Terminal.BLUE + "o" + Terminal.CLEAR;
			miniBoard.getBoard().editCoord(playerMarker, x, y);
		}
		return false;
	}

	private void cleanSuperMap(){
		for(int x = 0; x < 3; x++)
			for(int y = 0; y < 3; y++){
				superMap[y][x] = new TicTacToe();
				superMap[y][x].setBoard(3);
				superMap[y][x].getBoard().clearMap();
			}
	}

	private void printToes(){
		System.out.println("                |                 |");
		for(int y = 0; y < 3; y++){
			for(int smallY = 0; smallY < 3; smallY++){
				for(int x = 0; x < 3; x++){
					System.out.print("  ");
					System.out.print(superMap[y][x].getBoard().formatWideLine(smallY));
					if(x<2)
						System.out.print("   | ");
				}
				System.out.println();
				if(smallY<2){
					for(int x = 0; x < 3; x++){
						System.out.print(superMap[y][x].getBoard().getWideBorder());
						if(x<2)
							System.out.print("   | ");
					}
				}
				
				if(smallY==2)
					System.out.println("                |                 |");
				else
					System.out.println();
			}
			if(y<2){
				System.out.println("----------------|-----------------|---------------");
				System.out.println("                |                 |");
			}
		}
		System.out.println();
	}

	public static void main(String[] args){
		UltimateTacToe toe = new UltimateTacToe();
		toe.executeTestUltimateTacToe();
	}
}
