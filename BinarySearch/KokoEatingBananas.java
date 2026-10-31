package BinarySearch;

/*
 * Problem Statement:
 * Koko loves to eat bananas. There are n piles of bananas, the i-th pile has
 * piles[i] bananas. The guards have gone and will come back in h hours.
 * Koko can decide her bananas-per-hour eating speed of k. Each hour, she
 * chooses some pile of bananas and eats k bananas from that pile. If the
 * pile has less than k bananas, she eats all of them instead and will not
 * eat any more bananas during this hour.
 * Koko likes to eat slowly but still wants to finish eating all the bananas
 * before the guards return.
 * Return the minimum integer k such that she can eat all the bananas within
 * h hours.
 *
 * Example:
 * Input: piles = [3, 6, 7, 11], h = 8
 * Output: 4
 * Explanation: At speed 4, the hours needed are 1 + 2 + 2 + 3 = 8, which is
 * within h = 8. At speed 3 she would need 1 + 2 + 3 + 4 = 10 hours, which is
 * too slow.
 *
 * Approach: Binary Search on the answer
 * - The speed k lies between 1 and max(piles). At max(piles) speed she
 *   finishes one pile per hour, which is always enough because
 *   piles.length <= h.
 * - If Koko can finish at speed k, she can also finish at any speed greater
 *   than k, so the answer space is sorted (false ... false true ... true).
 * - Take mid as the speed and check it with canEat(): the hours needed are
 *   the sum of ceil(pile / mid) over all piles.
 * - If she can finish within h hours, store ans = mid and try a slower
 *   speed (high = mid - 1). Otherwise she needs to eat faster
 *   (low = mid + 1).
 * - ceil(pile / k) is calculated as (pile + k - 1) / k, and hours is kept in
 *   a long to avoid overflow.
 */

public class KokoEatingBananas {
    public static int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = 0;

        // Maximum speed needed is the size of the biggest pile
        for (int pile : piles) {
            high = Math.max(pile, high);
        }
        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canEat(piles, h, mid)) {
                // Speed mid works, try to find a slower speed
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    // Checks if Koko can finish all the piles within h hours at speed k
    private static boolean canEat(int[] piles, int h, int k) {
        long hours = 0;
        for (int pile : piles) {
            hours += (pile + k - 1) / k;
        }
        return hours <= h;
    }

    // Driver code: sample input values to test the solution
    public static void main(String[] args) {
        int[] piles = {3, 6, 7, 11};
        int h = 8;

        int result = minEatingSpeed(piles, h);

        System.out.println(result);
    }
}

/*
LeetCode No => 875
Time Complexity => O(N * log M)  (M = maximum pile size)
Space Complexity => O(1)

Output:
4


Companies that asked this question:
Facebook (Meta), Amazon, Google, Microsoft, Uber, Walmart, Adobe, Apple, Salesforce, Arcesium.
*/