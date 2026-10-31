package BinarySearch;

import java.util.Arrays;

/*
 * Problem Statement:
 * A peak element in a 2D grid is an element that is strictly greater than
 * all of its adjacent neighbors to the left, right, top, and bottom.
 * Given a 0-indexed m x n matrix mat where no two adjacent cells are equal,
 * find any peak element mat[i][j] and return the length 2 array [i, j].
 * You may assume that the entire matrix is surrounded by an outer perimeter
 * with the value -1 in each cell.
 * You must write an algorithm that runs in O(m log(n)) or O(n log(m)) time.
 *
 * Example:
 * Input: mat = [[10, 20, 15], [21, 30, 14], [7, 16, 32]]
 * Output: [1, 1]
 * Explanation: 30 is a peak, because it is greater than 21 (left?no, 21 is
 * on its left), 14 (right), 20 (top) and 16 (bottom). Both 30 and 32 are
 * peaks, so [1, 1] and [2, 2] are both accepted.
 *
 * Approach: Binary Search on columns
 * - Take the middle column (mid) and find the row that has the maximum
 *   value in this column (maxRow) using findMax().
 * - That element is already greater than its top and bottom neighbors, so
 *   only left and right need to be compared. Out of the matrix is treated
 *   as -1.
 * - If it is greater than both left and right, it is a peak, so return
 *   [maxRow, mid].
 * - If the left neighbor is bigger, a peak must exist on the left side, so
 *   high = mid - 1.
 * - Otherwise the right neighbor is bigger (no two adjacent cells are
 *   equal), so a peak must exist on the right side, so low = mid + 1.
 */

public class FindAPeakElementII {
    // Returns the row index of the maximum element in the given column
    public static int findMax(int[][] mat, int n, int m, int col) {
        int maxVal = -1;
        int index = -1;

        for (int i = 0; i < n; i++) {
            if (mat[i][col] >= maxVal) {
                maxVal = mat[i][col];
                index = i;
            }
        }
        return index;
    }

    public static int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int low = 0, high = m - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            // Row of the biggest element in the middle column
            int maxRow = findMax(mat, n, m, mid);

            int left;
            if (mid - 1 >= 0) {
                left = mat[maxRow][mid - 1];
            } else {
                left = -1;
            }

            int right;
            if (mid + 1 < m) {
                right = mat[maxRow][mid + 1];
            } else {
                right = -1;
            }

            if (mat[maxRow][mid] > left && mat[maxRow][mid] > right) {
                // Bigger than all four neighbors
                return new int[]{maxRow, mid};
            } else if (mat[maxRow][mid] < left) {
                // Peak is on the left side
                high = mid - 1;
            } else {
                // Peak is on the right side
                low = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }

    // Driver code: sample input values to test the solution
    public static void main(String[] args) {
        int[][] mat = {{10, 20, 15}, {21, 30, 14}, {7, 16, 32}};

        int[] result = findPeakGrid(mat);

        System.out.println(Arrays.toString(result));
    }
}

/*
LeetCode No => 1901
Time Complexity => O(N * log M)
Space Complexity => O(1)

Output:
[1, 1]


Companies that asked this question:
Amazon, Bloomberg, Google, Uber, Xing
*/