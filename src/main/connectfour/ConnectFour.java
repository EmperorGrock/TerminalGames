package main.connectfour;
import main.extramethods.TwoDHelper;
public class ConnectFour {
	public static void connectFour()
	{
		TwoDHelper test = new TwoDHelper(7,9);
		test.printMap();
		test.printWideMap();
	}
	public void main(String[] args){
		connectFour();
	}
}
