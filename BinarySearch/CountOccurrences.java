package BinarySearch;

/*
 * Problem Statement:
 * Given a sorted array arr[] and a number x, count the number of occurrences (frequency)
 * of x in the array. If x is not present in the array, return 0.
 *
 * Example:
 * Input: nums =, target = 2
 * Output: 4
 * Explanation: 2 appears 4 times in the given array.
 *
 * Approach: Binary Search (Using First and Last Occurrences)
 * - Find the first occurrence of the target using a modified binary search (findFirst).
 * - If the target is not found (first == -1), return 0 immediately.
 * - Otherwise, find the last occurrence of the target using another binary search (findLast).
 * - The total frequency will be (last - first + 1).
 */

public class CountOccurrences {
    public static int countFreq(int[] nums, int target) {
        int first = findFirst(nums, target);
        if (first == -1) return 0;
        int last = findLast(nums, target);
        return last - first + 1;
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
        int[] nums = {1, 1, 2, 2, 2, 2, 3};
        int target = 2;

        int result = countFreq(nums, target);

        System.out.println(result);
    }
}

/*
GFG Problem => Count Occurrences in Sorted Array
Time Complexity => O(log N)
Space Complexity => O(1)

Output:
4


Companies that asked this question:
Amazon, Google, Microsoft, Adobe
*/

