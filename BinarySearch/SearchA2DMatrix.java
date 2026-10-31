package BinarySearch;

/*
 * Problem Statement:
 * You are given an m x n integer matrix with the following two properties:
 * - Each row is sorted in non-decreasing order.
 * - The first integer of each row is greater than the last integer of the
 *   previous row.
 * Given an integer target, return true if target is in the matrix, or false
 * otherwise.
 * You must write a solution in O(log(m * n)) time complexity.
 *
 * Example:
 * Input: matrix = [[1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 60]],
 *        target = 3
 * Output: true
 * Explanation: 3 is present in the first row of the matrix.
 *
 * Approach: Binary Search treating the matrix as a 1D sorted array
 * - Because every row starts after the previous row ends, if we write all
 *   the rows one after another, we get one fully sorted array of size n * m.
 * - Run binary search on the indices from 0 to n * m - 1 without actually
 *   creating the 1D array.
 * - For any index mid, find its position in the matrix:
 *   row = mid / m and col = mid % m (m = number of columns).
 * - If matrix[row][col] equals the target, return true.
 * - If it is smaller than the target, search in the right half
 *   (low = mid + 1), otherwise search in the left half (high = mid - 1).
 * - If the search space gets empty, the target is not present, so
 *   return false.
 */

public class SearchA2DMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int low = 0, high = n * m - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Convert the 1D index to a 2D position
            int row = mid / m;
            int col = mid % m;

            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }

    // Driver code: sample input values to test the solution
    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int target = 3;

        boolean result = searchMatrix(matrix, target);

        System.out.println(result);
    }
}

/*
LeetCode No => 74
Time Complexity => O(log(N * M))
Space Complexity => O(1)

Output:
true


Companies that asked this question:
Amazon, Meta, Google, Apple, Tinkoff, Nutanix, Coupang, Grab, Walmart Labs, Arista Networks, Cisco, Goldman Sachs, Visa, Snap, Yahoo, Accenture, Adobe, Yandex, Oracle, Accolite, MentorGraphics, Directi, Groupon, InMobi, MakeMyTrip, Ola Cabs, Paytm.
*/