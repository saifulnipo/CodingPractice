package nipon.coding.practice;

import java.util.Arrays;

public class CyclicArrayRotator {

    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5, 6, 7};
        CyclicArrayRotator cyclicArrayRotator = new CyclicArrayRotator();
        cyclicArrayRotator.cyclicRotate(data);
        System.out.println(Arrays.toString(data));
    }

    private void cyclicRotate(int[] data) {

        if (data.length == 0) {
            return;
        }

        int i, size = data.length, temp = data[0];

        for (i = 0; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[size - 1] = temp;
    }
}
