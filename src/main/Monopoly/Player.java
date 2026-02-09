import java.util.HashSet;

public class Player {
	private String name; // name of the player
	public int money; // player money
	private int location; // the position on the game board
	public boolean jailed;
	private int jailPasses;
	public HashSet<Property> propertiesOwned = new HashSet<Property>();
	private HashSet<String> setsOwned = new HashSet<String>();

	public Player(String nme) { // Constructor for the Player class, set attributes at the start
		name = nme; // Set the player name from the Argument
		money = 1500;
		location = 0;
		jailed = false;
		jailPasses = 0;
	}

	public void executeTurn(){
		startTurn();
		moveSpaces();
		landOnSpace();
	}

	public void landOnSpace(){
		Space landed = Board.boardArray[location];
		if(landed instanceof Property){

		}
		landed.doEffect(this);
	}

	//public void buyProperty(int propertyID)


	public void startTurn() { // At the start of the turn, print whose turn it is and how much money they have
		System.out.println("It is " + name + "'s turn!");
		System.out.println("You have " + money + " dollars.");
	}

	public void moveSpaces() { // Roll dice, print the result, and update the location variable
		int spacesMoved = Extras.roll();
		System.out.println("You roll... A " + spacesMoved + "!");
		location += spacesMoved;
		if (location >= 40) { // If you go more than whole way around the board, subtract the length of the
								// board & receive GO money
			location -= 40;
			money += 200;
		}
	}

}
