package main.extramethods;

public class Terminal{
	public static void clearTerminal(){
		//Clear screen
		System.out.print("\033[2J");
		//Place cursor
		System.out.print("\033[H");
		//Clear scroll back (Most consoles)
		System.out.print("\033[3J");
		//IDK
		System.out.flush();
	}

	public static void clearFormat(){
		System.out.print("\033[0m");
	}

	/**
	 * Formats text such as bold, underline, italic
	 * @param which  1 Bold, 2 Dim, 3 Italic, 4 Underline, 7 Inverse
	 * @throws IllegalArgumentException  When the input isn't one of the specified ints
	 */
	public static void textForm(int which){
		// 
		if((which < 1 || which > 4 ) && which != 7)
			throw new IllegalArgumentException("Only supports 1-4 and 7");
		System.out.print("\033[" + which + "m");
	}

	/**
	 * Sets the text color to one of 7 colors
	 * @param color  Sets the color 0 grey, 1 red, 2 green, 3 yellow, 4 blue, 5 magenta, 6 cyan, 7 white
	 * @throws IllegalArgumentException if the color is outside the range
	*/
	public static void setTextColor(int color){
		if(color < 0 || color > 7)
			throw new IllegalArgumentException("Only supports 0-7");
		int newInt = 30 + color; 
		String code = "\033[" + newInt + "m";
		System.out.print(code);
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

	void main(){
		System.out.print("yayp");
		//cursorHorizontal(3);
		setTextColor(0);
		textForm(7);
		System.out.print("wow");
	}
}
