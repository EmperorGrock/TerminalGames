package main.tictactoe;

import main.extramethods.Input;

public class TicTacToeRunner {
	void main(){
		while(true){
			TicTacToe ticTac = new TicTacToe();
			Qubic cube = new Qubic();
			ConnectFour connect = new ConnectFour();
			String[] games = {"Quit TicTacToe", "Connect Four", "3x3 (Normal)", "4x4 (2D, larger)", "5x5 (2D, HUGE)", "Qubic: 4x4x4 (3D, Huge, complicated)"};
			int choice = Input.advancedAsk("Which TicTacToe game would you like to play?", games);
			if(choice == 1) break;
			switch(choice){
				case(2):
					ticTac.executeTicTacToe(3);
					break;
				case(3):
					connect.connectFour();
					break;
				case(4):
					ticTac.executeTicTacToe(4);
					break;
				case(5):
					ticTac.executeTicTacToe(5);
					break;
				case(6):
					cube.executeQubic();
					break;
			}
		}
	}
}
