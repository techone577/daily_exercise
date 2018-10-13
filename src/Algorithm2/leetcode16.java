package Algorithm2;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 *
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 */
public class leetcode16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minMinus = Integer.MAX_VALUE,res =0;
        for(int i=0;i<nums.length;++i){
            int j=i+1,k=nums.length-1;
            while(j<k){
                int sum = nums[i] + nums[j] +nums[k];
                if(sum == target)
                    return target;
                if(sum > target){
                     if(sum - target < minMinus) {
                         minMinus = sum - target;
                         res = sum;
                     }
                     --k;
                }
                if(sum < target){
                    if( target - sum < minMinus) {
                        minMinus = target - sum;
                        res = sum;
                    }
                    ++j;
                }
            }
        }
        return res;
    }

    public static void main(String []args){
        int []nums = new int[]{-1,2,1,-4};
        System.out.println(new leetcode16().threeSumClosest(nums,1));
    }
}
