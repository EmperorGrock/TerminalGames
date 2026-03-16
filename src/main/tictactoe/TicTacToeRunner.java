package main.tictactoe;

import main.extramethods.Input;

public class TicTacToeRunner {
	void main(){
		while(true){
			TicTacToe ticTac = new TicTacToe();
			Qubic cube = new Qubic();
			String[] games = {"Quit TicTacToe", "3x3 (Normal)", "4x4 (2D, larger)", "Qubic: 4x4x4 (3D, Huge"};
			int choice = Input.advancedAsk("Which TicTacToe game would you like to play?", games);
			if(choice == 1) break;
			switch(choice){
				case(2):
					ticTac.executeTicTacToe(3);
				case(3):
					ticTac.executeTicTacToe(4);
				case(4):
					cube.executeQubic();
			}
		}
	}
}
