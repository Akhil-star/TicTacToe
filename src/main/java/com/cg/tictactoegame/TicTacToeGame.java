package com.cg.tictactoegame;

import java.util.Scanner;

public class TicTacToeGame {
	static char[] board = new char[10];
	static Scanner sc = new Scanner(System.in);

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

	// UC4movePlayer
	private static int movePlayer() {
		System.out.println("Enter the index you want to move(1-9) : ");
		int index = sc.nextInt();
		if (index > 0 && index < 10) {
			if (board[index] == ' ') {
				return index;
			} else {
				System.out.println("Cell is occupied");
			}
		} else {
			System.out.println("Invalid cell");
			movePlayer();
		}
		return index;
	}

	public static void main(String[] args) {
		char playerLetter = chooseLetter();
		char computerLetter = (playerLetter == 'X') ? 'O' : 'X';
		System.out.println("Player's Letter : " + playerLetter + "\nComputer's Letter : " + computerLetter);
		createBoard();
		showBoard(board);
		movePlayer();
	}
}
