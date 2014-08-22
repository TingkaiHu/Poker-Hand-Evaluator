package net.baleful.games.poker.handevaluator;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import net.baleful.games.poker.handevaluator.HandEvaluator;
import net.baleful.games.poker.handevaluator.HandRank;
import net.baleful.games.poker.handevaluator.PokerCard;

import org.junit.Test;

public class HandEvaluatorTest {
	@Test
	public void testEvaluateSpecificHands() {
		
		for (Map.Entry<HandRank, PokerCard[]> entry : TestHands.getHands().entrySet()) {
			HandRank computed = HandEvaluator.evaluateSpecificHand(entry.getValue());
			
			assertEquals("Evaluation doesn't match for " + entry.getKey().toString(), entry.getKey(), computed);
		}
	}

	@Test
	public void testAllPermutations() {
		Map<HandRank, Integer> histogram = new HashMap<HandRank, Integer>();
		
		for (HandRank handRank : HandRank.values()) {
			histogram.put(handRank, 0);
		}

		PokerCard[] deck = TestDeck.getShuffledFullDeck();

		for (int a = 0; a < 48; a++) {
			for (int b = a + 1; b < 49; b++) {
				for (int c = b + 1; c < 50; c++) {
					for (int d = c + 1; d < 51; d++) {
						for (int e = d + 1; e < 52; e++) {
							HandRank output = HandEvaluator.evaluateSpecificHand(deck[a].getEncodedValue(),
																						   deck[b].getEncodedValue(),
																						   deck[c].getEncodedValue(),
																						   deck[d].getEncodedValue(),
																						   deck[e].getEncodedValue());
							
							Integer value = histogram.get(output);
							
							histogram.put(output, value + 1);
						}
					}
				}
			}
		}
		
		for (HandRank handRank : HandRank.values()) {
			switch(handRank) {
			case HIGH_CARD:
				assertEquals("Incorrect count for " + handRank.toString(), histogram.get(handRank).intValue(), 1302540);
				break;
			case ONE_PAIR:
				assertEquals("Incorrect count for " + handRank.toString(), histogram.get(handRank).intValue(), 1098240);
				break;
			case TWO_PAIR:
				assertEquals("Incorrect count for " + handRank.toString(), histogram.get(handRank).intValue(), 123552);
				break;
			case THREE_OF_A_KIND:
				assertEquals("Incorrect count for " + handRank.toString(), histogram.get(handRank).intValue(), 54912);
				break;
			case STRAIGHT:
				assertEquals("Incorrect count for " + handRank.toString(), histogram.get(handRank).intValue(), 10200);
				break;
			case FLUSH:
				assertEquals("Incorrect count for " + handRank.toString(), histogram.get(handRank).intValue(), 5108);
				break;
			case FULL_HOUSE:
				assertEquals("Incorrect count for " + handRank.toString(), histogram.get(handRank).intValue(), 3744);
				break;
			case FOUR_OF_A_KIND:
				assertEquals("Incorrect count for " + handRank.toString(), histogram.get(handRank).intValue(), 624);
				break;
			case STRAIGHT_FLUSH:
				assertEquals("Incorrect count for " + handRank.toString(), histogram.get(handRank).intValue(), 40);
				break;
			case ROYAL_FLUSH:
				break;
			default:
				fail();
				break;
			}
		}
	}
}
