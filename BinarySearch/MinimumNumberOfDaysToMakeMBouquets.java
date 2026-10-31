package BinarySearch;

/*
 * Problem Statement:
 * You are given an integer array bloomDay, an integer m and an integer k.
 * You want to make m bouquets. To make a bouquet, you need to use k adjacent
 * flowers from the garden.
 * The garden consists of n flowers, the i-th flower will bloom in
 * bloomDay[i] and then can be used in exactly one bouquet.
 * Return the minimum number of days you need to wait to be able to make m
 * bouquets from the garden. If it is impossible to make m bouquets, return
 * -1.
 *
 * Example:
 * Input: bloomDay = [1, 10, 3, 10, 2], m = 3, k = 1
 * Output: 3
 * Explanation: We need 3 bouquets of 1 flower each. After day 3, the flowers
 * at indices 0, 2 and 4 have bloomed, so we can make 3 bouquets.
 *
 * Approach: Binary Search on the answer
 * - If m * k > n, there are not enough flowers, so return -1.
 * - The answer lies between the smallest and the largest value in bloomDay.
 * - If we can make m bouquets on day D, we can also make them on any later
 *   day, so the answer space is sorted (false ... false true ... true).
 * - Take mid as the day and check it with canMake(): scan the array, count
 *   the continuous bloomed flowers (bloom <= day), and every time the count
 *   reaches k, make one bouquet and reset the count. If a flower has not
 *   bloomed, the count is reset to 0, because the flowers must be adjacent.
 * - If bouquets >= m, store ans = mid and try a smaller day (high = mid - 1),
 *   otherwise wait more (low = mid + 1).
 * - m * k is calculated as long, to avoid overflow.
 */

public class MinimumNumberOfDaysToMakeMBouquets {
    public static int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;

        // Not enough flowers to make m bouquets
        if ((long) m * k > n) {
            return -1;
        }

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for (int day : bloomDay) {
            low = Math.min(low, day);
            high = Math.max(high, day);
        }

        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canMake(bloomDay, m, k, mid)) {
                // Possible on this day, try a smaller day
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    // Checks if m bouquets can be made by the given day
    public static boolean canMake(int[] bloomDay, int m, int k, int day) {
        int count = 0, bouqets = 0;

        for (int bloom : bloomDay) {
            if (bloom <= day) {
                count++;
                if (count == k) {
                    bouqets++;
                    count = 0;
                }
            } else {
                // Flower not bloomed, adjacent flowers are broken
                count = 0;
            }
        }
        return bouqets >= m;
    }

    // Driver code: sample input values to test the solution
    public static void main(String[] args) {
        int[] bloomDay = {1, 10, 3, 10, 2};
        int m = 3;
        int k = 1;

        int result = minDays(bloomDay, m, k);

        System.out.println(result);
    }
}

/*
LeetCode No => 1482
Time Complexity => O(N * log(max(bloomDay)))
Space Complexity => O(1)

Output:
3


Companies that asked this question:
Google | Amazon | Meta (Facebook) | Microsoft | Apple | Bloomberg | Adobe | Flipkart | Barclays | Samsung | LinkedIn | Netflix | VMware
*/