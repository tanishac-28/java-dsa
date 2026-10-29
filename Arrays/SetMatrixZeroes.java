package Arrays;

import java.util.Arrays;

/*
 * Problem Statement:
 * Given an m x n integer matrix, if an element is 0, set its entire row and
 * column to 0's. You must do it in place.
 *
 * Example:
 * Input: matrix = [[1, 1, 1], [1, 0, 1], [1, 1, 1]]
 * Output: [[1, 0, 1], [0, 0, 0], [1, 0, 1]]
 * Explanation: The zero is at row 1, column 1, so the whole row 1 and the
 * whole column 1 become 0.
 *
 * Approach: Use the first row and first column as markers (O(1) space)
 * - Instead of using extra arrays, use matrix[i][0] to mark that row i must
 *   become 0, and matrix[0][j] to mark that column j must become 0.
 * - The first row and first column are also used as markers, so keep two
 *   boolean variables (firstRow, firstCol) to remember whether the first row
 *   and the first column originally had a zero.
 * - Pass 1: traverse the whole matrix, and for every zero at (i, j), mark
 *   matrix[i][0] = 0 and matrix[0][j] = 0.
 * - Pass 2: traverse from (1, 1) and set matrix[i][j] = 0 if its row marker
 *   or its column marker is 0.
 * - Finally, if firstCol is true make the first column 0, and if firstRow is
 *   true make the first row 0. This is done last so the markers are not
 *   destroyed before they are used.
 */

public class SetMatrixZeroes {
    public static void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        boolean firstRow = false, firstCol = false;

        // Pass 1: mark the rows and columns that have a zero
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) {
                        firstRow = true;
                    }
                    if (j == 0) {
                        firstCol = true;
                    }
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        // Pass 2: set zeroes using the markers (skip the first row and column)
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // The first column originally had a zero
        if (firstCol) {
            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }

        // The first row originally had a zero
        if (firstRow) {
            for (int j = 0; j < m; j++) {
                matrix[0][j] = 0;
            }
        }
    }

    // Driver code: sample input values to test the solution
    public static void main(String[] args) {
        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};

        setZeroes(matrix);

        System.out.println(Arrays.deepToString(matrix));
    }
}

/*
LeetCode No => 73
Time Complexity => O(N * M)
Space Complexity => O(1)

Output:
[[1, 0, 1], [0, 0, 0], [1, 0, 1]]


Companies that asked this question:
Microsoft | Amazon | Adobe | Expedia | eBay | Apple | Bloomberg | Docusign | Facebook (Meta) | Oracle | Paypal | Salesforce | TripAdvisor
*/