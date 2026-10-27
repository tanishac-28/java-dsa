package Arrays;
/*
 * Problem Statement:
 * Given an array of integers arr and two integers k and threshold, return
 * the number of sub-arrays of size k and average greater than or equal to
 * threshold.
 *
 * Example:
 * Input: arr = [2, 2, 2, 2, 5, 5, 5, 8], k = 3, threshold = 4
 * Output: 3
 * Explanation: Sub-arrays [2, 5, 5], [5, 5, 5] and [5, 5, 8] have averages
 * 4, 5 and 6 respectively. All other sub-arrays of size 3 have averages
 * less than 4.
 *
 * Approach: Sliding Window
 * - Calculate the sum of the first k elements and check its average.
 * - Slide the window one step at a time: add the new element entering the
 *   window and subtract the element leaving it.
 * - After every slide, check if the average of the window is >= threshold
 *   and increase the count.
 */
public class NumOfSubarraysOfSizeK {
    public static int numOfSubarrays(int[] nums, int k, int threshold) {
        int sum = 0;
        int count = 0;
        int n = nums.length;

        // Sum of the first window
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        double avg = (double) sum / k;

        if (avg >= threshold) {
            count++;
        }

        // Slide the window: add the new element, remove the old one
        for (int j = k; j < n; j++) {
            sum += nums[j] - nums[j - k];

            avg = (double) sum / k;

            if (avg >= threshold) {
                count++;
            }
        }

        return count;
    }

    // Driver code: sample input values to test the solution
    public static void main(String[] args) {
        int[] nums = {2, 2, 2, 2, 5, 5, 5, 8};
        int k = 3;
        int threshold = 4;

        int result = numOfSubarrays(nums, k, threshold);

        System.out.println(result);
    }
}

/*
LeetCode No => 1343
Time Complexity => O(N)
Space Complexity => O(1)

Output:
3


Companies that asked this question:
Goldman Sachs, Turo
*/