package BinarySearch;

/*
 * Problem Statement:
 * A conveyor belt has packages that must be shipped from one port to another
 * within days days.
 * The i-th package on the conveyor belt has a weight of weights[i]. Each day,
 * we load the ship with packages on the conveyor belt (in the order given by
 * weights). We may not load more weight than the maximum weight capacity of
 * the ship.
 * Return the least weight capacity of the ship that will result in all the
 * packages on the conveyor belt being shipped within days days.
 *
 * Example:
 * Input: weights = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], days = 5
 * Output: 15
 * Explanation: A ship capacity of 15 is the minimum to ship all the packages
 * in 5 days like this:
 * 1st day: 1, 2, 3, 4, 5
 * 2nd day: 6, 7
 * 3rd day: 8
 * 4th day: 9
 * 5th day: 10
 *
 * Approach: Binary Search on the answer
 * - The capacity must be at least max(weights), otherwise the heaviest
 *   package can never be shipped, so low = max(weights).
 * - With sum(weights) as the capacity, everything is shipped in 1 day, so
 *   high = sum(weights).
 * - If a capacity works, any bigger capacity also works, so the answer
 *   space is sorted (false ... false true ... true).
 * - Take mid as the capacity and check it with canShip(): go through the
 *   packages in order and keep adding them to the current day. When the next
 *   package does not fit, start a new day with that package.
 * - If the days needed <= days, store ans = capacity and try a smaller
 *   capacity (high = capacity - 1). Otherwise increase the capacity
 *   (low = capacity + 1).
 */

public class CapacityToShipPackagesWithinDDays {
    public static int shipWithinDays(int[] weights, int days) {
        int low = 0, high = 0;

        for (int w : weights) {
            low = Math.max(low, w);
            high = high + w;
        }
        int ans = 0;
        while (low <= high) {
            int capacity = low + (high - low) / 2;

            if (canShip(weights, days, capacity)) {
                // Works, try a smaller capacity
                ans = capacity;
                high = capacity - 1;
            } else {
                low = capacity + 1;
            }
        }
        return ans;
    }

    // Checks if all packages can be shipped within the given days
    public static boolean canShip(int[] weights, int days, int capacity) {
        int d = 1, curr = 0;
        for (int w : weights) {
            if (curr + w > capacity) {
                // Package does not fit, start a new day
                d++;
                curr = w;
            } else {
                curr += w;
            }
        }
        return d <= days;
    }

    // Driver code: sample input values to test the solution
    public static void main(String[] args) {
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int days = 5;

        int result = shipWithinDays(weights, days);

        System.out.println(result);
    }
}

/*
LeetCode No => 1011
Time Complexity => O(N * log(sum(weights) - max(weights)))
Space Complexity => O(1)

Output:
15


Companies that asked this question:
Amazon, Google, Meta (Facebook), Microsoft, Bloomberg, Uber, LinkedIn, Apple, Adobe.
*/