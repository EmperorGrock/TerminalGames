package main.cardGames.blackJava;

import java.util.ArrayList;
import main.cardGames.cardPack.*;

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
		printStatus();
		System.out.println("You have " + cash + " dollars.");
		int betAmt = 0;
		while(betAmt == 0){
			try{
				System.out.print("How much would you like to bet? ");
				betAmt = Integer.parseInt(IO.readln());
				System.out.println();
				if(betAmt > cash)
					System.out.println("You don't have that much. ");
				if(betAmt <= 0)
					System.out.println("Please input a positive value. ");
			}catch(NumberFormatException e){
				System.out.println("Invalid type.");
			}
		}
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
		for(int i = 0; i < nums.length; i++){
			nums[i] = list.get(i).getNum();
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
		int response = 0;
		while(response != 1 && response != 2)
		try{
			System.out.print("Hit (1) or stand (2)? ");
			response = Integer.parseInt(IO.readln());
			if(response != 1 && response != 2){
				System.out.println("1 or 2");
			}
		}catch(NumberFormatException e){
			System.out.println("Please input a valid response.");
		}
		if(response == 1) return true;
		else return false;
	}

	public int playHand(){
		while(score <= 21 && askAction()){
			drawCard();
			resetScore();
			printStatus();
		}
		return score;
	}
}

