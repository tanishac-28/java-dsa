package BinarySearch;

/*
 * Problem Statement:
 * Given 2 integers A and B and an array of integers C of size N. Element
 * C[i] represents the length of the i-th board.
 * You have to paint all N boards [C0, C1, C2, ..., CN-1]. There are A
 * painters available and each of them takes B units of time to paint 1 unit
 * of board.
 * Calculate and return the minimum time required to paint all boards under
 * the constraints that any painter will only paint contiguous sections of
 * boards, and a board cannot be painted partially by one painter and
 * partially by another.
 * Return the answer % 10000003.
 *
 * Example:
 * Input: A = 2, B = 5, C = [1, 10]
 * Output: 50
 * Explanation: The first painter paints board [1] and the second painter
 * paints board [10]. The longest work is 10 units, and 10 * 5 = 50.
 *
 * Approach: Binary Search on the answer
 * - First find the maximum length of boards a single painter can get
 *   (like the Allocate Pages / Split Array problem), then multiply it by B
 *   at the end.
 * - The answer lies between max(C) and sum(C). max(C) is needed because one
 *   board cannot be split, and with one painter he paints everything.
 * - If a limit maxAllowedLen works, any bigger limit also works, so the
 *   answer space is sorted (false ... false true ... true).
 * - Take mid as the limit and check it with isPossible(): give boards to
 *   the current painter while the length stays within mid, otherwise give
 *   the board to a new painter. Count the painters needed.
 * - If the painters needed <= A, store ans = mid and try a smaller limit
 *   (high = mid - 1). Otherwise increase the limit (low = mid + 1).
 * - Return (ans * B) % 10000003. Use long, since ans * B can be large.
 */

public class PaintersPartitionProblem {
    public static int paint(int A, int B, int[] C) {
        int n = C.length;
        long sum = 0;
        long max = 0;

        for (int i = 0; i < n; i++) {
            sum += C[i];
            max = Math.max(max, C[i]);
        }

        long low = max;
        long high = sum;
        long ans = -1;

        while (low <= high) {
            long mid = low + (high - low) / 2;

            if (isPossible(C, A, mid)) {
                // Works, try a smaller maximum length
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return (int) ((ans * B) % 10000003);
    }

    // Checks if the boards can be painted by at most A painters
    // such that no painter paints more than maxAllowedLen units
    private static boolean isPossible(int[] C, int A, long maxAllowedLen) {
        int painter = 1;
        long len = 0;

        for (int i = 0; i < C.length; i++) {
            if (len + C[i] <= maxAllowedLen) {
                len += C[i];
            } else {
                // Give this board to a new painter
                painter++;
                len = C[i];
            }
        }
        return painter <= A;
    }

    // Driver code: sample input values to test the solution
    public static void main(String[] args) {
        int A = 2;
        int B = 5;
        int[] C = {1, 10};

        int result = paint(A, B, C);

        System.out.println(result);
    }
}

/*
InterviewBit Problem => Painter's Partition Problem (not a LeetCode problem)
Time Complexity => O(N * log(sum(C)))
Space Complexity => O(1)

Output:
50


Companies that asked this question:
OYO, HSBC, PayPal, Arcesium
*/