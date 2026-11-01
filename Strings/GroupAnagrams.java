package Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Problem Statement:
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, 
 * typically using all the original letters exactly once.
 *
 * Example:
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 * Approach: Frequency Counting with HashMap
 * - Create a HashMap where the key is a unique string representation of the character frequencies, 
 *   and the value is a list of strings that match this frequency configuration.
 * - Iterate through each word in the given array `strs`:
 *   - Create a frequency array of size 26 to count the occurrences of each character in the current word.
 *   - Convert this frequency array into a unique string key using `Arrays.toString(count)`.
 *   - If this key is not already present in the map, initialize a new ArrayList for it.
 *   - Append the original word to the list corresponding to its frequency key.
 * - Return a new ArrayList containing all the grouped values from the map (`map.values()`).
 */

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            String word = strs[i];
            int[] count = new int[26];

            // Count occurrences of each character in the word
            for (int j = 0; j < word.length(); j++) {
                count[word.charAt(j) - 'a']++;
            }

            // Generate a unique key for the map from the frequency array
            String key = Arrays.toString(count);

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(word);
        }
        return new ArrayList<>(map.values());
    }

    // Driver code: sample input values to test the solution
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> result = groupAnagrams(strs);

        System.out.println(result);
    }
}

/*
LeetCode Problem => 49. Group Anagrams
Time Complexity => O(N * K) where N is number of strings and K is max length of a string
Space Complexity => O(N * K) to store the groups in the hashmap

Output:
[[eat, tea, ate], [bat], [tan, nat]]


Companies that asked this question:
Amazon, Microsoft, Meta (Facebook), Google, Bloomberg, Oracle, Expedia, Visa, Goldman Sachs, Wayfair, Agoda, TripAdvisor, Hertz, Walmart, Confluent, Fidelity Investments, Morgan Stanley, Directi, Toptal, N26, Glovo, Mercari, Canva, MathWorks, Grab, Foodpanda, TikTok, Coda Payments.
 */
