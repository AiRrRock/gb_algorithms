package ru.geekbrains.lesson5;

import com.sun.istack.internal.NotNull;

import java.util.Objects;

public class Item {
    @NotNull
    private String name;
    private int weight;
    private int price;

    public Item(@NotNull String name, int weight, int price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public int getPrice() {
        return price;
    }


    @Override
    public boolean equals(Object toCompare) {

        if (this == toCompare) {
            return true;
        }

        if (toCompare == null || this.getClass() != toCompare.getClass()) {
            return false;
        }

        Item that = (Item) toCompare;

        if (weight != that.weight || this.price != that.price) {
            return false;
        }

        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return (name.hashCode() * 17 + weight) * 97 + price;
    }

    @Override
    public String toString() {
        return "name = " + name + " weight = " + weight + " price = " + price;
    }

}

