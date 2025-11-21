package sorting.shaker_sort;

import java.util.Arrays;

public class ShakerSort {
    public static void main(String[] args) {
        int[] array = new int[]{22, 8, 6, 720, 7, 25, 5, 5, 9, 2, 21, 567, 113};
        System.out.println("Исходный массив: " + Arrays.toString(array));
        shakerSort(array);
        System.out.println("Отсортированный массив: " + Arrays.toString(array));
    }

    private static void shakerSort(int[] array) {
        int left = 0;
        int right = array.length - 1;
        boolean swapped = true;

        while (swapped && left < right) {
            swapped = false;
            for (int i = left; i < right; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
            right--;

            swapped = false;
            for (int i = right; i >= left + 1; i--) {
                if (array[i - 1] > array[i]) {
                    int temp = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = temp;
                    swapped = true;
                }
            }
            left++;
        }
    }
}