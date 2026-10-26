package Arrays;
import java.util.Arrays;

/*
 * Problem Statement:
 * Given an array nums with n objects colored red, white, or blue, sort them
 * in-place so that objects of the same color are adjacent, with the colors
 * in the order red, white, and blue. We use the integers 0, 1, and 2 to
 * represent red, white, and blue respectively.
 *
 * Notes:
 * - You must solve this problem without using the library's sort function.
 * - Follow up: can you do it in one pass using only constant extra space?
 *
 * Example:
 * Input: nums = [2, 0, 2, 1, 1, 0]
 * Output: [0, 0, 1, 1, 2, 2]
 *
 * Approach: Dutch National Flag (3 pointers)
 * - low  -> boundary of the 0s region (next position for a 0)
 * - mid  -> current element being checked
 * - high -> boundary of the 2s region (next position for a 2)
 * - If nums[mid] == 0: swap with low, move both low and mid forward.
 * - If nums[mid] == 1: it is already in place, move mid forward.
 * - If nums[mid] == 2: swap with high, move high back
 *   (do not move mid, the swapped element is not checked yet).
 */
public class SortColors {
    public static void sortColors(int[] nums) {
        int n = nums.length;
        int low = 0;
        int mid = 0;
        int high = n - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                mid++;
                low++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
    }

    // Driver code: sample input values to test the solution
    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};

        sortColors(nums);

        System.out.println(Arrays.toString(nums));
    }
}

/*
LeetCode No => 75
Time Complexity => O(N)
Space Complexity => O(1)

Output:
[0, 0, 1, 1, 2, 2]


Companies that asked this question:
Microsoft, Amazon, Meta, Google, Apple, Adobe, Uber, Flipkart
*/