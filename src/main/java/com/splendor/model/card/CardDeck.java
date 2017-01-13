package com.splendor.model.card;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by pvyletelek on 1/7/2017.
 */
public class CardDeck {
    private Deque<Card> cards;

    public CardDeck(List<Card> cards) {
        this.cards = new LinkedList<>(cards);
    }
    
    public void shuffle() {
        Collections.shuffle((List) cards);
    }
    
    public Card nextCard() {
        return cards.poll();
    }

    public Deque<Card> getCards() {
        return cards;
    }
}
