package Algorithm2;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列
 */
public class leetcode46 {
    public List<List<Integer>> permute (int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, nums, 0);
        return res;
    }

    private void helper (List<List<Integer>> res, int[] nums, int pos) {
        if (pos == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int t : nums) {
                list.add(t);
            }
            res.add(list);
        }
        for (int i = pos; i < nums.length; i++) {
            swap(nums, pos, i);
            helper(res, nums, pos + 1);
            swap(nums, pos, i);
        }
    }

    private void swap (int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
