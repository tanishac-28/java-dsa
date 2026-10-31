package BinarySearch;

/*
 * Problem Statement:
 * Given an integer array nums and an integer k, split nums into k non-empty
 * subarrays such that the largest sum of any subarray is minimized.
 * Return the minimized largest sum of the split.
 * A subarray is a contiguous part of the array.
 *
 * Example:
 * Input: nums = [7, 2, 5, 10, 8], k = 2
 * Output: 18
 * Explanation: There are four ways to split nums into two subarrays. The
 * best way is to split it into [7, 2, 5] and [10, 8], where the largest sum
 * among the two subarrays is only 18.
 *
 * Approach: Binary Search on the answer
 * - The answer (largest subarray sum) lies between max(nums) and
 *   sum(nums). A subarray must hold at least the biggest element, and with
 *   k = 1 the whole array is one subarray.
 * - If a limit maxsum works, any bigger limit also works, so the answer
 *   space is sorted (false ... false true ... true).
 * - Take mid as the limit and check it with canSplit(): keep adding elements
 *   to the current subarray while the sum stays within mid, otherwise start
 *   a new subarray with that element. Count the subarrays needed.
 * - If the subarrays needed <= k, store ans = mid and try a smaller limit
 *   (high = mid - 1). Otherwise increase the limit (low = mid + 1).
 * - If fewer than k subarrays are needed, we can always split further
 *   without increasing the largest sum, so <= k is enough.
 */

public class SplitArrayLargestSum {
    public static int splitArray(int[] nums, int k) {
        int low = 0, high = 0;

        for (int num : nums) {
            low = Math.max(low, num);
            high = high + num;
        }
        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canSplit(nums, k, mid)) {
                // Works, try a smaller largest sum
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    // Checks if the array can be split into at most k subarrays
    // such that every subarray sum is <= maxsum
    private static boolean canSplit(int[] nums, int k, int maxsum) {
        int count = 1;
        int currsum = 0;

        for (int num : nums) {
            if (currsum + num <= maxsum) {
                currsum += num;
            } else {
                // Start a new subarray
                count++;
                currsum = num;
            }
        }
        return count <= k;
    }

    // Driver code: sample input values to test the solution
    public static void main(String[] args) {
        int[] nums = {7, 2, 5, 10, 8};
        int k = 2;

        int result = splitArray(nums, k);

        System.out.println(result);
    }
}

/*
LeetCode No => 410
Time Complexity => O(N * log(sum(nums)))
Space Complexity => O(1)

Output:
18


Companies that asked this question:
Google | Amazon | Facebook (Meta) | Bloomberg | TikTok | Microsoft | Adobe | Baidu | DiDi
*/
