package Strings;

/*
 * Problem Statement:
 * Given a string s, return the longest palindromic substring in s.
 *
 * Example:
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 *
 * Approach: Expand Around Center
 * - A palindrome symmetric structure can expand outwards from its center.
 * - There are 2N - 1 possible centers for a palindrome of length N (odd length centers like 'aba' or even length centers like 'cbbc').
 * - Iterate through each index `i` as the potential center:
 *   - Call `expand(s, i, i)` for odd-length palindromes.
 *   - Call `expand(s, i, i + 1)` for even-length palindromes.
 * - Calculate the maximum length achieved. If it's greater than the previously recorded maximum length (`end - start`), update the boundaries.
 * - Finally, return the substring bounded by `start` and `end + 1`.
 */

public class LongestPalindromicSubstring {
    public static String longestPalindrome(String s) {
        int n = s.length();
        int start = 0, end = 0;

        for (int i = 0; i < n; i++) {
            // Center element expansions
            int len1 = expand(s, i, i);
            int len2 = expand(s, i, i + 1);
            int len = Math.max(len1, len2);

            // Update indices if a longer palindrome is tracked
            if (len > (end - start)) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    // Helper method to expand outwards and count length of the matched palindrome
    private static int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    // Driver code: sample input values to test the solution
    public static void main(String[] args) {
        String s = "babad";

        String result = longestPalindrome(s);

        System.out.println(result);
    }
}

/*
LeetCode Problem => 5. Longest Palindromic Substring
Time Complexity => O(N^2)
Space Complexity => O(1)

Output:
bab


Companies that asked this question:
FAANG & Tier-1 Tech:
Amazon, Microsoft, Google, Meta (Facebook), Apple, Netflix, Uber, Salesforce, Adobe.

Top Tech & High-Growth Companies:
LinkedIn, Twitter, Bloomberg, Oracle, Cisco, Intel, Qualcomm, Nvidia, PayPal, eBay, Yahoo, SAP, IBM.

E-commerce & Payments:
Walmart, Wayfair, Goldman Sachs, JPMorgan Chase, Visa, Mastercard, Capital One.

Ride-sharing, Logistics & Travel:
Lyft, Grab, Expedia, Airbnb, Booking.com.

Gaming & Entertainment:
TikTok (ByteDance), Spotify, Electronic Arts.
*/
