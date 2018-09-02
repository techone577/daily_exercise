package Algorithm;

import java.util.LinkedList;
import java.util.List;
/**
 * [0-9],给定数组[0，1，1，1，1，1，1，1.。。。]1表示必须输出，0表示可输出可不输出
 */

public class subsetn {
    public static void solution(int[] nums, int[] status) {

        List<List<Integer>> list = new LinkedList<>();
        helper(list, new LinkedList<Integer>(), nums, status, 0);
        return;

    }

    private static void helper(List<List<Integer>> list, List<Integer> bag, int[] nums, int[] status, int pos) {
        if (pos == nums.length) {
            list.add(new LinkedList<>(bag));
            return;
        }
        if (status[pos] == 0) {
            List<Integer> temp = new LinkedList<>(bag);
            helper(list, bag, nums, status, pos + 1);
            bag=temp;
            bag.add(nums[pos]);
            temp = new LinkedList<>(bag);
            helper(list, bag, nums, status, pos + 1);
            bag=temp;
        }
        if (status[pos] == 1) {
            bag.add(nums[pos]);
            List<Integer> temp = new LinkedList<>(bag);
            helper(list, bag, nums, status, pos + 1);
            bag=temp;
        }
    }


    public static void main(String[] args) {
        subsetn.solution(new int[]{0, 1, 2, 3, 4}, new int[]{0, 0, 1, 1, 0});
    }
}
