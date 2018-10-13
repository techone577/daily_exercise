package Algorithm2;

import java.util.*;

/**
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * 示例:
 * 输入: [1,1,2]
 * 输出:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 */
public class leetcode47 {
    public List<List<Integer>> permuteUnique (int[] nums) {
        int[] isVisited = new int[nums.length];
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), 0, nums, isVisited);
        Set<List<Integer>> set = new HashSet<>();
        for(List<Integer> list:res)
            set.add(list);
        res = new ArrayList<>();
        res.addAll(set);
        return res;
    }

    public void helper (List<List<Integer>> res, List<Integer> bag, int pos, int[] nums, int[] isVisited) {
        if (pos == nums.length)
            res.add(new ArrayList<>(bag));
        for (int i = 0; i < nums.length; ++i) {
            if (isVisited[i] != 1) {
                bag.add(nums[i]);
                isVisited[i] = 1;
                helper(res, bag, pos + 1, nums, isVisited);
                isVisited[i] = 0;
                bag.remove(bag.size() - 1);
            }
        }
    }

    public static void main (String[] args) {
        int[] nums = new int[]{1, 1, 2};
        new leetcode47().permuteUnique(nums);
    }
}
