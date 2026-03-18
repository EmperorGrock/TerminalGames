import main.cardgames.CardGamesRunner;
import main.extramethods.Input;
import main.extramethods.Terminal;
import main.tictactoe.TicTacToeRunner;

public class App {
	private static String[] games = {"Quit", "Card Games", "TicTacToe", "Chess", "Monopoly"};
	public static void main(String[] args){
		int input = Input.advancedAsk("Which games would you like?", games);
		switch(input){
			case(2):
				Terminal.printlnWithFormat("Card Games are coming soon! ", 5, 3);
				break;
			case(3):
				TicTacToeRunner.run();
			case(4):
				Terminal.printlnWithFormat("Chess is coming soon! ", 5, 3);
			case(5):
				Terminal.printlnWithFormat("Monopoly code is a train wreck, to be fixed soon! ", 5, 3);
		}
		
	}
}
