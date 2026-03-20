package main.cardgames.cardpack;

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

	public void shuffleDeck(){
		for(int i = 0; i < (int) (Math.random()*50 + 200); i++)
		{
			int firstLocation = (int)(Math.random()*52);
			Card movedCard = deck.remove(firstLocation);
			deck.add((int)(Math.random()*51), movedCard);
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
	void main()
	{
		Deck test = new Deck();
		test.shuffleDeck();
		for(int i = 0; i < 52; i++){
			System.out.print(test.deck.get(i).getNum());
			System.out.println(test.deck.get(i).getSuit());
		}
	}
}
