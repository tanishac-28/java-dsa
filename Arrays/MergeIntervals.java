package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
 * Problem Statement:
 * Given an array of intervals where intervals[i] = [start_i, end_i], merge
 * all overlapping intervals, and return an array of the non-overlapping
 * intervals that cover all the intervals in the input.
 *
 * Example:
 * Input: intervals = [[1, 3], [2, 6], [8, 10], [15, 18]]
 * Output: [[1, 6], [8, 10], [15, 18]]
 * Explanation: Since intervals [1, 3] and [2, 6] overlap, merge them into
 * [1, 6].
 *
 * Approach: Sorting + Linear Scan
 * - Sort the intervals by their start time, so the intervals that can
 *   overlap come next to each other.
 * - Keep the last interval added to the result (newInterval).
 * - For every interval, if its start is <= the end of newInterval, they
 *   overlap, so extend the end: newInterval[1] = max(both ends).
 * - Otherwise there is no overlap, so this interval becomes the new
 *   newInterval and is added to the result.
 * - If there is only one interval (or none), return it as it is.
 */

public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        // Sort by start time
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

        List<int[]> result = new ArrayList<>();

        int[] newInterval = intervals[0];
        result.add(newInterval);

        for (int[] interval : intervals) {
            if (interval[0] <= newInterval[1]) {
                // Overlapping, so extend the end of the current interval
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            } else {
                // No overlap, start a new interval
                newInterval = interval;
                result.add(newInterval);
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    // Driver code: sample input values to test the solution
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};

        int[][] result = merge(intervals);

        System.out.println(Arrays.deepToString(result));
    }
}

/*
LeetCode No => 56
Time Complexity => O(N log N)
Space Complexity => O(N)

Output:
[[1, 6], [8, 10], [15, 18]]


Companies that asked this question:
Facebook (Meta), Amazon, Google, Microsoft, Bloomberg, Apple, Uber, Airbnb
*/