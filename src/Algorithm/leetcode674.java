package Algorithm;

/**
 * 给定一个未经排序的整数数组，找到最长且连续的的递增序列。
 */
public class leetcode674 {
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length==0)
            return 0;
        int max=0;
        int count=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[i-1])
                count++;
            else{
                max = Math.max(max,count);
                count=1;
            }
        }
        max = Math.max(max,count);
        return max;
    }
}
