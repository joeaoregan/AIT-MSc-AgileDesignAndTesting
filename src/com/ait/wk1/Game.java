package com.ait.wk1;

import java.util.Scanner;

public class Game {
	private static Scanner sc = new Scanner(System.in);
	private int numDiceRolls = 0;
	private String winner;
	private int SCORE_TO_WIN = 20;

	public Game() {

	}

	public void start() {
		System.out.println("Welcome to the Dice Roller Application");
		System.out.println();
	
		PairOfDice pair = new PairOfDice();
		
		System.out.println("Please enter player one name: ");
		Player player1 = new Player(sc.next());
		System.out.println("Please enter player two name: ");
		Player player2 = new Player(sc.next());

		System.out.println("Roll the dice? (y/n): ");
		String choice = sc.next();
		
		System.out.println();
		
		while (!choice.equals("n")) {
			System.out.println("Round " + ++numDiceRolls+":");
		
			System.out.println("Rolling dice for player one");
			pair.roll();
			System.out.println("Die 1 is " + pair.getValue1());
			System.out.println("Die 2 is " + pair.getValue2());
			player1.setTotalScore(pair.getSum());

			System.out.println("Rolling dice for player two");
			pair.roll();
			System.out.println("Die 1 is " + pair.getValue1());
			System.out.println("Die 2 is " + pair.getValue2());
			player2.setTotalScore(pair.getSum());
			
			System.out.println(player1.toString());
			System.out.println(player2.toString());
			
			if (player1.getTotalScore() >= SCORE_TO_WIN && player2.getTotalScore() >= 20) {
				winner = "DRAW";
				break;
			} else if (player1.getTotalScore() >= SCORE_TO_WIN) {
				winner = player1.getName()+" wins";
				break;
			} else if (player2.getTotalScore() >= SCORE_TO_WIN) {
				winner = player2.getName()+" wins";
				break;
			} else {
				System.out.println("No winner yet");
				System.out.println("Roll the dice again? (y/n)");
				choice = sc.next();
				System.out.println();
			}
			
		}
		System.out.println(winner);
		System.out.println("Goodbye!");
	}
}