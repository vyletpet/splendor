package com.splendor.model.card;

import com.splendor.model.gem.Gem;
import com.splendor.model.gem.GemCollection;

/**
 * Created by pvyletelek on 1/6/2017.
 */
public class Card {
    private int prestigePoints;
    private Gem generatedGem;
    private GemCollection costs;

    public Card(int prestigePoints, GemCollection costs, Gem generatedGem) {
        this.prestigePoints = prestigePoints;
        this.generatedGem = generatedGem;
        this.costs = costs;
    }

    public Card(int prestigePoints, GemCollection costs) {
        this(prestigePoints, costs, null);
    }

    public int getPrestigePoints() {
        return prestigePoints;
    }

    public Gem getGeneratedGem() {
        return generatedGem;
    }

    public GemCollection getCosts() {
        return costs;
    }
}
