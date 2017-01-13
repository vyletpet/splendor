package com.splendor.model.card;

import com.splendor.model.gem.Gem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.splendor.model.gem.GemCollectionFactory.defineCosts;
import static java.util.Collections.unmodifiableList;
import static java.util.Collections.unmodifiableMap;

/**
 * Created by pvyletelek on 1/7/2017.
 */
public class CardDefinitions {
    
    public static final Map<CardLevel, List<Card>> REGULAR_DECKS;
    public static final List<Card> NOBLES_DECK;

    static {
        Map<CardLevel, List<Card>> deckDefinitions = new HashMap<>();
        
        List<Card> nobles = new ArrayList<>(10);
        nobles.add(new Card(2, defineCosts(0, 2, 3, 0, 1)));
        nobles.add(new Card(2, defineCosts(0, 2, 3, 0, 1)));
        nobles.add(new Card(2, defineCosts(0, 2, 3, 0, 1)));
        NOBLES_DECK = unmodifiableList(nobles);

        List<Card> firstLevelCards = new ArrayList<>(10);
        firstLevelCards.add(new Card(2, defineCosts(0, 2, 3, 0, 1), Gem.DIAMOND));
        firstLevelCards.add(new Card(2, defineCosts(0, 2, 3, 0, 1), Gem.EMERALD));
        firstLevelCards.add(new Card(2, defineCosts(0, 2, 3, 0, 1), Gem.ONYX));
        deckDefinitions.put(CardLevel.FIRST, unmodifiableList(firstLevelCards));

        List<Card> secondLevelCards = new ArrayList<>(10);
        secondLevelCards.add(new Card(2, defineCosts(0, 2, 3, 0, 1), Gem.DIAMOND));
        secondLevelCards.add(new Card(2, defineCosts(0, 2, 3, 0, 1), Gem.EMERALD));
        secondLevelCards.add(new Card(2, defineCosts(0, 2, 3, 0, 1), Gem.ONYX));
        deckDefinitions.put(CardLevel.SECOND, unmodifiableList(secondLevelCards));

        List<Card> thirdLevelCards = new ArrayList<>(10);
        thirdLevelCards.add(new Card(2, defineCosts(0, 2, 3, 0, 1), Gem.DIAMOND));
        thirdLevelCards.add(new Card(2, defineCosts(0, 2, 3, 0, 1), Gem.EMERALD));
        thirdLevelCards.add(new Card(2, defineCosts(0, 2, 3, 0, 1), Gem.ONYX));
        deckDefinitions.put(CardLevel.THIRD, unmodifiableList(thirdLevelCards));
        
        REGULAR_DECKS = unmodifiableMap(deckDefinitions);
    }

}
