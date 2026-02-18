package main.extraMethods;

public class input{

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

	public static void main(String[] args){
		
	}
}