package main.tictactoe;

import helpers.Input;

public class ToeRunner {
	public static final String[] games = {"Quit TicTacToe", "Connect Four", "3x3 (Normal)", "4x4 (2D, larger)", "5x5 (2D, HUGE)", "Qubic: 4x4x4 (3D, Huge, complicated)", 
			"Ultimate TicTacToe (9x9x9, special rules)"};

	public static void run(){
		while(true){
			TicTacToe ticTac;
			int choice = Input.advancedAsk("Which TicTacToe game would you like to play?", games);
			if(choice == 1) break;
			switch(choice){
				case(2):
					ConnectFour connect = new ConnectFour();
					connect.connectFour();
					break;
				case(3):
					ticTac = new TicTacToe();
					ticTac.executeTicTacToe(3);
					break;
				case(4):
					ticTac = new TicTacToe();
					ticTac.executeTicTacToe(4);
					break;
				case(5):
					ticTac = new TicTacToe();
					ticTac.executeTicTacToe(5);
					break;
				case(6):
					Qubic cube = new Qubic();
					cube.executeQubic();
					break;
				case(7):
					UltimateToe ult = new UltimateToe();
					ult.executeUltimateTacToe();
					break;
			}
		}
	}

	public static void main(String[] args){
		run();
	}
}
