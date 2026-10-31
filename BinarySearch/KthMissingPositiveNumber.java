package BinarySearch;

/*
 * Problem Statement:
 * Given an array arr of positive integers sorted in a strictly increasing
 * order, and an integer k, return the k-th positive integer that is missing
 * from this array.
 *
 * Example:
 * Input: arr = [2, 3, 4, 7, 11], k = 5
 * Output: 9
 * Explanation: The missing positive integers are [1, 5, 6, 8, 9, 10, 12,
 * 13, ...]. The 5th missing positive integer is 9.
 *
 * Approach: Binary Search on the count of missing numbers
 * - If no number was missing, nums[i] would be equal to i + 1. So the count
 *   of missing numbers before index mid is nums[mid] - (mid + 1).
 *   This count never decreases as the index increases, so it is sorted.
 * - If the missing count at mid is less than k, the k-th missing number lies
 *   further to the right, so low = mid + 1.
 * - Otherwise, enough numbers are already missing by this index, so the
 *   k-th missing number lies on the left, so high = mid - 1.
 * - When the loop ends, low is the number of array elements that appear
 *   before the k-th missing number. So the answer is low + k (the k missing
 *   numbers plus the low elements of the array which are before it).
 */

public class KthMissingPositiveNumber {
    public static int findKthPositive(int[] nums, int k) {
        int n = nums.length;
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Count of missing numbers before nums[mid]
            int missingNum = nums[mid] - (mid + 1);

            if (missingNum < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low + k;
    }

    // Driver code: sample input values to test the solution
    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 7, 11};
        int k = 5;

        int result = findKthPositive(nums, k);

        System.out.println(result);
    }
}

/*

LeetCode No => 1539
Time Complexity => O(log N)
Space Complexity => O(1)

Output:
9


Companies that asked this question:
Meta (Facebook) • Google • Apple • Amazon • Microsoft • Bloomberg • Adobe
*/