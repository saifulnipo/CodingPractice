package nipon.coding.practice;

/**
 * Problem: https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * @author saifulnipo
 * @reference: https://github.com/mission-peace/interview/blob/master/src/com/interview/binarysearch/MedianOfTwoSortedArrayOfDifferentLength.java
 */
public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        MedianOfTwoSortedArrays msa = new MedianOfTwoSortedArrays();
        System.out.println(
                msa.findMedianSortedArrays(new int[]{3, 4}, new int[]{1, 2})
        );

        System.out.println(
                msa.findMedianSortedArrays(new int[]{1, 1, 1, 2}, new int[]{2, 3, 3, 4, 4})
        );

        System.out.println(
                msa.findMedianSortedArrays(new int[]{3}, new int[]{-3, -1})
        );
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int lengthX = nums1.length,
            lengthY = nums2.length,
            low = 0,
            high = lengthX;

        while (low <= high) {
            int partitionX = (low + high) / 2,
                partitionY = (lengthX + lengthY + 1) / 2 - partitionX,
                maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1],
                minRightX = (partitionX == lengthX) ? Integer.MAX_VALUE : nums1[partitionX],
                maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1],
                minRightY = (partitionY == lengthY) ? Integer.MAX_VALUE : nums2[partitionY];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if ((lengthX + lengthY) % 2 == 0) {
                    return ((double) Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
                } else {
                    return Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) { // too far right for partitionX, need to go left
                high = partitionX - 1;
            } else { // too far left for partitionX, need to go right
                low = partitionX + 1;
            }
        }

        throw new IllegalArgumentException();
    }
}
