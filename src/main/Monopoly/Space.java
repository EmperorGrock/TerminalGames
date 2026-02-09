package main.monopoly;

public class Space {
	protected int spaceType;
	protected String name;
	protected String[] spaceTypesArray = { "Property", "Card", "Tax", "Corner" };

	public Space(String nme, int type) {
		name = nme;
		spaceType = type;
	}

	public String getType() {
		return spaceTypesArray[spaceType];
	}

	public String getName() {
		return name;
	}

	public void doEffect(Player active){}
}
