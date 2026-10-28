package Arrays;

import java.util.Arrays;

/*
 * Problem Statement:
 * Given an integer array nums, return an array answer such that answer[i] is
 * equal to the product of all the elements of nums except nums[i].
 * The product of any prefix or suffix of nums is guaranteed to fit in a
 * 32-bit integer.
 * You must write an algorithm that runs in O(n) time and without using the
 * division operation.
 *
 * Example:
 * Input: nums = [1, 2, 3, 4]
 * Output: [24, 12, 8, 6]
 *
 * Approach: Prefix Product + Suffix Product (without extra arrays)
 * - For every index i, answer[i] = (product of all elements on the left of i)
 *   * (product of all elements on the right of i).
 * - First pass (left to right): store the product of all left elements in
 *   ans[i]. ans[0] is 1 because nothing is on its left.
 * - Second pass (right to left): keep a running variable right, which holds
 *   the product of all elements on the right of j, and multiply it into
 *   ans[j].
 * - This way we do not use division and no extra prefix/suffix arrays are
 *   needed, only the answer array.
 */

public class ProductOfArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        ans[0] = 1;

        // ans[i] = product of all elements on the left of i
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }

        // Multiply with the product of all elements on the right of j
        int right = 1;
        for (int j = n - 2; j >= 0; j--) {
            right = right * nums[j + 1];
            ans[j] = ans[j] * right;
        }
        return ans;
    }

    // Driver code: sample input values to test the solution
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};

        int[] result = productExceptSelf(nums);

        System.out.println(Arrays.toString(result));
    }
}

/*
LeetCode No => 238
Time Complexity => O(N)
Space Complexity => O(1)  (output array is not counted as extra space)

Output:
[24, 12, 8, 6]


Companies that asked this question:
Amazon , Microsoft , Facebook (Meta) , Google , Apple , Uber , Bloomberg , Lyft , Goldman Sachs , Twitter (X) , TikTok , Adobe , IBM
*/