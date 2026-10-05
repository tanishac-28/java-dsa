package Arrays;

public class FindNoAppearingOnce {
    public static int singleNumber(int[] nums) {
        int n = nums.length;
        int ans = 0;
        
        for(int i=0; i<n; i++){
            ans = ans ^ nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};

        System.out.println(singleNumber(nums));
    }
}



/*
Leetcode NO => 136
Time Complexity => O(N)
Space Complexity => O(1)
*/