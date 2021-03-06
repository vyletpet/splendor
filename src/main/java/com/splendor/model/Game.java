package com.splendor.model;

import com.splendor.model.card.Card;
import com.splendor.model.card.CardDeck;
import com.splendor.model.card.CardLevel;
import com.splendor.model.gem.GemCollection;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

/**
 * Created by pvyletelek on 1/6/2017.
 */
public class Game {

    private Player onTurn;
    private Player winner;
    private GameState gameState;
    private int round;
    
    private GemCollection gemsOnBoard;
    private List<Player> players = new ArrayList<>(GameRules.MAX_PLAYERS);
    private Map<CardLevel, CardDeck> decks = new EnumMap<>(CardLevel.class);
    private Map<CardLevel, Card[]> cardsOnBoard = new EnumMap<>(CardLevel.class);
    private List<Card> availableNobles = new ArrayList<>(GameRules.MAX_NOBLES_COUNT);

    public Game() {
        gameState = GameState.NEW;
        
        // Init arrays
        cardsOnBoard.put(CardLevel.FIRST, new Card[GameRules.CARDS_ON_BOARD_COUNT]);
        cardsOnBoard.put(CardLevel.SECOND, new Card[GameRules.CARDS_ON_BOARD_COUNT]);
        cardsOnBoard.put(CardLevel.THIRD, new Card[GameRules.CARDS_ON_BOARD_COUNT]);
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
    
    public void addPlayer(Player player) {
        players.add(player);
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
    
    public CardDeck getDeck(CardLevel cardLevel) {
        return decks.get(cardLevel);
    }

    public Map<CardLevel, Card[]> getCardsOnBoard() {
        return cardsOnBoard;
    }

    public List<Card> getAvailableNobles() {
        return availableNobles;
    }

    public void addAvailableNoble(Card availableNoble) {
        availableNobles.add(availableNoble);
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

    public Card[] getCardsOnBoard(CardLevel cardLevel) {
        return cardsOnBoard.get(cardLevel);
    }
}
