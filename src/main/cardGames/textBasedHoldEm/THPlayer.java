package main.cardgames.textbasedholdem;

import main.cardgames.cardPack.*;
import main.extramethods.Input;

public class THPlayer {
	private int cash = 1000;
	private Card[] hand;

	public THPlayer(Deck d){
		hand = new Card[2];
		hand[0] = d.pickCard();
		hand[1] = d.pickCard();
	}

	/*public int bet(int amtInPot){
		System.out.println();
		Input.getInt(amtInPot + " to you." , 0, cash);
	}*/
}
