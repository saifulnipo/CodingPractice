package nipon.coding.practice;

import java.util.Arrays;

/**
 * Problem: https://leetcode.com/problems/two-sum/
 *
 * @author saifulnipo
 */
public class TwoSum {

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] result = twoSum.getSum(new int[]{2, 7, 11, 3, 6, 15}, 9);
        System.out.println(Arrays.toString(result));
    }

    private int[] getSum(int[] data, int target) {

        for (int i = 0; i < data.length; i++) {
            for (int j = i + 1; j < data.length; j++) {
                if (data[i] + data[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        throw new IllegalArgumentException("No result found");
    }
}
