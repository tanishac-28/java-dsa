package Strings;

/*
 * Problem Statement:
 * Given a string s, return the number of palindromic substrings in it.
 * A string is a palindrome when it reads the same backward as forward.
 * A substring is a contiguous sequence of characters within the string.
 *
 * Example:
 * Input: s = "aaa"
 * Output: 6
 * Explanation: Six palindromic substrings: "a", "a", "a", "aa", "aa", "aaa".
 *
 * Approach: Expand Around Center
 * - Similar to finding the longest palindromic substring, we choose every possible center.
 * - For a string of length N, there are 2N - 1 possible centers (individual characters and pairs between characters).
 * - Iterate through each index `i` as the potential center:
 *   - Count odd-length palindromes using `expand(s, i, i)`.
 *   - Count even-length palindromes using `expand(s, i, i + 1)`.
 * - In the helper `expand` function, increment `counnt` each time a matching boundary is found, 
 *   then move the pointers outward (`left--`, `right++`).
 * - Accumulate all counts to get the final result.
 */

public class PalindromicSubstrings {
    public static int countSubstrings(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            // Count odd-length palindromes centered at i
            count += expand(s, i, i);
            // Count even-length palindromes centered between i and i+1
            count += expand(s, i, i + 1);
        }   
        return count;
    }

    // Helper method to expand outwards and count valid palindromes
    private static int expand(String s, int left, int right) {
        int counnt = 0;

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            counnt++;
            right++;
            left--;
        }
        return counnt;
    }

    // Driver code: sample input values to test the solution
    public static void main(String[] args) {
        String s = "aaa";

        int result = countSubstrings(s);

        System.out.println(result);
    }
}

/*
LeetCode Problem => 647. Palindromic Substrings
Time Complexity => O(N^2)
Space Complexity => O(1)

Output:
6


Companies that asked this question:
Adobe, Amazon, Apple, Atlassian, Citadel, Coursera, Facebook (Meta), Google, LinkedIn, Mathworks, Microsoft, Pure Storage, SAP, Twitter (X), Uber, VMware
*/
