package Arrays;
import java.util.Arrays;

/*
 * Problem Statement:
 * You are given a 1-indexed array of integers "numbers" that is already
 * sorted in non-decreasing order. Find two numbers such that they add up
 * to a given "target". Return their indices as [index1, index2], where
 * 1 <= index1 < index2 <= numbers.length.
 *
 * Notes:
 * - Exactly one solution exists.
 * - The same element cannot be used twice.
 * - The solution must use only constant extra space.
 *
 * Example:
 * Input: numbers = [2, 7, 11, 15], target = 9
 * Output: [1, 2]
 *
 * Approach: Two Pointers
 * - Keep one pointer at the start (smallest) and one at the end (largest).
 * - If sum > target, move right backward to decrease the sum.
 * - If sum < target, move left forward to increase the sum.
 * - If sum == target, return the indices.
 */
public class TwoSumII {
    public static int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int left = 0;
        int right = n - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                // +1 because the answer must be 1-indexed
                return new int[] {left + 1, right + 1};
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }

        // Unreachable: the problem guarantees exactly one solution
        return new int[] {-1, -1};
    }

    // Driver code: sample input values to test the solution
    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;

        int[] result = twoSum(numbers, target);

        System.out.println(Arrays.toString(result));
    }
}

/*
LeetCode No => 167
Time Complexity => O(N)
Space Complexity => O(1)
*/
