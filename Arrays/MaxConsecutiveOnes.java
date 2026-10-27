package Arrays;
import java.util.Arrays;

/*
 * Problem Statement:
 * Given a binary array nums, return the maximum number of consecutive 1's
 * in the array.
 *
 * Example:
 * Input: nums = [1, 1, 0, 1, 1, 1]
 * Output: 3
 * Explanation: The first two digits or the last three digits are
 * consecutive 1s. The maximum number of consecutive 1s is 3.
 *
 * Approach: Single Pass (Running Count)
 * - Traverse the array once and keep a running count of consecutive 1s.
 * - If the current element is 1, increase the count and update the
 *   maximum seen so far.
 * - If the current element is 0, the streak is broken, so reset the
 *   count to 0.
 */
public class MaxConsecutiveOnes {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int count = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                count++;

                max = Math.max(count, max);
            } else {
                // Streak broken, start counting again
                count = 0;
            }
        }

        return max;
    }

    // Driver code: sample input values to test the solution
    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 1, 1, 1};

        int result = findMaxConsecutiveOnes(nums);

        System.out.println("Array: " + Arrays.toString(nums));
        System.out.println("Max consecutive ones: " + result);
    }
}

/*
LeetCode No => 485
Time Complexity => O(N)
Space Complexity => O(1)

Output:
Array: [1, 1, 0, 1, 1, 1]
Max consecutive ones: 3


Companies that asked this question:
Amazon, Google, Microsoft, Facebook (Meta), and Adobe
*/