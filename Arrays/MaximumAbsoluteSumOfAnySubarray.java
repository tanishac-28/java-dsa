package Arrays;

/*
 * Problem Statement:
 * You are given an integer array nums. The absolute sum of a subarray
 * [nums[l], nums[l+1], ..., nums[r]] is abs(nums[l] + nums[l+1] + ... +
 * nums[r]).
 * Return the maximum absolute sum of any (possibly empty) subarray of nums.
 *
 * Example:
 * Input: nums = [1, -3, 2, 3, -4]
 * Output: 5
 * Explanation: The subarray [2, 3] has absolute sum = abs(2 + 3) = 5.
 *
 * Approach: Kadane's Algorithm (max and min subarray)
 * - The maximum absolute sum is either the largest positive subarray sum or
 *   the smallest (most negative) subarray sum, taken as an absolute value.
 * - Run Kadane's algorithm for both at the same time:
 *   currmax = maximum subarray sum ending at the current index,
 *   currmin = minimum subarray sum ending at the current index.
 * - Keep track of the overall max and min seen so far.
 * - The answer is the larger of abs(max) and abs(min).
 */

public class MaximumAbsoluteSumOfAnySubarray {
    public static int maxAbsoluteSum(int[] nums) {
        int n = nums.length;
        int max = nums[0], min = nums[0];
        int currmax = nums[0], currmin = nums[0];
        int ans = Math.abs(nums[0]);

        for (int i = 1; i < n; i++) {
            // Maximum subarray sum ending at i
            int temp1 = nums[i] + currmax;
            currmax = Math.max(temp1, nums[i]);
            max = Math.max(max, currmax);

            // Minimum subarray sum ending at i
            int temp2 = nums[i] + currmin;
            currmin = Math.min(nums[i], temp2);
            min = Math.min(min, currmin);

            ans = Math.max(Math.abs(min), Math.abs(max));
        }
        return ans;
    }

    // Driver code: sample input values to test the solution
    public static void main(String[] args) {
        int[] nums = {1, -3, 2, 3, -4};

        int result = maxAbsoluteSum(nums);

        System.out.println(result);
    }
}

/*
LeetCode No => 1749
Time Complexity => O(N)
Space Complexity => O(1)

Output:
5


Companies that asked this question:
Amazon | Google | Apple | Adobe | Microsoft
*/