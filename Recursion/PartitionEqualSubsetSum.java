package Recursion;

/*
 * Problem Statement:
 * Given an integer array nums, return true if you can partition the array
 * into two subsets such that the sum of the elements in both subsets is
 * equal, or false otherwise.
 *
 * Example:
 * Input: nums = [1, 5, 11, 5]
 * Output: true
 * Explanation: The array can be partitioned as [1, 5, 5] and [11], and both
 * subsets have the sum 11.
 * (For nums = [1, 2, 3, 5] the output is false, because the total sum 11 is
 * odd.)
 


 * Approach: Subset Sum (0/1 Knapsack) with a 1D DP array
 * - Two subsets with equal sum are possible only if the total sum is even.
 *   If it is odd, return false.
 * - Then the problem becomes: is there a subset whose sum is
 *   target = totalSum / 2? (The remaining elements automatically make the
 *   other subset with the same sum.)
 * - dp[i] = true means a subset with sum i can be made using the elements
 *   seen so far. dp[0] = true, because an empty subset has sum 0.
 * - For every number, update dp from target down to num:
 *   dp[i] = dp[i] || dp[i - num].
 * - The loop goes backwards, so the same number is not used twice in one
 *   round (each element can be used only once).
 * - If dp[target] becomes true at any time, return true early.
 */

public class PartitionEqualSubsetSum {
    public static boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        // If the total sum is odd, it cannot be partitioned into two equal subsets
        if (totalSum % 2 != 0) {
            return false;
        }

        int target = totalSum / 2;
        boolean[] dp = new boolean[target + 1];

        dp[0] = true;

        for (int num : nums) {
            // Go backwards, so every number is used at most once
            for (int i = target; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }

            if (dp[target]) {
                return true;
            }
        }

        return dp[target];
    }

    // Driver code: sample input values to test the solution
    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};

        boolean result = canPartition(nums);

        System.out.println(result);
    }
}

/*
LeetCode No => 416
Time Complexity => O(N * Sum)  (Sum = totalSum / 2)
Space Complexity => O(Sum)

Output:
true


Companies that asked this question:
Amazon, Google, Facebook (Meta), Microsoft
*/