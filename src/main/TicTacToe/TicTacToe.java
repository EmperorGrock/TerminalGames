import java.util.Scanner;
public class TicTacToe{
	private static int player = 1;

	public static String[][] lines = 
		{{" "," "," "},
		 {" "," "," "},
		 {" "," "," "}};
	public static String emptyLine = "  --+-+--";

	public static void executeNormalTicTacToe(){
		Scanner input = new Scanner(System.in);
		boolean hasWon = false;
		int inputNum;
		System.out.println("To type coordinates, type two number coordinates in a row, as in: 02");
		input.nextLine();
		while(!hasWon){
			printScreen();
			System.out.println("It is player " + player + "'s turn!");
			inputNum = input.nextInt();
			placeMarker(inputNum);
			if(checkForWin()){
				hasWon = true;
				input.close();
				printScreen();
				System.out.println("Player " + player + " has won!");
			}
			if(player == 1) player = 2;
			else if(player == 2) player = 1;
		}
	}

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