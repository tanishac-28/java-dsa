package Arrays;

import java.util.Arrays;

/*
 * Problem Statement:
 * You are given an integer array nums consisting of n elements, and an
 * integer k. Find a contiguous subarray whose length is equal to k that has
 * the maximum average value and return this value. Any answer with a
 * calculation error less than 10^-5 will be accepted.
 *
 * Example:
 * Input: nums = [1, 12, -5, -6, 50, 3], k = 4
 * Output: 12.75
 * Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
 *
 * Approach: Sliding Window
 * - All windows have the same length k, so the window with the maximum sum
 *   also has the maximum average.
 * - Calculate the sum of the first k elements.
 * - Slide the window one step at a time: add the new element entering the
 *   window and subtract the element leaving it.
 * - Track the maximum sum and divide it by k at the end.
 */



public class MaximumAverageSubarray {
    public static double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;

        // Sum of the first window
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        int max = sum;

        // Slide the window: add the new element, remove the old one
        for (int j = k; j < n; j++) {
            sum += nums[j] - nums[j - k];
            max = Math.max(max, sum);
        }

        return (double) max / k;
    }

    // Driver code: sample input values to test the solution
    public static void main(String[] args) {
        int[] nums = {1, 12, -5, -6, 50, 3};
        int k = 4;

        double result = findMaxAverage(nums, k);

        System.out.println("Array: " + Arrays.toString(nums));
        System.out.println("Max average: " + result);
    }
}

/*
LeetCode No => 643
Time Complexity => O(N)
Space Complexity => O(1)

Output:
Array: [1, 12, -5, -6, 50, 3]
Max average: 12.75


Companies that asked this question:
Amazon and Oracle
*/