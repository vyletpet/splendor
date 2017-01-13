package com.splendor.model;

import com.splendor.model.card.Card;
import com.splendor.model.card.CardDeck;
import com.splendor.model.card.CardLevel;
import com.splendor.model.gem.GemCollection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Collections.addAll;

/**
 * Created by pvyletelek on 1/6/2017.
 */
public class Game {

    private GameState gameState;
    private GemCollection gemsOnBoard;
    private List<Player> players = new ArrayList<>(4);
    private Map<CardLevel, CardDeck> decks = new HashMap<>();
    private Map<CardLevel, List<Card>> availableCards = new HashMap<>();
    private List<Card> availableNobles = new ArrayList<>(5);

    public Game(Player... players) {
        addAll(this.players, players);
        gameState = GameState.NEW;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public void setGemsOnBoard(GemCollection gemsOnBoard) {
        this.gemsOnBoard = gemsOnBoard;
    }

    public void setDecks(Map<CardLevel, List<Card>> deckDefinitions) {
        for (Map.Entry<CardLevel, List<Card>> entry : deckDefinitions.entrySet()) {
            decks.put(entry.getKey(), new CardDeck(entry.getValue()));
        }
    }
    
    public GemCollection getGemsOnBoard() {
        return gemsOnBoard;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Map<CardLevel, CardDeck> getDecks() {
        return decks;
    }

    public Map<CardLevel, List<Card>> getAvailableCards() {
        return availableCards;
    }

    public List<Card> getAvailableNobles() {
        return availableNobles;
    }

    @Override
    public String toString() {
        String output = "";
        output += "Gems on board:\n" + gemsOnBoard + "\n";
        output += "Players(" + players.size() + "):\n";
        for (Player player : players) {
            output += player + "\n";
        }
        return output;
    }
}
