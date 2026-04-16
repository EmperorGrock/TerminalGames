import main.cardgames.CardGamesRunner;
import helpers.Terminal;
import helpers.Input;
import main.tictactoe.ToeRunner;

public class App {
	private static String[] games = {"Quit", "Card Games", "TicTacToe", "Chess", "Monopoly"};

	public static void run(){
		Terminal.clearTerminal();
		while(true){
			int input = Input.advancedAsk("Which games would you like?", games);
			if(input == 1) break;
			switch(input){
				case(2):
					Terminal.printlnWithFormat("Card Games are coming soon! ", 5, 3);
					break;
				case(3):
					ToeRunner.run();
					break;
				case(4):
					Terminal.printlnWithFormat("Chess is coming soon! ", 5, 3);
					break;
				case(5):
					Terminal.printlnWithFormat("Monopoly code is a train wreck, to be fixed soon! ", 5, 3);
					break;
			}
		}
	}
	public static void main(String[] args){
		run();
	}
}
