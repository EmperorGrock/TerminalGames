package main.connectfour;
import main.extramethods.TwoDHelper;
import main.extramethods.Input;
import main.extramethods.Terminal;

public class ConnectFour{
	private int player;
	private TwoDHelper board;

	public ConnectFour(){}

	public void connectFour()
	{
		player = 1;
		board = new TwoDHelper(7,6);
		boolean hasWon = false;
		while(!hasWon){
			board.printWideMap();
			System.out.println("It is player " + player + "'s turn!");
			int Coord = Input.getInt("Enter Coordinate", 1, 7);
			if(!processCoordinate(Coord))
			{
				System.out.println("That column is full! Try again.");
				continue;
			}
			if(player == 1) player++;
			else player--;
		}
	}

	private boolean processCoordinate(int column){
		if(board.getLocation(column, 1).equals(" ")){
			int row = 1;
			while(row <= 6){
				if(board.getLocation(column, row).equals(" ") && row < 6) 
					row++;
				else if(board.getLocation(column, row).equals(" ") && row == 6){
					if(player == 1){
						board.editCoord(Terminal.RED + "x" + Terminal.CLEAR, column, row);
					}else if(player == 2){
						board.editCoord(Terminal.BLUE + "o" + Terminal.CLEAR, column, row);
					}
					break;
				}
				else{
					if(player == 1){
						board.editCoord(Terminal.RED + "x" + Terminal.CLEAR, column, --row);
					}else if(player == 2){
						board.editCoord(Terminal.BLUE + "o" + Terminal.CLEAR, column, row);
					}
					break;
				}
			}
		} else 
			return false;
		return true;
	}
	public void main(String[] args){
		connectFour();
	}
}
