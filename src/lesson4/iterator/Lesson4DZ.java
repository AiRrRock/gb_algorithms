package lesson4.iterator;


import lesson4.LinkedList;
import lesson4.SimpleLinkedListImpl;

import java.util.ArrayList;
import java.util.List;

public class Lesson4DZ {

    public static void main(String[] args) {
        LinkedList<Integer> list = new SimpleLinkedListImpl<>();
        list.insertFirst(4);
        list.insertFirst(3);
        list.insertFirst(2);
        list.insertFirst(1);

        displayAll(list);

        System.out.println("-----------");

        ListIterator<Integer> iterator = (ListIterator<Integer>) list.iterator();
        iterator.reset();//1! 2 3 4
        iterator.insertAfter(11);//1 11! 2 3 4
        iterator.next();//1 11 2! 3 4
        iterator.remove();//1 11 3! 4
        iterator.insertBefore(0);// 1 11 0! 3 4

        displayAll(list);
        System.out.println("-----------");

        iterator = (ListIterator<Integer>) list.iterator();
        while (iterator.hasNext()) {
            iterator.remove();
            displayAll(list);
            System.out.println("-----------");
        }

        List<Integer> arrayData = new ArrayList<>();
        arrayData.add(1);
        arrayData.add(2);
        arrayData.add(3);
        arrayData.add(4);

        for (Integer datum : arrayData) {
            System.out.println(datum);
            arrayData.remove(datum);
        }

    }

    private static void displayAll(LinkedList<Integer> list) {
        for (Integer value : list) {
            System.out.println(value);
        }
    }
}