package com.splendor.model.gem;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pvyletelek on 1/6/2017.
 */
public class GemCollection {

    private Map<Gem, Integer> gemCollection = new HashMap<>();

    public GemCollection(boolean initBoardCollection, boolean includeGold) {
        for (Gem gem : Gem.values()) {
            if (!includeGold && gem == Gem.GOLD) {
                continue;
            }
            if (initBoardCollection) {
                gemCollection.put(gem, gem.getInitialCount());
            } else {
                gemCollection.put(gem, 0);
            }
        }
    }

    public GemCollection(boolean initBoardCollection) {
        this(initBoardCollection, true);
    }
    
    public GemCollection() {
        this(false, true);
    }
    
    public void addGem(Gem gem) {
        gemCollection.computeIfPresent(gem, (gem1, count) -> count + 1);
    }

    public Map<Gem, Integer> getGemCollection() {
        return gemCollection;
    }

    public void setGemCount(Gem gem, int count) {
        gemCollection.put(gem, count);
    }
    
    @Override
    public String toString() {
        String output = "";
        for (Map.Entry<Gem, Integer> entry : gemCollection.entrySet()) {
            output += entry.getKey() + ": " + entry.getValue() + "\n";
        }
        return output;
    }
    
    
}
