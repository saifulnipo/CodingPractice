package nipon.coding.algo;

import java.util.Arrays;

public class MergeSorter {

    public static void main(String[] args) {
        int[] data = {4, 1, 7, 6, 5, 3, 8, 2};
        MergeSorter sorter = new MergeSorter();
        sorter.mergeSort(data, 0, data.length - 1);
        System.out.println(Arrays.toString(data));
    }

    public void mergeSort(int[] data, int start, int end) {

        if (start < end) {
            int middel = (start + end) / 2;
            mergeSort(data, start, middel);
            mergeSort(data, middel + 1, end);
            merge(data, start, middel, end);
        }
    }

    private void merge(int[] data, int start, int middel, int end) {

        /* Create temp arrays */
        int[] left = new int[middel - start + 1];
        int[] right = new int[end - middel];

        /*Copy data to temp arrays*/
        if (left.length >= 0) System.arraycopy(data, start, left, 0, left.length);
        for (int j = 0; j < right.length; j++) {
            right[j] = data[middel + 1 + j];
        }

        int i = 0, j = 0, k = start;
        while (i < left.length && j < right.length) {

            if (left[i] <= right[j]) {
                data[k] = left[i];
                i++;
            } else {
                data[k] = right[j];
                j++;
            }
            k++;
        }
        
        // copy rest of left array  
        while (i < left.length) {
            data[k] = left[i];
            k++;
            i++;
        }

        // copy rest of right array
        while (j < right.length) {
            data[k] = right[j];
            k++;
            j++;
        }
    }
}
