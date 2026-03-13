package main.cardgames.blackjava;

import main.cardgames.cardpack.*;
import main.extramethods.Input;
import main.extramethods.Terminal;

/**
 * A class representing a player in the blackjack game, containing their hand(s) of cards, their cash, and methods for placing bets, 
 * playing their turn, and determining if they beat the dealer.
 * Built for the TerminalGames/cardgames app.
 * @author EmperorGrock
 */
public class BJPlayer {
	private int cash = 1000;
	private Hand hand;
	private Hand otherHand;

	/**
	 * Constructor for a blackjack player, which initializes their hand by drawing two cards from the provided deck.
	 * @param d The deck to draw cards from for the player's hand
	 */
	public BJPlayer(Deck d){
		hand = new Hand(d);
	}

	/**
	 * Resets the player's hand by creating a new hand with two new cards drawn from the deck, 
	 * and also resets the other hand if it exists (used for splitting).
	 */
	public void restartHand(){
		hand.restartHand();
		if(otherHand != null)
			otherHand.restartHand();
	}

	/**
	 * NOTE: MAY BE BUGGY, NEED TO TEST/FIX
	 * Ends the player's turn by comparing their hand(s) to the dealer's hand and updating their cash accordingly.
	 * @param dealerAmt The score of the dealer's hand
	 */
	public void endTurn(int dealerAmt){
		if(hand.beatDealer(dealerAmt)){
			System.out.println("You win!");
			editCash(hand.getBet());
		}else{
			System.out.println("You lose.");
			editCash(0-hand.getBet());
		}
		if(otherHand != null){
			if(otherHand.beatDealer(dealerAmt)){
				System.out.println("Your second hand wins!");
				editCash(otherHand.getBet());
			}else{
				System.out.println("Your second hand loses.");
				editCash(0-otherHand.getBet());
			}
		}
	}

	/**
	 * Places the player's bet for the current hand(s). If the player has split their hand, they can only bet half of their cash on each hand.
	 */
	public void placeBets(){
		if(otherHand != null){
			System.out.println("Because you splitted, only half cash is available for each hand. ");
			hand.placeBet(cash/2);
			otherHand = new Hand(hand);
			otherHand.setBet(hand.getBet());
		}else{
			hand.placeBet(cash);

		}
	}

	/**
	 * Edits the player's cash by adding the specified amount. Used for updating the player's cash after winning or losing a hand.
	 * @param amt The amount to add to the player's cash (can be negative for losing a bet)
	 */
	public void editCash(int amt){
		cash += amt;
	}

	/**
	 * Determines if the player is out of cash, which is true if their cash is less than 1.
	 * @return true if the player is out of cash, false otherwise
	 */
	public boolean isDead(){
		if(cash < 1) 
			return true;
		return false;
	}

	/**
	 * Asks the player if they want to split their hand, if possible, and if they do, creates a new hand for the second part of the split.
	 */
	public void askSplit(){
		if(hand.canSplit()){
			boolean response = Input.getYesNo("Would you like to split?");
			if(response){
				otherHand = new Hand(hand);
			}
		}
	}

	/**
	 * Calls the player's hand's playHand, and if otherHand is activated from splitting, also calls otherHand's playHand.
	 */
	public void runTurn(){
		hand.playHand();
		if(otherHand != null)
			otherHand.playHand();
	}
}
