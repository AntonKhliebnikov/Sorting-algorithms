package sorting.comb_sort;

import java.util.Arrays;

public class CombSort {
    public static void main(String[] args) {
        int[] array = new int[]{22, 8, 6, 720, 7, 25, 5, 5, 9, 2, 21, 567, 113};
        System.out.println("Исходный массив: " + Arrays.toString(array));
        combSort(array);
        System.out.println("Отсортированный массив: " + Arrays.toString(array));
    }

    private static void combSort(int[] array) {
        int n = array.length;
        int gap = n;
        final float shrinkFactor = 1.3f;
        boolean swapped = false;

        while (gap > 1 || swapped) {
            if (gap > 1) {
                gap = (int) (gap / shrinkFactor);
            }

            swapped = false;

            for (int i = 0; i + gap < n; i++) {
                if (array[i] > array[i + gap]) {
                    int temp = array[i];
                    array[i] = array[i + gap];
                    array[i + gap] = temp;
                    swapped = true;
                }
            }
        }
    }
}