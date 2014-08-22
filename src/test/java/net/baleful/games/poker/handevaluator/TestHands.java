package net.baleful.games.poker.handevaluator;

import java.util.Map;
import java.util.TreeMap;

import net.baleful.games.poker.handevaluator.HandRank;
import net.baleful.games.poker.handevaluator.PokerCard;

public class TestHands {
	private static final TreeMap<HandRank, PokerCard[]> hands;

	static {
		hands = new TreeMap<HandRank, PokerCard[]>();
		
		hands.put(HandRank.HIGH_CARD,       TestDeck.getHandArray("SJ", "H9", "C8", "D6", "S2"));
		hands.put(HandRank.ONE_PAIR,        TestDeck.getHandArray("SJ", "HJ", "C8", "D6", "S2"));
		hands.put(HandRank.TWO_PAIR,        TestDeck.getHandArray("SJ", "HJ", "C8", "D8", "S6"));
		hands.put(HandRank.THREE_OF_A_KIND, TestDeck.getHandArray("SJ", "HJ", "CJ", "D6", "S2"));
		hands.put(HandRank.STRAIGHT,        TestDeck.getHandArray("SJ", "HT", "C9", "D8", "C7"));
		hands.put(HandRank.FLUSH,           TestDeck.getHandArray("SJ", "S9", "S8", "S6", "S2"));
		hands.put(HandRank.FULL_HOUSE,      TestDeck.getHandArray("SJ", "DJ", "HJ", "D6", "S6"));
		hands.put(HandRank.FOUR_OF_A_KIND,  TestDeck.getHandArray("CJ", "DJ", "HJ", "SJ", "S8"));
		hands.put(HandRank.STRAIGHT_FLUSH,  TestDeck.getHandArray("DK", "DQ", "DJ", "DT", "D9"));
	}
	
	public static PokerCard[] getHand(int handType) {
		return hands.get(handType);
	}
	
	public static Map<HandRank, PokerCard[]> getHands() {
		return hands;
	}
}
