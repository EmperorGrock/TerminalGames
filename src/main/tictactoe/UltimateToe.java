package main.tictactoe;

import main.extramethods.Terminal;
import main.extramethods.Input;

/**
 * A class representing the Ultimate Tic-Tac-Toe game.
 * @author EmperorGrock
 * @author invisiblekoi
 */
public class UltimateToe {
	/** The 3x3 grid of TicTacToe boards. */
	private TicTacToe[][] superMap;
	/** The 3x3 grid tracking which boards are won and by whom. */
	private int[][] wonSuperMap;

	/** The current player (1 or 2). */
	private int player;
	/** The active round number. */
	private int round;
	/** The chosen mini-board that is currently being played in. */
	private int whichTacling;
	
	/** Whether the game has been won/tied. When true, the game ends. */
	private boolean hasWon;
	/** Whether the current player can choose which mini-board they want to play in. */
	private boolean freeMove;

	/**
	 * Executes the Ultimate Tic-Tac-Toe game.
	 */
	public void executeUltimateTacToe(){
		superMap = new TicTacToe[3][3];
		wonSuperMap = new int[3][3];
		player = 1;
		round = 1;
		whichTacling = 0;
		hasWon = false;
		freeMove = true;

		cleanSuperMap();
		Terminal.clearTerminal();
		Terminal.printlnWithFormat("NOTE: Taclings are numbered 1-9, left to right, top to bottom. ", 5, 3);

		while(!hasWon){
			printToes();
			Terminal.printlnWithFormat("Round " + round, 3, 4);
			String turnStatement = (player == 1)
									? "Player 1's turn!"
									: "Player 2's turn!";
			//Colour of text
			int clr = (player == 1) ? 1 : 4;
			Terminal.printlnWithFormat(turnStatement, clr, 1);
			if(freeMove)
				whichTacling = Input.getInt("FREE MOVE!! Which Tacling are you playing on", 1, 9);
			else
				Terminal.printlnWithFormat("You are on mini-board " + whichTacling, 5, 3);
			int x = Input.getInt("X Coordinate", 1, 3);
			int y = Input.getInt("Y Coordinate", 1, 3);
			if(!processCoordinates(whichTacling, x, y)){
				Terminal.printlnWithFormat("Occupied! Try again.", 5, 3);
				Terminal.sleep(1.5);
				continue;
			}
			//algorithm that converts coordinates to single number
			whichTacling = ((y-1)*3) + x;

			if(checkForBigWin()){
				hasWon = true;
				printToes();
				String winStatement = (player == 1)
									? "Player 1 won!"
									: "Player 2 won!";
				Terminal.printlnWithFormat(winStatement, clr, 1);
				System.console().readLine();
				//hasWon = !Input.getYesNo("Play again?");
			}else if(checkForTie()){
				printToes();
				hasWon = !Input.getYesNo("It's a tie! Play again?");
				player = 1;
				round = 1;
				freeMove = true;
				cleanSuperMap();
			}
			//if last given coordinates correspond with an unplayable area in the super-map, next move can be chosen
			freeMove = superMap[y-1][x-1] == null;
			if(player == 1) player++;
			else {
				player--;
				round++;
			}
			Terminal.clearTerminal();
		}
	}

	/**
	 * Tries to store coordinates into the board.
	 * @param board The chosen mini-board.
	 * @param x	The x coordinate within the mini-board.
	 * @param y The y coordinate within the mini-board.
	 * @return true if successfully stored and false if space is unavailable.
	 */
	private boolean processCoordinates(int board, int x, int y){
		TicTacToe tacling = superMap[(board-1)/3][(board-1)%3];
		if(tacling != null && tacling.getBoard().getLocation(x,y).equals(" ")){
			String playerMarker = (player == 1)
								? Terminal.RED + "x" + Terminal.CLEAR
								: Terminal.BLUE + "o" + Terminal.CLEAR;
			tacling.getBoard().editCoord(playerMarker, x, y);
			return true;
		}
		return false;
	}

	/**
	 * Checks if the game is tied (all boards are won).
	 * @return True if all boards are filled, false otherwise.
	 */
	private boolean checkForTie(){
		for(TicTacToe[] toes : superMap)
			for(TicTacToe toe : toes)
				if(toe != null)
					return false;
		return true;
	}

