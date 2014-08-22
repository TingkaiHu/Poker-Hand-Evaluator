package net.baleful.games.poker.handevaluator;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import net.baleful.games.poker.handevaluator.PokerCard;
import net.baleful.games.poker.handevaluator.Rank;
import net.baleful.games.poker.handevaluator.Suit;

public class TestDeck {
	private static HashMap<String, PokerCard> deck;
	
	static {
		deck = new HashMap<String, PokerCard>();
		
		for (int cnt = Rank.MIN_RANK; cnt <= Rank.MAX_RANK; cnt++) {
			for (Suit suit : Suit.values()) {
				PokerCard card = new PokerCard(new Rank(cnt), suit);
				
				deck.put(card.toString(), card);
			}
		}

	}
	
	public static PokerCard getCard(String id) {
		return deck.get(id);
	}
	
	public static PokerCard[] getFullDeck() {
		return deck.values().toArray(new PokerCard[52]);
	}
	
	public static PokerCard[] getShuffledFullDeck() {
		List<PokerCard> cards = new ArrayList<PokerCard>(deck.values());
		
		Collections.shuffle(cards);
		
		return cards.toArray(new PokerCard[52]);
	}
	
	public static PokerCard[] getHandArray(String id0,
		                                   String id1, 
			                               String id2,
			                               String id3,
			                               String id4)
	{
		PokerCard[] ret = new PokerCard[5];
		
		ret[0] = getCard(id0);
		ret[1] = getCard(id1);
		ret[2] = getCard(id2);
		ret[3] = getCard(id3);
		ret[4] = getCard(id4);
		
		return ret;
	}
}
