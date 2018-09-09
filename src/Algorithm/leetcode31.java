package Algorithm;

import java.util.Arrays;

/**
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * 必须原地修改，只允许使用额外常数空间。
 *
 * 下一个全排列就是找到比当前数大的最小值，找到降序排列开始的位置，记为i，从i到n找到比nums[i-1]大的最小值与i-1交换，
 * 并将交换后i之后序列按升序排列，若整个序列都为降序则反转
 */
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
