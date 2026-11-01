package Strings;

/*
 * Problem Statement:
 * Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer 
 * (similar to C/C++'s atoi function).
 * The algorithm must handle leading whitespaces, an optional sign ('+' or '-'), digit conversion, 
 * and clamp the integer if it goes out of the 32-bit signed integer range [-2^31, 2^31 - 1].
 *
 * Example:
 * Input: s = "   -042"
 * Output: -42
 * Explanation: The first non-whitespace character is '-', which is the minus sign. Then the digits
 * are read, skipping leading zeros.
 *
 * Approach: Linear Scan with Boundary Checking
 * - Handle empty or null strings early.
 * - Skip any leading white spaces using a pointer `i`.
 * - Check if the next character is a sign ('+' or '-') and set the `sign` variable accordingly.
 * - Traverse the string while characters are digits:
 *   - Convert the character to its numeric value and append it to `result`.
 *   - Check overflow/underflow dynamically at each step. If `sign * result` crosses `Integer.MAX_VALUE` 
 *     or `Integer.MIN_VALUE`, return the respective boundary limit immediately.
 * - Finally, return the truncated integer representation.
 */

public class StringToIntegerAtoi {
    public static int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        final int max = Integer.MAX_VALUE;
        final int min = Integer.MIN_VALUE;

        int i = 0; 
        int n = s.length();

        // Skip leading whitespaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }
        
        if (i == n) {
            return 0;
        }

        // Check for an optional sign symbol
        int sign = 1;
        if (s.charAt(i) == '+') {
            i++;
        } else if (s.charAt(i) == '-') {
            sign = -1;
            i++;
        }

        long result = 0;
        // Convert valid digits and handle potential arithmetic overflow
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';
            result = result * 10 + digit;

            if (sign * result <= min) {
                return min;
            }
            if (sign * result >= max) {
                return max;
            }
            i++;
        }
        return (int) (result * sign);
    }

    // Driver code: sample input values to test the solution
    public static void main(String[] args) {
        String s = "   -042";

        int result = myAtoi(s);

        System.out.println(result);
    }
}

/*
LeetCode Problem => 8. String to Integer (atoi)
Time Complexity => O(N) where N is the length of the string
Space Complexity => O(1)

Output:
-42


Companies that asked this question:
Adobe, Amazon, Apple, Bloomberg, Cisco, Databricks, eBay, Facebook (Meta), Goldman Sachs, Google, LinkedIn, Microsoft, Netflix, Nvidia, Qualcomm, Redfin, SAP, Tencent, Uber, and Zillow
*/
