package com.splendor.model.gem;

/**
 * Created by pvyletelek on 1/7/2017.
 */
public class GemCollectionFactory {

    private GemCollectionFactory() {
        throw new IllegalAccessError("Utility class");
    }

    public static GemCollection defineCosts(
            int emeraldsCount, 
            int sapphireCount, 
            int rubyCount, 
            int diamondCount, 
            int onyxCount) {
        
        GemCollection costs = new GemCollectionBuilder()
                .setIncludeGold(false)
                .setInitBoardCollection(false)
                .create();
        
        costs.setGemCount(Gem.EMERALD, emeraldsCount);
        costs.setGemCount(Gem.SAPPHIRE, sapphireCount);
        costs.setGemCount(Gem.RUBY, rubyCount);
        costs.setGemCount(Gem.DIAMOND, diamondCount);
        costs.setGemCount(Gem.ONYX, onyxCount);
        
        return costs;
    }
}
