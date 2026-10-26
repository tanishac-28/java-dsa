
package Arrays;
import java.util.Arrays;
import java.util.HashSet;

public class LongestConsecutiveSeq {
    public static int longestConsecutive(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        int longest = 0;

        for (int i = 0; i < n; i++) {
            int num = nums[i];
            set.add(num);
        }

        for (int num : set) {
            if (!set.contains(num - 1)) {
                int currNum = num;
                int count = 0;

                while (set.contains(currNum)) {
                    currNum++;
                    count++;
                }

                longest = Math.max(longest, count);
            }
        }

        return longest;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};

        int result = longestConsecutive(nums);

        System.out.println("Array: " + Arrays.toString(nums));
        System.out.println("Longest consecutive sequence: " + result);
    }
}

/*
LeetCode No => 128
Time Complexity => O(N)
Space Complexity => O(N)
*/