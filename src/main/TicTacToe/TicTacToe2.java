package main.TicTacToe;

import java.util.Scanner;
public class TicTacToe2{
	private static int player = 1;
	private static String playerOneName;
	private static String playerTwoName;

	public static String[][] lines = 
		{{" "," "," "},
		 {" "," "," "},
		 {" "," "," "}};
	public static String emptyLine = "  --+-+--";

	public static void executeNormalTicTacToe(){
		Scanner input = new Scanner(System.in);
		boolean hasWon = false;
		System.out.println("Please enter Player One's Name");
		playerOneName = input.nextLine();
		System.out.println("Please enter Player two's Name");
		playerTwoName = input.nextLine();
		int inputNum;
		int turns = 0;
		System.out.println("To type coordinates, type two number coordinates in a row, as in: 02");
		input.nextLine();
		while(!hasWon){
			printScreen();
			if(player == 1)
			System.out.println("It is " + playerOneName + "'s turn!");
				else 
			System.out.println("It is " + playerTwoName + "'s turn!");
			inputNum = input.nextInt();
			placeMarker(inputNum);
			turns++;
			if(checkForWin()){
				hasWon = true;
				input.close();
				printScreen();
				if(player == 1)
					System.out.println(playerOneName + " has won!");
				else 
					System.out.println(playerTwoName + " has won!");
			}
			player = 3 - player;
			if(turns>=9){
				printScreen();
				System.out.println("It's a tie!");
				turns = 0;
				for(int i = 0; i > 3; i++){
					for(int j = 0; j > 3; j++){
						lines[i][j] = " ";
					}
				}
			}
		}
	}

	/*public static String getAndCheckInput(){
		Scanner input = new Scanner(System.in);
		int number = input.nextInt();
		if(number){

		}else throw new IllegalArgumentException("Must input proper coordinates");
	}*/

	public static void placeMarker(int input){
		int y = input % 10;
		int x = input / 10;
		processCoordinates(x,y);
	}

	public static String formatLine(int row){
		String result = " ";
		for(int i = 0; i < 2; i++){
			result += lines[row][i];
			result += "|";
		}
		result+=lines[row][2];
		return result;
	}

	public static void printScreen(){
		System.out.println("   0 1 2");
		for(int j = 0; j < 3; j++){
			System.out.print(j + " ");
			System.out.print(formatLine(j));
			if(j<2) System.out.println("\n"+emptyLine);
			else System.out.println();
		}
		System.out.println();
	}

	public static void processCoordinates(int first, int second){
		if(lines[second][first].equals(" ")){
			if(player == 1){
				lines[second][first] = "x";
			}else if(player == 2){
				lines[second][first] = "o";
			}
		}else throw new IllegalArgumentException("That space is occupied");
	}

	public static boolean checkForWin(){
		boolean result = false;
		//Check for Vertical
		for(int i = 0; i < 3; i++){
			if(((lines[i][0].equals(lines[i][1]))&&lines[i][0].equals(lines[i][2])) && !(lines[i][0].equals(" "))){
				result = true;
			}
		}
		//check for Horizontal
		for(int i = 0; i < 3; i++){
			if((lines[0][i].equals(lines[1][i])&&lines[0][i].equals(lines[2][i])) && !(lines[0][i].equals(" "))){
				result = true;
			}
		}
		//Check for Diagonals
		if((lines[0][0].equals(lines[1][1])&&lines[0][0].equals(lines[2][2]))&&!(lines[0][0].equals(" "))){
			result = true;
		}else if((lines[0][2].equals(lines[1][1])&&lines[0][2].equals(lines[2][0]))&&!(lines[0][2].equals(" "))){
			result = true;
		}

		return result;
	}

	public static void main(String[] args){
		executeNormalTicTacToe();
	}
}