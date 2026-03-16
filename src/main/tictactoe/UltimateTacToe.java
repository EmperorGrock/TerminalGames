package main.tictactoe;

import main.extramethods.Terminal;
import main.extramethods.TwoDHelper;
import main.extramethods.Input;

public class UltimateTacToe {
	private TicTacToe[][] superMap = new TicTacToe[3][3];

	public void executeUltimateTacToe(){
		System.out.println("Unfortunately, Ultimate Tic Tac Toe hasn't been programmed yet!");
	}

	public void executeTestUltimateTacToe(){

	}

	private void printToes(){
		for(int y = 0; y < 3; y++){
			for(int smallY = 0; smallY < 3; smallY++){
				for(int x = 0; x < 3; x++){
					System.out.print(superMap[y][x].getBoard().formatWideLine(smallY));
					System.out.print();
				}
				
			}
		}
	}

	void main(){
		UltimateTacToe toe = new UltimateTacToe();
		toe.executeTestUltimateTacToe();
	}
}
