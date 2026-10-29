package Arrays;

/*
 * Problem Statement:
 * Given an array nums of size n, return the majority element.
 * The majority element is the element that appears more than ⌊n / 2⌋ times.
 * You may assume that the majority element always exists in the array.
 *
 * Example:
 * Input: nums = [2, 2, 1, 1, 1, 2, 2]
 * Output: 2
 * Explanation: 2 appears 4 times, which is more than 7 / 2 = 3 times.
 *
 * Approach: Boyer-Moore Voting Algorithm
 * - Keep a candidate (maj) and a count.
 * - If count is 0, pick the current element as the new candidate.
 * - If the current element is equal to the candidate, increase count,
 *   otherwise decrease count (the two different elements cancel each other).
 * - The majority element appears more than n / 2 times, so it can never be
 *   fully cancelled out by all the other elements, and it will be the
 *   candidate left at the end.
 * - This works because the problem guarantees that a majority element
 *   always exists.
 */

public class MajorityElement {
    public static int majorityElement(int[] nums) {
        int n = nums.length;
        int maj = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            // No candidate left, choose the current element
            if (count == 0) {
                maj = nums[i];
            }
            if (maj == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        return maj;
    }

    // Driver code: sample input values to test the solution
    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};

        int result = majorityElement(nums);

        System.out.println(result);
    }
}

/*
LeetCode No => 169
Time Complexity => O(N)
Space Complexity => O(1)

Output:
2


Companies that asked this question:
Amazon, Microsoft, Google, Adobe, Apple, Facebook (Meta), Bloomberg, Uber, Flipkart, Coupang, Atlassian, D-E-Shaw, Accolite, Nagarro
*/