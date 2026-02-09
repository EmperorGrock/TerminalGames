package main.monopoly;

import java.util.*;
import java.io.*;

public class CardSpace extends Space{
	protected int cardType;
	protected ArrayList<String> chanceDeckResponses = new ArrayList<String>();
	protected ArrayList<String> communityDeckResponses = new ArrayList<String>();
	protected File chanceText = new File("chanceText.txt");
	protected File communityText = new File("communityText.txt");
	
	

	public CardSpace(int type){ //Type 1 is community chest, type 2 is Chance
		super(((type == 1) ? "Community Chest" : "Chance"),2);//2nd argument is type of space
		cardType = type;
	}

	@Override 
	public void doEffect(Player active){

	}

	private void refreshDeck(int which){
		if(which == 1){
			try(Scanner chanceReader = new Scanner(chanceText)){
				while(chanceReader.hasNextLine()){
					chanceDeckResponses.add(chanceReader.nextLine());
				}
			}catch(FileNotFoundException f){
				System.out.println("File not found.");
			}
		}else if(which == 2){
			try(Scanner communityReader = new Scanner(communityText)){
				while(communityReader.hasNextLine()){
					communityDeckResponses.add(communityReader.nextLine());
				}
			}catch(FileNotFoundException f){
				System.out.println("File not found.");
			}
		}
	}
	//TO DO: Implement an array of card options, somehow? Might be necessary to creat cardDeckChance class

}
