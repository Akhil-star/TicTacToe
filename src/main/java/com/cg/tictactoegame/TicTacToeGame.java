package com.cg.tictactoegame;

import java.util.Scanner;

public class TicTacToeGame {
	static char[] board = new char[10];
	static Scanner sc = new Scanner(System.in);
	static final int HEAD = 0;
	static final int TAIL = 1;

	// UC1createBoard
	private static char[] createBoard() {
		for (int i = 1; i < board.length; i++) {
			board[i] = ' ';
		}
		return board;
	}

	// UC2chooseLetter
	private static char chooseLetter() {
		System.out.println("Player's Letter (X/O) :");
		char letter = Character.toUpperCase(sc.next().charAt(0));
		if (letter == 'X' || letter == 'O') {
			return letter;
		} else {
			System.out.println("Invalid Character");
			return chooseLetter();
		}
	}

	// UC3showBoard
	private static void showBoard(char[] board) {
		System.out.println("| " + board[1] + " | " + board[2] + " | " + board[3] + " |");
		System.out.println("|-----------|");
		System.out.println("| " + board[4] + " | " + board[5] + " | " + board[6] + " |");
		System.out.println("|-----------|");
		System.out.println("| " + board[7] + " | " + board[8] + " | " + board[9] + " |");
	}

	// UC4&UC5makeMove(checks free space)
	private static void makeMove(char[] board, char playerLetter) {
		System.out.println("Enter the index you want to move(1-9) : ");
		int index = sc.nextInt();
		if (index > 0 && index < 10) {
			if (board[index] == ' ') {
				board[index] = playerLetter;
				showBoard(board);
			} else {
				System.out.println("Cell is occupied");
			}
		} else {
			System.out.println("Invalid cell");
			makeMove(board, playerLetter);
		}
	}

	// UC6toss
	private static int whoStartsFirst() {
		int toss = (int) (Math.random() * 10) % 2;
		return toss;
	}

	// UC7wincondition
	private static boolean isWinner(char[] b, char ch) {
		return ((b[1] == ch && b[2] == ch && b[3] == ch) || (b[4] == ch && b[5] == ch && b[6] == ch)
				|| (b[7] == ch && b[8] == ch && b[9] == ch) || (b[1] == ch && b[4] == ch && b[7] == ch)
				|| (b[2] == ch && b[5] == ch && b[8] == ch) || (b[3] == ch && b[6] == ch && b[9] == ch)
				|| (b[1] == ch && b[5] == ch && b[9] == ch) || (b[7] == ch && b[5] == ch && b[3] == ch));
	}

	// UC8computerTurn
	private static boolean computerTurn(char[] b, char ch) {
		boolean f = false;
		if ((b[1] == ch && b[2] == ch) || (b[6] == ch && b[9] == ch) || (b[5] == ch && b[7] == ch) && b[3] == ' ') {
			b[3] = ch;
			f = true;
		} else if ((b[2] == ch && b[3] == ch) || (b[5] == ch && b[9] == ch)
				|| (b[4] == ch && b[7] == ch) && b[1] == ' ') {
			b[1] = ch;
			f = true;
		} else if ((b[1] == ch && b[3] == ch) || (b[5] == ch && b[8] == ch) && b[2] == ' ') {
			b[2] = ch;
			f = true;
		} else if ((b[1] == ch && b[7] == ch) || (b[5] == ch && b[6] == ch) && b[4] == ' ') {
			b[4] = ch;
			f = true;
		} else if ((b[7] == ch && b[3] == ch) || (b[1] == ch && b[9] == ch)
				|| (b[4] == ch && b[6] == ch) && b[5] == ' ') {
			b[5] = ch;
			f = true;
		} else if ((b[4] == ch && b[5] == ch) || (b[3] == ch && b[9] == ch) && b[6] == ' ') {
			b[6] = ch;
			f = true;
		} else if ((b[1] == ch && b[4] == ch) || (b[8] == ch && b[9] == ch)
				|| (b[5] == ch && b[3] == ch) && b[7] == ' ') {
			b[7] = ch;
			f = true;
		} else if ((b[2] == ch && b[5] == ch) || (b[7] == ch && b[9] == ch) && b[8] == ' ') {
			b[8] = ch;
			f = true;
		} else if ((b[1] == ch && b[5] == ch) || (b[7] == ch && b[8] == ch)
				|| (b[3] == ch && b[6] == ch) && b[9] == ' ') {
			b[9] = ch;
			f = true;
		} else
			System.out.println("checks Opponent");
		return f;
	}

	// UC9opponentBlock
	private static boolean checkOpponent(char[] b, char pCh, char cCh) {
		boolean f = false;
		if ((b[1] == pCh && b[2] == pCh) || (b[6] == pCh && b[9] == pCh)
				|| (b[5] == pCh && b[7] == pCh) && b[3] == ' ') {
			b[3] = cCh;
			f = true;
		} else if ((b[2] == pCh && b[3] == pCh) || (b[5] == pCh && b[9] == pCh)
				|| (b[4] == pCh && b[7] == pCh) && b[1] == ' ') {
			b[1] = cCh;
			f = true;
		} else if ((b[1] == pCh && b[3] == pCh) || (b[5] == pCh && b[8] == pCh) && b[2] == ' ') {
			b[2] = cCh;
			f = true;
		} else if ((b[1] == pCh && b[7] == pCh) || (b[5] == pCh && b[6] == pCh) && b[4] == ' ') {
			b[4] = cCh;
			f = true;
		} else if ((b[7] == pCh && b[3] == pCh) || (b[1] == pCh && b[9] == pCh)
				|| (b[4] == pCh && b[6] == pCh) && b[5] == ' ') {
			b[5] = cCh;
			f = true;
		} else if ((b[4] == pCh && b[5] == pCh) || (b[3] == pCh && b[9] == pCh) && b[6] == ' ') {
			b[6] = cCh;
			f = true;
		} else if ((b[1] == pCh && b[4] == pCh) || (b[8] == pCh && b[9] == pCh)
				|| (b[3] == pCh && b[5] == pCh) && b[7] == ' ') {
			b[7] = cCh;
			f = true;
		} else if (((b[2] == pCh && b[5] == pCh) || (b[7] == pCh && b[9] == pCh)) && b[8] == ' ') {
			b[8] = cCh;
			f = true;
		} else if (((b[1] == pCh && b[5] == pCh) || (b[7] == pCh && b[8] == pCh) || (b[3] == pCh && b[6] == pCh))
				&& b[9] == ' ') {
			b[9] = cCh;
			f = true;
		} else
			System.out.println("Check corner Condition");
		return f;
	}

	public static void main(String[] args) {
		char playerLetter = chooseLetter();
		char computerLetter = (playerLetter == 'X') ? 'O' : 'X';
		System.out.println("Player's Letter : " + playerLetter + "\nComputer's Letter : " + computerLetter);
		createBoard();
		showBoard(board);
		whoStartsFirst();
		System.out.println("check if won " + isWinner(board, playerLetter));
		System.out.println("Computer turn " + computerTurn(board, computerLetter));
		System.out.println("Opponent Block "+ checkOpponent(board, playerLetter, computerLetter));
	}
}
