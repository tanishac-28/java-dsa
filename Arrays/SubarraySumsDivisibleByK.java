package Arrays;

import java.util.HashMap;

/*
 * Problem Statement:
 * Given an integer array nums and an integer k, return the number of
 * non-empty subarrays that have a sum divisible by k.
 * A subarray is a contiguous part of an array.
 *
 * Example:
 * Input: nums = [4, 5, 0, -2, -3, 1], k = 5
 * Output: 7
 * Explanation: There are 7 subarrays with a sum divisible by k = 5:
 * [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3],
 * [-2, -3]
 *
 * Approach: Prefix Sum Remainder + HashMap
 * - If two prefix sums have the same remainder when divided by k, then the
 *   subarray between them has a sum divisible by k.
 * - Keep a running sum and find rem = sum % k at every index.
 * - The map stores how many times each remainder has appeared so far.
 *   Initially put (0, 1), because an empty prefix has remainder 0.
 * - For every index, add map.get(rem) to count, because each earlier prefix
 *   with the same remainder gives one valid subarray ending at this index.
 * - Then increase the frequency of rem in the map.
 * - Negative sums can give a negative remainder in Java, so we convert it
 *   to a positive remainder using ((sum % k) + k) % k.
 */

public class SubarraySumsDivisibleByK {
    public static int subarraysDivByK(int[] nums, int k) {
        int sum = 0;
        int n = nums.length;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int i = 0; i < n; i++) {
            sum = sum + nums[i];

            // Make the remainder positive (sum can be negative)
            int rem = ((sum % k) + k) % k;

            // Earlier prefixes with the same remainder
            if (map.containsKey(rem)) {
                count = count + map.get(rem);
            }
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }
        return count;
    }

    // Driver code: sample input values to test the solution
    public static void main(String[] args) {
        int[] nums = {4, 5, 0, -2, -3, 1};
        int k = 5;

        int result = subarraysDivByK(nums, k);

        System.out.println(result);
    }
}

/*
LeetCode No => 974
Time Complexity => O(N)
Space Complexity => O(K)

Output:
7


Companies that asked this question:
Amazon , Google , Microsoft, Meta, Goldman Sachs, Expedia, Twilio, Yandex.
*/