package Arrays;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Problem Statement:
 * Given an integer array nums, return all the triplets
 * [nums[i], nums[j], nums[k]] such that i != j, i != k, j != k, and
 * nums[i] + nums[j] + nums[k] == 0.
 *
 * Notes:
 * - The solution set must not contain duplicate triplets.
 *
 * Example:
 * Input: nums = [-1, 0, 1, 2, -1, -4]
 * Output: [[-1, -1, 2], [-1, 0, 1]]
 *
 * Approach: Sorting + Two Pointers
 * - Sort the array so that duplicates sit together and two pointers work.
 * - Fix one number nums[i], then find a pair in the rest of the array
 *   whose sum is -nums[i] using left and right pointers.
 * - If sum > 0, move right back; if sum < 0, move left forward.
 * - Skip duplicate values for i, left and right to avoid repeated triplets.
 */
public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        int n = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < n - 2; i++) {
            // Skip duplicate values for the fixed number
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = nums[i] + nums[right] + nums[left];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[right], nums[left]));

                    // Skip duplicates on both sides
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return result;
    }

    // Driver code: sample input values to test the solution
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};

        List<List<Integer>> result = threeSum(nums);

        System.out.println(result);
    }
}

/*
LeetCode No => 15
Time Complexity => O(N^2)
Space Complexity => O(1)  (ignoring the output list, sorting space aside)


Companies that asked this question:
Google, Amazon, Microsoft, Facebook (Meta), Apple, Adobe, Bloomberg
*/