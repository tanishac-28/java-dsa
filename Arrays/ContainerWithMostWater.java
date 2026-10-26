package Arrays;
import java.util.Arrays;

/*
 * Problem Statement:
 * You are given an integer array "height" of length n. There are n vertical
 * lines drawn such that the two endpoints of the i-th line are (i, 0) and
 * (i, height[i]). Find two lines that, together with the x-axis, form a
 * container such that the container holds the most water. Return the
 * maximum amount of water a container can store.
 *
 * Notes:
 * - You may not slant the container.
 *
 * Example:
 * Input: height = [1, 8, 6, 2, 5, 4, 8, 3, 7]
 * Output: 49
 *
 * Approach: Two Pointers
 * - Start with the widest container (left = 0, right = n - 1).
 * - Area = width * min(height[left], height[right]).
 * - The shorter line limits the height, so move the pointer at the
 *   shorter line inward, hoping to find a taller one.
 * - Keep track of the maximum area seen so far.
 */
public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int max = 0;
        int n = height.length;

        int left = 0;
        int right = n - 1;

        while (left < right) {
            int w = right - left;
            int h = Math.min(height[left], height[right]);
            int currWater = w * h;

            max = Math.max(max, currWater);

            // Move the pointer at the shorter line
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return max;
    }

    // Driver code: sample input values to test the solution
    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        int result = maxArea(height);

        System.out.println("Heights: " + Arrays.toString(height));
        System.out.println("Max water: " + result);
    }
}

/*
LeetCode No => 11
Time Complexity => O(N)
Space Complexity => O(1)


Companies that asked this question:
Apple, Goldman Sachs, Microsoft, Google, Facebook (Meta), Amazon, Intel,
Swiggy, Uber, Adobe, Bloomberg, Oracle, Flipkart, Zoho, TCS
*/