package ru.geekbrains.lesson3;

import lesson3.stack.Stack;
import lesson3.stack.StackImpl;
import ru.geekbrains.lesson3.deque.Deque;
import ru.geekbrains.lesson3.deque.DequeImpl;


import java.util.Scanner;

public class HomeWork {
    public static void main(String[] args) {
/*        //Part1
        // QUEUE FIFO
        Queue<String> strings = new QueueImpl<>(10);
        System.out.println(strings.isEmpty());
        strings.insert("first");
        strings.insert("second");

        System.out.println(strings.isEmpty());
        System.out.println(strings.size());
        String first = strings.peekFront();
        String alsoFirst = strings.remove();
        String second = strings.remove();
        System.out.println(first.equals(alsoFirst));
        System.out.println(second);
        // Stack LIFO
        Stack<String> stringStack = new StackImpl<>(10);
        stringStack.push(first);
        stringStack.push(second);
        System.out.println(stringStack.isEmpty());
        System.out.println(stringStack.size());
        System.out.println(second.equals(stringStack.peek()));*/

        //Part 2 Reverse string
        Scanner sc = new Scanner(System.in); //System.in is a standard input stream
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        System.out.print("Your string reversed is  " + reverseStringUsingStack(str));

        //Part 3
        Deque<String> stringDeque = new DequeImpl<>(5);
        stringDeque.insertLeft("A");
        stringDeque.insertRight("b");
        stringDeque.insertLeft("C");


    }

    private static String reverseStringUsingStack(String input) {
        Stack<Character> characterStack = new StackImpl<>(input.length());
        for (int i = 0; i < input.length(); i++) {
            characterStack.push(input.charAt(i));
        }
        StringBuilder builder = new StringBuilder();
        int size = characterStack.size();
        for (int i = 0; i < size; i++) {
            builder.append(characterStack.pop());
        }
        return builder.toString();
    }
}
