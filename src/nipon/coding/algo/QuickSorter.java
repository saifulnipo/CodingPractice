package nipon.coding.algo;

import java.util.Arrays;

public class QuickSorter {

    public static void main(String[] args) {
        int[] data = {4, 1, 7, 6, 5, 3, 8, 2};
        QuickSorter sorter = new QuickSorter();
        sorter.quickSort(data, 0, data.length - 1);
        System.out.println(Arrays.toString(data));
    }

    private void quickSort(int[] data, int low, int hight) {

        if (low < hight) {
            int pivot = partition(data, low, hight);
            quickSort(data, low, pivot - 1);
            quickSort(data, pivot + 1, hight);
        }
    }

    private int partition(int[] data, int low, int high) {
        int pivot = data[high];
        int i = low;

        for (int j = low; j < high; j++) {
            if (data[j] <= pivot) {
                swap(data, i, j);
                i++;
            }
        }
        swap(data, i, high);

        return i;
    }

    private void swap(int[] data, int indexA, int indexB) {
        int temp = data[indexA];
        data[indexA] = data[indexB];
        data[indexB] = temp;
    }
}
