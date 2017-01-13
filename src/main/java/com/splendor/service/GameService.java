package com.splendor.service;

import com.splendor.model.Game;
import com.splendor.model.Player;
import com.splendor.model.card.CardDefinitions;
import com.splendor.model.gem.GemCollectionBuilder;
import org.springframework.stereotype.Component;

/**
 * Created by pvyletelek on 1/7/2017.
 */
@Component
public class GameService {
    
    public Game startNewGame() {
        Game newGame = new Game(new Player("Petr"), new Player("John"));
        newGame.setGemsOnBoard(
                new GemCollectionBuilder()
                        .setInitBoardCollection(true)
                        .createGemCollection());
        newGame.setDecks(CardDefinitions.REGULAR_DECKS);
        return newGame;
    } 
}
