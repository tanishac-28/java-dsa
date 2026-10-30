package BinarySearch;

/*
 * Problem Statement:
 * Given a sorted array arr[] and a number x, find the ceiling of x in the array.
 * The ceiling of x is the smallest element in the array which is greater than or equal to x.
 * The function should return the index of the ceiling element. If no such element exists, return -1.
 *
 * Example:
 * Input: arr =, x = 9
 * Output: 3
 * Explanation: The smallest element greater than or equal to 9 is 10, and its index is 3.
 *
 * Approach: Binary Search
 * - The array is sorted, so use binary search with low = 0 and high = n - 1.
 * - Keep ans = -1, which is the default answer when no element is greater than or equal to x.
 * - If arr[mid] >= x, mid can be a valid ceiling, so store ans = mid and keep
 *   searching in the left half (high = mid - 1) to find a smaller valid index.
 * - Otherwise arr[mid] < x, so the answer must be on the right side
 *   (low = mid + 1).
 * - When the loop ends, ans holds the index of the ceiling of x.
 */

public class CeilInSortedArray {
    public static int findCeil(int[] arr, int x) {
        int n = arr.length;
        int low = 0;
        int high = n - 1;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] >= x) {
                // Possible answer, try to find a smaller element on the left
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
        int[] arr = {2, 3, 7, 10, 11, 11, 25};
        int x = 9;

        int result = findCeil(arr, x);

        System.out.println(result);
    }
}

/*
GFG Problem => Ceil in a Sorted Array
Time Complexity => O(log N)
Space Complexity => O(1)

Output:
3


Companies that asked this question:
Company list not verified (no company tags found)
*/
