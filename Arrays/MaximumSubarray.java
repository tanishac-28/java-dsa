package Arrays;

/*
 * Problem Statement:
 * Given an integer array nums, find the subarray with the largest sum, and
 * return its sum.
 *
 * Example:
 * Input: nums = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
 * Output: 6
 * Explanation: The subarray [4, -1, 2, 1] has the largest sum 6.
 *
 * Approach: Kadane's Algorithm
 * - Keep a running sum of the current subarray.
 * - At every index add nums[i] to sum, then update the maximum sum so far.
 * - If sum becomes negative, it can only reduce the sum of any future
 *   subarray, so reset sum to 0 and start a fresh subarray from the next
 *   element.
 * - Initialize max with nums[0], so the answer is correct even when all the
 *   elements are negative (answer is the largest single element).
 */

public class MaximumSubarray {
    public static int maxSubArray(int[] nums) {

        int n = nums.length;
        int max = nums[0];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];

            max = Math.max(sum, max);

            // Negative sum will only hurt the next subarray, so reset it
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }

    // Driver code: sample input values to test the solution
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        int result = maxSubArray(nums);

        System.out.println(result);
    }
}

/*
LeetCode No => 53
Time Complexity => O(N)
Space Complexity => O(1)

Output:
6


Companies that asked this question:
Apple, Amazon, Google, Goldman Sachs, Microsoft, Oracle, Cisco, Meta (Facebook), NVIDIA, Accenture, Visa, TikTok, Yandex, Infosys, Bloomberg, IBM, Upstart, TCS, LinkedIn, Adobe, Alibaba, Asana, Atlassian, ByteDance, Capital One, Citadel, eBay, Evernote, Expedia, Intel, JPMorgan Chase, Morgan Stanley, Palantir Technologies, PayPal, Salesforce, SAP, Two Sigma, Uber, Walmart Labs, Wayfair, Yahoo, Zillow.
 */