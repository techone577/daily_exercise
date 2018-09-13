package Algorithm;

/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 *
 * 遇到0放到左边，2放到右边，1跳过
 */
public class leetcode75 {

    public void sortColors (int[] nums) {
        int pre = 0;
        int post = nums.length - 1;
        for (int i = 0; i <= post; i++) {
            if (nums[i] == 0) {
                int t = nums[pre];
                nums[pre] = nums[i];
                nums[i] = t;
                ++pre;
            } else if (nums[i] == 2) {
                int t = nums[post];
                nums[post] = nums[i];
                nums[i] = t;
                --i;
                --post;
            }
        }
    }

    public static void main (String[] args) {
        new leetcode75().sortColors(new int[]{1,2,2,1,1,0,0,2,0,0,1,0,0,1,0});
    }
}
