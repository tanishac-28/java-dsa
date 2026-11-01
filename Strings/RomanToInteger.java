package Strings;

import java.util.HashMap;
import java.util.Map;

/*
 * Problem Statement:
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * Given a roman numeral string s, convert it to an integer.
 *
 * Example:
 * Input: s = "LVIII"
 * Output: 58
 * Explanation: L = 50, V = 5, III = 3.
 *
 * Approach: HashMap and Right-to-Left/Look-Ahead Comparison
 * - Map each Roman character to its corresponding integer value using a HashMap.
 * - Iterate through the string character by character:
 *   - Check if the value of the current character is less than the value of the next character (e.g., IV where I < V).
 *   - If it is less, subtract the current character's value from the total sum.
 *   - Otherwise, add the current character's value to the total sum.
 * - Return the accumulated total.
 */

public class RomanToInteger {
    public static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int total = 0;

        for (int i = 0; i < s.length(); i++) {
            // If current value is less than the next value, subtract it
            if (i + 1 < s.length() && map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                total -= map.get(s.charAt(i));
            } 
            // Otherwise, add it to the total
            else {
                total += map.get(s.charAt(i));
            }
        }
        return total;
    }

    // Driver code: sample input values to test the solution
    public static void main(String[] args) {
        String s = "LVIII";

        int result = romanToInt(s);

        System.out.println(result);
    }
}

/*
LeetCode Problem => 13. Roman to Integer
Time Complexity => O(N) where N is the length of the string
Space Complexity => O(1) (As the map size remains constant at 7 elements)

Output:
58


Companies that asked this question:
Adobe, Amazon, Apple, Bloomberg, Facebook (Meta), Goldman Sachs, Google, LinkedIn, Microsoft, Netflix, Oracle, Paypal, Qualtrics, Twitter (X), Uber, Yahoo, Zillow
*/
