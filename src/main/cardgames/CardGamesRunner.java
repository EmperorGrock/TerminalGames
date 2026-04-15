package main.cardgames;

import helpers.Input;
import main.cardgames.blackjava.BJGame;
import main.cardgames.textbasedholdem.THGame;
import helpers.Terminal;

public class CardGamesRunner{
	public final static String[] games = {"Quit", "Blackjava", "Text Based Hold Em", "Cribbage"};

	public static void run(){
		BJGame blackJava;
		while(true){
			int gameNum = Input.advancedAsk("Which game do you want to play? ", games);
			if(gameNum == 1) break;
			switch(gameNum){
				case(2):
					blackJava = new BJGame();
					blackJava.runGame();
				case(3):
					Terminal.printlnWithFormat("Coming soon!", 5, 3);
				case(4):
					Terminal.printlnWithFormat("Cribbage is still in testing.", 5, 3);
			}
		}
	}
	
	
	public static void main(String[] args){
		run();
	}
}