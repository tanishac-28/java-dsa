package Arrays;

/*
 * Problem Statement:
 * Given a binary array nums and an integer k, return the maximum number of
 * consecutive 1's in the array if you can flip at most k 0's.
 *
 * Example:
 * Input: nums = [1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0], k = 2
 * Output: 6
 * Explanation: [1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1]
 * The numbers at index 5 and 10 are flipped from 0 to 1, so the longest
 * subarray of 1s has length 6.
 *
 * Approach: Sliding Window (variable size)
 * - Find the longest window that contains at most k zeros, because every
 *   zero inside it can be flipped to 1.
 * - Expand the window by moving right and count the zeros in it.
 * - If the zeros exceed k, shrink the window from the left until the zero
 *   count is back to k (reduce the count when a 0 leaves the window).
 * - After every step, update the maximum window length.
 */

public class MaxConsecutiveOnesIII {
    public static int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int left = 0;
        int zero = 0;
        int max = 0;

        for (int right = 0; right < n; right++) {
            if (nums[right] == 0) {
                zero++;
            }

            // Too many zeros, shrink the window from the left
            while (zero > k) {
                if (nums[left] == 0) {
                    zero--;
                }
                left++;
            }

            int length = right - left + 1;
            max = Math.max(length, max);
        }

        return max;
    }

    // Driver code: sample input values to test the solution
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;

        int result = longestOnes(nums, k);

        System.out.println(result);
    }
}

/*
LeetCode No => 1004
Time Complexity => O(N)
Space Complexity => O(1)

Output:
6


Companies that asked this question:
Amazon, Facebook (Meta), Microsoft, Yandex, LinkedIn, Google, Sigmoid, Roku, Snap, Walmart, Expedia, Salesforce
*/