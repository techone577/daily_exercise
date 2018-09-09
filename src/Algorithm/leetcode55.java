package Algorithm;


/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个位置。
 *
 * 不断更新你能到达的最大位置
 */
public class leetcode55 {
    public boolean canJump (int[] nums) {
        if (nums.length == 1)
            return true;
        int max = 0;
        //注意是小于max
        for (int i = 0; i <= max; i++) {
            max = Math.max(max,nums[i]+i);
            if (max >= nums.length-1)
                return true;
        }
        return false;
    }
}
