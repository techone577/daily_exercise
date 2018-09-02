package Algorithm;

import java.util.Arrays;

public class leetcode31 {
    public void nextPermutation (int[] nums) {
        int i = nums.length - 1;
        while (i > 0 && nums[i] <= nums[i - 1]) {
               i--;
        }
        if(i==0)
            Arrays.sort(nums);
        else{
            int index = nums[i-1];
            int j;
            for(j=nums.length-1;j>=i;j--){
               if(nums[j]>index)
                   break;
            }
            int temp = nums[i-1];
            nums[i-1]=nums[j];
            nums[j]=temp;
            Arrays.sort(nums,i,nums.length);
        }
    }
    public static void main(String []args){
        new leetcode31().nextPermutation(new int[]{5,1,1});
    }
}
