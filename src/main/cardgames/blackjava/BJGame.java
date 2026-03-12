package main.cardgames.blackjava;

import main.cardgames.cardpack.*;
import main.extramethods.Input;
import main.extramethods.Terminal;

import java.util.ArrayList;

/**
 * A class representing the blackjack game, containing the deck, the players, and the dealer's hand, as well as methods for running the game and each round.
 * The game starts by calling the setup method, which initializes the deck, creates the player objects, and creates the dealer's hand.
 * The runGame method then starts the game, and calls the round method for each round of the game until the players choose to stop or all players are out of cash.
 * The round method handles the flow of each round, including each player's turn, the dealer's turn, and determining the outcome of each player's hand against the dealer's hand.
 * Built for the TerminalGames/cardgames app.
 * @author EmperorGrock
 */
public class BJGame {
	private Deck gameDeck;
	private ArrayList<BJPlayer> players = new ArrayList<BJPlayer>();
	private Hand dealerHand;

	/**
	 * Default constructor for BJGame, which calls the setup method to initialize the game.
	 * The setup method prompts the user for the number of players, initializes the deck, creates the player objects, and creates the dealer's hand.
	 * The game starts with each player having a hand of two cards, and the dealer having one card. 
	 */
	public BJGame(){
		setup();
	}

	/**
	 * Handles the dealer's turn by revealing the dealer's hand, and then drawing cards until the dealer's score is at least 17.
	 */
	public void dealerTurn(){
		Terminal.textColor(1);
		Terminal.textForm(1);
		System.out.println("Dealer's Turn: ");
		Terminal.clearFormat();
		dealerHand.printStatus();
		while(dealerHand.getScore() < 17){
			Terminal.sleep(1.5);
			System.out.println("Dealer Hits. ");
			dealerHand.drawCard();
			dealerHand.printStatus();
		}
		if(dealerHand.getScore() > 21){
				System.out.println("Dealer Busts!");
		}else{
			System.out.println("Dealer Stands. ");
		}

	}

	/**
	 * Sets up the game by prompting the user for the number of players, initializing the deck, creating the player objects, and creating the dealer's hand.
	 */
	public void setup(){
		int numPlayers = Input.getInt("Enter the number of players (1-5)", 1, 5);
		this.gameDeck = new Deck();
		for(int i = 0; i < numPlayers; i++){
			players.add(new BJPlayer(gameDeck));
		}
		this.dealerHand = new Hand(gameDeck, true);
	}

	/**
	 * Handles the flow of each round, including each player's turn, the dealer's turn, and determining the outcome of each player's hand against the dealer's hand.
	 */
	public void round(){
		dealerHand.restartHand();
		for(BJPlayer p : players){
			p.restartHand();
		}
		for(int i = 0; i < players.size(); i++){
			System.out.println("Player " + (i+1) + "'s turn: ");
			players.get(i).placeBets();
			players.get(i).askSplit();
			players.get(i).runTurn();
		}
		dealerTurn();
		for(int i = 0; i < players.size(); i++){
			players.get(i).endTurn(dealerHand.getScore());
			if(players.get(i).isDead()){
				players.remove(i);
				System.out.println("Player " + (i+1) + " is out of cash and is removed from the game. ");
				i--;
			}
		}
		
	}

	/**
	 * Runs the game by repeatedly calling the round method until the players choose to stop or all players are out of cash. 
	 * After each round, the player is prompted to play another round or end the game.
	 */
	public void runGame(){
		while(true){
			round();
			if(players.size() == 0){
				System.out.println("All players are out of cash. Game over.");
				break;
			}
			if(!Input.getYesNo("Would you like to play another round?")){
				System.out.println("Thanks for playing!");
				break;
			}
		}
	}

	/**
	 * The main method to start the game, which creates a new 
	 * BJGame object and calls its runGame method to start the game loop.
	 */
	public static void main(){
		BJGame blackjava = new BJGame();
		blackjava.runGame();
	}
}
