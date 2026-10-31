package BinarySearch;

/*
 * Problem Statement:
 * Write an efficient algorithm that searches for a value target in an m x n
 * integer matrix. This matrix has the following properties:
 * - Integers in each row are sorted in ascending order from left to right.
 * - Integers in each column are sorted in ascending order from top to
 *   bottom.
 * Return true if the target is present in the matrix, otherwise false.
 *
 * Example:
 * Input: matrix = [[1, 4, 7, 11, 15],
 *                  [2, 5, 8, 12, 19],
 *                  [3, 6, 9, 16, 22],
 *                  [10, 13, 14, 17, 24],
 *                  [18, 21, 23, 26, 30]], target = 5
 * Output: true
 * Explanation: 5 is present in the second row and second column.
 *
 * Approach: Start from the top-right corner (Staircase Search)
 * - The top-right element is the biggest in its row and the smallest in its
 *   column, so every comparison lets us throw away a whole row or column.
 * - Start with row = 0 and col = m - 1.
 * - If matrix[row][col] equals the target, return true.
 * - If the target is smaller, then every element below in this column is
 *   even bigger, so this column cannot have the target: move left (col--).
 * - If the target is bigger, then every element on the left in this row is
 *   even smaller, so this row cannot have the target: move down (row++).
 * - If we go outside the matrix, the target is not present, so return false.
 */

public class SearchA2DMatrixII {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        // Start from the top-right corner
        int row = 0, col = m - 1;

        while (row < n && col >= 0) {
            if (target == matrix[row][col]) {
                return true;
            } else if (target < matrix[row][col]) {
                // Target is smaller, discard this column
                col--;
            } else {
                // Target is bigger, discard this row
                row++;
            }
        }
        return false;
    }

    // Driver code: sample input values to test the solution
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 4, 7, 11, 15},
            {2, 5, 8, 12, 19},
            {3, 6, 9, 16, 22},
            {10, 13, 14, 17, 24},
            {18, 21, 23, 26, 30}
        };
        int target = 5;

        boolean result = searchMatrix(matrix, target);

        System.out.println(result);
    }
}

/*
LeetCode No => 240
Time Complexity => O(N + M)
Space Complexity => O(1)

Output:
true


Companies that asked this question:
Amazon, Microsoft, Meta (Facebook), Google, Goldman Sachs, Bloomberg, Uber, Adobe, Apple
*/