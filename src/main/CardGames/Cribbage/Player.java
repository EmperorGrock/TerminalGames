package main.cardgames.cribbage;

import java.util.*;

import main.cardgames.cardpack.*;

public class Player {
	public int score = 0;
	private String name;
	public boolean dealer;
	private ArrayList<Card> hand = new ArrayList<Card>();
	private ArrayList<Card> crib = new ArrayList<Card>();
	private Card[] cribDonation = new Card[2];

	Player(String name, boolean deal){
		this.name = name;
		this.dealer = deal;
	}

	public void addCard(Card i){
		hand.add(i);
	}

	public String getName(){
		return name;
	}

	public int scoreSet(ArrayList<Card> set){
		int result = 0;
		
		//Form an array of the numbers on cards
		int[] values = new int[set.size()];
		for(int i = 0; i < values.length; i++){
			values[i] = set.get(i).getNum();
		}

		//Form an array of the suits on card
		int[] suits = new int[set.size()];
		for(int i = 0; i < values.length; i++){
			suits[i] = set.get(i).getSuit();
		}

		//Check for pairs/triples
		for(int i = 0; i < values.length; i++){
			for(int j = i + 1; j < values.length; j++){
				if(values[i] == values[j]){
					result += 2;
				}
			}
		}

		// check for 15s
		for(int i : values){
			if(i == 7){
				for(int j : values){
					if(j == 8) result += 2;
				}
			}
			if(i == 5){
				for(int j : values){
					if(j == 9 || j == 10 || j == 11 || j == 12) result += 2;
				}
			}
			if(i == 6){
				for(int j : values){
					if(j == 9) result += 2;
				}
			}
		}

		//check for runs of 3 BUGGED COUNTS A RUN OF 4 AS 2 RUNS OF 3
		for(int i : values){
			boolean less = false;
			boolean more = false;
			for(int j : values){
				if(i == j+1){
					less = true;
				}
				if(i == j - 1){
					more = true;
				}
			}
			if(less && more)
				result += 3;
		}

		//check for flush
		for(int i = 0; i < suits.length; i++){
			int count = 1;
			for(int j = i + 1; j < suits.length; j++){
				if(suits[i] == suits[j])
					count++;
			}
			result += (count == 4) ? 4 : (count == 5) ? 5 : 0;
			if(count >= 2){
				break;
			}
		}

		return result;
	}

	public void drawHand(Deck deck){
		for(int i = 0; i < 6; i++)
			this.hand.add(deck.pickCard());
	}

	public void fillCrib(ArrayList<Card> otherDonation){
		crib.add(cribDonation[0]);
		crib.add(cribDonation[1]);
		crib.add(otherDonation.get(0));
		crib.add(otherDonation.get(1));
	}

	public Card selectCard(){
		Scanner input = new Scanner(System.in);
		ArrayList<Card> handDupe = new ArrayList<>(hand);
		int index;
		Card.printCards(handDupe);
		System.out.print("Enter the index of the card to play: ");
		while(true){
			String typed = input.nextLine();
			try{
				index = Integer.parseInt(typed);
				if(index > -1 && index < handDupe.size()){
					input.close();
					return handDupe.get(index);
				}else System.out.println("Invalid input.");

			}catch(NumberFormatException e){
				IO.println("Invalid input.");
			}
		}
	}

	public void donate(){
		boolean badResponse = true;
		int indicies = -1;
		while(badResponse){
			try{
				indicies = Integer.parseInt(IO.readln("Please type 2 cards to donate: "));
				badResponse = false;
			}catch(IllegalArgumentException e){
				IO.println("Bad response.");
			}
		}
		int first = indicies % 10;
		int second = indicies / 10;
		cribDonation[0] = hand.get(first);
		cribDonation[1] = hand.get(second);
		if(first > second){
			hand.remove(first);
			hand.remove(second);
		}else{
			hand.remove(second);
			hand.remove(first);
		}
	}

	/*public static void main(String[] args){
		Player p = new Player("y", true);
		//Deck d = new Deck();
		//p.drawHand(d);
		IO.println(p.scoreSet(p.hand));
		Card.printCards(p.hand);
		p.selectCard().printCard();
		Card.printCards(p.hand);
	}*/
}
