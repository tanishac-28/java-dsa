package BinarySearch;

/*
 * Problem Statement:
 * Given an n x n matrix where each of the rows and columns is sorted in
 * ascending order, return the k-th smallest element in the matrix.
 * Note that it is the k-th smallest element in the sorted order, not the
 * k-th distinct element.
 * You must find a solution with a memory complexity better than O(n^2).
 *
 * Example:
 * Input: matrix = [[1, 5, 9], [10, 11, 13], [12, 13, 15]], k = 8
 * Output: 13
 * Explanation: The elements in sorted order are
 * [1, 5, 9, 10, 11, 12, 13, 13, 15], and the 8th smallest number is 13.
 *
 * Approach: Binary Search on the value range + Counting
 * - The smallest element is mat[0][0] and the largest is mat[n-1][n-1], so
 *   the answer lies between them. We binary search on the values, not on
 *   the indices.
 * - For a value mid, count how many elements are <= mid using
 *   countLessEqual(). Start from the bottom-left corner: if the current
 *   element is <= target, then all the elements above it in this column
 *   are also <= target, so add (row + 1) and move right. Otherwise move up.
 *   This takes O(n) time.
 * - If count < k, the k-th smallest is bigger than mid, so low = mid + 1.
 * - Otherwise the k-th smallest is mid or smaller, so high = mid - 1.
 * - When the loop ends, low is the smallest value for which the count is
 *   at least k, which is the k-th smallest element (it always exists in the
 *   matrix).
 */

public class KthSmallestElementInASortedMatrix {
    public static int kthSmallest(int[][] mat, int k) {
        int n = mat.length;
        int low = mat[0][0];
        int high = mat[n - 1][n - 1];

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int count = countLessEqual(mat, n, mid);

            if (count < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    // Counts the elements which are <= target
    public static int countLessEqual(int[][] mat, int n, int target) {
        // Start from the bottom-left corner
        int row = n - 1;
        int col = 0;
        int count = 0;

        while (row >= 0 && col < n) {
            if (mat[row][col] <= target) {
                // All the elements above in this column are also <= target
                count = count + (row + 1);
                col++;
            } else {
                row--;
            }
        }
        return count;
    }

    // Driver code: sample input values to test the solution
    public static void main(String[] args) {
        int[][] mat = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        int k = 8;

        int result = kthSmallest(mat, k);

        System.out.println(result);
    }
}

/*
LeetCode No => 378
Time Complexity => O(N * log(max - min))
Space Complexity => O(1)

Output:
13


Companies that asked this question:
Adobe, Amazon, Apple, Facebook (Meta), Google, Microsoft, Twitter (X), Uber, and Walmart Labs
*/