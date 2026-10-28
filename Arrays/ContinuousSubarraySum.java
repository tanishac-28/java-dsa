package Arrays;

import java.util.HashMap;

/*
 * Problem Statement:
 * Given an integer array nums and an integer k, return true if nums has a
 * good subarray or false otherwise.
 * A good subarray is a subarray where:
 * - its length is at least two, and
 * - the sum of the elements of the subarray is a multiple of k.
 * Note: A subarray is a contiguous part of the array. An integer x is a
 * multiple of k if there exists an integer n such that x = n * k.
 * 0 is always a multiple of k.
 *
 * Example:
 * Input: nums = [23, 2, 4, 6, 7], k = 6
 * Output: true
 * Explanation: [2, 4] is a continuous subarray of size 2 whose elements
 * sum up to 6.
 *
 * Approach: Prefix Sum Remainder + HashMap
 * - If two prefix sums have the same remainder when divided by k, then the
 *   subarray between them has a sum that is a multiple of k.
 * - Keep a running sum and find rem = sum % k at every index.
 * - The map stores the first index where each remainder appeared.
 *   Initially put (0, -1), so a subarray starting from index 0 is handled.
 * - If rem is already in the map, check the distance between the indices.
 *   If i - map.get(rem) >= 2, the subarray length is at least 2, so
 *   return true.
 * - If rem is not in the map, store its first index. We do not update it
 *   later, because keeping the earliest index gives the longest subarray.
 * - If no such subarray is found, return false.
 */

public class ContinuousSubarraySum {
    public static boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum = sum + nums[i];
            int rem = sum % k;

            // Same remainder seen before, check the subarray length
            if (map.containsKey(rem)) {
                if (i - map.get(rem) >= 2) {
                    return true;
                }
            } else {
                // Store only the first index of this remainder
                map.put(rem, i);
            }
        }
        return false;
    }

    // Driver code: sample input values to test the solution
    public static void main(String[] args) {
        int[] nums = {23, 2, 4, 6, 7};
        int k = 6;

        boolean result = checkSubarraySum(nums, k);

        System.out.println(result);
    }
}

/*
LeetCode No => 523
Time Complexity => O(N)
Space Complexity => O(min(N, K))

Output:
true


Companies that asked this question:
Amazon , Google , Meta, Microsoft, Apple, Bloomberg, TCS, Yandex, Samsung, LinkedIn.
*/