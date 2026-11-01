package Strings;

/*
 * Problem Statement:
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * An Anagram is a word or phrase formed by rearranging the letters of a different 
 * word or phrase, typically using all the original letters exactly once.
 *
 * Example:
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Explanation: Both strings contain the exact same characters with the same frequencies.
 *
 * Approach: Frequency Counting (Hash Array / Bucket Array)
 * - First, check if lengths of both strings are equal. If not, return false immediately.
 * - Create a frequency array `count` of size 26 (for lowercase English letters).
 * - Iterate through both strings simultaneously:
 *   - For every character in string `s`, increment its respective bucket index (`count[s.charAt(i) - 'a']++`).
 *   - For every character in string `t`, decrement its respective bucket index (`count[t.charAt(i) - 'a']--`).
 * - Finally, check the frequency array. If all values are 0, it means all characters matched perfectly, so return true.
 * - If any bucket value is non-zero, return false.
 */

public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        // If lengths are not equal, they cannot be anagrams
        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26];

        // Track frequencies of characters from both strings
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        // Verify if all counts are reset to zero
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }

    // Driver code: sample input values to test the solution
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";

        boolean result = isAnagram(s, t);

        System.out.println(result);
    }
}

/*
LeetCode Problem => 242. Valid Anagram
Time Complexity => O(N)
Space Complexity => O(1) (Since size of array is fixed to 26)

Output:
true


Companies that asked this question:
Google, Meta (Facebook), Amazon, Microsoft, Apple, Uber, Netflix, Twitter, Snapchat, Spotify, Bloomberg, Goldman Sachs, Adobe, Affirm, Tesla, Yahoo, BlackRock.
*/
