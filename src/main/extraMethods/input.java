package main.extramethods;


/**
 * A class with multiple static methods for various input types and styles. 
 * Built for the TerminalGames app.
 * 
 * @author Catmaoneko 
 * @author EmperorGrock
 */
public class Input{

	public static int checkInt(String message){
		int input = 0;
		while(true){
			try{
				input = Integer.parseInt(message);
				break;
			}catch(NumberFormatException e){
				System.out.println("Invalid input. Please enter an integer.");
			}
		}
		return input;
	}
	/**
	 * Print the message, and keep asking for input until an integer is entered
	 * @param message The message to print before asking for input
	 * @return The integer that the user entered
	 */
	public static int getInt(String message){
		System.out.print(message + ": ");
		int input;
		while(true){
			try{
				input = Integer.parseInt(System.console().readLine());
				break;
			}catch(NumberFormatException e){
				System.out.println("Invalid input. Please enter an integer.");
				continue;
			}
		}
		return input;
	}

	/**
	 * Print the message, and keep asking for input until an integer is entered that is within the provided range (inclusive)
	 * @param message The message to print before asking for input
	 * @param min The minimum acceptable value (inclusive)
	 * @param max The maximum acceptable value (inclusive)
	 * @return The integer that the user entered
	 */
	public static int[] getInt(String message, int min, int max, int dimensions){
		boolean allowed = false;
		int[] input = new int[dimensions];
		do{
			System.out.print(message + ": ");
			String[] splString = System.console().readLine().split(",");
			if (splString.length != dimensions){
				System.out.println("Invalid Syntax.");
				continue;
			}
			for(int i = 0; i < dimensions; i++){
				input[i] = checkInt(splString[i]);
				if(input[i] < min || input[i] > max){
					System.out.println("Input must be between " + min + " and " + max + ".");
				} else {
					allowed = true;
				}
			}
		} while(!allowed);
		return input;
	}

	/**
	 * Print the message, and keep asking for input until a valid 'y' or 'n' is entered
	 * @param message The message to print before asking for input
	 * @return true if the user entered 'y', false if the user entered 'n'
	 */
	public static boolean getYesNo(String message){
		System.out.print(message + " (y/n): ");
		String input = "";
		while(true){
			input = System.console().readLine().toLowerCase();
			if(input.equals("y")){
				return true;
			}else if(input.equals("n")){
				return false;
			}else{
				System.out.println("Invalid input. Please enter 'y' or 'n'.");
			}
		}
	}

	/**
	 * Print the message and a list of choices, and keep asking for input until a valid choice is entered
	 * @param message The message to print before the list of choices (if null, a default message will be printed)
	 * @param choices An array of strings representing the choices to present to the user
	 * @return The index of the choice that the user selected (1-based index)
	 */
	public static int advancedAsk(String message,String[] choices){
		int input=0;
		if (message.equals(null)){
			System.out.println("Please choose from the following");
		} else {
			System.out.println(message);
		}
		for (int i=0;i<choices.length;i++){
			System.out.println((i+1)+": "+choices[i]);
		}
		while (true){
			try{

				input=Integer.parseInt(System.console().readLine());
				if (input<1 || input>choices.length){
					if (message.equals(null)){
						System.out.println("Please enter a valid value");
					} else {
						System.out.println(message);
					}
					continue;
				}
				return input;
			} catch (NumberFormatException e){
				if (message.equals(null)){
					System.out.println("Please enter a valid value");
				} else {
					System.out.println(message);
				}
			}
		}
	}		
}