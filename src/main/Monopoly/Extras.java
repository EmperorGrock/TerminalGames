package main.monopoly;

public class Extras {
	public static boolean yesOrNoResponse() {
		System.out.println("(y/n): ");
		String response = Game.input.next();
		while (!(response.equals("y") || response.equals("n"))) {
			System.out.println("Please input a valid respose.");
			response = Game.input.nextLine();
		}
		if (response.equals("y")) return true;
		return false;

	}

	public static int roll() {
		int die1 = rollOne();
		int die2 = rollOne();
		return die1 + die2;
	}

	public static int rollOne() {
		return (int) (Math.random() * 6) + 1;
	}
}
