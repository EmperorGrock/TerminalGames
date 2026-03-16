package main.tictactoe;

import main.extramethods.Terminal;
import main.extramethods.TwoDHelper;
import main.extramethods.Input;

public class UltimateTacToe {
	private TicTacToe[][] superMap;
	private int player;

	public void executeUltimateTacToe(){
		System.out.println("Unfortunately, Ultimate Tic Tac Toe hasn't been programmed yet!");
	}

	public void executeTestUltimateTacToe(){
		player = 1;
		superMap = new TicTacToe[3][3];
		cleanSuperMap();

	}

	private void cleanSuperMap(){
		for(int x = 0; x < 3; x++)
			for(int y = 0; y < 3; y++){
				superMap[y][x] = new TicTacToe();
				superMap[y][x].setBoard(3);
				superMap[y][x].getBoard().clearMap();
			}
	}

	private void printToes(){
		System.out.println("                |                 |");
		for(int y = 0; y < 3; y++){
			for(int smallY = 0; smallY < 3; smallY++){
				for(int x = 0; x < 3; x++){
					System.out.print("  ");
					System.out.print(superMap[y][x].getBoard().formatWideLine(smallY));
					if(x<2)
						System.out.print("   | ");
				}
				System.out.println();
				if(smallY<2){
					for(int x = 0; x < 3; x++){
						System.out.print(superMap[y][x].getBoard().getWideBorder());
						if(x<2)
							System.out.print("   | ");
					}
				}
				
				if(smallY==2)
					System.out.println("                |                 |");
				else
					System.out.println();
			}
			if(y<2){
				System.out.println("----------------|-----------------|---------------");
				System.out.println("                |                 |");
			}
		}
		System.out.println();
	}

	void main(){
		UltimateTacToe toe = new UltimateTacToe();
		toe.executeTestUltimateTacToe();
	}
}
