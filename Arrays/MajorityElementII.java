package Arrays;

import java.util.ArrayList;
import java.util.List;

/*
 * Problem Statement:
 * Given an integer array of size n, find all elements that appear more than
 * ⌊ n / 3 ⌋ times.
 *
 * Example:
 * Input: nums = [1, 1, 1, 3, 3, 2, 2, 2]
 * Output: [1, 2]
 * Explanation: n = 8, so ⌊ n / 3 ⌋ = 2. The elements 1 and 2 appear 3 times
 * each (more than 2), while 3 appears only 2 times.
 *
 * Approach: Extended Boyer-Moore Voting Algorithm
 * - At most two elements can appear more than n / 3 times, so keep two
 *   candidates (ele1, ele2) with their counts (count1, count2).
 * - First pass: for every element
 *   - if count1 is 0 and the element is not ele2, make it the new ele1.
 *   - else if count2 is 0 and the element is not ele1, make it the new ele2.
 *   - else if it matches ele1 or ele2, increase that count.
 *   - otherwise decrease both counts (three different elements cancel out).
 * - The candidates may not be real majority elements, because the problem
 *   does not guarantee that they exist. So do a second pass to count the
 *   actual occurrences of both candidates.
 * - Add a candidate to the result only if its count is more than n / 3.
 */

public class MajorityElementII {
    public static List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int count1 = 0, count2 = 0;
        int ele1 = Integer.MIN_VALUE, ele2 = Integer.MIN_VALUE;

        // First pass: find the two candidates
        for (int i = 0; i < n; i++) {
            if (count1 == 0 && nums[i] != ele2) {
                ele1 = nums[i];
                count1 = 1;
            } else if (count2 == 0 && nums[i] != ele1) {
                ele2 = nums[i];
                count2 = 1;
            } else if (nums[i] == ele1) {
                count1++;
            } else if (nums[i] == ele2) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        // Second pass: verify the candidates
        count1 = 0;
        count2 = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == ele1) {
                count1++;
            } else if (nums[i] == ele2) {
                count2++;
            }
        }

        List<Integer> result = new ArrayList<>();

        if (count1 > n / 3) {
            result.add(ele1);
        }
        if (count2 > n / 3) {
            result.add(ele2);
        }
        return result;
    }

    // Driver code: sample input values to test the solution
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 3, 3, 2, 2, 2};

        List<Integer> result = majorityElement(nums);

        System.out.println(result);
    }
}

/*
LeetCode No => 229
Time Complexity => O(N)
Space Complexity => O(1)

Output:
[1, 2]


Companies that asked this question:
Amazon | Apple | Bloomberg | Google | Meta (Facebook) | Microsoft | Uber | Zenefits
*/