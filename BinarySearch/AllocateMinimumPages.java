package BinarySearch;

/*
 * Problem Statement:
 * You are given an array nums where nums[i] is the number of pages in the
 * i-th book, and an integer m, the number of students. Allocate all the
 * books to the students such that:
 * 1. Each student gets at least one book.
 * 2. Each book is allocated to only one student.
 * 3. Book allocation is contiguous (a student gets consecutive books).
 * Allocate the books so that the maximum number of pages assigned to a
 * student is minimum, and return that minimum value.
 * If the allocation is not possible (more students than books), return -1.
 *
 * Example:
 * Input: nums = [12, 34, 67, 90], m = 2
 * Output: 113
 * Explanation: Allocation [12, 34, 67] and [90] gives the maximum 113.
 * Other allocations like [12, 34] and [67, 90] give 157, and [12] and
 * [34, 67, 90] give 191, so the minimum possible maximum is 113.
 *
 * Approach: Binary Search on the answer
 * - If m > n, some student would get no book, so return -1.
 * - The answer (maximum pages of a student) lies between max(nums) and
 *   sum(nums). Here low starts from 0 and isValid() rejects any value less
 *   than the biggest book, so it works the same.
 * - If a limit of maxAllowedPages works, any bigger limit also works, so
 *   the answer space is sorted (false ... false true ... true).
 * - Take mid as the limit and check it with isValid(): give books to the
 *   current student while the pages stay within mid, otherwise give the
 *   book to a new student. Count the students needed.
 * - If the students needed <= m, store ans = mid and try a smaller limit
 *   (high = mid - 1). Otherwise increase the limit (low = mid + 1).
 */

public class AllocateMinimumPages {
    public static int findPages(int[] nums, int m) {
        int n = nums.length;

        // More students than books
        if (m > n) {
            return -1;
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        int ans = -1;
        int low = 0;
        int high = sum;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isValid(nums, m, mid)) {
                // Works, try a smaller maximum
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    // Checks if the books can be given to at most m students
    // so that no student gets more than maxAllowedPages
    private static boolean isValid(int[] nums, int m, int maxAllowedPages) {
        int n = nums.length;
        int student = 1;
        int pages = 0;

        for (int i = 0; i < n; i++) {
            // A single book is bigger than the limit
            if (nums[i] > maxAllowedPages) {
                return false;
            }
            if (pages + nums[i] <= maxAllowedPages) {
                pages += nums[i];
            } else {
                // Give this book to a new student
                student++;
                pages = nums[i];
            }
        }

        return student > m ? false : true;
    }

    // Driver code: sample input values to test the solution
    public static void main(String[] args) {
        int[] nums = {12, 34, 67, 90};
        int m = 2;

        int result = findPages(nums, m);

        System.out.println(result);
    }
}


/*
GFG Problem => Allocate Minimum Pages (not a LeetCode problem)
Time Complexity => O(N * log(sum(nums)))
Space Complexity => O(1)

Output:
113


Companies that asked this question:
Google, Flipkart, TCS, Adobe, Arcesium, ZS Associates, PayU, IBM
*/