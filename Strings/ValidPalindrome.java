package Strings;

/*
 * Problem Statement:
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters 
 * and removing all non-alphanumeric characters, it reads the same forward and backward. 
 * Alphanumeric characters include letters and numbers.
 * Given a string s, return true if it is a palindrome, or false otherwise.
 *
 * Example:
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 *
 * Approach: Two Pointers
 * - Initialize two pointers: left at index 0 and right at index s.length() - 1.
 * - Loop while left < right:
 *   - If the character at left is not a letter or digit, increment left.
 *   - Else if the character at right is not a letter or digit, decrement right.
 *   - Otherwise, both characters are alphanumeric. Convert both to lowercase and compare them.
 *     - If they are not equal, the string is not a palindrome, so return false.
 *     - If they are equal, move both pointers closer to the center (left++, right--).
 * - If the loop completes successfully, return true.
 */

public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            char l = s.charAt(left);
            char r = s.charAt(right);

            // Skip non-alphanumeric characters from the left
            if (!Character.isLetterOrDigit(l)) {
                left++;
            }
            // Skip non-alphanumeric characters from the right
            else if (!Character.isLetterOrDigit(r)) {
                right--;
            }
            // Both are alphanumeric, compare them case-insensitively
            else {
                if (Character.toLowerCase(l) != Character.toLowerCase(r)) {
                    return false;
                } else {
                    left++;
                    right--;
                }
            }
        }
        return true;
    }

    // Driver code: sample input values to test the solution
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";

        boolean result = isPalindrome(s);

        System.out.println(result);
    }
}

/*
LeetCode Problem => 125. Valid Palindrome
Time Complexity => O(N)
Space Complexity => O(1)

Output:
true


Companies that asked this question:
Altimetrik, Amazon, Apple, Axon, Bank of America, BCG, Bloomberg, Cadence, Cisco, CleverTap, Cognizant, Comcast, Deloitte, Google, Infosys, Intuit, LTIMindtree, Meta, Microsoft, Oracle, Spotify, TCS, Tiktok, Wipro, Yandex, Zoho
*/
