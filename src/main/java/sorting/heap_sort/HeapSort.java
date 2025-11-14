package sorting.heap_sort;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] array = new int[]{85, 56, 6, 11, 7, 25, 5, 44, 9, 2, 21};
        heapSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void heapSort(int[] array) {
        int n = array.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, i, n);
        }

        for (int i = n - 1; i >= 0 ; i--) {
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;
            heapify(array, 0, i);
        }
    }

    private static void heapify(int[] array, int parent, int n) {
        int leftChild = parent * 2 + 1;
        int rightChild = parent * 2 + 2;
        int largest = parent;

        if (leftChild < n && array[leftChild] > array[largest]) {
            largest = leftChild;
        }

        if (rightChild < n && array[rightChild] > array[largest]) {
            largest = rightChild;
        }

        if (parent != largest) {
            int temp = array[parent];
            array[parent] = array[largest];
            array[largest] = temp;
            heapify(array, largest, n);
        }
    }
}
