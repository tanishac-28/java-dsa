package Arrays;
import java.util.Arrays;

/*
 * Problem Statement:
 * You are given an array people where people[i] is the weight of the i-th
 * person, and an infinite number of boats where each boat can carry a
 * maximum weight of limit. Each boat carries at most two people at the same
 * time, provided the sum of the weight of those people is at most limit.
 * Return the minimum number of boats to carry every given person.
 *
 * Example:
 * Input: people = [3, 2, 2, 1], limit = 3
 * Output: 3
 * Explanation: 3 boats (1, 2), (2) and (3)
 *
 * Approach: Sorting + Two Pointers (Greedy)
 * - Sort the array so the lightest person is at left and heaviest at right.
 * - The heaviest person always needs a boat, so try to pair them with the
 *   lightest person.
 * - If people[left] + people[right] <= limit, both share a boat
 *   (move left forward and right back).
 * - Otherwise the heaviest person goes alone (move right back only).
 * - Every iteration uses exactly one boat.
 */
public class BoatsToSavePeople {
    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int left = 0;
        int right = people.length - 1;
        int boat = 0;

        while (left <= right) {
            int sum = people[left] + people[right];

            if (sum <= limit) {
                // Lightest and heaviest fit together in one boat
                left++;
                right--;
            } else {
                // Heaviest person goes alone
                right--;
            }

            boat++;
        }

        return boat;
    }

    // Driver code: sample input values to test the solution
    public static void main(String[] args) {
        int[] people = {3, 2, 2, 1};
        int limit = 3;

        int result = numRescueBoats(people, limit);

        System.out.println(result);
    }
}

/*
LeetCode No => 881
Time Complexity => O(N log N)  (due to sorting)
Space Complexity => O(1)  (sorting space aside)

Output:
3


Companies that asked this question:
Amazon, Google, and Meta (Facebook
*/