package BinarySearch;

/*
 * Problem Statement:
 * Given an array of integers nums and an integer threshold, we will choose a
 * positive integer divisor, divide all the array by it, and sum the result
 * of the division. Find the smallest divisor such that the result mentioned
 * above is less than or equal to threshold.
 * Each result of the division is rounded to the nearest integer greater than
 * or equal to that element. (For example: 7 / 3 = 3 and 10 / 2 = 5).
 * The test cases are generated so that there will be an answer.
 *
 * Example:
 * Input: nums = [1, 2, 5, 9], threshold = 6
 * Output: 5
 * Explanation: With divisor 1 the sum is 1 + 2 + 5 + 9 = 17. With divisor 4
 * the sum is 1 + 1 + 2 + 3 = 7 (more than 6). With divisor 5 the sum is
 * 1 + 1 + 1 + 2 = 5 (within 6), so the smallest divisor is 5.
 *
 * Approach: Binary Search on the answer
 * - The divisor lies between 1 and max(nums). With max(nums) as the divisor,
 *   every element gives 1, and the sum is n, which is always <= threshold.
 * - As the divisor increases, the sum of the divisions decreases, so the
 *   answer space is sorted (false ... false true ... true).
 * - Take mid as the divisor and find the sum using sumByD(), which adds
 *   ceil(num / mid) for every element.
 * - If the sum <= threshold, mid can be the answer, but a smaller divisor
 *   may also work, so high = mid. Otherwise the divisor is too small, so
 *   low = mid + 1.
 * - When low == high, that value is the smallest valid divisor.
 */

public class FindTheSmallestDivisorGivenAThreshold {
    public static int smallestDivisor(int[] nums, int threshold) {
        int low = 1, high = 0;

        // Largest possible divisor is the maximum element
        for (int num : nums) {
            high = Math.max(high, num);
        }

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (sumByD(nums, mid) <= threshold) {
                // Valid divisor, try to find a smaller one
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    // Sum of ceil(num / Div) for all the elements
    public static int sumByD(int[] nums, int Div) {
        int sum = 0;
        for (int num : nums) {
            sum += Math.ceil((double) num / (double) Div);
        }
        return sum;
    }

    // Driver code: sample input values to test the solution
    public static void main(String[] args) {
        int[] nums = {1, 2, 5, 9};
        int threshold = 6;

        int result = smallestDivisor(nums, threshold);

        System.out.println(result);
    }
}

/*
LeetCode No => 1283
Time Complexity => O(N * log(max(nums)))
Space Complexity => O(1)

Output:
5


Companies that asked this question:
Amazon, Google, Uber, Salesforce, Adobe, Bloomberg, Facebook (Meta), ByteDance, Microsoft, SpaceX, Apple, Walmart Global Tech
*/