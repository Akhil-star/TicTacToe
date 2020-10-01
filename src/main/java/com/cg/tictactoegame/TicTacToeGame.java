package com.cg.tictactoegame;

import java.util.Scanner;

public class TicTacToeGame {
	static Scanner sc = new Scanner(System.in);

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

	public static void main(String[] args) {
		char playerLetter = chooseLetter();
		char computerLetter = (playerLetter == 'X') ? 'O' : 'X';
		System.out.println("Player's Letter : " + playerLetter + "\nComputer's Letter : " + computerLetter);

	}
}
