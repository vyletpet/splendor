package com.splendor.model;

import com.splendor.model.card.Card;
import com.splendor.model.gem.GemCollection;
import com.splendor.model.gem.GemCollectionBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pvyletelek on 1/6/2017.
 */
public class Player {
    private String name;
    private int prestigePoints = 0;
    private GemCollection ownedGems;
    private GemCollection generatedGems;
    private List<Card> ownedCards = new ArrayList<>(40);
    private List<Card> reservedCards = new ArrayList<>(3);

    public Player(String name) {
        this.name = name;
        generatedGems = new GemCollectionBuilder().setIncludeGold(false).create();
        ownedGems = new GemCollectionBuilder().create();
    }

    public String getName() {
        return name;
    }

    public int getPrestigePoints() {
        return prestigePoints;
    }

    public GemCollection getOwnedGems() {
        return ownedGems;
    }

    public GemCollection getGeneratedGems() {
        return generatedGems;
    }

    public List<Card> getOwnedCards() {
        return ownedCards;
    }

    public List<Card> getReservedCards() {
        return reservedCards;
    }

    @Override
    public String toString() {
        String output = "Name: " + name + "\n";
        output += "Prestige points: " + prestigePoints + "\n";
        output += "Owned gems:\n" + ownedGems + "\n";
        output += "Generated gems:\n" + generatedGems + "\n";
        output += "Owned cards:\n";
        for (Card card : ownedCards) {
            output += card;
        }
        output += "Reserved cards: " + reservedCards.size();
        return output;
    }
}
