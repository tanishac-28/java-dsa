package Arrays;

import java.util.Arrays;

/*
 * Problem Statement:
 * Given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. 
 * DO NOT allocate another 2D matrix and do the rotation.
 *
 * Example:
 * Input: matrix = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
 * Output: [[7, 4, 1], [8, 5, 2], [9, 6, 3]]
 * Explanation: The matrix is rotated 90 degrees clockwise.
 *
 * Approach: Transpose and Reverse (O(1) space)
 * - Step 1 (Transpose): Swap elements across the main diagonal (matrix[i][j] with matrix[j][i]).
 *   This converts all rows into columns.
 * - Step 2 (Reverse): Reverse each row of the transposed matrix. Two pointers (left and right) 
 *   are used to swap elements from both ends moving towards the center.
 * - This combination of transposing and reversing results in a 90-degree clockwise rotation.
 */

public class RotateImage {
    public static void rotate(int[][] matrix) {
        int n = matrix.length;

        // Step 1: Transpose the matrix
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = n - 1;

            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;

                left++;
                right--;
            }
        }
    }

    // Driver code: sample input values to test the solution
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        rotate(matrix);

        System.out.println(Arrays.deepToString(matrix));
    }
}

/*
LeetCode No => 48
Time Complexity => O(N * N)
Space Complexity => O(1)

Output:
[[7, 4, 1], [8, 5, 2], [9, 6, 3]]


Companies that asked this question:
Amazon, Google, Microsoft, Apple, Uber, Bloomberg, Cisco, Roblox, Nutanix, Visa, SIG, Infosys, Zoho
*/
