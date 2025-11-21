package sorting.tim_sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TimSort {
    private static final int MIN_RUN = 4;

    private static class Run {
        int startIndex;
        int endIndex;

        public Run(int startIndex, int endIndex) {
            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{22, 8, 6, 720, 7, 25, 5, 5, 9, 2, 21, 567, 113};
        System.out.println("Исходный массив: " + Arrays.toString(array));
        timSort(array);
        System.out.println("Отсортированный массив: " + Arrays.toString(array));
    }

    private static void timSort(int[] array) {
        int n = array.length;
        if (n <= 1) {
            return;
        }

        List<Run> runs = new ArrayList<>();
        int currentStartIndex = 0;
        while (currentStartIndex < n) {
            int runStartIndex = currentStartIndex;
            int runEndIndex = runStartIndex + 1;

            while (runEndIndex < n && array[runEndIndex] >= array[runEndIndex - 1]) {
                runEndIndex++;
            }

            int currentRunLength = runEndIndex - runStartIndex;
            int desiredRunLength = Math.max(currentRunLength, MIN_RUN);
            int desiredRunEndIndex = runStartIndex + desiredRunLength - 1;
            if (desiredRunEndIndex >= n) {
                desiredRunEndIndex = n - 1;
            }

            insertionSortOnRange(array, runStartIndex, desiredRunEndIndex);
            runs.add(new Run(runStartIndex, desiredRunEndIndex));
            currentStartIndex = desiredRunEndIndex + 1;
        }

        while (runs.size() > 1) {
            List<Run> mergedRuns = new ArrayList<>();
            for (int i = 0; i < runs.size(); i += 2) {
                if (i + 1 < runs.size()) {
                    Run leftRun = runs.get(i);
                    Run rightRun = runs.get(i + 1);
                    mergeSortedRanges(array, leftRun.startIndex, leftRun.endIndex, rightRun.endIndex);
                    mergedRuns.add(new Run(leftRun.startIndex, rightRun.endIndex));
                } else {
                    mergedRuns.add(runs.get(i));
                }
            }
            runs = mergedRuns;
        }
    }

    private static void insertionSortOnRange(int[] array, int leftIndex, int rightIndex) {
        for (int i = leftIndex + 1; i <= rightIndex; i++) {
            int currentValue = array[i];
            int j = i - 1;
            while (j >= leftIndex && array[j] > currentValue) {
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = currentValue;
        }
    }

    private static void mergeSortedRanges(int[] array, int leftStartIndex, int middleIndex, int rightEndIndex) {
        int leftLength = middleIndex - leftStartIndex + 1;
        int rightLength = rightEndIndex - middleIndex;

        int[] leftArray = new int[leftLength];
        int[] rightArray = new int[rightLength];

        for (int i = 0; i < leftLength; i++) {
            leftArray[i] = array[leftStartIndex + i];
        }

        for (int i = 0; i < rightLength; i++) {
            rightArray[i] = array[middleIndex + 1 + i];
        }

        int leftPointer = 0;
        int rightPointer = 0;
        int targetIndex = leftStartIndex;

        while (leftPointer < leftLength && rightPointer < rightLength) {
            if (leftArray[leftPointer] <= rightArray[rightPointer]) {
                array[targetIndex] = leftArray[leftPointer];
                leftPointer++;
            } else {
                array[targetIndex] = rightArray[rightPointer];
                rightPointer++;
            }
            targetIndex++;
        }

        while (leftPointer < leftLength) {
            array[targetIndex] = leftArray[leftPointer];
            leftPointer++;
            targetIndex++;
        }

        while (rightPointer < rightLength) {
            array[targetIndex] = rightArray[rightPointer];
            rightPointer++;
            targetIndex++;
        }
    }
}
