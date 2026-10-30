package BinarySearch;

/*
 * Problem Statement:
 * Suppose an array of length n sorted in ascending order is rotated between 1 and n times.
 * Given the sorted rotated array nums of unique elements, return the minimum element of this array.
 * You must write an algorithm that runs in O(log n) time.
 *
 * Example:
 * Input: nums = [3, 4, 5, 1, 2]
 * Output: 1
 * Explanation: The original array was [1, 2, 3, 4, 5] rotated 3 times.
 *
 * Approach: Binary Search
 * - Use binary search with low = 0 and high = n - 1.
 * - Loop continues while low < high (instead of low <= high because we are narrowing down to a single element).
 * - Check if nums[mid] <= nums[high]:
 *   - If true, it means the right half is sorted, and the minimum element could be nums[mid] itself 
 *     or lies to its left. So, we shrink our search space to high = mid.
 *   - Otherwise, the left half is sorted, and the inflection point (minimum element) must be on 
 *     the right side. So, we set low = mid + 1.
 * - When the loop terminates, low will point directly to the minimum element.
 */

public class FindMinimumInRotatedSortedArray {
    public static int findMin(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] <= nums[high]) {
                // Minimum element could be mid or to the left of mid
                high = mid;
            } else {
                // Minimum element must be to the right of mid
                low = mid + 1;
            }
        }
        return nums[low];
    }

    // Driver code: sample input values to test the solution
    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 1, 2};

        int result = findMin(nums);

        System.out.println(result);
    }
}

/*
LeetCode Problem => 153. Find Minimum in Rotated Sorted Array
Time Complexity => O(log N)
Space Complexity => O(1)

Output:
1


Companies that asked this question:
Adobe / Amazon / Apple / Bloomberg / Facebook (Meta) / Goldman Sachs / Google / LinkedIn / Microsoft / Morgan Stanley / Salesforce / TikTok / Uber / VMware / Walmart Labs
*/
