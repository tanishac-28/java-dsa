package Arrays;

import java.util.Arrays;

/*
 * Problem Statement:
 * You are given a 0-indexed integer array nums of even length consisting of
 * an equal number of positive and negative integers.
 * Rearrange the elements of nums such that:
 * 1. Every consecutive pair of integers have opposite signs.
 * 2. For all integers with the same sign, the order in which they were
 *    present in nums is preserved.
 * 3. The rearranged array begins with a positive integer.
 * Return the modified array after rearranging the elements.
 *
 * Example:
 * Input: nums = [3, 1, -2, -5, 2, -4]
 * Output: [3, -2, 1, -5, 2, -4]
 * Explanation: The positive integers are [3, 1, 2] and the negative integers
 * are [-2, -5, -4]. Placing them alternately, starting with a positive one,
 * gives [3, -2, 1, -5, 2, -4].
 *
 * Approach: Two Pointers (fill by index)
 * - The answer must start with a positive number, so all positive numbers go
 *   to the even indices (0, 2, 4, ...) and all negative numbers go to the
 *   odd indices (1, 3, 5, ...).
 * - Keep two pointers: posi starting at 0 and nege starting at 1.
 * - Traverse nums from left to right. If the number is positive, put it at
 *   ans[posi] and move posi by 2. Otherwise put it at ans[nege] and move
 *   nege by 2.
 * - Since we traverse from left to right, the relative order of positive
 *   numbers and of negative numbers is preserved.
 */

public class RearrangeArrayElementsBySign {
    public static int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int posi = 0;
        int nege = 1;

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                // Positive numbers go to the even indices
                ans[posi] = nums[i];
                posi += 2;
            } else {
                // Negative numbers go to the odd indices
                ans[nege] = nums[i];
                nege += 2;
            }
        }
        return ans;
    }

    // Driver code: sample input values to test the solution
    public static void main(String[] args) {
        int[] nums = {3, 1, -2, -5, 2, -4};

        int[] result = rearrangeArray(nums);

        System.out.println(Arrays.toString(result));
    }
}

/*
LeetCode No => 2149
Time Complexity => O(N)
Space Complexity => O(N)  (extra array for the answer)

Output:
[3, -2, 1, -5, 2, -4]


Companies that asked this question:
Tesla | Amazon | Adobe | Microsoft | Meta | Google | Apple | Qualcomm
*/