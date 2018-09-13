package Algorithm;

/**
 * 右边-左边最的大
 */
public class RMinusLMax {
    public static int max (int[] nums) {
        int max = nums[0];
        int res = max - nums[1];
        max = Math.max(max, nums[1]);
        for (int i = 2; i < nums.length - 1; i++) {
            res = Math.max(max - nums[i], res);
            max = Math.max(max, nums[i]);
        }
        return res;
    }

    public static void main (String[] args) {
        RMinusLMax.max(new int[]{10,6,3,3,5,5,9,9,19});
    }
}
