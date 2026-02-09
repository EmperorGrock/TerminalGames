import CardPack.*;
/*
	To Do:
		- Why wont it run???
		- FIX SCORING
			- Currently if both player and dealer bust, player loses. Should be a push.
			- If both player and dealer have same score, should be a push. Currently player loses.
			- If player has blackjack and dealer doesn't, player should win 1.5x bet. Currently just wins normal amount.
			- If dealer has blackjack and player doesn't, player should lose bet.
		- Convert players[] to an ArrayList so that players can be removed when they run out of cash.
		- Aces can be 1 or 11, currently they are always 1.
		- clear terminal after each round? , and turn, so that players can't see each other's cards.
		- Add time module so dealer turn doesnt spit out so much all at once.
		- 

*/
public class Game {
	private Deck gameDeck;
	private BJPlayer[] players;
	private Hand dealerHand;

	public Game(){
		setup();
	}

	private void sleep(int ms){
		try{
			Thread.sleep(ms);
		}catch(InterruptedException e){
			System.out.println("An error occurred while sleeping. ");
		}
	}

	public void dealerTurn(){
		System.out.println("Dealer's Turn: ");
		dealerHand.printStatus();
		while(dealerHand.getScore() < 17){
			sleep(1500);
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
		int numPlayers = 0;
		while(true){
			try{
				numPlayers = Integer.parseInt(IO.readln("Enter the number of players (1-5): "));
				if(numPlayers > 5 || numPlayers < 1){
					System.out.println("Must be 1-5 players.");
				}else break;
			}catch(NumberFormatException e){
				System.out.println("Invalid format.");
			}
		}
		this.players = new BJPlayer[numPlayers];
		this.gameDeck = new Deck();
		for(int i = 0; i < numPlayers; i++){
			players[i] = new BJPlayer(gameDeck);
		}
		this.dealerHand = new Hand(gameDeck, true);
	}

	public void round(){
		dealerHand.restartHand();
		for(BJPlayer p : players){
			p.restartHand();
		}
		for(int i = 0; i < players.length; i++){
			System.out.println("Player " + (i+1) + "'s turn: ");
			players[i].askSplit();
			players[i].placeBets();
			players[i].runTurn();
		}
		dealerTurn();
		for(int i = 0; i < players.length; i++){
			players[i].endTurn(dealerHand.getScore());
			if(players[i].isDead()){
				//players.remove(i);
			}
		}
		
	}

	public static void main(String[] args){
		Game m = new Game();
		while(true){
			m.round();
			if(m.players.length == 0){
				System.out.println("All players are out of cash. Game over.");
				break;
			}
			if(IO.readln("Keep playing? (n) to quit. ").equals("n")){
				System.out.println("Thanks for playing!");
				break;
			}
		}
	}
}
