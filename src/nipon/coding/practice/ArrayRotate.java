package nipon.coding.practice;

import java.util.Arrays;

public class ArrayRotate {

    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5, 6, 7};
        int d = 3;
        ArrayRotate arrayRotate = new ArrayRotate();
        arrayRotate.rotate(data, d);
        System.out.println(Arrays.toString(data));
    }

    private void rotate(int[] data, int d) {
        this.reverseRotate(data, 0, d - 1);
        this.reverseRotate(data, d, data.length - 1);
        this.reverseRotate(data, 0, data.length - 1);
    }

    private void reverseRotate(int[] data, int start, int end) {
        int temp;
        while (start < end) {
            temp = data[start];
            data[start] = data[end];
            data[end] = temp;
            start++;
            end--;
        }
    }
}
