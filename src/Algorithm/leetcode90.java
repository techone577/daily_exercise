package Algorithm;

import java.util.*;

/**
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 * dfs
 */
public class leetcode90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);
        helper2(res, new LinkedList<Integer>(), 0, nums);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> bag, int pos, int[] nums) {
        res.add(new LinkedList<>(bag));
        for (int i = pos; i < nums.length; i++) {
            if (i > pos && nums[i] == nums[i - 1]) continue;
            List<Integer> temp = new LinkedList<>(bag);
            bag.add(nums[i]);
            helper(res, bag, i + 1, nums);
            bag = temp;
        }
    }

    //wrong
    private void helper2(List<List<Integer>> res, List<Integer> bag, int pos, int[] nums) {
        if(pos>0)
        res.add(new LinkedList<>(bag));
        if (pos == nums.length)
            return;
        List<Integer> temp = new LinkedList<>(bag);
        helper2(res, bag, pos + 1, nums);
        bag = temp;
        bag.add(nums[pos]);
        temp = new LinkedList<>(bag);
        helper2(res, bag, pos + 1, nums);
        bag = temp;
    }


    public static void main(String[] args) {
        new leetcode90().subsetsWithDup(new int[]{1,2,3});
    }
}
