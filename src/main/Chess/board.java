package main.chess;

import java.util.InputMismatchException;

import main.extramethods.*;

import java.util.ArrayList;

public class Board {
	//Creates a chess board
	final static Piece[][] location= new Piece[8][8]; //chess is 8x8 fixed. Does not need a method to initialize
	//This board is orientated so that the white pieces are at the bottom and the black are at the top.

	//Array to use for user selction
	final static String[] letters= {"a","b","c","d","e","f","g","h"};

	//Array
	/* 
	x  0  1  2  3  4  5  6  7
	0  0
	1     1  
	2        2  
	3           3  
	4              4  
	5                 5  
	6                    6  
	7                       7
	*/

	//Chessboard
	/*
	x  a  b  c  d  e  f  g  h
	8
	7
	6
	5
	4
	3
	2
	1
	*/

	//Order of pieces:
	//pppppppp
	//rkbqKqbkr

	//This is a place to record which piece moved where in order. May not be used.
	ArrayList<Piece> replay=new ArrayList<>();

	public static void clear(int x, int y){
		location[y][x]=null;
	}

	public static void clearBoard(){
		for (int i=0;i<location.length;i++){
			for (int j=0;j<location[0].length;j++){
				location[i][j]=null;
			}
		}
	}

	public static void setPiece(Piece subject, int x, int y){
		clear(subject.xLocation,subject.yLocation);
		location[y][x]=subject;
	}

	public static void initialize(){
		//Needs better names for pieces maybe

		//white pawns
		for (int i=0;i<location[0].length;i++){
			location[7][i]=new Pawn(i,7,true);
		}

		//black pawns
		for (int i=0;i<location[0].length;i++){
			location[1][i]=new Pawn(i,1,false);
		}

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

	}

	//Converts y coordinates of chess piece to array, used to convert user selection to array equivalent
	public static int yToBoard(int y){
		return y%8;
	}
	


	//Main method that runs
	public static void Main(String args[]){
		
	}

}
