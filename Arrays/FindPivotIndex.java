package Arrays;

/*
 * Problem Statement:
 * Given an array of integers nums, calculate the pivot index of this array.
 * The pivot index is the index where the sum of all the numbers strictly to
 * the left of the index is equal to the sum of all the numbers strictly to
 * the index's right.
 * If the index is on the left edge of the array, then the left sum is 0
 * because there are no elements to the left. This also applies to the right
 * edge of the array.
 * Return the leftmost pivot index. If no such index exists, return -1.
 *
 * Example:
 * Input: nums = [1, 7, 3, 6, 5, 6]
 * Output: 3
 * Explanation: The pivot index is 3.
 * Left sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11
 * Right sum = nums[4] + nums[5] = 5 + 6 = 11
 *
 * Approach: Prefix Sum (running left sum)
 * - First find the total sum of the array.
 * - Keep a running leftSum, which is the sum of all elements before index i.
 * - For every index i, the right sum is totalSum - leftSum - nums[i].
 * - If leftSum == rightSum, then i is the pivot index, so return it.
 * - Otherwise add nums[i] to leftSum and move ahead.
 * - If no index matches, return -1.
 */

public class FindPivotIndex {
    public static int pivotIndex(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum = totalSum + nums[i];
        }
        int leftSum = 0;

        for (int i = 0; i < n; i++) {
            // Sum of all elements to the right of index i
            int rightSum = totalSum - leftSum - nums[i];

            if (leftSum == rightSum) {
                return i;
            }
            leftSum = leftSum + nums[i];
        }
        return -1;
    }

    // Driver code: sample input values to test the solution
    public static void main(String[] args) {
        int[] nums = {1, 7, 3, 6, 5, 6};

        int result = pivotIndex(nums);

        System.out.println(result);
    }
}

/*
LeetCode No => 724
Time Complexity => O(N)
Space Complexity => O(1)

Output:
3


Companies that asked this question:
Amazon, Google , Apple, Microsoft, Meta, LinkedIn, Bloomberg, Goldman Sachs, IBM, Salesforce, Expedia, Myntra, Ola, Agoda, Accenture
*/