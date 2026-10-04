package Arrays;
import java.util.Arrays;

public class MoveZeros{
    public static void moveZeros (int[] nums){
        int n = nums.length;
        int left = 0;

        for(int right=0; right<n; right++){
            if(nums[right] != 0){
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left++;
            }
        }
    }

    public static void main (String[] args) {
        int[] nums = {0,1,0,2,0,3};

        moveZeros(nums);

        System.out.println(Arrays.toString(nums));
    }
}


/*
Leetcode NO => 283
Space Complexity => O(N)
Time Complexity => O(1)
*/