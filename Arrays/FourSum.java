package Arrays;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Problem Statement:
 * Given an array nums of n integers and an integer target, return all the
 * unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
 * - 0 <= a, b, c, d < n
 * - a, b, c, and d are distinct
 * - nums[a] + nums[b] + nums[c] + nums[d] == target
 * You may return the answer in any order.
 *
 * Example:
 * Input: nums = [1, 0, -1, 0, -2, 2], target = 0
 * Output: [[-2, -1, 1, 2], [-2, 0, 0, 2], [-1, 0, 0, 1]]
 *
 * Approach: Sorting + Two Pointers
 * - Sort the array so that duplicates sit together.
 * - Fix the first two numbers using two nested loops (i and j).
 * - Find the remaining two numbers using two pointers (k and l).
 * - If sum < target, move k forward; if sum > target, move l back.
 * - Skip duplicate values for i, j, k and l to avoid repeated quadruplets.
 * - Use long for the sum to avoid integer overflow.
 */
public class FourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < n - 3; i++) {
            // Skip duplicate values for the first number
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < n - 2; j++) {
                // Skip duplicate values for the second number
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int k = j + 1;
                int l = n - 1;

                while (k < l) {
                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];

                    if (sum == target) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));

                        k++;
                        l--;

                        // Skip duplicates on both sides
                        while (k < l && nums[k] == nums[k - 1]) {
                            k++;
                        }
                        while (k < l && nums[l] == nums[l + 1]) {
                            l--;
                        }
                    } else if (sum < target) {
                        k++;
                    } else {
                        l--;
                    }
                }
            }
        }

        return ans;
    }

    // Driver code: sample input values to test the solution
    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;

        List<List<Integer>> result = fourSum(nums, target);

        System.out.println(result);
    }
}

/*
LeetCode No => 18
Time Complexity => O(N^3)
Space Complexity => O(1)  (ignoring the output list, sorting space aside)

Output:
[[-2, -1, 1, 2], [-2, 0, 0, 2], [-1, 0, 0, 1]]


Companies that asked this question:
Amazon, Apple, Adobe, Facebook (Meta)
*/