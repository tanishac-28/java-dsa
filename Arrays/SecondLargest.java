package Arrays;

public class SecondLargest {
    public static int findLargest(int[] nums) {
        int largest = nums[0];
        int seclargest = -1;
        int n = nums.length;

        for(int i=1; i<n; i++){
            if(nums[i] > largest){
                seclargest = largest;
                largest = nums[i];
            }
            else if(largest < nums[i] && nums[i] > seclargest){
                seclargest = nums[i];
            }
        }
        return seclargest;
    }  
    
    public static void main(String[] args) {
        int[] nums = {3,2,4,8,9};
        
        System.out.println(findLargest(nums));
    }
}
