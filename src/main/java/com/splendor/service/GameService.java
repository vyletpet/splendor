package com.splendor.service;

import com.splendor.model.Game;
import com.splendor.model.GameState;
import com.splendor.model.Player;
import com.splendor.model.card.Card;
import com.splendor.model.card.CardDeck;
import com.splendor.model.card.CardDefinitions;
import com.splendor.model.card.CardLevel;
import com.splendor.model.gem.GemCollectionBuilder;
import org.springframework.stereotype.Component;

import static com.splendor.model.GameRules.AVAILABLE_CARDS_COUNT;
import static com.splendor.model.GameRules.MAX_PLAYERS;
import static com.splendor.model.GameRules.MIN_PLAYERS;
import static com.splendor.model.GameRules.NOBLES_OFFSET;

/**
 * Created by pvyletelek on 1/7/2017.
 */
@Component
public class GameService {


    public Game createNewGame(String... playerNames) throws Exception {
        validatePlayers(playerNames);

        Game newGame = new Game();
        for (String playerName : playerNames) {
            newGame.addPlayer(new Player(playerName));
        }

        newGame.setGemsOnBoard(
                new GemCollectionBuilder()
                        .setInitBoardCollection(true)
                        .createGemCollection());

        prepareAvailableCards(newGame);

        prepareNobles(newGame, playerNames);

        return newGame;
    }

    private void prepareAvailableCards(Game newGame) {
        newGame.setDecks(CardDefinitions.REGULAR_DECKS);
        newGame.getDeck(CardLevel.FIRST).shuffle();
        prepareAvailableCards(newGame, CardLevel.FIRST);
        newGame.getDeck(CardLevel.SECOND).shuffle();
        prepareAvailableCards(newGame, CardLevel.SECOND);
        newGame.getDeck(CardLevel.THIRD).shuffle();
        prepareAvailableCards(newGame, CardLevel.THIRD);
    }

    private void prepareAvailableCards(Game newGame, CardLevel cardLevel) {
        for (int i = 0; i < AVAILABLE_CARDS_COUNT; ++i) {
            addNewAvailableCard(
                    newGame.getAvailableCards(cardLevel),
                    newGame.getDeck(cardLevel),
                    i);
        }
    }

    public void addNewAvailableCard(Card[] availableCards, CardDeck deck, int index) {
        availableCards[index] = deck.nextCard();
    }

    private void prepareNobles(Game newGame, String[] playerNames) {
        CardDeck noblesDeck = new CardDeck(CardDefinitions.NOBLES_DECK);
        noblesDeck.shuffle();
        for (int i = 0; i < playerNames.length + NOBLES_OFFSET; ++i) {
            newGame.addAvailableNoble(noblesDeck.nextCard());
        }
    }

    private void validatePlayers(String[] playerNames) throws Exception {
        if (playerNames.length < MIN_PLAYERS) {
            throw new Exception("Minimum players is " + MIN_PLAYERS);
        }

        if (playerNames.length > MAX_PLAYERS) {
            throw new Exception("Maximum players is " + MAX_PLAYERS);
        }
    }

    public void startGame(Game game) {
        game.setGameState(GameState.ONGOING);
    }

    public void endGame(Game game) {
        game.setGameState(GameState.FINISHED);
    }

}
