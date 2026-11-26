package Recursion;

/*
 * Problem Statement:
 * Implement pow(x, n), which calculates x raised to the power n (i.e., x^n).
 *
 * Example:
 * Input: x = 2.00000, n = 10
 * Output: 1024.00000
 * Explanation: 2^10 = 1024.
 * (For x = 2.00000, n = -2 the output is 0.25000, because 2^-2 = 1 / 4.)
 *
 


 * Approach: Binary Exponentiation (recursion, halving the power)
 * - Multiplying x by itself n times takes O(n) time, which is too slow for
 *   a large n. Instead, halve the power in every step:
 *   x^n = (x * x)^(n / 2), and if n is odd, one extra x is multiplied.
 * - power(x, n, ans) keeps the answer collected so far in ans.
 *   - Base case: if n == 0, return ans.
 *   - If n is odd, multiply ans by x (this takes care of the extra x).
 *   - Recursive call: power(x * x, n / 2, ans).
 * - Negative power: calculate with the absolute value of n, and return
 *   1 / result at the end.
 * - Store n in a long before negating it, because -Integer.MIN_VALUE does
 *   not fit in an int.
 */

public class PowXN {
    public static double myPow(double x, int n) {

        // Use long, so that -n does not overflow for Integer.MIN_VALUE
        long exp = n;
        if (exp < 0) {
            exp = -exp;
        }
        double result = power(x, exp, 1);

        // Negative power means the reciprocal
        if (n < 0) {
            return 1 / result;
        }
        return result;
    }

    static double power(double x, long n, double ans) {
        if (n == 0) {
            return ans;
        }
        // Odd power, multiply one extra x
        if (n % 2 != 0) {
            ans = ans * x;
        }

        return power(x * x, n / 2, ans);
    }

    // Driver code: sample input values to test the solution
    public static void main(String[] args) {
        double x = 2.00000;
        int n = 10;

        double result = myPow(x, n);

        System.out.println(result);
    }
}

/*
LeetCode No => 50
Time Complexity => O(log N)
Space Complexity => O(log N)  (recursion stack)

Output:
1024.0


Companies that asked this question:
Adobe, Amazon, Apple, Asana, Bloomberg, Facebook (Meta), Goldman Sachs, Google, LinkedIn, Microsoft, Morgan Stanley, Oracle, Uber, Walmart Labs
*/