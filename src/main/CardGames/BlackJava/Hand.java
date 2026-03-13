package main.cardgames.blackjava;

import java.util.ArrayList;

import main.cardgames.cardpack.*;
import main.extramethods.Input;

public class Hand {
	private ArrayList<Card> hand = new ArrayList<Card>();
	private Deck deck;
	private int score = 0;
	private int bet = 0;
	private boolean dealerHand = false;

	public Hand(Deck d){
		deck = d;
		hand.add(deck.pickCard());
		hand.add(deck.pickCard());
	}

	public Hand(Deck d, boolean dealerHand){
		deck = d;
		hand.add(deck.pickCard());
		this.dealerHand = dealerHand;
	}

	public Hand(Hand other){
		this.hand.add(other.get(1));
		other.remove(1);
	}

	public void drawCard(){
		hand.add(deck.pickCard());
	}

	public void restartHand(){
		hand.clear();
		if(dealerHand){
			hand.add(deck.pickCard());
		}else{
			hand.add(deck.pickCard());
			hand.add(deck.pickCard());
		}
	}

	public void placeBet(int cash){
		System.out.println("You have " + cash + " dollars.");
		int betAmt = Input.getInt("How much would you like to bet?", 1, cash);
		this.bet = betAmt;
	} 

	public int getBet(){
		return bet;
	}

	public void setBet(int newBet){
		this.bet = newBet;
	}

	public int getScore(){
		resetScore();
		return score;
	}

	public Card get(int index){
		return hand.get(index);
	}

	public void remove(int index){
		this.hand.remove(index);
	}

	public boolean canSplit(){
		if(hand.get(0).getNum() == hand.get(1).getNum()) 
			return true;
		return false;
	}

	public boolean beatDealer(int dealerScore){
		if(score > 21) return false;
		if(score > dealerScore)
			return true;
		return false;
	}

	public static int[] formIntArray(ArrayList<Card> list){
		int[] nums = new int[list.size()];
		int total = 0;
		for(int i = 0; i < nums.length; i++){
			nums[i] = list.get(i).getNum();
			total += nums[i];
			if (list.get(i).getNum() == 0 && total < 11){
				nums[i] += 10;
				total += 10;
			}
			nums[i]++;
			if(nums[i] > 10) nums[i] = 10;
		}
		return nums;
	}

	public void printStatus(){
		Card.printCards(hand);
		resetScore();
		System.out.println(score);
	}

	public void resetScore(){
		int[] vals = formIntArray(hand);
		score = 0;
		for(int v : vals) 
			score += v;
	}

	public boolean askAction(){
		boolean hit = Input.getYesNo("Hit?");
		if(hit) return true;
		else return false;
	}

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

