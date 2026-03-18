package main.monopoly;

public class Extras {
	public static int roll() {
		int die1 = rollOne();
		int die2 = rollOne();
		return die1 + die2;
	}

	public static int rollOne() {
		return (int) (Math.random() * 6) + 1;
	}
}
