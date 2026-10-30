package BinarySearch;

/*
 * Problem Statement:
 * Given a sorted array of distinct integers and a target value, return the
 * index if the target is found. If not, return the index where it would be
 * if it were inserted in order.
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * Example:
 * Input: nums = [1, 3, 5, 6], target = 2
 * Output: 1
 * Explanation: 2 is not in the array, and it should be inserted at index 1
 * to keep the array sorted: [1, 2, 3, 5, 6].
 * (For target = 5 the output is 2, because 5 is found at index 2.)
 *
 * Approach: Binary Search
 * - The array is sorted, so use binary search with low = 0 and high = n - 1.
 * - Find mid as low + (high - low) / 2, which avoids integer overflow.
 * - If nums[mid] == target, return mid.
 * - If nums[mid] < target, search in the right half (low = mid + 1).
 * - Otherwise search in the left half (high = mid - 1).
 * - If the target is not found, the loop ends when low > high, and low is
 *   exactly the position where the target should be inserted (the first
 *   index whose element is greater than the target), so return low.
 */

public class SearchInsertPosition {
    public static int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            // Safe way to find mid (avoids overflow)
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        // Target not found, low is the insert position
        return low;
    }

    // Driver code: sample input values to test the solution
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 2;

        int result = searchInsert(nums, target);

        System.out.println(result);
    }
}

/*
LeetCode No => 35
Time Complexity => O(log N)
Space Complexity => O(1)

Output:
1


Companies that asked this question:
Amazon, Google, Microsoft, Apple, Adobe, Bloomberg, Meta, Uber, Palantir, Lyft, SAP, Goldman Sachs, Freshworks, and Tekion
*/