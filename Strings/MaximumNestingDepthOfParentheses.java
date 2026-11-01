package Strings;

/*
 * Problem Statement:
 * Given a valid parentheses string s, return the maximum nesting depth of s.
 * The nesting depth of a string can be calculated based on the maximum number of 
 * consecutive open parentheses '(' that are not closed yet.
 *
 * Example:
 * Input: s = "(1+(2*3)+((8)/4))+1"
 * Output: 3
 * Explanation: Digit 8 is inside 3 nested parentheses in the string.
 *
 * Approach: Counter / Depth Tracking
 * - Initialize two variables: `depth` to track the current nesting level and `maxDepth` to store the maximum nesting depth encountered so far.
 * - Iterate through the string character by character:
 *   - If the character is '(', increment the `depth` counter, and then update `maxDepth` by comparing it with the current `depth`.
 *   - If the character is ')', decrement the `depth` counter since one level of nesting is closed.
 * - Non-parentheses characters are simply ignored as they don't affect the nesting depth.
 * - Return `maxDepth`.
 */

public class MaximumNestingDepthOfParentheses {
    public static int maxDepth(String s) {
        int depth = 0;
        int maxDepth = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // Increment depth on encountering an opening parenthesis
            if (c == '(') {
                depth++;
                maxDepth = Math.max(depth, maxDepth);
            }
            // Decrement depth on encountering a closing parenthesis
            else if (c == ')') {
                depth--;
            }
        }
        return maxDepth;
    }

    // Driver code: sample input values to test the solution
    public static void main(String[] args) {
        String s = "(1+(2*3)+((8)/4))+1";

        int result = maxDepth(s);

        System.out.println(result);
    }
}

/*
LeetCode Problem => 1614. Maximum Nesting Depth of the Parentheses
Time Complexity => O(N) where N is the length of the string
Space Complexity => O(1)

Output:
3


Companies that asked this question:
Intel, Meta, Amazon, Bloomberg, Microsoft, Google
*/
