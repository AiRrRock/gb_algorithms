package ru.geekbrains.lesson6;

import lesson6.Node;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int maxLevels = 6;
        int maxElements = (int) (Math.pow(2, maxLevels) - 1);
        List<TreeImpl<Integer>> trees = new LinkedList<>();
        for (int i = 0; i < 20; i++) {
            TreeImpl<Integer> tree = new TreeImpl<>(maxLevels);
            Random rand = new Random();
            for (int j = 0; j < maxElements; j++) {
                int number = rand.nextInt(101) * (rand.nextInt(100) < 50 ? -1 : 1);
                tree.add(number);
            }
            trees.add(tree);
        }

        int balanced = 0;
        for (TreeImpl tree : trees) {
            if (isBalanced(tree.getRoot())) {
                balanced++;
            }
        }
        System.out.println(balanced);


    }

    public static boolean isBalanced(Node node) {
        return (node == null) ||
                isBalanced(node.getLeftChild()) &&
                        isBalanced(node.getRightChild()) &&
                        Math.abs(height(node.getLeftChild()) - height(node.getRightChild())) <= 1;
    }

    private static int height(Node node) {
        return node == null ? 0 : 1 + Math.max(height(node.getLeftChild()), height(node.getRightChild()));
    }
}
