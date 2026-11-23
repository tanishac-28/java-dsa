package Recursion;

import java.util.ArrayList;
import java.util.List;

/*
 * Problem Statement:
 * Given an integer array nums of unique elements, return all possible
 * subsets (the power set).
 * The solution set must not contain duplicate subsets. Return the solution
 * in any order.
 *
 * Example:
 * Input: nums = [1, 2, 3]
 * Output: [[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3]]
 * Explanation: An array of 3 elements has 2^3 = 8 subsets, from the empty
 * subset to the full array.
 *
 * Approach: Backtracking (Choose, Explore, Undo)
 * - Keep a temporary list (temp) which holds the current subset.
 * - At every call, the current temp is itself a valid subset, so store a
 *   copy of it in the result.
 * - Then try to add every element from index start to the end: choose the
 *   element, recurse with i + 1 (so an element is never reused and no
 *   duplicate subset is made), and then undo the choice by removing the
 *   last element.
 * - A copy of temp is stored (new ArrayList<>(temp)), because temp keeps
 *   changing during the recursion.
 */

public class Subsets {
    public static List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    public static void backtrack(List<List<Integer>> result, List<Integer> temp, int[] nums, int start) {

        // Store current subset
        result.add(new ArrayList<>(temp));

        for (int i = start; i < nums.length; i++) {

            // Choose
            temp.add(nums[i]);
            backtrack(result, temp, nums, i + 1);

            // Undo
            temp.remove(temp.size() - 1);
        }
    }

    // Driver code: sample input values to test the solution
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};

        List<List<Integer>> result = subsets(nums);

        System.out.println(result);
    }
}

/*
LeetCode No => 78
Time Complexity => O(N * 2^N)
Space Complexity => O(N)  (recursion stack, output not counted)

Output:
[[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3]]


Companies that asked this question:
Facebook (Meta), Amazon, Google, Microsoft, Apple, DocuSign, BloomBerg
*/