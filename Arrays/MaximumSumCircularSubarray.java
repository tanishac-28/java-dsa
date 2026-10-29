package Arrays;

/*
 * Problem Statement:
 * Given a circular integer array nums of length n, return the maximum
 * possible sum of a non-empty subarray of nums.
 * A circular array means the end of the array connects to the beginning of
 * the array. A subarray may only include each element of the fixed buffer
 * nums at most once.
 *
 * Example:
 * Input: nums = [5, -3, 5]
 * Output: 10
 * Explanation: Subarray [5, 5] (last element + first element) has the
 * maximum sum 5 + 5 = 10.
 *
 * Approach: Kadane's Algorithm (max and min subarray)
 * - The best subarray is either a normal subarray (not wrapping around), or
 *   a wrapping subarray.
 * - Case 1 (no wrap): use Kadane's algorithm to find the maximum subarray
 *   sum (max).
 * - Case 2 (wrap): a wrapping subarray is the whole array minus some middle
 *   subarray, so its sum = totalSum - (minimum subarray sum). Find the
 *   minimum subarray sum (min) with the same Kadane idea.
 * - The answer is max(max, totalSum - min).
 * - Edge case: if all the elements are negative, max < 0 and min is the
 *   whole array, so totalSum - min would be 0 (an empty subarray), which is
 *   not allowed. In this case return max directly.
 */

public class MaximumSumCircularSubarray {
    public static int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        int min = nums[0];
        int currmin = 0;
        int currmax = 0;
        int totalSum = 0;

        for (int i = 0; i < n; i++) {
            totalSum += nums[i];
            int temp1 = currmin + nums[i];
            int temp2 = currmax + nums[i];
            currmax = Math.max(temp2, nums[i]);
            currmin = Math.min(temp1, nums[i]);

            max = Math.max(max, currmax);
            min = Math.min(min, currmin);
        }

        // All elements are negative, so wrapping is not possible
        if (max < 0) {
            return max;
        } else {
            return Math.max(max, totalSum - min);
        }
    }

    // Driver code: sample input values to test the solution
    public static void main(String[] args) {
        int[] nums = {5, -3, 5};

        int result = maxSubarraySumCircular(nums);

        System.out.println(result);
    }
}

/*
LeetCode No => 918
Time Complexity => O(N)
Space Complexity => O(1)

Output:
10


Companies that asked this question:
Amazon, Apple, Bloomberg, Goldman Sachs, Google, Sprinklr, TikTok, Two Sigma, and Flipkart
*/