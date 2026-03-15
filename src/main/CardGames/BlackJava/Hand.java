package main.cardgames.blackjava;

import java.util.ArrayList;

import main.cardgames.cardpack.*;
import main.extramethods.Input;

/**
 * Represents a hand of cards in the blackjack game.
 * Contains methods for drawing cards, calculating score, placing bets, and playing the hand.
 * Built for the TerminalGames/cardgames app.
 * @author EmperorGrock
 */
public class Hand {
	private ArrayList<Card> hand = new ArrayList<Card>();
	private Deck deck;
	private int score = 0;
	private int bet = 0;
	private boolean dealerHand = false;

	/**
	 * Constructor for a hand that is not the dealer's hand. Draws two cards from the deck.
	 * @param d The deck to draw cards from
	 */
	public Hand(Deck d){
		deck = d;
		hand.add(deck.pickCard());
		hand.add(deck.pickCard());
	}

	/** 
	 * Constructor for the dealer's hand. 
	 * Draws one card from the deck, if dealerHand is true, otherwise draws two cards.
	 * @param d The deck to draw cards from
	 * @param dealerHand Whether this hand is the dealer's hand or not.
	*/
	public Hand(Deck d, boolean dealerHand){
		deck = d;
		hand.add(deck.pickCard());
		if(!dealerHand) hand.add(deck.pickCard());
		this.dealerHand = dealerHand;
	}

	/** 
	 * Constructor for splitting a hand. Takes a card from the other hand, 
	 * and adds it to this hand, and removes it from the other hand.
	 * @param other The hand to split
	 */
	public Hand(Hand other){
		this.hand.add(other.get(1));
		other.remove(1);
	}

	/**
	 * Draws a card from the deck and adds it to the hand.
	 */
	public void drawCard(){
		hand.add(deck.pickCard());
	}

	/**
	 * Restarts the hand by clearing the current hand and drawing new cards from the deck.
	 * If this is the dealer's hand, only one card is drawn, otherwise two cards are drawn.
	 */
	public void restartHand(){
		hand.clear();
		if(dealerHand){
			hand.add(deck.pickCard());
		}else{
			hand.add(deck.pickCard());
			hand.add(deck.pickCard());
		}
	}

	/**
	 * Prompts the user to place a bet, and sets the bet for this hand. 
	 * The bet must be between 1 and the amount of cash the player has.
	 * @param cash The amount of cash the player has, which is the maximum bet allowed.
	 */
	public void placeBet(int cash){
		System.out.println("You have " + cash + " dollars.");
		int betAmt = Input.getInt("How much would you like to bet?", 1, cash);
		this.bet = betAmt;
	} 

	/**
	 * Returns the current bet for this hand.
	 * @return The current bet for this hand
	 */
	public int getBet(){
		return bet;
	}

	/**
	 * Sets the bet for this hand to a new value. 
	 */
	public void setBet(int newBet){
		this.bet = newBet;
	}

	/**
	 * Returns the current score for this hand.
	 * @return The current score for this hand
	 */
	public int getScore(){
		resetScore();
		return score;
	}

	/**
	 * Returns the card at the specified index in the hand.
	 * @param index The index of the card to return
	 * @return The card at the specified index
	 */
	public Card get(int index){
		return hand.get(index);
	}

	/**
	 * Removes the card at the specified index from the hand. Used for splitting a hand.
	 * @param index The index of the card to remove
	 */
	public void remove(int index){
		this.hand.remove(index);
	}

	/**
	 * Checks if the hand can be split, which is true if the first two cards in the hand have the same number.
	 * @return true if the hand can be split, false otherwise
	 */
	public boolean canSplit(){
		if(hand.get(0).getNum() == hand.get(1).getNum()) 
			return true;
		return false;
	}

	/**
	 * NOTE: MAY BE BUSTED, NEED TO TEST/FIX
	 * Determines if this hand beats the dealer's hand, which is true if the score of this hand is greater than the dealer's score, 
	 * and this hand is not busted (score over 21).
	 * @param dealerScore The score of the dealer's hand to compare against
	 * @return true if this hand beats the dealer's hand, false otherwise
	 */
	public boolean beatDealer(int dealerScore){
		if(score > 21) return false;
		if(score > dealerScore)
			return true;
		return false;
	}

	/**
	 * NOTE: ACES ARE ALWAYS COUNTED AS 1, NOT 11, NEED TO TEST/FIX
	 * Helper method that takes a list of cards and returns an array of their values, 
	 * with face cards counting as 10, and aces counting as 1.
	 * @param list The ArrayList of cards to convert to an array of values
	 * @return An array of the values of the cards in the list, with face cards counting as 10, and aces counting as 1
	 */
	public static int[] formIntArray(ArrayList<Card> list){
		int[] nums = new int[list.size()];
		int total = 0;
		for(int i = 0; i < nums.length; i++){
			nums[i] = list.get(i).getNum();
			total += nums[i];
			if(nums[i] > 10) nums[i] = 10;
			if (list.get(i).getNum() == 0 && total < 11){
				nums[i] += 10;
				total += 10;
			}
			nums[i]++;
		}
		return nums;
	}

	/**
	 * Prints the cards in the hand and the current score. 
	 * Used for displaying the player's hand during their turn.
	 */
	public void printStatus(){
		Card.printCards(hand);
		resetScore();
		System.out.println(score);
	}

	/**
	 * NOTE: ACES ARE ALWAYS COUNTED AS 1, NOT 11, NEED TO TEST/FIX
	 * Resets the score for this hand by calculating the sum of the values of the cards in the hand,
	 * with face cards counting as 10, and aces counting as 1.
	 */
	public void resetScore(){
		int[] vals = formIntArray(hand);
		score = 0;
		for(int v : vals) 
			score += v;
	}

	/**
	 * Asks the user if they want to hit or not, and returns true if they want to hit, false otherwise.
	 */
	public boolean askAction(){
		boolean hit = Input.getYesNo("Hit?");
		if(hit) return true;
		else return false;
	}

	/**
	 * Plays the hand by repeatedly asking the user if they want to hit, and drawing a card if they do, until they either choose to stand or bust.
	 * @return The final score of the hand after the player has finished their turn
	 */
	public int playHand(){
		printStatus();
		while(score <= 21 && askAction()){
			drawCard();
			resetScore();
			printStatus();
		}
		if(score > 21) System.out.println("BUSTED!");
		return score;
	}
}

