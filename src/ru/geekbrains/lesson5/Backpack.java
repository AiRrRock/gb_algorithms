package ru.geekbrains.lesson5;

import java.util.List;

public class Backpack {

    private final int maxWeight;

    private int topValue;
    private List<Item> bestMatch = null;

    public Backpack(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public void setTopValue(int topValue) {
        this.topValue = topValue;
    }

    public List<Item> getBestMatch() {
        return bestMatch;
    }

    public void setBestMatch(List<Item> bestMatch) {
        this.bestMatch = bestMatch;
    }

    public int getTopValue() {
        return topValue;
    }
}
