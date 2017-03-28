package com.splendor.model.gem;

/**
 * Created by pvyletelek on 1/6/2017.
 */
public enum Gem {
    
    EMERALD("Emerald", "green"),
    SAPPHIRE("Sapphire", "blue"),
    RUBY("Ruby", "red"),
    DIAMOND("Diamond", "white"),
    ONYX("Onyx", "black"),
    GOLD("Gold", "yellow", 5);

    private static final int DEFAULT_INITIAL_COUNT = 7;

    
    private String name;
    private String color;
    private int initialCount = DEFAULT_INITIAL_COUNT;

    Gem(String name, String color) {
        this.name = name;
        this.color = color;
    }

    Gem(String name, String color, int initialCount) {
        this.name = name;
        this.color = color;
        this.initialCount = initialCount;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getInitialCount() {
        return initialCount;
    }


    @Override
    public String toString() {
        return name;
    }
}
