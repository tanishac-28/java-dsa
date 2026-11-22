package Recursion;

import java.util.Arrays;

/*
 * Problem Statement:
 * You are given an array of integers nums and an integer target.
 * Return the number of non-empty subsequences of nums such that the sum of
 * the minimum and maximum element on it is less than or equal to target.
 * Since the answer may be too large, return it modulo 10^9 + 7.
 *
 * Example:
 * Input: nums = [3, 5, 6, 7], target = 9
 * Output: 4
 * Explanation: The 4 valid subsequences are [3], [3, 5], [3, 6] and
 * [3, 5, 6]. For example, [3, 6] has min + max = 3 + 6 = 9 <= 9.
 *
 * Approach: Sort + Two Pointers + Powers of 2
 * - A subsequence does not depend on the order of elements, and we only care
 *   about its minimum and maximum. So sort the array, then the minimum and
 *   maximum of a subsequence are at its boundaries.
 * - Use two pointers, left (as the minimum) and right (as the maximum).
 * - If nums[left] + nums[right] <= target, then nums[left] is the minimum,
 *   and every subset of the elements between left + 1 and right can be added
 *   with it. That gives 2^(right - left) valid subsequences. Add it to the
 *   result and move left ahead.
 * - Otherwise the sum is too large, so reduce the maximum (right--).
 * - Precompute the powers of 2 modulo 10^9 + 7 in advance, so every power is
 *   found in O(1) and there is no overflow.
 */

public class NumberOfSubsequencesThatSatisfyTheGivenSumCondition {
    public static int numSubseq(int[] nums, int target) {
        int MOD = 1_000_000_007;
        int n = nums.length;

        // 1. Sort the array so min and max are at the boundaries
        Arrays.sort(nums);

        // 2. Precompute powers of 2 modulo 10^9 + 7
        int[] pow2 = new int[n];
        pow2[0] = 1;
        for (int i = 1; i < n; i++) {
            pow2[i] = (pow2[i - 1] * 2) % MOD;
        }

        int left = 0;
        int right = n - 1;
        int result = 0;

        // 3. Use two pointers to count valid subsequences
        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                // nums[left] is the min; any subset of elements from (left + 1) to right is valid
                result = (result + pow2[right - left]) % MOD;
                left++;
            } else {
                // Sum is too large, decrease the maximum element
                right--;
            }
        }

        return result;
    }

    // Driver code: sample input values to test the solution
    public static void main(String[] args) {
        int[] nums = {3, 5, 6, 7};
        int target = 9;

        int result = numSubseq(nums, target);

        System.out.println(result);
    }
}

/*
LeetCode No => 1498
Time Complexity => O(N log N)
Space Complexity => O(N)

Output:
4


Companies that asked this question:
Company list not verified (premium tag)
*/