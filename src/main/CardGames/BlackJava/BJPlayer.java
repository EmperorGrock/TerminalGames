package main.cardGames.blackJava;

import main.cardGames.cardPack.*;

public class BJPlayer {
	private int cash = 1000;
	private Hand hand;
	private Hand otherHand;

	public BJPlayer(Deck d){
		hand = new Hand(d);
	}

	public void restartHand(){
		hand.restartHand();
		if(otherHand != null)
			otherHand.restartHand();
	}

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

	public void editCash(int amt){
		cash += amt;
	}

	public boolean isDead(){
		if(cash < 1) 
			return true;
		return false;
	}

	public void askSplit(){
		if(hand.canSplit()){
			System.out.println("Would you like to split? (y/n): ");
			String response = IO.readln();
			System.out.println();
			while(!(response.equals("y") || response.equals("n"))){
				System.out.println("Please input y or n. ");
				response = IO.readln();
				System.out.println();
			}
			if(response.equals("y")){
				otherHand = new Hand(hand);
			}
		}
	}

	public void runTurn(){
		hand.playHand();
		if(otherHand != null)
			otherHand.playHand();
	}
}
