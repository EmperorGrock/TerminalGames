package main.extramethods;

/**
 * A class with static methods for terminal manipulation.
 * Built for the TerminalGames app.
 * @author EmperorGrock
 */
public class Terminal{
	public static final String RED = "\u001b[31m";
	public static final String BLUE = "\u001b[34m";
	public static final String CLEAR = "\u001b[0m";

	/**
	 * Simplified version of Thread.sleep that takes seconds instead of milliseconds
	 * @param seconds The number of seconds to sleep
	 */
	public static void sleep(double seconds){
		try{
			Thread.sleep((int)(seconds*1000));
		}catch(InterruptedException e){
			System.out.println("Interrupted Exception.");
		}
	}

	/**
	 * Clears the terminal screen, clears the scrollback, and moves the cursor to the top-left corner
	 */
	public static void clearTerminal(){
		//Clear screen
		System.out.print("\033[2J");
		//Place cursor
		System.out.print("\033[H");
		//Clear scroll back (Most consoles)
		System.out.print("\033[3J");
		//Clear buffered data or smths
		System.out.flush();
	}

	/**
	 * clears all text formatting, including color and text formating such as bold or underline
	 */
	public static void clearFormat(){
		System.out.print("\033[0m");
	}

	/**
	 * Formats text such with bold, underline, italic
	 * @param which  1 Bold, 2 Dim, 3 Italic, 4 Underline
	 * @throws IllegalArgumentException When input is outside the supported range, 1-4
	 */
	public static void textForm(int which){
		if(which < 0 || which > 4)
			throw new IllegalArgumentException("Only supports 1-4");
		if(which != 0)
			System.out.print("\033[" + which + "m");
	}

	/**
	 * Sets the text color to one of 7 colors, 
	 * 0 grey, 1 red, 2 green, 3 yellow, 4 blue, 5 magenta, 6 cyan, 7 white
	 * @param color Sets the color 
	 * @throws IllegalArgumentException if the color is outside the range 0-7
	*/
	public static void textColor(int color){
		if(color < 0 || color > 7)
			throw new IllegalArgumentException("Only supports 0-7");
		int newInt = 30 + color; 
		String code = "\033[" + newInt + "m";
		System.out.print(code);
	}

	/**
	 * Sets color and format in one method call. Uses calls to textForm and textColor.
	 * @param color Sets the text color, 0 grey, 1 red, 2 green, 3 yellow, 4 blue, 5 magenta, 6 cyan, 7 white
	 * @param form Sets the text format, 1 Bold, 2 Dim, 3 Italic, 4 Underline
	 * @throws IllegalArgumentException if the color is outside the range 0-7 or the form is outside the range 1-4
	 */
	public static void textEdit(int color, int form){
		textColor(color);
		textForm(form);
	}

	/**
	 * Prints text with the specified color and format, then resets formatting back to default. Uses calls to textEdit and clearFormat.
	 * @param text The text to print
	 * @param color Sets the text color, 0 grey, 1 red, 2 green, 3 yellow, 4 blue, 5 magenta, 6 cyan, 7 white
	 * @param form Sets the text format, 1 Bold, 2 Dim, 3 Italic, 4 Underline
	 * @throws IllegalArgumentException if the color is outside the range 0-7 or the form is outside the range 1-4
	 */
	public static void printWithFormat(String text, int color, int form){
		textEdit(color, form);
		System.out.print(text);
		clearFormat();
	}

	/**
	 * Printlns text with the specified color and format, then resets formatting back to default. Uses calls to textEdit and clearFormat.
	 * @param text The text to print
	 * @param color Sets the text color, 0 grey, 1 red, 2 green, 3 yellow, 4 blue, 5 magenta, 6 cyan, 7 white
	 * @param form Sets the text format, 1 Bold, 2 Dim, 3 Italic, 4 Underline
	 * @throws IllegalArgumentException if the color is outside the range 0-7 or the form is outside the range 1-4
	 */
	public static void printlnWithFormat(String text, int color, int form){
		textEdit(color, form);
		System.out.println(text);
		clearFormat();
	}

	/*public static void cursorHorizontal(int lines){
		String code = "";
		if(lines < 0)
			code = "\033[" + lines + "C";
		if(lines > 0)
			code = "\033[" + (0-lines) + "D";
		System.out.print(code);
	}

	public static void cursorVertical(int lines){
		
	}*/
}
