package Algorithm;

import java.util.Arrays;

public class fastsort {
    public static void sort (int[] nums) {
        partition(0, nums.length - 1, nums);
        return;
    }

    private static void partition (int i, int j, int[] nums) {
        if (i >= j)
            return;
        int left = i;
        int right = j;
        int index = nums[i];
        while (i < j) {
            while (i < j && nums[j] >= index)
                j--;
                nums[i] = nums[j];
            while (i < j && nums[i] <= index)
                i++;
                nums[j] = nums[i];
        }
        nums[i] = index;
        partition(left, i - 1, nums);
        partition(i + 1, right, nums);
    }

    private static void swap (int i, int j, int[] nums) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main (String[] args) {
        fastsort.sort(new int[]{9,8,7,6,5,4,3,2,1});
    }
}
