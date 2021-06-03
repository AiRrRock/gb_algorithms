package ru.geekbrains.lesson4;

import lesson4.SimpleLinkedListImpl;

public class LinkIteratorApp {
    public static void main(String[] args) {
        // Part 1 - understood the classes implementation, implementation of the TwoSidedLinkedList is a bit strange(without previous)

        //Part 2, 3
        SimpleLinkedListImpl<String> strings = new SimpleLinkedListImpl<>();
        strings.insertFirst("A");
        strings.insertFirst("B");
        strings.insertFirst("C");
        strings.insertFirst("D");
        for(String s : strings){
            System.out.println(s);
        }

        //Part 4
        LinkedDequeImpl<String> deque = new LinkedDequeImpl<>();
        deque.insertLeft("q");
        deque.insertLeft("e");
        deque.insertRight("u");
        deque.insertLeft("d");
        deque.insertRight("e");
        for(String s: deque){
            System.out.print(s);
        }


    }
}
