package com.splendor.model.gem;

public class GemCollectionBuilder {
    
    private boolean initBoardCollection = false;
    private boolean includeGold = true;

    public GemCollectionBuilder setInitBoardCollection(boolean initBoardCollection) {
        this.initBoardCollection = initBoardCollection;
        return this;
    }

    public GemCollectionBuilder setIncludeGold(boolean includeGold) {
        this.includeGold = includeGold;
        return this;
    }

    public GemCollection createGemCollection() {
        return new GemCollection(initBoardCollection, includeGold);
    }
}