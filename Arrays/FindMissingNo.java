package Arrays;

class FindMissingNo {

    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int ans = 0;

        for(int i=0; i<=n; i++){
            ans = ans ^ i;
        }
        for(int i=0; i<n; i++){
            ans = ans ^ nums[i];
        }
        return ans;
    } 

    public static void main(String[] args) {
        int[] nums = {3,0,1};

        System.out.println(missingNumber(nums));
    }
}


/*
Leetcode No => 268
Time Complexity => O(N)
Space Complexity => O(1)
*/