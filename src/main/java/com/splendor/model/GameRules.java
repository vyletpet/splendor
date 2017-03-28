package com.splendor.model;

/**
 * Created by pvyletelek on 1/14/2017.
 */
public final class GameRules {

    public static final int MIN_PLAYERS = 2;
    public static final int MAX_PLAYERS = 4;

    public static final int WIN_PRESTIGE_POINTS_LIMIT = 15;

    public static final int NOBLES_OFFSET = 1;
    public static final int MAX_NOBLES_COUNT = MAX_PLAYERS + NOBLES_OFFSET;
    public static final int CARDS_ON_BOARD_COUNT = 4;


    private GameRules() {
        throw new IllegalAccessError("Utility class");
    }
}
