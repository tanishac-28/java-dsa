package Arrays;

import java.util.HashMap;

public class containsDuplicate {

    public static boolean containsDuplicate(int[] nums) {
       
        HashMap<Integer , Integer> map = new HashMap<>();
        int n = nums.length;

        for(int i=0; i<n; i++){
            if(map.containsKey(nums[i])){
                return true;
            }
            map.put(nums[i], 1);
        }
        return false;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};

        System.out.println(containsDuplicate(nums));
    }
}



/*
Leetcode No => 217
Time Complexity => O(N)
Space Complexity => O(1) */