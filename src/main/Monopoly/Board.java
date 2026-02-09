package main.monopoly;

public class Board { // This class contains methods to access attibutes of spaces on the board.
	public static Space[] boardArray = {
		new CornerSpace(1), 							new Property("Mediterranean Ave",1,60,30,33),	new CardSpace(1),
		new Property("Baltic Ave",1,60,30,33),			new TaxSpace(1),								new Railroad("Reading Railroad"),				
		new Property("Oriental Ave",2,100,50,55),		new CardSpace(2),								new Property("Vermont Ave",2,100,50,55),		
		new Property("Connecticut Ave",2,120,60,66),	new CornerSpace(2),								new Property("St. Charles Place",3,140,70,77),	
		new Utility("Electric Company"),				new Property("States Ave",3,140,70,77),			new Property("Virginia Ave",3,160,80,88),		
		new Railroad("Pennsylvania Railroad"),			new Property("St. James Place",4,180,90,99),	new CardSpace(1),								
		new Property("Tennessee Ave",4,180,90,99),		new Property("New York Ave",4,200,100,110),		new CornerSpace(3),
		new Property("Kentucky Ave",5,220,110,121),		new CardSpace(2),								new Property("Indiana Ave",5,220,110,121),	
		new Property("Illinois Ave",5,240,120,132),		new Railroad("B & O Railroad"),					new Property("Atlantic Ave",6,260,130,143),		
		new Property("Ventnor Ave",6,260,130,143),		new Utility("Water Works"),						new Property("Marvin Gardens",6,280,140,154),	
		new CornerSpace(4),								new Property("Pacific Ave",7,300,150,165),		new Property("North Carolina Ave",7,300,150,165),
		new CardSpace(1),								new Property("Pennsylvania Ave",7,320,160,176),	new Railroad("Short Line"),						
		new CardSpace(2),								new Property("Park Place",8,350,175,193),		new TaxSpace(2),
		new Property("Boardwalk",8,400,200,220)
	};
}
