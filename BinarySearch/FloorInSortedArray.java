package BinarySearch;

/*
 * Problem Statement:
 * Given a sorted array arr[] and a number x, find the floor of x in the array.
 * The floor of x is the largest element in the array which is smaller than or equal to x.
 * The function should return the index of the floor element. If no such element exists, return -1.
 *
 * Example:
 * Input: arr =, x = 9
 * Output: 2
 * Explanation: The largest element smaller than or equal to 9 is 7, and its index is 2.
 *
 * Approach: Binary Search
 * - The array is sorted, so use binary search with low = 0 and high = n - 1.
 * - Keep ans = -1, which is the default answer when no element is smaller than or equal to x.
 * - If nums[mid] <= x, mid can be a valid floor, so store ans = mid and keep
 *   searching in the right half (low = mid + 1) to find a larger valid element.
 * - Otherwise nums[mid] > x, so the answer must be on the left side
 *   (high = mid - 1).
 * - When the loop ends, ans holds the index of the floor of x.
 */

public class FloorInSortedArray {
    public static int findFloor(int[] nums, int x) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] <= x) {
                // Possible answer, try to find a larger element on the right
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    // Driver code: sample input values to test the solution
    public static void main(String[] args) {
        int[] nums = {2, 3, 7, 10, 11, 11, 25};
        int x = 9;

        int result = findFloor(nums, x);

        System.out.println(result);
    }
}

/*
GFG Problem => Floor in a Sorted Array
Time Complexity => O(log N)
Space Complexity => O(1)

Output:
2


Companies that asked this question:
Company list not verified (no company tags found)
*/
