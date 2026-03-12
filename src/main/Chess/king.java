package main.chess;

import java.util.*;

import main.extramethods.*;

public class King extends Piece {
	private boolean castling;
	private boolean check;
	private boolean checkmate;

	public King(int x, int y, boolean start){
		super(x,y,start);
		castling=true;
		check=false;
		checkmate=false;
	}

	
}
