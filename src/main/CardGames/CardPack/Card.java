package main.cardGames.cardPack;

import java.util.ArrayList;

public class Card {
	private int number;
	private int suit;
	private static final String top = "_______";
	private static final String bottom = "-------";
	private static final String middle = "|     |";
	//Spades, Clubs, Hearts, Diamond
	private final static String[] suits = {"\u2660", "\u2663", "\u2665", "\u2666"};
	//A-K, 0-12
	private final static String[] identity = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

	Card(int number, int suit){
		this.number = number;
		this.suit = suit;
	}

	Card(){
		this.number = (int)(Math.random()*13);
		this.suit = (int)(Math.random()*4);
	}

	public int getNum(){
		return this.number;
	}

	public int getSuit(){
		return this.suit;
	}

	public static void printBack(){
		System.out.println(top);
		System.out.println("|/////|");
		System.out.println("|\\\\\\\\\\|");
		System.out.println("|/////|");
		System.out.println(bottom);
	}

	private static String data(Card c){
		if(c.number == 9) return ("| " + suits[c.suit] + identity[c.number] + " |");
		else return ("| " + suits[c.suit] + " " + identity[c.number] + " |");
	}

	public void printCard(){
		System.out.println(top);
		System.out.println(data(this));
		System.out.println(middle);
		System.out.println(data(this));
		System.out.println(bottom);
	}

	public static void printCards(Card[] array){
		int max = array.length;
		for(int i = 0; i < max; i++){
			System.out.print(top + "   ");
		}
		System.out.println();
		for(Card i : array){
			System.out.print(data(i) + "   ");
		}
		System.out.println();
		for(int i = 0; i < max; i++){
			System.out.print(middle + "   ");
		}
		System.out.println();
		for(Card i : array){
			System.out.print(data(i) + "   ");
		}
		System.out.println();
		for(int i = 0; i < max; i++){
			System.out.print(bottom + "   ");
		}
		System.out.println();
	}

	public static void printCards(ArrayList<Card> array){
		int max = array.size();
		for(int i = 0; i < max; i++){
			System.out.print(top + "   ");
		}
		System.out.println();
		for(Card i : array){
			System.out.print(data(i) + "   ");
		}
		System.out.println();
		for(int i = 0; i < max; i++){
			System.out.print(middle + "   ");
		}
		System.out.println();
		for(Card i : array){
			System.out.print(data(i) + "   ");
		}
		System.out.println();
		for(int i = 0; i < max; i++){
			System.out.print(bottom + "   ");
		}
		System.out.println();
	}

	void main(String[] args){
		var n = new ArrayList<Card>();
		n.add(new Card(0, 0));
		n.add(new Card(12, 3));
		printCards(n);
	}
}
