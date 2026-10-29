package Arrays;

import java.util.Arrays;

/*
 * Problem Statement:
 * The next permutation of an array of integers is the next lexicographically
 * greater permutation of its integers. If such an arrangement is not
 * possible, the array must be rearranged as the lowest possible order
 * (sorted in ascending order).
 * Given an array of integers nums, find the next permutation of nums.
 * The replacement must be in place and use only constant extra memory.
 *
 * Example:
 * Input: nums = [1, 2, 3]
 * Output: [1, 3, 2]
 * Explanation: Among all permutations of [1, 2, 3], the one that comes right
 * after [1, 2, 3] is [1, 3, 2]. For [3, 2, 1] there is no greater
 * permutation, so the answer would be [1, 2, 3].
 *
 * Approach: Find Pivot + Swap + Reverse
 * - Step 1: From the right, find the first index pivot where
 *   nums[pivot] < nums[pivot + 1]. Everything on the right of pivot is in
 *   descending order. If no pivot exists, the array is the last permutation,
 *   so reverse the whole array and return.
 * - Step 2: From the right, find the first element greater than
 *   nums[pivot] and swap it with nums[pivot]. This is the smallest element
 *   that can replace the pivot to make the number bigger.
 * - Step 3: Reverse the part after pivot, so it becomes ascending (the
 *   smallest possible order), which gives the next permutation.
 */

public class NextPermutation {
    public static void nextPermutation(int[] nums) {
        int n = nums.length;
        int pivot = -1;

        // Step 1: find the pivot (first dip from the right)
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                pivot = i;
                break;
            }
        }

        // Array is in descending order, so it is the last permutation
        if (pivot == -1) {
            reverse(nums, 0, n - 1);
            return;
        }

        // Step 2: swap the pivot with the next greater element on its right
        for (int i = n - 1; i > pivot; i--) {
            if (nums[i] > nums[pivot]) {
                int temp = nums[i];
                nums[i] = nums[pivot];
                nums[pivot] = temp;
                break;
            }
        }

        // Step 3: reverse the part after pivot
        int i = pivot + 1, j = n - 1;
        while (i <= j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    // Driver code: sample input values to test the solution
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};

        nextPermutation(nums);

        System.out.println(Arrays.toString(nums));
    }
}

/*
LeetCode No => 31
Time Complexity => O(N)
Space Complexity => O(1)

Output:
[1, 3, 2]


Companies that asked this question:
Adobe • Amazon • Apple • Bloomberg • ByteDance • eBay • Facebook (Meta) • FactSet • Flipkart • Google • Hike • Houzz • Infosys • JPMorgan Chase • MakeMyTrip • Microsoft • Qualcomm • Quora • Rubrik • Salesforce • Sumo Logic • Uber
*/