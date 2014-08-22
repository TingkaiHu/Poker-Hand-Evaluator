package net.baleful.games.poker.handevaluator;

import static org.junit.Assert.*;
import net.baleful.games.poker.handevaluator.PokerCard;
import net.baleful.games.poker.handevaluator.Rank;
import net.baleful.games.poker.handevaluator.Suit;

import org.junit.Test;

public class PokerCardTest {

	@Test
	public void testAceofSpades() {
		PokerCard card = new PokerCard(Rank.parse('A'), Suit.SPADE);

		assertEquals("Encoded value incorred for the ace of Spades", card.getEncodedValue(), 268442665);
	}

	@Test
	public void testTwoofHearts() {
		PokerCard card = new PokerCard(Rank.parse('2'), Suit.HEART);

		assertEquals("Encoded value incorred for the deuce of Hearts", card.getEncodedValue(), 73730);
	}
}
