package Algorithm;

/**
 * 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
 * 输入: [1,2,0]
 * 输出: 3
 * 示例 2:
 * 输入: [3,4,-1,1]
 * 输出: 2
 * 示例 3:
 * 输入: [7,8,9,11,12]
 * 输出: 1
 */
public class leetcode41 {
    public int firstMissingPositive(int[] nums) {
        int i = 0, n = nums.length;
        if (n == 0)
            return 1;
        while (i < n) {
            if (nums[i] != i + 1 && nums[i] > 0 && nums[i] < n && nums[nums[i] - 1] != nums[i]) {
                int t = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = t;
            } else
                ++i;
        }
        for (i = 0; i < n; i++) {
            if (nums[i] != i + 1)
                return i + 1;
        }
        return n + 1;
    }
}
