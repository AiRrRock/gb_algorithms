package ru.geekbrains.lesson5;

import java.util.ArrayList;
import java.util.List;

public class ItemsEvaluator {
    public static int getTotalWeight(List<Item> items) {
        int totalWeight = 0;
        for (Item item : items) {
            totalWeight += item.getWeight();
        }
        return totalWeight;
    }

    public static int getTotalPrice(List<Item> items) {
        int totalPrice = 0;
        for (Item item : items) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }

    public static void calcBestValueItems(List<Item> items, Backpack backpack) {
        if (items == null || backpack == null || items.isEmpty()) {
            return;
        }

        int totalPrice = getTotalPrice(items);
        int totalWeight = getTotalWeight(items);

        if (totalWeight <= backpack.getMaxWeight() && totalPrice > backpack.getTopValue()) {
            backpack.setBestMatch(items);
            backpack.setTopValue(totalPrice);
        }

        for (int i = 0; i < items.size(); i++) {
            List<Item> copiedItems = new ArrayList<>(items);
            copiedItems.remove(i);
            calcBestValueItems(copiedItems, backpack);
        }
    }

    public static void bestSet(List<Item> items) {


    }
}
