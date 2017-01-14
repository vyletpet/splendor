package com.splendor.model;

/**
 * Created by pvyletelek on 1/14/2017.
 */
public interface GameRules {
    
    int MIN_PLAYERS = 2;
    int MAX_PLAYERS = 4;

    int NOBLES_OFFSET = 1;
    int MAX_NOBLES_COUNT = MAX_PLAYERS + NOBLES_OFFSET;
    int AVAILABLE_CARDS_COUNT = 4;
}
