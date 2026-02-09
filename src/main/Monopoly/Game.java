package main.monopoly;

import java.util.Scanner;
import java.util.ArrayList;

public class Game {
	public static int numPlayers = 0;
	public static int pot = 0;
	public static ArrayList<Player> players = new ArrayList<Player>();
	public static int activePlayer = 0;
	public static Scanner input = new Scanner (System.in);
	// private static boolean hasWon = false;

	public static Player getPlayer() {
		return players.get(activePlayer);
	}

	public static void setup() {
		while (numPlayers > 5 || numPlayers < 2) {
			System.out.println("How many players? (2-5)");
			numPlayers = input.nextInt();
		}
		for (int i = 1; i <= numPlayers; i++) {
			System.out.println("Input player " + i + "'s name: ");
			String name = input.next();
			players.add(new Player(name));
		}
	}

	

	public static void main(String[] args) {

	}
}
