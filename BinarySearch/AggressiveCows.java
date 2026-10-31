package BinarySearch;

import java.util.Arrays;

/*
 * Problem Statement:
 * You are given an array nums with the positions of n stalls (all distinct,
 * in no particular order) and an integer k, the number of cows. You have to
 * place the k cows in different stalls such that the minimum distance
 * between any two cows is as large as possible.
 * Return the largest possible value of this minimum distance.
 *
 * Example:
 * Input: nums = [1, 2, 4, 8, 9], k = 3
 * Output: 3
 * Explanation: Place the cows at stalls 1, 4 and 8. The distances between
 * them are 3 and 4, so the minimum distance is 3. No arrangement can give a
 * minimum distance of 4 or more with 3 cows.
 *
 * Approach: Sort + Binary Search on the answer
 * - Sort the stalls, so cows can be placed from left to right greedily.
 * - The minimum distance lies between 0 and (largest stall - smallest
 *   stall).
 * - If we can place k cows with a minimum distance d, we can also place
 *   them with any smaller distance, so the answer space is sorted
 *   (true ... true false ... false).
 * - Take mid as the distance and check it with isPossible(): put the first
 *   cow in the first stall, then put the next cow in the first stall that is
 *   at least mid away from the last placed cow. Count the cows placed.
 * - If at least k cows can be placed, store ans = mid and try a bigger
 *   distance (low = mid + 1). Otherwise try a smaller one (high = mid - 1).
 */

public class AggressiveCows {
    public static int aggressiveCows(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int low = 0;
        int high = nums[n - 1] - nums[0];
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isPossible(nums, k, mid)) {
                // Possible, try a bigger minimum distance
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    // Checks if k cows can be placed with at least minAllowedDist between them
    public static boolean isPossible(int[] nums, int k, int minAllowedDist) {
        int cows = 1;
        int lastStallPos = nums[0];
        int n = nums.length;

        for (int i = 1; i < n; i++) {
            if (nums[i] - lastStallPos >= minAllowedDist) {
                cows++;
                lastStallPos = nums[i];
            }
        }
        return cows >= k;
    }

    // Driver code: sample input values to test the solution
    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 8, 9};
        int k = 3;

        int result = aggressiveCows(nums, k);

        System.out.println(result);
    }
}

/*
GFG Problem => Aggressive Cows (not a LeetCode problem)
Time Complexity => O(N log N + N * log(maxStall - minStall))
Space Complexity => O(1)  (ignoring the space used by sorting)

Output:
3


Companies that asked this question:
Adobe, Goldman Sachs, Dunzo   (Most Imp)
*/