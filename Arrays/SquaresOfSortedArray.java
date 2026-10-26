package Arrays;
import java.util.Arrays;

/*
 * Problem Statement:
 * Given an integer array "nums" sorted in non-decreasing order, return an
 * array of the squares of each number, also sorted in non-decreasing order.
 *
 * Example:
 * Input: nums = [-4, -1, 0, 3, 10]
 * Output: [0, 1, 9, 16, 100]
 *
 * Approach: Two Pointers
 * - Squares of negative numbers can be large, so the biggest square is
 *   always at either the left end or the right end of the array.
 * - Compare the squares at both ends and place the larger one at the
 *   last free position of the result array (filling from back to front).
 * - Move the pointer whose square was used, and decrease the index.
 */
public class SquaresOfSortedArray {
    public static int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int[] result = new int[n];
        int index = n - 1;

        while (left <= right) {
            int sq1 = nums[left] * nums[left];
            int sq2 = nums[right] * nums[right];

            if (sq1 < sq2) {
                result[index] = sq2;
                right--;
            } else {
                result[index] = sq1;
                left++;
            }

            index--;
        }

        return result;
    }

    // Driver code: sample input values to test the solution
    public static void main(String[] args) {
        int[] nums = {-4, -1, 0, 3, 10};

        int[] result = sortedSquares(nums);

        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Output: " + Arrays.toString(result));
    }
}

/*
LeetCode No => 977
Time Complexity => O(N)
Space Complexity => O(N)  (for the result array, O(1) extra space)


Companies that asked this question:
Google, Apple, Microsoft, Amazon, and Facebook (Meta)
*/