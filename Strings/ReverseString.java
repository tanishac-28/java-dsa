package Strings;

/*
 * Problem Statement:
 * Write a function that reverses a string. The input string is given as an array 
 * of characters s. You must do this by modifying the input array in-place with 
 * O(1) extra memory.
 *
 * Example:
 * Input: s = ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 * Explanation: The characters are reversed in place.
 *
 * Approach: Two Pointers
 * - Initialize two pointers: left at the beginning (0) and right at the end (n - 1) of the character array.
 * - Swap the characters at the left and right positions.
 * - Move the left pointer one step forward (left++) and the right pointer one step backward (right--).
 * - Continue this process until the left pointer crosses or meets the right pointer.
 */

public class ReverseString {
    public static void reverseString(char[] s) {
        int n = s.length;
        int left = 0;
        int right = n - 1;

        while (left < right) {
            // Swap characters in place
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }
    }

    // Driver code: sample input values to test the solution
    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};

        reverseString(s);

        System.out.println(java.util.Arrays.toString(s));
    }
}

/*
LeetCode Problem => 344. Reverse String
Time Complexity => O(N)
Space Complexity => O(1)

Output:
[o, l, l, e, h]


Companies that asked this question:
Adobe • Amazon • Apple • Cisco • Facebook (Meta) • Google • Microsoft • Netflix • Oracle • Nvidia • Bloomberg • Uber
*/
