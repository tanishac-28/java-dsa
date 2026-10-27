package Arrays;

/*
 * Problem Statement:
 * Given an array of positive integers nums and an integer k, return the number
 * of contiguous subarrays where the product of all the elements in the
 * subarray is strictly less than k.
 *
 * Example:
 * Input: nums = [10, 5, 2, 6], k = 100
 * Output: 8
 * Explanation: The 8 subarrays that have product less than 100 are:
 * [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
 * Note that [10, 5, 2] is not included as the product is 100, which is not
 * strictly less than k.
 *
 * Approach: Sliding Window (variable size)
 * - Keep a window [left, right] whose product is always less than k.
 * - Expand the window by moving right and multiply nums[right] into product.
 * - If product becomes >= k, shrink the window from the left by dividing
 *   product by nums[left] until product is less than k again.
 * - For every right, all subarrays ending at right and starting anywhere
 *   from left to right are valid, so we add the window length
 *   (right - left + 1) to the count.
 * - Edge case: if k <= 1, no subarray can have product less than k
 *   (all elements are positive, so min product is 1), so return 0.
 */

public class SubarrayProductLessThanK {
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        // Product of positive numbers can never be less than 1
        if (k <= 1) {
            return 0;
        }

        int count = 0;
        int n = nums.length;
        int left = 0;
        int product = 1;

        for (int right = 0; right < n; right++) {
            product = product * nums[right];

            // Product too big, shrink the window from the left
            while (product >= k) {
                product = product / nums[left];
                left++;
            }

            // Number of valid subarrays ending at index right
            int length = right - left + 1;
            count = count + length;
        }

        return count;
    }

    // Driver code: sample input values to test the solution
    public static void main(String[] args) {
        int[] nums = {10, 5, 2, 6};
        int k = 100;

        int result = numSubarrayProductLessThanK(nums, k);

        System.out.println(result);
    }
}

/*
LeetCode No => 713
Time Complexity => O(N)
Space Complexity => O(1)

Output:
8


Companies that asked this question:
Amazon, Google, Facebook (Meta), Microsoft, Apple, Bloomberg, Adobe, Uber
*/