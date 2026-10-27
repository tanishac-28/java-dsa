
package Arrays;

/*
 * Problem Statement:
 * Given an array of positive integers nums and a positive integer target,
 * return the minimal length of a subarray whose sum is greater than or
 * equal to target. If there is no such subarray, return 0 instead.
 *
 * Example:
 * Input: target = 7, nums = [2, 3, 1, 2, 4, 3]
 * Output: 2
 * Explanation: The subarray [4, 3] has the minimal length under the
 * problem constraint.
 *
 * Approach: Sliding Window (variable size)
 * - Expand the window by moving right and adding nums[right] to the sum.
 * - While the sum is >= target, the window is valid: update the minimum
 *   length, then shrink the window from the left to look for a smaller one.
 * - If no valid window was ever found, return 0.
 * - This works because all numbers are positive, so removing an element
 *   from the left always decreases the sum.
 */
public class MinimumSizeSubarraySum {
    public static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int left = 0;
        int min = Integer.MAX_VALUE;
        int sum = 0;

        for (int right = 0; right < n; right++) {
            sum = sum + nums[right];

            // Shrink the window while it is still valid
            while (sum >= target) {
                int length = right - left + 1;
                min = Math.min(length, min);

                sum = sum - nums[left];
                left++;
            }
        }

        // No valid subarray found
        if (min == Integer.MAX_VALUE) {
            return 0;
        }

        return min;
    }

    // Driver code: sample input values to test the solution
    public static void main(String[] args) {
        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};

        int result = minSubArrayLen(target, nums);

        System.out.println(result);
    }
}

/*
LeetCode No => 209
Time Complexity => O(N)
Space Complexity => O(1)

Output:
2


Companies that asked this question:
Amazon, Apple, Bloomberg, ByteDance, Facebook (Meta), Google, Microsoft, and Accolite
*/