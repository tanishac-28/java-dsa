package BinarySearch;

/*
 * Problem Statement:
 * Given a rotated sorted array nums[] of distinct integers and a target value, 
 * return the index of the target if it is in the array, or -1 if it is not in the array.
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * Example:
 * Input: nums =, target = 0
 * Output: 4
 * Explanation: The element 0 is present at index 4 in the rotated array.
 *
 * Approach: Binary Search (Rotated Array Strategy)
 * - Since the array is rotated, at any given mid, at least one half (left or right) will always be strictly sorted.
 * - Identify which half is sorted:
 *   - If nums[low] <= nums[mid], the left half is sorted. Check if the target falls within this range.
 *     If yes, narrow down to the left side (high = mid - 1); otherwise, move to the right side (low = mid + 1).
 *   - Else, the right half must be sorted. Check if the target falls within this range.
 *     If yes, narrow down to the right side (low = mid + 1); otherwise, move to the left side (high = mid - 1).
 * - If nums[mid] == target at any point, return mid. Return -1 if the loop finishes without finding it.
 */

public class SearchInRotatedSortedArray {
    public static int search(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // Check if the left half is sorted
            if (nums[mid] >= nums[low]) {
                // Target lies within the sorted left half
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } 
            // Otherwise, the right half must be sorted
            else {
                // Target lies within the sorted right half
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    // Driver code: sample input values to test the solution
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;

        int result = search(nums, target);

        System.out.println(result);
    }
}

/*
LeetCode Problem => 33. Search in Rotated Sorted Array
Time Complexity => O(log N)
Space Complexity => O(1)

Output:
4


Companies that asked this question:
Adobe, Alibaba, Amazon, Apple, Baidu, Bloomberg, ByteDance, Cisco, eBay, Expedia, Facebook, Goldman Sachs, Google, LinkedIn, Microsoft, NetEase, Nutanix, Nvidia, Oracle, Samsung, Snapchat, Tencent, Tesla, TripAdvisor, Twitch, Uber, Visa, VMware, Walmart Labs, Yahoo, Zillow, Zulily
*/
