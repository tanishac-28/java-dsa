package Arrays;

import java.util.HashMap;

/*
 * Problem Statement:
 * Given an array of integers nums and an integer k, return the total number
 * of subarrays whose sum equals to k.
 * A subarray is a contiguous non-empty sequence of elements within an array.
 *
 * Example:
 * Input: nums = [1, 2, 3], k = 3
 * Output: 2
 * Explanation: The subarrays that sum up to 3 are [1, 2] and [3].
 *
 * Approach: Prefix Sum + HashMap
 * - The array can have negative numbers, so sliding window will not work.
 * - Keep a running prefix sum while moving through the array.
 * - If the sum of the subarray from index j + 1 to i is k, then
 *   prefixSum(i) - prefixSum(j) = k, which means prefixSum(j) = sum - k.
 * - The map stores how many times each prefix sum has appeared so far.
 * - For every index, if (sum - k) is in the map, add its frequency to count,
 *   because each occurrence gives one valid subarray ending at this index.
 * - Then store the current sum in the map (increase its frequency by 1).
 * - Initially put (0, 1) in the map to handle subarrays starting from
 *   index 0.
 */

public class SubarraySumEqualsK {
    public static int subarraySum(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        map.put(0, 1);
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum = sum + nums[i];

            // Subarrays ending at i with sum k
            if (map.containsKey(sum - k)) {
                count = count + map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    // Driver code: sample input values to test the solution
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int k = 3;

        int result = subarraySum(nums, k);

        System.out.println(result);
    }
}

/*
LeetCode No => 560
Time Complexity => O(N)
Space Complexity => O(N)

Output:
2


Companies that asked this question:
Amazon, Google Meta, Microsoft, Apple, Adobe , Flipkart, TCS,  Goldman Sachs (Most Imp)
*/