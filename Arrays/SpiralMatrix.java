package Arrays;

import java.util.ArrayList;
import java.util.List;

/*
 * Problem Statement:
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 *
 * Example:
 * Input: matrix = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
 * Output: [1, 2, 3, 6, 9, 8, 7, 4, 5]
 * Explanation: The elements are visited in a clockwise spiral direction starting from the top-left.
 *
 * Approach: Layer-by-Layer Simulation (O(1) auxiliary space)
 * - Define four pointers: srow (starting row), erow (ending row), scol (starting column), and ecol (ending column).
 * - Run a loop while srow <= erow and scol <= ecol to traverse the matrix in layers.
 * - Move left to right along the top row (srow), then increment srow.
 * - Move top to bottom along the right column (ecol), then decrement ecol.
 * - Move right to left along the bottom row (erow) if srow <= erow check passes, then decrement erow.
 * - Move bottom to top along the left column (scol) if scol <= ecol check passes, then increment scol.
 */

public class SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int srow = 0, scol = 0, erow = m - 1, ecol = n - 1;
        ArrayList<Integer> ans = new ArrayList<>();

        while (srow <= erow && scol <= ecol) {
            // Traverse Top Row
            for (int j = scol; j <= ecol; j++) {
                ans.add(matrix[srow][j]);
            }

            // Traverse Right Column
            for (int i = srow + 1; i <= erow; i++) {
                ans.add(matrix[i][ecol]);
            }

            // Traverse Bottom Row
            for (int j = ecol - 1; j >= scol; j--) {
                if (srow == erow) {
                    break;
                }
                ans.add(matrix[erow][j]);
            }

            // Traverse Left Column
            for (int i = erow - 1; i >= srow + 1; i--) {
                if (scol == ecol) {
                    break;
                }
                ans.add(matrix[i][scol]);
            }
            srow++;
            erow--;
            scol++;
            ecol--;
        }
        return ans;
    }

    // Driver code: sample input values to test the solution
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        List<Integer> result = spiralOrder(matrix);

        System.out.println(result);
    }
}

/*
LeetCode No => 54
Time Complexity => O(M * N)
Space Complexity => O(1) (excluding the output list)

Output:
[1, 2, 3, 6, 9, 8, 7, 4, 5]


Companies that asked this question:
Adobe, Amazon, Apple, Bloomberg, ByteDance, Capital One, Cisco, D-E-Shaw, eBay, Epic Systems, Facebook (Meta), Goldman Sachs, Google, Hulu, LinkedIn, LiveRamp, Microsoft, Morgan Stanley, Nagarro, Oracle, Paypal, Paytm, Robinhood, Snapchat, Uber, Visa, Walmart Labs, Zillow, Zoho.
*/
