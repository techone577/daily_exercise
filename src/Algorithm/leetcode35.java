package Algorithm;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 *
 * 二分查找下界
 */

public class leetcode35 {
    public int searchInsert (int[] nums, int target) {
        return boundSearch(nums,0,nums.length,target);
    }

    public int boundSearch (int[] nums, int left, int right, int target) {
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target)
                right = mid;
            else if(nums[mid] == target)
                return mid;
            else
                left =mid+1;
        }
        return left;
    }
}
