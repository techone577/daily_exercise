package Algorithm;

import java.util.List;

/**
 * 最长非递减子序列
 * dp[i]表示里nums[i]为结尾的lis
 */
public class LIS {
    /**
     * 动态规划n2复杂度
     */
    public static int solution (int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
        }
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] <= nums[i])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }

    /**
     * 贪心+二分 nlogn
     */
    public static int solution2 (int[] nums) {
        int[] res = new int[nums.length];
        int size = 0;
        res[size++] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= res[size - 1]) {
                res[size++] = nums[i];
            } else {
                res[lower_bound(0, size - 1, res, nums[i])] = nums[i];
            }
        }
        return res.length;
    }

    /**
     * 二分查下界
     */
    public static int lower_bound (int left, int right, int[] nums, int target) {
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= target)
                right = mid;
            else
                left = mid + 1;
        }
        return left;
    }

    public static void main (String[] args) {
        System.out.println(LIS.solution2(new int[]{1, 0, 3, 4, 5, 6, 7, 7, 9}));
    }
}
