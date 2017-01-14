package com.splendor;

import com.splendor.model.Game;
import com.splendor.model.card.Card;
import com.splendor.model.card.CardLevel;
import com.splendor.service.GameService;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

/**
 * Created by pvyletelek on 1/14/2017.
 */
public class FirstTest {

    @Test
    public void minimumPlayersIs2() throws Exception {
        try {
            new GameService().createNewGame();
            fail();
        } catch (Exception e) {
            Assert.assertThat(e.getMessage(), Is.is("Minimum players is 2"));
        }

        try {
            new GameService().createNewGame("Jirka");
            fail();
        } catch (Exception e) {
            Assert.assertThat(e.getMessage(), Is.is("Minimum players is 2"));
        }
    }
    
    @Test
    public void maximumPlayersIs4() throws Exception {
        try {
            new GameService().createNewGame("a","b","c","d","pop");
            fail();
        } catch (Exception e) {
            Assert.assertThat(e.getMessage(), Is.is("Maximum players is 4"));
        }

        try {
            new GameService().createNewGame("a","b","c","d","pop","a1","b1","c0","d1","pop1");
            fail();
        } catch (Exception e) {
            Assert.assertThat(e.getMessage(), Is.is("Maximum players is 4"));
        }
    }

    @Test
    public void myTest() throws Exception {
        Game game = new GameService().createNewGame("Petr", "Jan", "Pavel");

        assertAvailableCards(game, CardLevel.FIRST);
        assertAvailableCards(game, CardLevel.SECOND);
        assertAvailableCards(game, CardLevel.THIRD);
        
        Assert.assertNotNull(game.getAvailableNobles());
        Assert.assertEquals(4, game.getAvailableNobles().size());

        boolean noblesAreTheSame = true;
        while (noblesAreTheSame) {
            Game game2 = new GameService().createNewGame("Petr", "Jan", "Pavel");
            noblesAreTheSame = cardsAreEqual(game.getAvailableNobles(), game2.getAvailableNobles());
        }
    }

    private void assertAvailableCards(Game game, CardLevel cardLevel) throws Exception {
        assertEquals(4, game.getAvailableCards().get(cardLevel).length);
        boolean availableCardsAreTheSame = true;
        while (availableCardsAreTheSame) {
            Game game2 = new GameService().createNewGame("Petr", "Jan", "Pavel");
            availableCardsAreTheSame = cardsAreEqual(game.getAvailableCards(cardLevel), game2.getAvailableCards(cardLevel));
        }
    }

    private boolean cardsAreEqual(List<Card> cards1, List<Card> cards2) {
        for (int i = 0; i < cards1.size(); ++i) {
            if (!cards1.get(i).equals(cards2.get(i))) {
                return false;
            }
        }
        return true;
    }
    
    private boolean cardsAreEqual(Card[] cards1, Card[] cards2) {
        for (int i = 0; i < cards1.length; ++i) {
            if (!cards1[i].equals(cards2[i])) {
                return false;
            }
        }
        return true;
    }
}
