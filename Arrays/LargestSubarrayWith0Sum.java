package Arrays;

import java.util.HashMap;

/*
 * Problem Statement:
 * Given an array arr[] containing both positive and negative integers, the
 * task is to find the length of the longest subarray with the sum of the
 * elements equal to 0.
 *
 * Example:
 * Input: arr = [15, -2, 2, -8, 1, 7, 10, 23]
 * Output: 5
 * Explanation: The longest subarray with sum 0 is [-2, 2, -8, 1, 7].
 *
 * Approach: Prefix Sum + HashMap
 * - If the same prefix sum appears at two different indices, then the
 *   elements between them add up to 0.
 * - Keep a running sum and store the first index where each prefix sum
 *   appears in the map.
 * - Initially put (0, -1), so a subarray starting from index 0 with sum 0
 *   is also handled.
 * - If the current sum is already in the map, the subarray from
 *   map.get(sum) + 1 to i has sum 0, so update the maximum length with
 *   i - map.get(sum).
 * - If the sum is not in the map, store its first index. We never update it
 *   later, because the earliest index gives the longest subarray.
 */

public class LargestSubarrayWith0Sum {
    public static int maxLen(int arr[]) {
        // Store (prefixSum -> first occurrence index)
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxLen = 0;

        // Put (0, -1) to handle the case where a subarray
        // starting from index 0 has a sum of 0
        map.put(0, -1);

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (map.containsKey(sum)) {
                // The sum has been seen before; the subarray between
                // map.get(sum) + 1 and i has a sum of 0
                maxLen = Math.max(maxLen, i - map.get(sum));
            } else {
                // Store the first time this prefix sum appears
                map.put(sum, i);
            }
        }
        return maxLen;
    }

    // Driver code: sample input values to test the solution
    public static void main(String[] args) {
        int[] arr = {15, -2, 2, -8, 1, 7, 10, 23};

        int result = maxLen(arr);

        System.out.println(result);
    }
}

/*
GFG Problem => Largest subarray with 0 sum (not a LeetCode problem)
Time Complexity => O(N)
Space Complexity => O(N)

Output:
5


Companies that asked this question:
Amazon, Ola, PayU
*/