package Algorithm;

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
