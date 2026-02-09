package main.monopoly;

import java.util.ArrayList;

public class Property extends Space {
	public int owner = -1;
	protected int set;
	protected int price;
	protected int mortgageValue;
	protected int mortgagePayback;
	protected int rent;
	protected int houseCost;
	protected boolean isMortgaged;
	protected ArrayList<String> sets = new ArrayList<String>();

	public Property(String nme, int group, int prce, int mortVal, int mortPay){
		super(nme, 1);
		populateSetsList();
		name = nme;
		set = group;
		price = prce;
		mortgageValue = mortVal;
		mortgagePayback = mortPay;
		setHouseCost();
	}

	private void setHouseCost(){
		if(set == 1 || set == 2){
			houseCost = 50;
		}else if(set == 3 || set == 4){
			houseCost = 100;
		}else if(set == 5 || set == 6){
			houseCost = 150;
		}else if(set == 7 || set == 8){
			houseCost = 200;
		}
	}

	public int getPrice(){
		return price;
	}

	protected void populateSetsList(){
		sets.add("Brown");	sets.add("Light Blue");	sets.add("Purple");	//1-3
		sets.add("Orange");	sets.add("Red");		sets.add("Yellow");	//4-6
		sets.add("Green");	sets.add("Blue");		sets.add("Utility");//7-9
		sets.add("Railroad"); //10
	}

	public int getRent(){
		return rent;
	}
	
}

