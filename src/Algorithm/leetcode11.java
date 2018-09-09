package Algorithm;

/**
 *
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，
 * 垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，
 * 使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 * 最大面积取决于短边，所以每次移动较短的一边即可
 */

public class leetcode11 {
    public static int maxArea (int[] height) {
        if (height.length < 2)
            return 0;
        int left = 0;
        int right = height.length-1;
        int max = 0;
        while (left < right) {
            int h = Math.min(height[left], height[right]);
            max = Math.max(max, h * (right - left));
            if (h == height[left])
                left++;
            else
                right--;
        }
        return max;
    }
    public static void main(String []args){
        int []h = {1,8,6,2,5,4,8,3,7};
        leetcode11.maxArea(h);
    }
}
