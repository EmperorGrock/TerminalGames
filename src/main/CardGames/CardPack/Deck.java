package main.cardGames.cardPack;

import java.util.*;

public class Deck {
	private ArrayList<Card> deck = new ArrayList<Card>();

	public Deck(){
		for(int i = 0; i < 13; i++){
			for(int j = 0; j < 4; j++){
				deck.add(new Card(i,j));
			}
		}
	}

	public int size(){
		return deck.size();
	}

	public void resetDeck(){
		deck.clear();
		for(int i = 0; i < 13; i++){
			for(int j = 0; j < 4; j++){
				deck.add(new Card(i,j));
			}
		}
	}

	public Card pickCard(){
		int index = (int)(Math.random()*deck.size());
		Card card = this.deck.get(index);
		int suit = card.getSuit();
		int num = card.getNum();
		Card newCard = new Card(num, suit);
		this.deck.remove(index);
		return newCard;
	}
}
