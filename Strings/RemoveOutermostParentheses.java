package Strings;

/*
 * Problem Statement:
 * A valid parentheses string is either empty "", "(" + A + ")", or A + B, where A and B are valid 
 * parentheses strings. A valid parentheses string s is primitive if it is nonempty, and there 
 * does not exist a way to split it into s = A + B, with A and B nonempty valid parentheses strings.
 * Given a valid parentheses string s, consider its primitive decomposition: s = P_1 + P_2 + ... + P_k, 
 * where P_i are primitive valid parentheses strings.
 * Return s after removing the outermost parentheses of every primitive string in the primitive decomposition of s.
 *
 * Example:
 * Input: s = "(()())(())"
 * Output: "()()()"
 * Explanation: 
 * The input string is "(()())(())", with primitive decomposition "(()())" + "(())".
 * After removing outer parentheses of each part, this is "()()" + "()" = "()()()".
 *
 * Approach: Counter / Depth Tracking
 * - Use a `depth` variable to track the nesting level of the parentheses.
 * - Iterate through the string character by character:
 *   - If the character is '(', it belongs to an inner primitive string only if `depth > 0`. Append it to the result in this case, then increment `depth`.
 *   - If the character is ')', decrement `depth` first. It belongs to an inner primitive string only if the updated `depth > 0`. Append it to the result in this case.
 * - This effectively skips the outermost '(' (where depth is 0) and the matching outermost ')' (where depth drops back to 0).
 */

public class RemoveOutermostParentheses {
    public static String removeOuterParentheses(String s) {
        StringBuilder res = new StringBuilder();
        int depth = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                // If depth > 0, it means this '(' is not the outermost one
                if (depth > 0) {
                    res.append(ch);
                }
                depth++;
            } else {
                depth--;
                // If depth > 0, it means this ')' is not the outermost one
                if (depth > 0) {
                    res.append(ch);
                }
            }
        }
        return res.toString();
    }

    // Driver code: sample input values to test the solution
    public static void main(String[] args) {
        String s = "(()())(())";

        String result = removeOuterParentheses(s);

        System.out.println(result);
    }
}

/*
LeetCode Problem => 1021. Remove Outermost Parentheses
Time Complexity => O(N) where N is the length of the string
Space Complexity => O(N) to store the result string in StringBuilder

Output:
()()()


Companies that asked this question:
Google / Amazon / Microsoft / Bloomberg / Meta
*/
