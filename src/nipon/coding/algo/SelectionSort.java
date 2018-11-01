package nipon.coding.algo;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int[] data = {4, 1, 7, 6, 5, 3, 2};
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.selectionSort(data);
        System.out.println(Arrays.toString(data));
    }

    public void selectionSort(int[] data) {
        int minIndex;
        for (int i = 0; i < data.length - 1; i++) {
            minIndex = findMinIndex(i, data);
            swap(data, i, minIndex);
        }
    }

    private int findMinIndex(int currentIndex, int[] data) {
        int minIndex = currentIndex;
        for (int j = currentIndex + 1; j < data.length; j++) {

            if (data[j] < data[minIndex]) {
                minIndex = j;
            }
        }
        return minIndex;
    }

    private void swap(int[] data, int i, int minIndex) {
        int temp = data[i];
        data[i] = data[minIndex];
        data[minIndex] = temp;
    }
}
