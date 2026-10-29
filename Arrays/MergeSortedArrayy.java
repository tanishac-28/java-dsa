package Arrays;

import java.util.Arrays;

/*
 * Problem Statement:
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing
 * order, and two integers m and n, representing the number of elements in
 * nums1 and nums2 respectively.
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 * The final sorted array should not be returned by the function, but instead
 * be stored inside the array nums1. To accommodate this, nums1 has a length
 * of m + n, where the first m elements denote the elements that should be
 * merged, and the last n elements are set to 0 and should be ignored.
 * nums2 has a length of n.
 *
 * Example:
 * Input: nums1 = [1, 2, 3, 0, 0, 0], m = 3, nums2 = [2, 5, 6], n = 3
 * Output: [1, 2, 2, 3, 5, 6]
 * Explanation: The arrays we are merging are [1, 2, 3] and [2, 5, 6]. The
 * result of the merge is [1, 2, 2, 3, 5, 6].
 *
 * Approach: Three Pointers (merge from the back)
 * - nums1 has free space at the end, so fill it from the back. If we filled
 *   from the front, we would overwrite the elements of nums1 that are not
 *   merged yet.
 * - Keep r1 at the last real element of nums1 (m - 1), r2 at the last
 *   element of nums2 (n - 1), and index at the last position of nums1
 *   (m + n - 1).
 * - While both arrays have elements, put the larger of nums1[r1] and
 *   nums2[r2] at nums1[index] and move that pointer back.
 * - If only nums1 has elements left, they are already at the right place
 *   in order, but copying keeps the code simple.
 * - If only nums2 has elements left, copy them into nums1.
 */

public class MergeSortedArrayy {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int r1 = m - 1;
        int r2 = n - 1;
        int index = m + n - 1;

        while (index >= 0) {
            if (r1 >= 0 && r2 >= 0) {
                // Both have elements, take the larger one
                if (nums1[r1] > nums2[r2]) {
                    nums1[index] = nums1[r1];
                    r1--;
                } else {
                    nums1[index] = nums2[r2];
                    r2--;
                }
            } else if (r1 >= 0) {
                // Only nums1 has elements left
                nums1[index] = nums1[r1];
                r1--;
            } else {
                // Only nums2 has elements left
                nums1[index] = nums2[r2];
                r2--;
            }
            index--;
        }
    }

    // Driver code: sample input values to test the solution
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;

        merge(nums1, m, nums2, n);

        System.out.println(Arrays.toString(nums1));
    }
}

/*
LeetCode No => 88
Time Complexity => O(M + N)
Space Complexity => O(1)

Output:
[1, 2, 2, 3, 5, 6]


Companies that asked this question:
Amazon, Facebook (Meta), Microsoft, Google, Apple, Bloomberg, Adobe
*/