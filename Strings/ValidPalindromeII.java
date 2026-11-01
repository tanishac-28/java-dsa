package Strings;

/*
 * Problem Statement:
 * Given a string s, return true if the s can be palindrome after deleting at most one character from it.
 *
 * Example:
 * Input: s = "abca"
 * Output: true
 * Explanation: You could delete the character 'c' or 'b' to make it a palindrome ("aba" or "aca").
 *
 * Approach: Two Pointers (Greedy Check on First Mismatch)
 * - Initialize two pointers: left at index 0 and right at index s.length() - 1.
 * - Loop while left < right:
 *   - If characters at left and right match, simply move both pointers closer to the center (left++, right--).
 *   - If a mismatch is encountered (s.charAt(left) != s.charAt(right)), we have two choices to try deleting one character:
 *     1. Skip the left character and check if the remaining substring from left + 1 to right is a palindrome.
 *     2. Skip the right character and check if the remaining substring from left to right - 1 is a palindrome.
 * - Use a helper function `isPalindrome` to check these inner substrings. If either choice returns true, the main function returns true.
 * - If the loop completes without a mismatch, the string is already a palindrome, so return true.
 */

public class ValidPalindromeII {
    public static boolean validPalindrome(String s) {
        int left = 0; 
        int right = s.length() - 1;

        while (left < right) {
            // Mismatch found, try deleting at most one character
            if (s.charAt(left) != s.charAt(right)) {
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            } else {
                left++;
                right--;
            }
        }
        return true;
    }

    // Helper method to validate a standard palindrome within specific boundaries
    private static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }

    // Driver code: sample input values to test the solution
    public static void main(String[] args) {
        String s = "abca";

        boolean result = validPalindrome(s);

        System.out.println(result);
    }
}

/*
LeetCode Problem => 680. Valid Palindrome II
Time Complexity => O(N)
Space Complexity => O(1)

Output:
true


Companies that asked this question:
Meta (Facebook), Microsoft, Google, Atlassian, Yahoo, Amazon, Apple, Uber.
*/
