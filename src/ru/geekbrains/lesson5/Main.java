package ru.geekbrains.lesson5;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Part 1
        System.out.println(pow(2, 1));
        System.out.println(pow(2, 4));
        System.out.println(pow(2, 8));
        System.out.println(pow(2, 10));
        System.out.println(pow(2, 0));
        System.out.println(pow(2, -1));
        System.out.println(pow(2, -2));

        //Part 2

        List<Item> items = new ArrayList<>();
        items.add(new Item("Airsoft gun", 3, 15000)); // +
        items.add(new Item("Skateboard", 5, 19000)); // +
        items.add(new Item("Laptop", 4, 50000));  // -
        items.add(new Item("Sunglasses", 1, 1000)); // +

        Backpack backpack = new Backpack(7);
        ItemsEvaluator.calcBestValueItems(items, backpack);

        for (Item item : backpack.getBestMatch()) {
            System.out.println(item);
        }

        System.out.println("Best price = " + backpack.getTopValue());

    }

    //Part 1
    private static double pow(int num, int toPow) {
        if (toPow > 1) {
            return num * pow(num, --toPow);
        } else if (toPow == 1) {
            return num;
        } else if (toPow == 0) {
            return 1;
        } else {
            return 1 / pow(num, -toPow);
        }

    }
}
