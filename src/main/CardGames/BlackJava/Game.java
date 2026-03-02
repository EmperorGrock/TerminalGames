package main.cardgames.blackjava;

import main.cardgames.cardpack.*;
import main.extramethods.Input;
import main.extramethods.Terminal;

import java.util.ArrayList;


public class Game {
	private Deck gameDeck;
	private ArrayList<BJPlayer> players = new ArrayList<BJPlayer>();
	private Hand dealerHand;

	public Game(){
		setup();
	}

	public void dealerTurn(){
		System.out.println("Dealer's Turn: ");
		dealerHand.printStatus();
		while(dealerHand.getScore() < 17){
			Terminal.sleep(1.5);
			System.out.println("Dealer Hits. ");
			dealerHand.drawCard();
			dealerHand.printStatus();
		}
		if(dealerHand.getScore() > 21){
				System.out.println("Dealer Busts!");
		}else{
			System.out.println("Dealer Stands. ");
		}

	}

	public void setup(){
		int numPlayers = Input.getInt("Enter the number of players (1-5)", 1, 5);
		this.gameDeck = new Deck();
		for(int i = 0; i < numPlayers; i++){
			players.add(new BJPlayer(gameDeck));
		}
		this.dealerHand = new Hand(gameDeck, true);
	}

	public void round(){
		dealerHand.restartHand();
		for(BJPlayer p : players){
			p.restartHand();
		}
		for(int i = 0; i < players.size(); i++){
			System.out.println("Player " + (i+1) + "'s turn: ");
			players.get(i).placeBets();
			players.get(i).askSplit();
			players.get(i).runTurn();
		}
		dealerTurn();
		for(int i = 0; i < players.size(); i++){
			players.get(i).endTurn(dealerHand.getScore());
			if(players.get(i).isDead()){
				players.remove(i);
				System.out.println("Player " + (i+1) + " is out of cash and is removed from the game. ");
				i--;
			}
		}
		
	}

	public static void main(String[] args){
		Game m = new Game();
		while(true){
			m.round();
			if(m.players.size() == 0){
				System.out.println("All players are out of cash. Game over.");
				break;
			}
			if(!Input.getYesNo("Would you like to play another round?")){
				System.out.println("Thanks for playing!");
				break;
			}
		}
	}
}
