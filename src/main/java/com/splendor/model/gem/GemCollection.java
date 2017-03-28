package com.splendor.model.gem;

import java.util.EnumMap;
import java.util.Map;

/**
 * Created by pvyletelek on 1/6/2017.
 */
public class GemCollection {

    private Map<Gem, Integer> gemCounts = new EnumMap<>(Gem.class);

    public GemCollection(boolean initBoardCollection, boolean includeGold) {
        for (Gem gem : Gem.values()) {
            if (!includeGold && gem == Gem.GOLD) {
                continue;
            }
            if (initBoardCollection) {
                gemCounts.put(gem, gem.getInitialCount());
            } else {
                gemCounts.put(gem, 0);
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
        gemCounts.computeIfPresent(gem, (gem1, count) -> count + 1);
    }

    public Map<Gem, Integer> getGemCollection() {
        return gemCounts;
    }

    public void setGemCount(Gem gem, int count) {
        gemCounts.put(gem, count);
    }
    
    @Override
    public String toString() {
        String output = "";
        for (Map.Entry<Gem, Integer> entry : gemCounts.entrySet()) {
            output += entry.getKey() + ": " + entry.getValue() + "\n";
        }
        return output;
    }
    
    
}
