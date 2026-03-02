package main.extramethods;

public class Input{

	//Print the message, and keep asking for input until an integer is entered
	public static int getInt(String message){
		System.out.print(message + ": ");
		int input = 0;
		while(true){
			try{
				input = Integer.parseInt(System.console().readLine());
				break;
			}catch(NumberFormatException e){
				System.out.println("Invalid input. Please enter an integer.");
			}
		}
		return input;
	}

	//Print the message and keep asking for an int until it is within the range
	public static int getInt(String message, int min, int max){
		int input = 0;
		while(true){
			input = getInt(message);
			if(input >= min && input <= max){
				break;
			}else{
				System.out.println("Input must be between " + min + " and " + max + ".");
			}
		}
		return input;
	}

	//Print message, then keep asking until input is y or n, y returns true, n returns false
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
	//Prints list of choices then keeps asking until user inputs desired choice. Returns user choice
	//Input null for message if you want the default message	
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

	public static void main(String[] args){
		
	}
}