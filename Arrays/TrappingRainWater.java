package Arrays;

/*
 * Problem Statement:
 * Given n non-negative integers representing an elevation map where the
 * width of each bar is 1, compute how much water it can trap after raining.
 *
 * Example:
 * Input: height = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
 * Output: 6
 *
 * Approach: Two Pointers
 * - Water above a bar = (smaller of the tallest bars on both sides) - bar height.
 * - Keep lmax (tallest bar seen from the left) and rmax (tallest from the right).
 * - If lmax < rmax, the left side decides the water level, so add
 *   lmax - height[left] and move left forward.
 * - Otherwise the right side decides the level, so add
 *   rmax - height[right] and move right back.
 */
public class TrappingRainWater {
    public static int trap(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n - 1;
        int lmax = 0;
        int rmax = 0;
        int ans = 0;

        while (left < right) {
            lmax = Math.max(lmax, height[left]);
            rmax = Math.max(rmax, height[right]);

            if (lmax < rmax) {
                ans += lmax - height[left];
                left++;
            } else {
                ans += rmax - height[right];
                right--;
            }
        }

        return ans;
    }

    // Driver code: sample input values to test the solution
    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

        int result = trap(height);

        System.out.println(result);
    }
}

/*
LeetCode No => 42
Time Complexity => O(N)
Space Complexity => O(1)

Output:
6


Companies that asked this question:
Adobe, Affirm, Airbnb, Amazon, Apple, Atlassian, Bloomberg, ByteDance,
Citadel, Databricks, Dataminr, Electronic Arts, Facebook (Meta), Flipkart,
Goldman Sachs, Google, Grab, HBO, Huawei, Lyft, Microsoft, Nvidia, Oracle,
Palantir Technologies, Qualtrics, Salesforce, Snapchat, Tableau, Twitter,
Uber, Visa, Walmart Labs, Wish, Yahoo, Yandex, Zenefits, Zoho
*/