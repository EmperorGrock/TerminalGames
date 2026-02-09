public class Utility extends Property {
	public Utility(String nme) {
		super(nme, 9, 150, 75, 83);
		populateSetsList();
	}

	private void calcRent(int utilOwned) {
		int rollResult = Extras.roll();
		System.out.println("You rolled: " + rollResult);
		if (utilOwned == 1) {
			rent = 4 * rollResult;
		} else if (utilOwned == 2) {
			rent = 10 * rollResult;
		}
	}

	public int getRent() {
		if ((Game.getPlayer().propertiesOwned.contains(Board.boardArray[12]))
		&& 	(Game.getPlayer().propertiesOwned.contains(Board.boardArray[28])))
			calcRent(2);
		else
			calcRent(1);
		return rent;
	}
}
