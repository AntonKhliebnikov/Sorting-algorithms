package sorting.bucket_sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BucketSort {
    public static void main(String[] args) {
        int[] array = new int[]{22, 8, 6, 720, 7, 25, 5, 5, 9, 2, 21, 567, 113};
        System.out.println("Исходный массив: " + Arrays.toString(array));
        bucketSort(array);
        System.out.println("Отсортированный массив: " + Arrays.toString(array));
    }

    private static void bucketSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        int min = array[0];
        int max = array[0];
        for (int value : array) {
            if (value < min) {
                min = value;
            }
            if (value > max) {
                max = value;
            }
        }

        int n = array.length;
        int bucketCount = n / 4;
        List<List<Integer>> buckets = new ArrayList<>(bucketCount);
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<>());
        }

        int range = max - min + 1;
        for (int value : array) {
            int bucketIndex = (value - min) * bucketCount / range;
            if (bucketIndex == bucketCount) {
                bucketIndex = bucketCount - 1;
            }
            buckets.get(bucketIndex).add(value);
        }

        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket);
        }

        int index = 0;
        for (List<Integer> bucket : buckets) {
            for (int value : bucket) {
                array[index] = value;
                index++;
            }
        }
    }
}