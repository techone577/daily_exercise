package Algorithm;

import java.util.LinkedList;
import java.util.List;

public class leetcode39 {
    public List<List<Integer>> combinationSum (int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        helper(res, new LinkedList<Integer>(), target, candidates,0);
        return res;
    }

    private void helper (List<List<Integer>> res, List<Integer> bag, int target, int[] nums,int pos) {
        if (target == 0) {
            res.add(bag);
            return;
        }
        if (target < 0)
            return;
        else {
            for (int i = pos; i < nums.length; i++) {
                List<Integer> temp = new LinkedList<>(bag);
                bag.add(nums[i]);
                helper(res, bag, target - nums[i], nums,i);
                bag = temp;
            }
        }

    }
}
