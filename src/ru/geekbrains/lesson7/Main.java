package ru.geekbrains.lesson7;

import lesson7.Graph;
import lesson7.GraphImpl;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Graph graph = new GraphImpl(10);
        graph.addVertex("1");
        graph.addVertex("2");
        graph.addVertex("3");
        graph.addVertex("4");
        graph.addVertex("5");
        graph.addVertex("6");
        graph.addVertex("7");
        graph.addVertex("8");
        graph.addVertex("9");
        graph.addVertex("10");

        graph.addEdge("1", "2");
        graph.addEdge("1", "3");
        graph.addEdge("3", "2");
        graph.addEdge("3", "4");
        graph.addEdge("4", "6");
        graph.addEdge("4", "7");
        graph.addEdge("3", "5");
        graph.addEdge("5", "8");
        graph.addEdge("8", "10");
        graph.addEdge("6", "8");
        graph.addEdge("9", "10");
        graph.addEdge("10", "8");

        Stack<String> path = graph.findShortPathViaBfs("1", "10");
        System.out.println("\n The shortest path:");
        showShortPath(path);
    }

    private static void showShortPath(Stack<String> path) {
        StringBuilder sb = new StringBuilder();
        boolean isFirst = true;

        while (!path.isEmpty()) {
            if (!isFirst) {
                sb.append(" -> ");
            }
            isFirst = false;
            sb.append(path.pop());
        }

        System.out.println(sb);
    }

}