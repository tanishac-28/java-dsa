package BinarySearch;

/*
 * Problem Statement:
 * A peak element is an element that is strictly greater than its neighbors.
 * Given a 0-indexed integer array nums, find a peak element, and return its index. 
 * If the array contains multiple peaks, return the index to any of the peaks.
 * You may imagine that nums[-1] = nums[n] = -∞.
 * You must write an algorithm that runs in O(log n) time.
 *
 * Example:
 * Input: nums = [1, 2, 3, 1]
 * Output: 2
 * Explanation: 3 is a peak element and its index is 2.
 *
 * Approach: Binary Search (Peak Elimination / Slope Strategy)
 * - Handle edge cases for arrays of size 1, or when the peak is at the boundaries (index 0 or n-1).
 * - Initialize low = 1 and high = n - 2 to safely check neighbors without running out of bounds.
 * - At any mid:
 *   - If nums[mid] > nums[mid-1] and nums[mid] > nums[mid+1], then mid is a peak, return it.
 *   - If nums[mid] > nums[mid-1], it means we are on an increasing slope, so a peak must exist 
 *     on the right side (low = mid + 1).
 *   - Otherwise, we are on a decreasing slope, meaning a peak must exist on the left side (high = mid - 1).
 */

public class FindPeakElement {
    public static int findPeakElement(int[] nums) {
        int n = nums.length;
        
        // Edge cases
        if (n == 1) {
            return 0;
        }
        if (nums[0] > nums[1]) {
            return 0;
        }
        if (nums[n - 1] > nums[n - 2]) {
            return n - 1;
        }

        int low = 1; 
        int high = n - 2;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Check if mid is the peak element
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            // If we are on the increasing slope, move right
            else if (nums[mid] > nums[mid - 1]) {
                low = mid + 1;
            }
            // If we are on the decreasing slope, move left
            else {
                high = mid - 1;
            }
        }
        return -1;
    }

    // Driver code: sample input values to test the solution
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};

        int result = findPeakElement(nums);

        System.out.println(result);
    }
}

/*
LeetCode Problem => 162. Find Peak Element
Time Complexity => O(log N)
Space Complexity => O(1)

Output:
2


Companies that asked this question:
Meta (Facebook) | Google | Amazon | Microsoft | Apple | Uber | Goldman Sachs | Bloomberg | Adobe | Snapchat
*/
