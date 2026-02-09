package main.monopoly;

public class Railroad extends Property {

	public Railroad(String nme) {
		super(nme, 10, 200, 100, 110);
		populateSetsList();
	}

	private void calcRent(int railsOwned) {
		if (railsOwned == 1) {
			rent = 25;
		} else if (railsOwned == 2) {
			rent = 50;
		} else if (railsOwned == 3) {
			rent = 100;
		} else if (railsOwned == 4) {
			rent = 200;
		}
	}

	public int getRent(int numRails) {
		calcRent(numRails);
		return rent;
	}
}
