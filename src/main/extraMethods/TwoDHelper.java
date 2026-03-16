package main.extramethods;

/**
 * A helper class for creating and managing a 2D array of strings, with methods for editing and printing the array in a formatted way.
 * Built for the TerminalGames app, used currently in the tic-tac-toe game, but can be used for any game or application that requires a 2D grid of strings.
 * @todo - Add error handling for out-of-bounds coordinates in editCoord and getLocation methods
 * @todo - Add method for checking if a specific coordinate is empty or not, for use in games like tic-tac-toe
 * @todo - Convert printMap into a method to return a large string with the formatted grid, instead of printing directly, for more flexible use in different applications
 * @author EmperorGrock
 */
public class TwoDHelper {
	private String[][] map;
	private int xMax;
	private int yMax;

	/**
	 * Default constructor for TwoDHelper, which initializes a 3x3 grid with empty spaces.
	 */
	public TwoDHelper(){
		this.xMax = 3;
		this.yMax = 3;
		map = new String[yMax][xMax];
		for(int x = 0; x < yMax; x++){
			for(int y = 0; y < xMax; y++){
				map[y][x] = " ";
			}
		}
	}

	/**
	 * Constructor for TwoDHelper, which initializes a grid of the specified size with empty spaces.
	 * @param xMax The number of columns in the grid
	 * @param yMax The number of rows in the grid
	 */
	public TwoDHelper(int xMax, int yMax){
		this.xMax = xMax;
		this.yMax = yMax;
		map = new String[yMax][xMax];
		for(int y = 0; y < yMax; y++){
			for(int x = 0; x < xMax; x++){
				map[y][x] = " ";
			}
		}
	}

	/**
	 * Formats a single line of the grid for printing, by concatenating the strings in the specified row with vertical bars in between.
	 * @param row The index of the row to format (0-indexed)
	 * @return A string representing the formatted line of the grid
	 */
	public String formatLine(int row){
		String result = "";
		for(int i = 0; i < xMax-1; i++){
			result += map[row][i];
			result += "|";
		}
		result += map[row][xMax-1];
		return result;
	}
	/**
	 * Formats a single line of the grid for printing, by concatenating the strings in the specified row with vertical bars in between. Has additional space between the string and the vertical bars.
	 * @param row The index of the row to format (0-indexed)
	 * @return A string representing the formatted line of the grid
	 */
	public String formatWideLine(int row){
		String result = "";
		for(int i = 0; i < xMax-1; i++){
			result += " " + map[row][i] + " ";
			result += "|";
		}
		result += " " + map[row][xMax-1] + " ";
		return result;
	}

	/**
	 * Generates a string representing the horizontal border between rows in the grid, consisting of dashes and plus signs.
	 * @return A string representing the horizontal border between rows in the grid
	 */
	public String getBorder(){
		String result = "  ";
		for(int i = 0; i < xMax-1; i++)
			result += "-+";
		result += "-";
		return result;
	}
	/**
	 * Generates a string representing the horizontal border between rows in the grid, consisting of dashes and plus signs.
	 * @return A string representing the horizontal border between rows in the grid
	 */
	public String getWideBorder(){
		String result = "  ";
		for(int i = 0; i < xMax-1; i++)
			result += "---+";
		result += "---";
		return result;
	}

	/**
	 * Edits the character at the specified coordinates in the grid. newChar MUST be a single character string
	 * No precondition checks that x and y are within bounds, or that newChar is one character, so be careful when using this method.
	 * @param newChar The new character to place in the grid, must be a single character string
	 * @param X The x-coordinate of the position to edit (starts at 1 for user-friendliness, will be converted to 0-indexed in the method)
	 * @param Y The y-coordinate of the position to edit (starts at 1 for user-friendliness, will be converted to 0-indexed in the method)
	 */
	public void editCoord(String newChar, int X, int Y){ 
		X -= 1;
		Y -= 1;
		map[Y][X] = newChar;
	}

	/**
	 * Simple method to clear the grid by setting all coordinates back to a single space character. 
	 * Can be used for restarting a game or clearing the board.
	 */
	public void clearMap(){
		for(int i = 1; i <= map.length; i++)
			for(int j = 1; j <= map.length; j++)
				editCoord(" ", i, j);
	}

	/**
	 * Prints the grid in a formatted way, with row and column indices.
	 */
	public void printMap(){
		System.out.print(" ");
		for(int i = 1; i < xMax + 1; i++){
			System.out.print(" " + i);
		}
		System.out.println();
		for(int j = 0; j < yMax; j++){
			System.out.print((j+1) + " ");
			System.out.print(formatLine(j));
			if(j<yMax-1) System.out.println("\n"+getBorder());
			else System.out.println();
		}
		System.out.println();
	}
	/**
	 * Prints the grid in a formatted way with extra width, with row and column indices.
	 */
	public void printWideMap(){
		for(int i = 1; i < xMax + 1; i++){
			System.out.print("   " + i);
		}
		System.out.println();
		for(int j = 0; j < yMax; j++){
			System.out.print((j+1) + " ");
			System.out.print(formatWideLine(j));
			if(j<yMax-1) System.out.println("\n"+getWideBorder());
			else System.out.println();
		}
		System.out.println();
	}

	/**
	 * Returns the maximum y-coordinate of the grid. 
	 * @return The maximum y-coordinate of the grid.
	 */
	public int getYMax(){
		return yMax;
	}

	/**
	 * Returns the maximum x-coordinate of the grid.
	 * @return The maximum x-coordinate of the grid
	 */
	public int getXMax(){
		return xMax;
	}

	/**
	 * Returns the character at the specified coordinates in the grid.
	 * @param x The x-coordinate of the position to retrieve (starts at 1 for user-friendliness, will be converted to 0-indexed in the method)
	 * @param y The y-coordinate of the position to retrieve (starts at 1 for user-friendliness, will be converted to 0-indexed in the method)
	 * @return The character at the specified coordinates
	 */
	public String getLocation(int x, int y){
		return map[y-1][x-1];
	}
}
