package sorting.tree_sort;

import java.util.Arrays;

public class TreeSort {
    private Node root;
    private int index;

    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{22, 8, 6, 720, 7, 25, 5, 5, 9, 2, 21, 567, 113};
        System.out.println("Исходный массив: " + Arrays.toString(array));
        TreeSort treeSort = new TreeSort();
        treeSort.sort(array);
        System.out.println("Отсортированный массив: " + Arrays.toString(array));
    }

    private void sort(int[] array) {
        root = null;
        index = 0;
        for (int value : array) {
            insert(value);
        }
        inorderTraversalDFS(root, array);
    }

    private void insert(int value) {
        root = insertRec(root, value);
    }

    private Node insertRec(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }
        if (value < root.value) {
            root.left = insertRec(root.left, value);
        } else {
            root.right = insertRec(root.right, value);
        }
        return root;
    }

    private void inorderTraversalDFS(Node root, int[] array) {
        if (root != null) {
            inorderTraversalDFS(root.left, array);
            array[index] = root.value;
            index++;
            inorderTraversalDFS(root.right, array);
        }
    }
}