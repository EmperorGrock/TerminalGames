package main.cardgames;

import main.extramethods.Input;
import main.cardgames.blackjava.BJGame;
import main.cardgames.textbasedholdem.THGame;

public class CardGamesRunner{
	private String[] games = {"Quit", "Blackjava", "Text Based Hold Em", "Cribbage"};
	
	void main(){
		while(true){
			int gameNum = Input.advancedAsk("Which game do you want to play? ", games);
			if(gameNum == 0)
				break;
			if(gameNum == 1)
				BJGame.main();
			if(gameNum == 2)
				THGame.main();
		}
	}
}