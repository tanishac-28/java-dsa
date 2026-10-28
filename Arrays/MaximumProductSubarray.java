package Arrays;

/*
 * Problem Statement:
 * Given an integer array nums, find a subarray that has the largest product,
 * and return the product.
 *
 * Example:
 * Input: nums = [2, 3, -2, 4]
 * Output: 6
 * Explanation: [2, 3] has the largest product 6.
 *
 * Approach: Prefix Product + Suffix Product
 * - The maximum product subarray is always either a prefix or a suffix of
 *   the parts of the array that are separated by zeros.
 * - Move i from the left and, at the same time, from the right (n - i - 1),
 *   keeping a prefix product (pref) and a suffix product (suff).
 * - If a product becomes 0 (because of a zero element), reset it to 1, so a
 *   new subarray starts after that zero.
 * - If there are an even number of negatives, the whole part gives the
 *   answer. If odd, removing the first negative (suffix side) or the last
 *   negative (prefix side) gives the best product, and one of the two
 *   products always covers it.
 * - After every step, update the answer with the maximum of pref and suff.
 */

public class MaximumProductSubarray {
    public static int maxProduct(int[] nums) {
        int n = nums.length;
        int pref = 1;
        int suff = 1;
        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            // A zero in between breaks the subarray, so start fresh
            if (pref == 0) {
                pref = 1;
            }
            if (suff == 0) {
                suff = 1;
            }

            pref = pref * nums[i];
            suff = suff * nums[n - i - 1];

            ans = Math.max(ans, Math.max(pref, suff));
        }
        return ans;
    }

    // Driver code: sample input values to test the solution
    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};

        int result = maxProduct(nums);

        System.out.println(result);
    }
}

/*
LeetCode No => 152
Time Complexity => O(N)
Space Complexity => O(1)

Output:
6


Companies that asked this question:
Amazon, Google, Microsoft, Meta (Facebook), Apple, Uber, LinkedIn, Adobe, Bloomberg, Oracle, Morgan Stanley, D-E-Shaw, Goldman Sachs, Flipkart, Walmart Labs, OYO Rooms, NPCI, Akuna Capital, DRW
*/