package BinarySearch;

/*
 * Problem Statement:
 * Given a 2D binary array arr[][] with only 1s and 0s, where each row is
 * sorted in non-decreasing order, find the 0-based index of the first row
 * that has the maximum number of 1's.
 * If no such row exists (no row has a 1), return -1.
 *
 * Example:
 * Input: arr = [[0, 1, 1, 1],
 *               [0, 0, 1, 1],
 *               [1, 1, 1, 1],
 *               [0, 0, 0, 0]]
 * Output: 2
 * Explanation: Row 2 has four 1's, which is the maximum.
 *
 * Approach: Binary Search in every row
 * - Every row is sorted (all 0s first, then all 1s), so the number of 1s in
 *   a row = (number of columns) - (index of the first 1 in that row).
 * - For every row, binary search for the first index having 1. Keep
 *   firstOne = number of columns as the default, which means the row has
 *   no 1.
 * - If arr[i][mid] == 1, store firstOne = mid and search on the left side
 *   for an earlier 1 (high = mid - 1). Otherwise search on the right
 *   (low = mid + 1).
 * - count = columns - firstOne. If count is strictly greater than maxCount,
 *   update maxCount and rowIndex. Using strictly greater keeps the first
 *   row when two rows have the same count.
 * - rowIndex stays -1 when no row has a 1.
 */

public class RowWithMax1s {
    public static int rowWithMax1s(int[][] arr) {
        int n = arr.length;
        int maxCount = 0;
        int rowIndex = -1;

        for (int i = 0; i < n; i++) {

            int low = 0;
            int high = arr[i].length - 1;
            int firstOne = arr[i].length;

            // Find the index of the first 1 in this row
            while (low <= high) {
                int mid = low + (high - low) / 2;

                if (arr[i][mid] == 1) {
                    firstOne = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            int count = arr[i].length - firstOne;

            if (count > maxCount) {
                maxCount = count;
                rowIndex = i;
            }
        }
        return rowIndex;
    }

    // Driver code: sample input values to test the solution
    public static void main(String[] args) {
        int[][] arr = {
            {0, 1, 1, 1},
            {0, 0, 1, 1},
            {1, 1, 1, 1},
            {0, 0, 0, 0}
        };

        int result = rowWithMax1s(arr);

        System.out.println(result);
    }
}

/*
GFG Problem => Row with max 1s (not a LeetCode problem)
Time Complexity => O(N * log M)
Space Complexity => O(1)

Output:
2


Companies that asked this question:
Arcesium, Disney + Hotstar, Microsoft
*/