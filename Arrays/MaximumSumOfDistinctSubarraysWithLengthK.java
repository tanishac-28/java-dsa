package Arrays;

import java.util.HashMap;
import java.util.Map;

/*
 * Problem Statement:
 * You are given an integer array nums and an integer k. Find the maximum
 * subarray sum of all the subarrays of nums that meet these conditions:
 * - The length of the subarray is k, and
 * - All the elements of the subarray are distinct.
 * Return the maximum subarray sum of all the subarrays that meet the
 * conditions. If no subarray meets the conditions, return 0.
 *
 * Example:
 * Input: nums = [1, 5, 4, 2, 9, 9, 9], k = 3
 * Output: 15
 * Explanation: The subarrays of length 3 are:
 * [1, 5, 4] -> distinct, sum = 10
 * [5, 4, 2] -> distinct, sum = 11
 * [4, 2, 9] -> distinct, sum = 15
 * [2, 9, 9] -> 9 is repeated, not valid
 * [9, 9, 9] -> 9 is repeated, not valid
 * The maximum sum among the valid subarrays is 15.
 *
 * Approach: Sliding Window (fixed size) + HashMap
 * - Keep a window of size k and a map that stores the count of each number
 *   in the window.
 * - dups counts the extra duplicate occurrences inside the window.
 *   Whenever a number's count goes above 1 after adding, dups increases.
 *   Whenever a number's count is above 1 before removing, dups decreases.
 * - Build the first window of size k, and if dups == 0 (all distinct),
 *   use its sum as the first max.
 * - Slide the window: add nums[i], remove nums[i - k], and update sum and
 *   dups.
 * - After every slide, if dups == 0 then all elements are distinct, so
 *   update the maximum sum.
 */

public class MaximumSumOfDistinctSubarraysWithLengthK {
    public static long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long sum = 0, max = 0;

        Map<Integer, Integer> map = new HashMap<>();
        int dups = 0;

        // First window of size k
        for (int i = 0; i < k; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 0);
            }
            map.put(nums[i], map.get(nums[i]) + 1);

            sum = sum + nums[i];

            if (map.get(nums[i]) > 1) {
                dups++;
            }
        }
        if (dups == 0) {
            max = Math.max(sum, max);
        }

        // Slide the window one step at a time
        for (int i = k; i < n; i++) {
            int numToAdd = nums[i];
            int numToRemove = nums[i - k];

            if (!map.containsKey(numToAdd)) {
                map.put(numToAdd, 0);
            }
            map.put(numToAdd, map.get(numToAdd) + 1);

            if (map.get(numToAdd) > 1) {
                dups++;
            }
            sum = sum + numToAdd;

            if (map.get(numToRemove) > 1) {
                dups--;
            }
            map.put(numToRemove, map.get(numToRemove) - 1);

            sum = sum - numToRemove;

            // All elements in the window are distinct
            if (dups == 0) {
                max = Math.max(sum, max);
            }
        }

        return max;
    }

    // Driver code: sample input values to test the solution
    public static void main(String[] args) {
        int[] nums = {1, 5, 4, 2, 9, 9, 9};
        int k = 3;

        long result = maximumSubarraySum(nums, k);

        System.out.println(result);
    }
}

/*
LeetCode No => 2461
Time Complexity => O(N)
Space Complexity => O(K)

Output:
15


Companies that asked this question:
Facebook (Meta), Amazon, WalMart

*/