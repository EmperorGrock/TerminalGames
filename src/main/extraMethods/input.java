package main.extraMethods;

public class Input{
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