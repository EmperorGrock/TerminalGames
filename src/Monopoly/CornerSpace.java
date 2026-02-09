public class CornerSpace extends Space{
	protected static int cornerNum;
	public CornerSpace(int which){	//1 is GO, 2 is jail, 3 is Free Parking, 4 is Go to Jail
		super((which == 1) ? "GO"
			: (which == 2) ? "Jail"
			: (which == 3) ? "Free Parking"
			: "Go to Jail", 3);
		cornerNum = which;
	} 

	public static void doEffect(){
		if(cornerNum == 1){
			Game.getPlayer().money += 200;
			System.out.println("Bonus 200 for landing on GO!");
		}else if(cornerNum == 2 && !(Game.getPlayer().jailed)){
			System.out.println("Just Visiting!");
		}else if(cornerNum == 3){
			System.out.println("Free Parking!");
			Game.getPlayer().money += Game.pot;
			Game.pot = 0;
		}else if(cornerNum == 4) {
			System.out.println("GO TO JAIL!");
			Game.getPlayer().jailed = true;
		}
	}
}
