package Arrays;

public interface ArrayIsSorted {
    public static boolean isSorted(int[] nums){
        int n = nums.length;
        boolean isSorted = true;

        for(int i=1 ; i<n; i++){
            if(nums[i] < nums[i-1]){
                isSorted = false;
                break;
            }
        }
        return isSorted;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,8,5,2,3};

        System.out.println(isSorted(nums));
    }
}



// Time Complexity:- O(N)
// Space Complexxity :- O(1)


