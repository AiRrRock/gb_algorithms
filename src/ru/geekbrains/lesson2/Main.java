package ru.geekbrains.lesson2;

import lesson2.Array;
import lesson2.ArrayImpl;
import ru.geekbrains.lesson2.HomeworkArrayImpl;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Main {
    private static Random random = new Random();

    public static void main(String[] args) {
        int size = 100000;
        Array<Double> doubles = new ArrayImpl<>(100000);
        for (int i = 0; i < size; i++) {
            doubles.add(random.nextDouble());
        }

        Array<Double> bubbleSort = new HomeworkArrayImpl<>(doubles);
        Array<Double> insertionSort = new HomeworkArrayImpl<>(doubles);
        Array<Double> selectionSort = new HomeworkArrayImpl<>(doubles);

        System.out.println("Sorting");
        long sortTime = TimeUnit.NANOSECONDS.toMillis(System.nanoTime());
        bubbleSort.sortBubble();
        sortTime = TimeUnit.NANOSECONDS.toMillis(System.nanoTime())-sortTime;
        System.out.println(String.format("%s sort took %d ms", "Bubble", sortTime));
        sortTime = TimeUnit.NANOSECONDS.toMillis(System.nanoTime());
        insertionSort.sortSelect();
        sortTime = TimeUnit.NANOSECONDS.toMillis(System.nanoTime())-sortTime;
        System.out.println(String.format("%s sort took %d ms", "Selection", sortTime));
        sortTime = TimeUnit.NANOSECONDS.toMillis(System.nanoTime());
        selectionSort.sortInsert();
        sortTime = TimeUnit.NANOSECONDS.toMillis(System.nanoTime())-sortTime;
        System.out.println(String.format("%s sort took %d ms", "Insertion", sortTime));
    }

}
