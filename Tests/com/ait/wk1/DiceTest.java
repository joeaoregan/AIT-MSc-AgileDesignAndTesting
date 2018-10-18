package com.ait.wk1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DiceTest {
	Die die;
	Game game;
	PairOfDice pairOfDice;
	Player player;

	@BeforeEach
	void setup() {
		die = new Die();
		game = new Game();
		pairOfDice = new PairOfDice();
		player = new Player("Test");
	}

	@Test
	void testConstructor() {
		Die die1 = new Die();
		Game game1 = new Game();
		PairOfDice pairOfDice1 = new PairOfDice();
		Player player1 = new Player("Test");
		DiceRollerApp diceRollerApp = new DiceRollerApp();
		
		// Added to clear warnings
		assertEquals(0, die1.getValue());
		assertTrue(game1 instanceof Game);
		assertTrue(pairOfDice1.getValue1() == 0);
		assertTrue(pairOfDice1.getValue2() == 0);
		assertTrue(pairOfDice1.getSum() == 0);
		assertEquals("Test", player1.getName());
		assertTrue(diceRollerApp instanceof DiceRollerApp);
	}

	@Test
	void testGetValue() {
		assertEquals(0, die.getValue());
	}

	@Test
	void testPlayerGetName() {
		assertEquals("Test", player.getName());
	}

	@Test
	void testPlayerGetTotalScore() {
		assertEquals(0, player.getTotalScore());
	}

	@Test
	void testDieRoll() {
		die.roll();
		//assertTrue(die.getValue() > 0 && die.getValue() <= 6);
		assertTrue(die.getValue() > 0);
		assertTrue(die.getValue() <= 6);
	}

	//@Test
	//void testGameStart() {
		//game.start();
	//}
}
