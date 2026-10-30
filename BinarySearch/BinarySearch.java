package BinarySearch;

/*
 * Problem Statement:
 * Given an array of integers nums which is sorted in ascending order, and an
 * integer target, write a function to search target in nums. If target
 * exists, then return its index. Otherwise, return -1.
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * Example:
 * Input: nums = [-1, 0, 3, 5, 9, 12], target = 9
 * Output: 4
 * Explanation: 9 exists in nums and its index is 4.
 *
 * Approach: Binary Search
 * - The array is sorted, so we can cut the search space in half every step.
 * - Keep two pointers, low = 0 and high = n - 1, and find mid.
 * - If nums[mid] == target, return mid.
 * - If target is greater than nums[mid], the target can only be in the right
 *   half, so move low to mid + 1.
 * - Otherwise the target can only be in the left half, so move high to
 *   mid - 1.
 * - If low becomes greater than high, the target is not present, so
 *   return -1.
 */

public class BinarySearch {
    public static int search(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (target > nums[mid]) {
                // Search in the right half
                low = mid + 1;
            } else {
                // Search in the left half
                high = mid - 1;
            }
        }
        return -1;
    }

    // Driver code: sample input values to test the solution
    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;

        int result = search(nums, target);

        System.out.println(result);
    }
}

/*
LeetCode No => 704
Time Complexity => O(log N)
Space Complexity => O(1)

Output:
4


Companies that asked this question:
Google, Meta, Amazon, Bloomberg, Infosys, Microsoft, Cognizant, Oracle, PureStorage, TCS, and Yandex
*/