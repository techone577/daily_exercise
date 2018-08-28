package Algorithm;

import java.util.*;

public class leetcode90 {
    public List<List<Integer>> subsetsWithDup (int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);
        helper(res, new LinkedList<Integer>(), 0, nums);
        return res;
    }

    private void helper (List<List<Integer>> res, List<Integer> bag, int pos, int[] nums) {
        res.add(new LinkedList<>(bag));
        for (int i = pos; i < nums.length; i++) {
            if (i > pos && nums[i] == nums[i - 1]) continue;
            List<Integer> temp = new LinkedList<>(bag);
            bag.add(nums[i]);
            helper(res, bag, i + 1, nums);
            bag = temp;
        }
    }


    public static void main (String[] args) {
        new leetcode90().subsetsWithDup(new int[]{2, 1, 2});
    }
}
