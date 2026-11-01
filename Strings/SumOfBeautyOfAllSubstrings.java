package Strings;

/*
 * Problem Statement:
 * The beauty of a string is the difference between the frequency of the most frequent character 
 * and the frequency of the least frequent character.
 * Given a string s, return the sum of beauty of all its substrings.
 *
 * Example:
 * Input: s = "aabcb"
 * Output: 5
 * Explanation: The substrings with non-zero beauty are ["aab","aabc","aabcb","abcb","bcb"], 
 * and the sum of their beauties is 1 + 1 + 1 + 1 + 1 = 5.
 *
 * Approach: Nested Loops with Frequency Tracking
 * - Use an outer loop with pointer `i` to fix the starting index of the substring.
 * - For each starting index, maintain a frequency array `freq` of size 26 to count characters dynamically.
 * - Use an inner loop with pointer `j` to expand the substring rightwards from `i` to `n-1`.
 * - In each step of expansion, increment the frequency of the character at `s.charAt(j)`.
 * - Find the maximum (`max`) and minimum (`min`) non-zero frequencies from the tracking array.
 * - Calculate the beauty score as `(max - min)` and add it to the running cumulative sum.
 */

public class SumOfBeautyOfAllSubstrings {
    public static int beautySum(String s) {
        int sum = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            int[] freq = new int[26];

            for (int j = i; j < n; j++) {
                // Add current character to frequency map
                freq[s.charAt(j) - 'a']++;

                int max = 0;
                int min = Integer.MAX_VALUE;

                // Find maximum and minimum non-zero frequencies
                for (int k = 0; k < 26; k++) {
                    if (freq[k] > 0) {
                        max = Math.max(max, freq[k]);
                        min = Math.min(min, freq[k]);
                    }
                }

                sum += (max - min);
            }
        }

        return sum;
    }

    // Driver code: sample input values to test the solution
    public static void main(String[] args) {
        String s = "aabcb";

        int result = beautySum(s);

        System.out.println(result);
    }
}

/*
LeetCode Problem => 1781. Sum of Beauty of All Substrings
Time Complexity => O(N^2 * 26) = O(N^2)
Space Complexity => O(1) (Since size of frequency array is fixed to 26)

Output:
5


Companies that asked this question:
Amazon, Google, Microsoft, Adobe, and Uber.
*/
