package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * Problem Statement:
 * Given an ascending sorted rotated array nums of distinct integers, find the number of times 
 * the array is rotated. The number of rotations is equal to the index of the minimum element 
 * in the array.
 *
 * Example:
 * Input: nums = [4, 5, 6, 7, 0, 1, 2, 3]
 * Output: 4
 * Explanation: The original sorted array was [0, 1, 2, 3, 4, 5, 6, 7] and it was rotated 4 times.
 *
 * Approach: Binary Search
 * - The number of rotations is exactly the index of the minimum element in the array.
 * - Use binary search with low = 0 and high = n - 1. Track the minimum value found so far (`ans`) and its `index`.
 * - If the current search space from `low` to `high` is already sorted (`nums.get(low) <= nums.get(high)`), 
 *   the minimum element in this range is at `low`. Update `index` if needed and break early.
 * - Otherwise, check which half is sorted:
 *   - If the left half is sorted (`nums.get(low) <= nums.get(mid)`), the minimum element of this half is at `low`. 
 *     Update `index` and search the right half (`low = mid + 1`).
 *   - If the right half is sorted, the minimum element of this half is at `mid`. 
 *     Update `index` and search the left half (`high = mid - 1`).
 */

public class FindKRotation {
    public static int findKRotation(ArrayList<Integer> nums) {
        int n = nums.size();
        int low = 0;
        int high = n - 1;
        int ans = Integer.MAX_VALUE;
        int index = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // If the search space is already sorted
            if (nums.get(low) <= nums.get(high)) {
                if (nums.get(low) < ans) {
                    index = low;
                    ans = nums.get(low);
                }
                break;
            }

            // If the left half is sorted
            if (nums.get(low) <= nums.get(mid)) {
                if (nums.get(low) < ans) {
                    index = low;
                    ans = nums.get(low);
                }
                low = mid + 1;
            } 
            // If the right half is sorted
            else {
                if (nums.get(mid) < ans) {
                    index = mid;
                    ans = nums.get(mid);
                }
                high = mid - 1;
            }
        }
        return index;
    }

    // Driver code: sample input values to test the solution
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(4, 5, 6, 7, 0, 1, 2, 3));

        int result = findKRotation(nums);

        System.out.println(result);
    }
}

/*
GFG Problem => Find Kth Rotation / Find no of rotations
Time Complexity => O(log N)
Space Complexity => O(1)

Output:
4


Companies that asked this question:
Amazon, Flipkart, Microsoft, Adobe
*/
