package Arrays;
import java.util.Arrays;
import java.util.HashSet;

/*
 * Problem Statement:
 * Given an integer array nums, return true if any value appears at least
 * twice in the array, and return false if every element is distinct.
 *
 * Example:
 * Input: nums = [1, 2, 3, 1]
 * Output: true
 * Explanation: The element 1 occurs at the indices 0 and 3.
 *
 * Approach: HashSet
 * - Traverse the array once and keep a set of the numbers seen so far.
 * - If the current number is already in the set, a duplicate exists,
 *   so return true immediately.
 * - Otherwise add it to the set and continue.
 * - If the loop ends without finding a repeat, return false.
 */
public class containsDuplicate {
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            // Number was already seen, so it is a duplicate
            if (set.contains(num)) {
                return true;
            }

            set.add(num);
        }

        return false;
    }

    // Driver code: sample input values to test the solution
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};

        boolean result = containsDuplicate(nums);

        System.out.println("Array: " + Arrays.toString(nums));
        System.out.println("Contains duplicate: " + result);
    }
}

/*
LeetCode No => 217
Time Complexity => O(N)
Space Complexity => O(N)

Output:
Array: [1, 2, 3, 1]
Contains duplicate: true


Companies that asked this question:
Adobe, Airbnb, Amazon, Apple, Microsoft, Oracle, Palantir Technologies,
Yahoo, Google, TCS, Accenture, IBM, Meta (Facebook), Netflix, Capgemini,
Zoho, Bloomberg, Infosys, Visa
*/