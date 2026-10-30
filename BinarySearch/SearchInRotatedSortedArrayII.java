package BinarySearch;

/*
 * Problem Statement:
 * Given a rotated sorted array nums[] that may contain duplicates and a target value,
 * return true if the target is in the array, or false if it is not in the array.
 * This is an extension of the search in rotated sorted array problem where elements are not distinct.
 *
 * Example:
 * Input: nums =, target = 0
 * Output: true
 * Explanation: The element 0 is present in the rotated sorted array.
 *
 * Approach: Binary Search (Handling Duplicates)
 * - Since the array contains duplicates, we can encounter a scenario where nums[low] == nums[mid] == nums[high].
 *   In this case, we cannot confidently determine which half is fully sorted.
 * - To handle this edge case, we simply shrink our search space from both ends by doing low++ and high--,
 *   then continue to the next iteration.
 * - For all other cases, we follow the same logic as Rotated Sorted Array I:
 *   - Identify if the left half or right half is sorted.
 *   - Check if the target falls within the boundary of that sorted half to adjust low or high.
 * - Return true if target is found, otherwise return false.
 */

public class SearchInRotatedSortedArrayII {
    public static boolean search(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return true;
            }

            // Edge case: when duplicates make it impossible to identify the sorted half
            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low++;
                high--;
                continue;
            }

            // Check if the left half is sorted
            if (nums[low] <= nums[mid]) {
                // Target lies within the sorted left half
                if (nums[low] <= target && target <= nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } 
            // Otherwise, the right half must be sorted
            else {
                // Target lies within the sorted right half
                if (nums[mid] <= target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return false;
    }

    // Driver code: sample input values to test the solution
    public static void main(String[] args) {
        int[] nums = {2, 5, 6, 0, 0, 1, 2};
        int target = 0;

        boolean result = search(nums, target);

        System.out.println(result);
    }
}

/*
LeetCode Problem => 81. Search in Rotated Sorted Array II
Time Complexity => O(log N) on average, O(N) in worst case (when all elements are identical)
Space Complexity => O(1)

Output:
true


Companies that asked this question:
Meta, Amazon, Microsoft, Google, Adobe, TikTok.
*/
