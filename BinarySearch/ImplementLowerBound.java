package BinarySearch;

/*
 * Problem Statement:
 * Given a sorted array arr[] and a number x, find the lower bound of x in
 * the array. The lower bound of a number is the smallest index in the sorted
 * array where the element is greater than or equal to x.
 * Note: If all the elements in the array are smaller than x, the lower bound
 * will be the length of the array.
 *
 * Example:
 * Input: arr = [2, 3, 7, 10, 11, 11, 25], x = 9
 * Output: 3
 * Explanation: The first element which is greater than or equal to 9 is 10,
 * and its index is 3.
 *
 * Approach: Binary Search
 * - The array is sorted, so use binary search with low = 0 and high = n - 1.
 * - Keep ans = n, which is the answer when every element is smaller than x.
 * - If nums[mid] >= x, mid can be the answer, so store ans = mid and keep
 *   searching in the left half (high = mid - 1) for a smaller index.
 * - Otherwise nums[mid] < x, so the answer must be on the right side
 *   (low = mid + 1).
 * - When the loop ends, ans holds the smallest index with nums[index] >= x.
 */

public class ImplementLowerBound {
    public static int lowerBound(int[] nums, int x) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        int ans = n;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] >= x) {
                // Possible answer, try to find a smaller index on the left
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    // Driver code: sample input values to test the solution
    public static void main(String[] args) {
        int[] nums = {2, 3, 7, 10, 11, 11, 25};
        int x = 9;

        int result = lowerBound(nums, x);

        System.out.println(result);
    }
}

/*
GFG Problem => Implement Lower Bound (not a LeetCode problem)
Time Complexity => O(log N)
Space Complexity => O(1)

Output:
3


Companies that asked this question:
Company list not verified (no company tags found)
*/