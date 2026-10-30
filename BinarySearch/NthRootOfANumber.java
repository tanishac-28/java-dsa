package BinarySearch;

/*
 * Problem Statement:
 * You are given 2 numbers n and m. The task is to find the nth root of m,
 * i.e. the number x such that x raised to the power n is equal to m.
 * If the nth root is not an integer, return -1.
 *
 * Example:
 * Input: n = 3, m = 27
 * Output: 3
 * Explanation: The cube root of 27 is 3, as 3 * 3 * 3 = 27.
 * (For n = 4, m = 69 the answer is -1, because there is no integer whose
 * 4th power is 69.)
 *
 * Approach: Binary Search on the answer
 * - The answer, if it exists, lies between 1 and m, and mid^n increases as
 *   mid increases, so we can use binary search.
 * - Take mid and compute mid^n (stored in a long, so it does not overflow).
 * - If mid^n == m, mid is the nth root, so return it.
 * - If mid^n > m, mid is too big, so search in the left half
 *   (high = mid - 1).
 * - Otherwise mid is too small, so search in the right half
 *   (low = mid + 1).
 * - If the search space gets empty, no integer root exists, so return -1.
 */

public class NthRootOfANumber {
    public static int NthRoot(int N, int M) {
        int low = 1;
        int high = M;

        while (low <= high) {
            int mid = (low + high) / 2;
            long ans = (long) Math.pow(mid, N);

            if (ans == M) {
                return mid;
            } else if (ans > M) {
                // mid is too big
                high = mid - 1;
            } else {
                // mid is too small
                low = mid + 1;
            }
        }
        return -1;
    }

    // Driver code: sample input values to test the solution
    public static void main(String[] args) {
        int N = 3;
        int M = 27;

        int result = NthRoot(N, M);

        System.out.println(result);
    }
}

/*
GFG Problem => Nth Root of a Number (not a LeetCode problem)
Time Complexity => O(log M * log N)  (binary search, and pow takes about log N)
Space Complexity => O(1)

Output:
3


Companies that asked this question:
Amazon, Directi, Accenture
*/
