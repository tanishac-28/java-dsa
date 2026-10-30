package BinarySearch;

/*
 * Problem Statement:
 * Given a non-negative integer x, return the square root of x rounded down
 * to the nearest integer. The returned integer should be non-negative as
 * well.
 * You must not use any built-in exponent function or operator.
 * (For example, do not use pow(x, 0.5) in C++ or x ** 0.5 in Python.)
 *
 * Example:
 * Input: x = 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since we round it
 * down to the nearest integer, 2 is returned.
 *
 * Approach: Binary Search on the answer
 * - The answer lies between 1 and x, and squares increase as the number
 *   increases, so we can use binary search.
 * - If x < 2, the square root is x itself (0 or 1), so return x.
 * - Take mid and find its square. If mid * mid == x, mid is the answer.
 * - If mid * mid < x, mid could be the answer, but a bigger value may also
 *   work, so search in the right half (low = mid + 1).
 * - Otherwise mid is too big, so search in the left half (high = mid - 1).
 * - Use long for mid * mid, because the square of a large int can overflow.
 * - When the loop ends, high points to the largest number whose square is
 *   less than x, which is the rounded down square root.
 */

public class SqrtX {
    public static int mySqrt(int x) {
        if (x < 2) {
            return x;
        }

        long low = 1;
        long high = x;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            long square = mid * mid;

            if (square == x) {
                return (int) mid;
            } else if (square < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        // high is the floor of the square root
        return (int) high;
    }

    // Driver code: sample input values to test the solution
    public static void main(String[] args) {
        int x = 8;

        int result = mySqrt(x);

        System.out.println(result);
    }
}

/*
LeetCode No => 69
Time Complexity => O(log X)
Space Complexity => O(1)

Output:
2


Companies that asked this question:
Amazon, Apple, Bloomberg, Facebook (Meta), Google, LinkedIn, Lyft, Microsoft, Qualtrics, Uber, Wayfair
*/