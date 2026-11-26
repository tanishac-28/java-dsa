package Recursion;

/*
 * Problem Statement:
 * A digit string is good if the digits (0-indexed) at even indices are even
 * and the digits at odd indices are prime (2, 3, 5, or 7).
 * For example, "2582" is good because the digits (2 and 8) at even positions
 * are even and the digits (5 and 2) at odd positions are prime. However,
 * "3245" is not good because 3 is at an even index but is not even.
 * Given an integer n, return the total number of good digit strings of
 * length n. Since the answer may be large, return it modulo 10^9 + 7.
 * A digit string is a string consisting of digits 0 through 9 that may
 * contain leading zeros.
 *
 * Example:
 * Input: n = 4
 * Output: 400
 * Explanation: Positions 0 and 2 (even indices) have 5 choices each
 * (0, 2, 4, 6, 8), and positions 1 and 3 (odd indices) have 4 choices each
 * (2, 3, 5, 7). So the total is 5 * 4 * 5 * 4 = 400.
 *
 



 * Approach: Counting + Fast Exponentiation (recursion)
 * - Every even index has 5 choices and every odd index has 4 choices, and
 *   all the positions are independent, so the answer is
 *   5^(even positions) * 4^(odd positions).
 * - Number of even indices = (n + 1) / 2, and number of odd indices = n / 2.
 * - n can be as large as 10^15, so a loop that multiplies n times is too
 *   slow. Use fast exponentiation instead: x^n = (x^(n/2))^2, and if n is
 *   odd, multiply one extra x.
 * - Take the modulo (10^9 + 7) after every multiplication, so the numbers
 *   never overflow a long.
 */

public class CountGoodNumbers {

    // Define MOD as a class variable for easier reference and readability
    public static long MOD = 1_000_000_007;

    public static int countGoodNumbers(long n) {

        // Calculate the number of even and odd positions in the digit string
        long odd = n / 2;
        long even = (n + 1) / 2;

        return (int) (pow(5, even) * pow(4, odd) % MOD);
    }

    public static long pow(long x, long n) {

        // Base case for the recursion
        if (n == 0) {
            return 1;
        }

        // Recursively calculate x^(n/2)
        long temp = pow(x, n / 2);

        // If n is even, return (x^(n/2))^2
        if (n % 2 == 0) {
            return (temp * temp) % MOD;
        }
        // If n is odd, return (x^(n/2))^2 * x
        else {
            return (x * temp * temp) % MOD;
        }
    }

    // Driver code: sample input values to test the solution
    public static void main(String[] args) {
        long n = 4;

        int result = countGoodNumbers(n);

        System.out.println(result);
    }
}

/*
LeetCode No => 1922
Time Complexity => O(log N)
Space Complexity => O(log N)  (recursion stack)

Output:
400


Companies that asked this question:
Google, Amazon, Microsoft, Meta, Apple, and Uber
*/