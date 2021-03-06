package Algorithm;

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 思路:把数字放到前面
 */

public class leetcode26 {
    public int removeDuplicates (int[] nums) {
        int pos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[pos] != nums[i]) {
                pos++;
                nums[pos] = nums[i];
            }
        }
        return pos + 1;
    }

    public static void main (String []args) {
        int nums[] = new int[]{1,1,1,1,2,2,3,4,4,5};
        new leetcode26().removeDuplicates(nums);
    }
}
