package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Problem Statement:
 * Given an integer array nums that may contain duplicates, return all
 * possible subsets (the power set).
 * The solution set must not contain duplicate subsets. Return the solution
 * in any order.
 *
 * Example:
 * Input: nums = [1, 2, 2]
 * Output: [[], [1], [1, 2], [1, 2, 2], [2], [2, 2]]
 * Explanation: Without handling duplicates, [1, 2] and [2] would be created
 * twice. Each distinct subset must appear only once.
 *
 * Approach: Sort + Backtracking (skip duplicates at the same level)
 * - Sort the array first, so equal elements come next to each other.
 * - Use the same backtracking as the Subsets problem: store a copy of the
 *   current subset in the result, then choose an element, recurse with
 *   i + 1, and undo the choice.
 * - To avoid duplicate subsets, skip an element if it is equal to the
 *   previous element and it is not the first choice at this level
 *   (i > start && nums[i] == nums[i - 1]).
 * - This means a repeated value can be used only after its earlier copy is
 *   already in the current subset, and never as a fresh choice at the same
 *   position again.
 */

public class SubsetsII {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        // Sort, so duplicates come together
        Arrays.sort(nums);
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    public static void backtrack(List<List<Integer>> result, List<Integer> temp, int[] nums, int start) {

        // Store current subset
        result.add(new ArrayList<>(temp));

        for (int i = start; i < nums.length; i++) {

            // Skip duplicates at the same level
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            // Choose
            temp.add(nums[i]);
            backtrack(result, temp, nums, i + 1);

            // Undo
            temp.remove(temp.size() - 1);
        }
    }

    // Driver code: sample input values to test the solution
    public static void main(String[] args) {
        int[] nums = {1, 2, 2};

        List<List<Integer>> result = subsetsWithDup(nums);

        System.out.println(result);
    }
}

/*
LeetCode No => 90
Time Complexity => O(N * 2^N)
Space Complexity => O(N)  (recursion stack, output not counted)

Output:
[[], [1], [1, 2], [1, 2, 2], [2], [2, 2]]


Companies that asked this question:
Apple, Facebook (Meta), Amazon, Google
*/