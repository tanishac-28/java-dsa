package BinarySearch;

/*
 * Problem Statement:
 * Given an array of integers nums sorted in non-decreasing order, find the starting
 * and ending position of a given target value.
 * If target is not found in the array, return [-1, -1].
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * Example:
 * Input: nums =, target = 8
 * Output: [3, 4]
 * Explanation: The first occurrence of 8 is at index 3, and the last occurrence is at index 4.
 *
 * Approach: Binary Search (Two Passes)
 * - Use two separate binary search helper functions: findFirst and findLast.
 * - In findFirst: When nums[mid] == target, it could be the first position, so store ans = mid 
 *   and keep searching in the left half (high = mid - 1) to look for an even earlier index.
 * - In findLast: When nums[mid] == target, it could be the last position, so store ans = mid 
 *   and keep searching in the right half (low = mid + 1) to look for a later index.
 * - Combine both results into a size-2 array and return.
 */

public class FirstAndLastPosition {
    public static int[] searchRange(int[] nums, int target) {
        int first = findFirst(nums, target);
        int last = findLast(nums, target);
        return new int[]{first, last};
    }

    private static int findFirst(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                ans = mid;
                high = mid - 1; // Look for smaller index on the left
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    private static int findLast(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                ans = mid;
                low = mid + 1; // Look for larger index on the right
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    // Driver code: sample input values to test the solution
    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;

        int[] result = searchRange(nums, target);

        System.out.println("[" + result[0] + ", " + result[1] + "]");
    }
}

/*
LeetCode Problem => 34. Find First and Last Position of Element in Sorted Array
Time Complexity => O(log N)
Space Complexity => O(1)

Output:
[3, 4]


Companies that asked this question:
Google, Amazon, Microsoft, Adobe, Facebook
*/
