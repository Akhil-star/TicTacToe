package com.cg.tictactoegame;

public class TicTacToeGame 
{
	static char[] board = new char[10];
	private static char[] createBoard() {
		for (int i = 1; i < board.length; i++) {
			board[i] = ' ';
		}
		return board;
	}
    public static void main( String[] args )
    {
     createBoard();
     System.out.println("Board is created");
    }
}
