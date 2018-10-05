package com.ait.wk1;

public class Player {
	private String name;
	private int totalScore;
	
	public Player(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int score) {
		this.totalScore += score;
	}

	@Override
	public String toString() {
		return "Current score for " + name + " is " + totalScore;
	}
	
}
