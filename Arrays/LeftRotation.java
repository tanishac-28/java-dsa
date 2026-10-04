package Arrays;
import java.util.Arrays;

class LeftRotation {
    public static void LeftRotate(int[] nums) {
        int n = nums.length;
        int temp = nums[0];

        for(int i=1; i<n; i++){
            nums[i-1] = nums[i];
        }
        nums[n-1] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};

        LeftRotate(nums);
        System.out.println(Arrays.toString(nums));
    }
}


// Time Complexity => O(N)
// Space Complexty => O(1)