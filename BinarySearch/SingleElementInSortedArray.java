package BinarySearch;

/*
 * Problem Statement:
 * Given a sorted array nums[] where every element appears exactly twice, except for one
 * element which appears exactly once. Find and return the single element that appears only once.
 * Your solution must run in O(log n) time and O(1) space.
 *
 * Example:
 * Input: nums = [1, 1, 2, 3, 3, 4, 4, 8, 8]
 * Output: 2
 * Explanation: The element 2 appears only once in the sorted array.
 *
 * Approach: Binary Search (Even-Odd Index Pattern)
 * - If the array has only 1 element, return it immediately.
 * - Use binary search with start = 0 and end = n - 1.
 * - At any mid, check boundary conditions (mid == 0 or mid == n-1) and check if nums[mid] 
 *   is unique by comparing it with its adjacent neighbors (nums[mid-1] and nums[mid+1]).
 * - If not found, use the indexing property of duplicates before and after the single element:
 *   - Before the single element, duplicates appear at (even, odd) index pairs.
 *   - After the single element, duplicates appear at (odd, even) index pairs.
 * - If mid is even:
 *   - If nums[mid-1] == nums[mid], we are in the right half, so search left (end = mid - 1).
 *   - Otherwise, we are in the left half, so search right (start = mid + 1).
 * - If mid is odd:
 *   - If nums[mid-1] == nums[mid], we are in the left half, so search right (start = mid + 1).
 *   - Otherwise, we are in the right half, so search left (end = mid - 1).
 */

public class SingleElementInSortedArray {
    public static int singleNonDuplicate(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        int start = 0, end = n - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // Check boundary conditions and unique element criteria
            if (mid == 0 && nums[0] != nums[1]) {
                return nums[mid];
            }
            if (mid == n - 1 && nums[n - 1] != nums[n - 2]) {
                return nums[mid];
            }
            if (mid > 0 && mid < n - 1 && nums[mid - 1] != nums[mid] && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            }

            // Even-Odd Index Logic
            if (mid % 2 == 0) {
                if (nums[mid - 1] == nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (nums[mid - 1] == nums[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    // Driver code: sample input values to test the solution
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3, 3, 4, 4, 8, 8};

        int result = singleNonDuplicate(nums);

        System.out.println(result);
    }
}

/*
LeetCode Problem => 540. Single Element in a Sorted Array
Time Complexity => O(log N)
Space Complexity => O(1)

Output:
2


Companies that asked this question:
Facebook | Google | Amazon | Microsoft | Adobe | Apple | Netflix | LinkedIn | NVIDIA | Palo Alto Networks | D.E. Shaw | Flipkart
*/
