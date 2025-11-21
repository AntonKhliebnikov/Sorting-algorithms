package sorting.gnom_sort;

import java.util.Arrays;

public class GnomeSort {
    public static void main(String[] args) {
        int[] array = new int[]{22, 8, 6, 720, 7, 25, 5, 5, 9, 2, 21, 567, 113};
        System.out.println("Исходный массив: " + Arrays.toString(array));
        gnomeSort(array);
        System.out.println("Отсортированный массив: " + Arrays.toString(array));
    }

    private static void gnomeSort(int[] array) {
        int n = array.length;
        int index = 0;
        while (index < n) {
            if (index == 0) {
                index++;
            } else if (array[index] >= array[index - 1]) {
                index++;
            } else {
                int temp = array[index];
                array[index] = array[index - 1];
                array[index - 1] = temp;
                index--;
            }
        }
    }
}