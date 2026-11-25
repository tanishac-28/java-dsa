package Recursion;

/*
 * Problem Statement:
 * Given a positive integer n, count all the possible distinct binary strings
 * of length n such that there are no consecutive 1s.
 * Since the answer can be large, return it modulo 10^9 + 7.
 *
 * Example:
 * Input: n = 3
 * Output: 5
 * Explanation: The 5 valid strings are 000, 001, 010, 100 and 101.
 * (For n = 2 the answer is 3: 00, 01, 10.)
 *




 * Approach: Fibonacci pattern (space optimized DP):-

 * - Look at the last bit of a valid string of length i:
 *   - If it ends in 0, the previous part can be any valid string of length
 *     i - 1.
 *   - If it ends in 1, the bit before it must be 0, so the part before that
 *     can be any valid string of length i - 2.
 * - So count(i) = count(i - 1) + count(i - 2), which is the Fibonacci
 *   series.
 * - Base cases: count(0) = 1 (the empty string) and count(1) = 2 ("0", "1").
 * - Keep only the last two values (prev1 and prev2) instead of a full array,
 *   and take the modulo at every step. The sum is calculated in a long, so
 *   it does not overflow.
 */

public class CountBinaryStringsWithoutConsecutiveOnes {

    public static int countStrings(int n) {

        int mod = 1000000007;

        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 2;
        }

        int prev1 = 2;
        int prev2 = 1;

        for (int i = 2; i <= n; i++) {
            int curr = (int) (((long) prev1 + prev2) % mod);

            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }

    // Driver code: sample input values to test the solution
    public static void main(String[] args) {
        int n = 3;

        int result = countStrings(n);

        System.out.println(result);
    }
}

/*
GFG Problem => Count number of binary strings without consecutive 1's (not a LeetCode problem)
Time Complexity => O(N)
Space Complexity => O(1)

Output:
5


Companies that asked this question:
Amazon, Google, Wells Fargo, Swiggy, and PayPal.
*/