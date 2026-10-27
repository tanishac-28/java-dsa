package Arrays;

import java.util.HashMap;

/*
 * Problem Statement:
 * You are visiting a farm with a single row of fruit trees. fruits[i] is the
 * type of fruit the i-th tree produces. You have two baskets and each basket
 * can hold only one type of fruit (but any quantity). Starting from any tree,
 * you must pick exactly one fruit from every tree moving to the right, and
 * you stop when you reach a tree whose fruit cannot fit in your baskets.
 * Return the maximum number of fruits you can pick.
 *
 * Example:
 * Input: fruits = [1, 2, 3, 2, 2]
 * Output: 4
 * Explanation: We can pick from trees [2, 3, 2, 2]. If we started at the
 * first tree, we would only pick [1, 2].
 *
 * Approach: Sliding Window (variable size) + HashMap
 * - This is the same as finding the longest subarray with at most 2
 *   distinct values.
 * - Expand the window by moving right and store the count of each fruit
 *   type in the map.
 * - If the map has more than 2 fruit types, shrink the window from the left,
 *   reduce the count of fruits[left], and remove it from the map when its
 *   count becomes 0.
 * - After every step, update the maximum window length.
 */

public class FruitIntoBaskets {
    public static int totalFruit(int[] fruits) {
        int n = fruits.length;
        int ans = 0;
        int left = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int right = 0; right < n; right++) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);

            // More than 2 types of fruits, shrink the window from the left
            while (map.size() > 2) {
                map.put(fruits[left], map.get(fruits[left]) - 1);
                if (map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);
                }
                left++;
            }

            int length = right - left + 1;
            ans = Math.max(ans, length);
        }

        return ans;
    }

    // Driver code: sample input values to test the solution
    public static void main(String[] args) {
        int[] fruits = {1, 2, 3, 2, 2};

        int result = totalFruit(fruits);

        System.out.println(result);
    }
}

/*
LeetCode No => 904
Time Complexity => O(N)
Space Complexity => O(1)  (map never holds more than 3 keys)

Output:
4


Companies that asked this question:
Amazon, Google, Facebook (Meta), Microsoft, Apple, Bloomberg, Uber, Adobe
*/