package main.chess;

import java.util.InputMismatchException;

import main.extramethods.*;

import java.util.ArrayList;

public class Board {
	final static Piece[][] location= new Piece[8][8]; //chess is 8x8 fixed. Does not need a method to initialize
	//This board is orientated so that the white pieces are at the bottom and the black are at the top.

	//This is a place to record which piece moved where in order. May not be used.
	ArrayList<Piece> replay=new ArrayList<>();

	public static void clear(int x, int y){
		location[x][y]=null;
	}

	public static void setPiece(Piece subject, int x, int y){
		clear(subject.xLocation,subject.yLocation);
		location[x][y]=subject;
	}

	public static void initialize(){
		//Needs better names for pieces maybe

		//white Pawns
		Pawn p1w=new Pawn(0,1,true);
		Pawn p2w=new Pawn(1,1,true);
		Pawn p3w=new Pawn(2,1,true);
		Pawn p4w=new Pawn(3,1,true);
		Pawn p5w=new Pawn(4,1,true);
		Pawn p6w=new Pawn(5,1,true);
		Pawn p7w=new Pawn(6,1,true);
		Pawn p8w=new Pawn(7,1,true);

		//black Pawns
		Pawn p1b=new Pawn(0,6,true);
		Pawn p2b=new Pawn(1,6,true);
		Pawn p3b=new Pawn(2,6,true);
		Pawn p4b=new Pawn(3,6,true);
		Pawn p5b=new Pawn(4,6,true);
		Pawn p6b=new Pawn(5,6,true);
		Pawn p7b=new Pawn(6,6,true);
		Pawn p8b=new Pawn(7,6,true);

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


		//Pawns
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
