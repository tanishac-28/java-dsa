package Arrays;
import java.util.Arrays;

public class RemoveDuplicate {
    public static int removeDuplicates(int[] nums) {
        int n = nums.length;
        int k = 1;

        for(int i=1; i<n; i++){
            if(nums[i] != nums[k-1]){
                nums[k] = nums[i];
                k++;
            }
        }
        return k ;
    }
    public static void main(String[] args) {
        int[] nums = {0,0,1,2,2,2,3,3,4};
        int k = removeDuplicates(nums);

        System.out.println(k);

        System.out.println(Arrays.toString(Arrays.copyOf(nums, k)));
    }
}

// Leetcode No. => 26

// Space Complexity -> O(N);
// Time Complexity -> O(1);