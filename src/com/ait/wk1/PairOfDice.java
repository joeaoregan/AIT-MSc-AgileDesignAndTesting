package com.ait.wk1;
public class PairOfDice
{
	private Die die1;
	private Die die2;

	public PairOfDice()
	{
		die1 = new Die();
		die2 = new Die();
	}

	// roll the dice
	public void roll()
	{
		die1.roll();
		die2.roll();
	}

	// get value of die1
	public int getValue1()
	{
		return die1.getValue();
	}

	// get value of die2
	public int getValue2()
	{
		return die2.getValue();
	}

	public int getSum()
	{
		return die1.getValue() + die2.getValue();
	}

}