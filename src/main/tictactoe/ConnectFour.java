package main.tictactoe;
import main.extramethods.TwoDHelper;
import main.extramethods.Input;
import main.extramethods.Terminal;

public class ConnectFour{
	private int player;
	private TwoDHelper board;

	public ConnectFour(){}

	public void connectFour(){
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
			hasWon = checkWin();
			if(player == 1) player++;
			else player--;
		}
		board.printWideMap();
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
						board.editCoord(Terminal.BLUE + "o" + Terminal.CLEAR, column, --row);
					}
					break;
				}
			}
		} else 
			return false;
		return true;
	}

	private boolean checkWin(){
		for(int x = 1; x < 8; x++){
			for(int y = 1; y < 7; y++){
				if(!board.getLocation(x, y).equals(" ")){
					if(x < 5){
						if (y > 3){
							if(checkToTopRight(x, y))
								return true;
						}
					}
				}
			}
		}
		return false;
	}

	private boolean checkToTopRight(int x, int y){
		boolean connection = true;
		String origin = board.getLocation(x, y);
		for(int increment = 1; increment < 4; increment++){
			if(!origin.equals(board.getLocation(x+increment,y-increment))){
				connection = false;
				break;
			}
		}
		return connection;
	}
	void main(String[] args){
		connectFour();
	}
}
