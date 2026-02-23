package main.Chess;

import java.util.InputMismatchException;
import main.extraMethods.*;
import java.util.ArrayList;

public class board {
	final static piece[][] location= new piece[8][8]; //chess is 8x8 fixed. Does not need a method to initialize
	//This board is orientated so that the white pieces are at the bottom and the black are at the top.

	//This is a place to record which piece moved where in order. May not be used.
	ArrayList<piece> replay=new ArrayList<>();

	public static void clear(int x, int y){
		location[x][y]=null;
	}

	public static void setPiece(piece subject, int x, int y){
		clear(subject.xLocation,subject.yLocation);
		location[x][y]=subject;
	}

	public static void initialize(){
		//Needs better names for pieces maybe

		//white pawns
		pawn p1w=new pawn(0,1,true);
		pawn p2w=new pawn(1,1,true);
		pawn p3w=new pawn(2,1,true);
		pawn p4w=new pawn(3,1,true);
		pawn p5w=new pawn(4,1,true);
		pawn p6w=new pawn(5,1,true);
		pawn p7w=new pawn(6,1,true);
		pawn p8w=new pawn(7,1,true);

		//black pawns
		pawn p1b=new pawn(0,6,true);
		pawn p2b=new pawn(1,6,true);
		pawn p3b=new pawn(2,6,true);
		pawn p4b=new pawn(3,6,true);
		pawn p5b=new pawn(4,6,true);
		pawn p6b=new pawn(5,6,true);
		pawn p7b=new pawn(6,6,true);
		pawn p8b=new pawn(7,6,true);

		//white rook


		//black rook


		//white knight


		//black knight


		//white bishop


		//black bishop


		//white queen


		//black queen


		//white king


		//black king


		//Set each piece on board

		//Bottom pieces
		//location[0][0]=;


		//pawns
		location[0][1]=p1w;
		location[1][1]=p2w;
		location[2][1]=p3w;
		location[3][1]=p4w;
		location[4][1]=p5w;
		location[5][1]=p6w;
		location[6][1]=p7w;
		location[7][1]=p8w;

		location[0][6]=p1b;
		location[1][6]=p2b;
		location[2][6]=p3b;
		location[3][6]=p4b;
		location[4][6]=p5b;
		location[5][6]=p6b;
		location[6][6]=p7b;
		location[7][6]=p8b;
	}
}
