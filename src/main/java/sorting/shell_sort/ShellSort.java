package sorting.shell_sort;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] array = new int[]{85, 56, 6, 11, 7, 25, 5, 44, 9, 2, 21};
        shellSort(array);
        System.out.println(Arrays.toString(array));
    }

    // Сортировка Шелла
    // Сложность:
    // лучший случай O(n * log n)
    // худший случай O(n^2)
    // средний случай O(n * log n)
    public static void shellSort(int[] array) {
        int n = array.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (array[j] > array[j + gap]) {
                        int temp = array[j];
                        array[j] = array[j + gap];
                        array[j + gap] = temp;
                    }
                }
            }
        }
    }
}