	/**
	 * Checks all mini-boards for a win or tie. If a mini-board has been won or tied, 
	 * the location in the super-map is set to null, 
	 * and the same location in the won-super-map is set to the winning player's number (1 or 2), or 3 if tied.
	 */
	private void checkSmallWins(){
		for(int y = 0; y < 3; y++)
		{
			for(int x = 0; x < 3; x++)
			{
				boolean tie = true;
				boolean won = false;
				if(superMap[y][x] != null){
					won = TicTacToe.checkForWin(superMap[y][x].getBoard());
					if(won){
						superMap[y][x] = null;
						wonSuperMap[y][x] = player;
					}else{

						//re-using the original for-loops, but checking if each mini space is full
						for(int yMini = 1; yMini < 4; yMini++)
							for(int xMini = 1; xMini < 4; xMini++)
								if(superMap[y][x].getBoard().getLocation(yMini, xMini).equals(" ")) tie = false;

						//3 means tie
						if(tie){
							superMap[y][x] = null;
							wonSuperMap[y][x] = 3;
						}
					}
				}
			}
		}
	}

	/**
	 * Checks for a win on the big board.
	 * @return true if there is a big win, false otherwise.
	 */
	private boolean checkForBigWin(){
		checkSmallWins();
		//Diagonal 1
		if((superMap[0][0]==null) && (wonSuperMap[0][0] != 3) && (wonSuperMap[0][0] == wonSuperMap[1][1]) && (wonSuperMap[0][0] == wonSuperMap[2][2])){
			return true;
		}

		//Diagonal 2
		if((superMap[0][2]==null) && (wonSuperMap[0][2] != 3) && (wonSuperMap[0][2] == wonSuperMap[1][1]) && (wonSuperMap[0][2] == wonSuperMap[2][0])){
			return true;
		}

		//Vertical
		for(int i = 0; i < 3; i++){
			if((superMap[0][i] == null) && (wonSuperMap[0][i] != 3) && (wonSuperMap[0][i] == wonSuperMap[1][i]) && (wonSuperMap[2][i] == wonSuperMap[0][i]))
				return true;
		}

		//Horizontal
		for(int i = 0; i < 3; i++){
			if((superMap[i][0] == null) && (wonSuperMap[0][i] != 3) && (wonSuperMap[i][0] == wonSuperMap[i][1]) && (wonSuperMap[i][2] == wonSuperMap[i][0]))
				return true;
		}

		return false;
	}

	/**
	 * Resets the entire map
	 */
	private void cleanSuperMap(){
		for(int x = 0; x < 3; x++)
			for(int y = 0; y < 3; y++){
				superMap[y][x] = new TicTacToe();
				superMap[y][x].setBoard(3);
				superMap[y][x].getBoard().clearMap();
				wonSuperMap[y][x] = 0;
			}
	}

	/**
	 * Complicated, annoying method to print out the formatted ultimate board.
	 * /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	 * Compares the super-map to the won-super-map to print out the completely formatted ultimate board. 
	 */
	private void printToes(){
		System.out.println("                 |                 |");
		for(int y = 0; y < 3; y++){
			for(int smallY = 0; smallY < 3; smallY++){
				for(int x = 0; x < 3; x++){
					System.out.print("   ");
					String playerLine =    (wonSuperMap[y][x] == 0) ? superMap[y][x].getBoard().formatWideLine(smallY)
										:  (wonSuperMap[y][x] == 1) ? Terminal.RED + "xxxxxxxxxxx" + Terminal.CLEAR
										:  (wonSuperMap[y][x] == 2) ? Terminal.BLUE + "ooooooooooo" + Terminal.CLEAR
										:  "###########";
					System.out.print(playerLine);
					if(x<2)
						System.out.print("   |");
				}
				System.out.println();
				if(smallY<2){
					for(int x = 0; x < 3; x++){
						String borderLine = (wonSuperMap[y][x] == 0) ? " " + superMap[y][x].getBoard().getWideBorder()
										:	(wonSuperMap[y][x] == 1) ? Terminal.RED + "   xxxxxxxxxxx" + Terminal.CLEAR
										:	(wonSuperMap[y][x] == 2) ? Terminal.BLUE + "   ooooooooooo" + Terminal.CLEAR
										:	"   ###########";
						System.out.print(borderLine);
						if(x<2)
							System.out.print("   |");
					}
				}
				
				if(smallY==2)
					System.out.println("                 |                 |");
				else
					System.out.println();
			}
			if(y<2){
				System.out.println("-----------------|-----------------|-----------------");
				System.out.println("                 |                 |");
			}
		}
		System.out.println();
	}

	public static void main(String[] args){
		UltimateToe toe = new UltimateToe();
		toe.executeUltimateTacToe();
	}
}