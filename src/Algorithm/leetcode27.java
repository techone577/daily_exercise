package Algorithm;

public class leetcode27 {
    public int removeElement (int[] nums, int val) {
        int count=0;
        int pos=nums.length-1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == val) {
                int t = nums[pos];
                nums[pos] = nums[i];
                nums[i] = t;
                count++;
                pos--;
            }
        }
        return nums.length - count;
    }
}
