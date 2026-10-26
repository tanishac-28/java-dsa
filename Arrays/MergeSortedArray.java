package Arrays;
import java.util.Arrays;

/*
 * Problem Statement:
 * You are given two integer arrays nums1 and nums2, sorted in
 * non-decreasing order, and two integers m and n, representing the number
 * of elements in nums1 and nums2 respectively. Merge nums1 and nums2 into
 * a single array sorted in non-decreasing order.
 *
 * The final sorted array should not be returned by the function, but
 * instead be stored inside the array nums1. To accommodate this, nums1 has
 * a length of m + n, where the first m elements are the elements to be
 * merged and the last n elements are set to 0 and should be ignored.
 * nums2 has a length of n.
 *
 * Example:
 * Input: nums1 = [1, 2, 3, 0, 0, 0], m = 3, nums2 = [2, 5, 6], n = 3
 * Output: [1, 2, 2, 3, 5, 6]
 *
 * Approach: Two Pointers (merge from the back)
 * - The end of nums1 is empty, so fill it from the back with the larger
 *   element, which never overwrites an unread element.
 * - r1 points to the last real element of nums1, r2 to the last element
 *   of nums2, and index to the last position of nums1.
 * - Compare nums1[r1] and nums2[r2], place the larger at nums1[index],
 *   and move the pointer it came from.
 * - If one array is exhausted, copy the rest from the other.
 */
public class MergeSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int r1 = m - 1;
        int r2 = n - 1;
        int index = m + n - 1;

        while (index >= 0) {
            if (r1 >= 0 && r2 >= 0) {
                if (nums1[r1] > nums2[r2]) {
                    nums1[index] = nums1[r1];
                    r1--;
                } else {
                    nums1[index] = nums2[r2];
                    r2--;
                }
            } else if (r1 >= 0) {
                // nums2 is exhausted, copy the remaining nums1 elements
                nums1[index] = nums1[r1];
                r1--;
            } else {
                // nums1 is exhausted, copy the remaining nums2 elements
                nums1[index] = nums2[r2];
                r2--;
            }

            index--;
        }
    }

    // Driver code: sample input values to test the solution
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;

        merge(nums1, m, nums2, n);

        System.out.println(Arrays.toString(nums1));
    }
}

/*
LeetCode No => 88
Time Complexity => O(M + N)
Space Complexity => O(1)


Companies that asked this question:
Adobe, Amazon, Apple, Baidu, Bloomberg, Cisco, eBay, Expedia, Facebook (Meta),
Goldman Sachs, Google, IBM, Indeed, Intel, LinkedIn, Microsoft, Oracle,
Quip (Salesforce), Tableau, Uber, VMware, Yahoo, Yandex
*/