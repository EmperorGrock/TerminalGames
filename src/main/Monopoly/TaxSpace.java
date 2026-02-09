package main.monopoly;

public class TaxSpace extends Space {
	protected int taxType;
	protected int cost;

	public TaxSpace(int type) { // 1 is Income Tax, 2 is Luxury Tax
		super((type == 1) ? "Income Tax" : "Luxury Tax", 3);
		taxType = type;
		cost = (type == 1) ? 200 : 100;
	}

	public int getCost() {
		return cost;
	}
}
