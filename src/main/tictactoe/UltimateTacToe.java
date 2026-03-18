package main.tictactoe;

import main.extramethods.Terminal;
import main.extramethods.Input;

public class UltimateTacToe {
	private TicTacToe[][] superMap;
	private int[][] wonSuperMap;
	private int player;

	public void executeUltimateTacToe(){
		player = 1;
		int round = 1;
		superMap = new TicTacToe[3][3];
		wonSuperMap = new int[3][3];
		cleanSuperMap();
		boolean hasWon = false;
		boolean freeMove = true;
		int whichMiniBoard = 0;
		Terminal.clearTerminal();
		Terminal.printlnWithFormat("NOTE: miniBoards are numbered 1-9, left to right, top down. ", 5, 3);
		while(!hasWon){
			printToes();
			Terminal.printlnWithFormat("Round " + round, 3, 4);
			String turnStatement = (player == 1)
									? "Player 1's turn!"
									: "Player 2's turn!";
			int clr = (player == 1) ? 1 : 4;
			Terminal.printlnWithFormat(turnStatement, clr, 1);
			if(freeMove)
				whichMiniBoard = Input.getInt("FREE MOVE!! Which miniBoard are you playing on", 1, 9);
			int x = Input.getInt("X Coordinate", 1, 3);
			int y = Input.getInt("Y Coordinate", 1, 3);
			if(!processCoordinates(whichMiniBoard, x, y)){
				Terminal.printlnWithFormat("Occupied! Try again.", 5, 3);
				continue;
			}
			whichMiniBoard = ((y-1)*3) + x;
			if(checkForBigWin()){
				hasWon = true;
				printToes();
				String winStatement = (player == 1)
									? "Player 1 won!"
									: "Player 2 won!";
				Terminal.printlnWithFormat(winStatement, clr, 1);
			}else if(checkForTie()){
				hasWon = !Input.getYesNo("It's a tie! Play again?");
				cleanSuperMap();
				round = 1;
			}
			freeMove = superMap[y-1][x-1] == null;
			if(player == 1) player++;
			else {
				player--;
				round++;
			}
			if(round%2 == 0)
				Terminal.clearTerminal();
		}
	}

	private boolean processCoordinates(int board, int x, int y){
		TicTacToe miniBoard = superMap[(board-1)/3][(board-1)%3];
		if(miniBoard != null && miniBoard.getBoard().getLocation(x,y).equals(" ")){
			String playerMarker = (player == 1)
								? Terminal.RED + "x" + Terminal.CLEAR
								: Terminal.BLUE + "o" + Terminal.CLEAR;
			miniBoard.getBoard().editCoord(playerMarker, x, y);
			return true;
		}
		return false;
	}

	private boolean checkForTie(){
		for(TicTacToe[] toes : superMap)
			for(TicTacToe toe : toes)
				if(toe != null)
					return false;
		return true;
	}

	private void checkSmallWins(){
		for(int y = 0; y < 3; y++)
			for(int x = 0; x < 3; x++){
				if(superMap[y][x] != null){
					boolean won = TicTacToe.checkForWin(superMap[y][x].getBoard());
					if(won){
						superMap[y][x] = null;
						wonSuperMap[y][x] = player;
					}
			}
			}
	}

	private boolean checkForBigWin(){
		checkSmallWins();
		//Diagonal 1
		if((superMap[0][0]==null) && (wonSuperMap[0][0] == wonSuperMap[1][1]) && (wonSuperMap[0][0] == wonSuperMap[2][2])){
			return true;
		}

		//Diagonal 2
		if((superMap[0][2]==null) && (wonSuperMap[0][2] == wonSuperMap[1][1]) && (wonSuperMap[0][2] == wonSuperMap[2][0])){
			return true;
		}

		//Vertical
		for(int i = 0; i < 3; i++){
			if((superMap[0][i] == null) && (wonSuperMap[0][i] == wonSuperMap[1][i]) && (wonSuperMap[2][i] == wonSuperMap[0][i]))
				return true;
		}

		//Horizontal
		for(int i = 0; i < 3; i++){
			if((superMap[i][0] == null) && (wonSuperMap[i][0] == wonSuperMap[i][1]) && (wonSuperMap[i][2] == wonSuperMap[i][0]))
				return true;
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
					String playerLine = (wonSuperMap[y][x] == 0) ? superMap[y][x].getBoard().formatWideLine(smallY)
									: (wonSuperMap[y][x] == 1) ? Terminal.RED + "  xxxxxxxx " + Terminal.CLEAR
									: Terminal.BLUE + "  oooooooo " + Terminal.CLEAR;
					System.out.print(playerLine);
					if(x<2)
						System.out.print("   | ");
				}
				System.out.println();
				if(smallY<2){
					for(int x = 0; x < 3; x++){
						String borderLine = (wonSuperMap[y][x] == 0) ? superMap[y][x].getBoard().getWideBorder()
									: (wonSuperMap[y][x] == 1) ? Terminal.RED + "    xxxxxxxx " + Terminal.CLEAR
									: Terminal.BLUE + "    oooooooo " + Terminal.CLEAR;
						System.out.print(borderLine);
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
		toe.executeUltimateTacToe();
	}
}
