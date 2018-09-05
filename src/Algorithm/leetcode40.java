package Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, target, 0, res, new ArrayList<>());
        return res;
    }

//    private void helper(int[] nums, int target, int pos, List<List<Integer>> res, List<Integer> bag) {
//        if (target == 0)
//            res.add(new ArrayList<>(bag));
//        if (target < 0)
//            return;
//        if (pos >= nums.length)
//            return;
//        else {
//            List<Integer> temp = new ArrayList<>(bag);
//            helper(nums, target, pos + 1, res, bag);
//            bag =temp;
//            bag.add(nums[pos]);
//            helper(nums, target - nums[pos], pos + 1, res, bag);
//        }
//
//    }

    private void helper(int[] nums, int target, int pos, List<List<Integer>> res, List<Integer> bag) {
        if (target == 0)
            res.add(new ArrayList<>(bag));
        if (target < 0)
            return;
        else {
            for (int i = pos; i < nums.length; i++) {
                if (i > pos && nums[i] == nums[i - 1]) continue;
                bag.add(nums[i]);
                helper(nums, target-nums[i], i + 1, res, bag);
                bag.remove(bag.size() - 1);
            }
        }

    }

    public static void main(String []args) {
        new leetcode40().combinationSum2(new int []{10,1,2,7,6,1,5},  8);

    }
}
