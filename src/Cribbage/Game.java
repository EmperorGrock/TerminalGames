import java.util.ArrayList;
import CardPack.*;

public class Game {
	public Player one = new Player(IO.readln("Input the dealer's name: "), true);
	public Player two = new Player(IO.readln("Input the other player's name: "), false);

	public void executeGame(){

	}

	public void play(){
		int total = 0; 
		var played = new ArrayList<Card>();
		while(total < 31){
			played.add(one.selectCard());
			Card.printCards(played);
			IO.println("Total is: " + total);
			if(total == 15 || total == 31) one.score += 2;
			if(total > 30) break;
			played.add(two.selectCard());
			Card.printCards(played);
			IO.println("Total is: " + total);
			if(total == 15 || total == 31) two.score += 2;
		}
		
		
	}

	
}
