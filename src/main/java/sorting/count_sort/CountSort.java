package sorting.count_sort;

import java.util.Arrays;

public class CountSort {
    public static void main(String[] args) {
        int[] array = new int[]{22, 8, 6, 720, 7, 25, 5, 5, 9, 2, 21, 567, 113};
        countSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void countSort(int[] array) {
        int max = findMaxValue(array);
        int[] countDigit = new int[max + 1];

        for (int element : array) {
            countDigit[element]++;
        }

        int index = 0;
        for (int i = 0; i < countDigit.length; i++) {
            for (int j = 0; j < countDigit[i]; j++) {
                array[index] = i;
                index++;
            }
        }
    }

    private static int findMaxValue(int[] array) {
        int max = 0;
        for (int value : array) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }
}