package sorting.radix_sort;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int[] array = new int[]{22, 8, 6, 720, 7, 25, 5, 5, 9, 2, 21, 567, 113};
        System.out.println("Исходный массив: " + Arrays.toString(array));
        radixSort(array);
        System.out.println("Отсортированный массив: " + Arrays.toString(array));
    }

    private static void radixSort(int[] array) {
        int base = 10;
        int max = findMaxValue(array);

        for (int exp = 1; max / exp > 0; exp *= base) {
            countSort(array, exp, base);
        }
    }

    private static void countSort(int[] array, int exp, int base) {
        int n = array.length;
        int[] temp = new int[n];
        int[] countDigit = new int[base];

        for (int value : array) {
            int digit = (value / exp) % base;
            countDigit[digit]++;
        }

        for (int i = 1; i < base; i++) {
            countDigit[i] += countDigit[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            int value = array[i];
            int digit = (value / exp) % base;
            int index = countDigit[digit] - 1;
            temp[index] = value;
            countDigit[digit]--;
        }

        System.arraycopy(temp, 0, array, 0, n);
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