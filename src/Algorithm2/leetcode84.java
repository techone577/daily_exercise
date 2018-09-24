package Algorithm2;

import java.util.Arrays;

/**
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 * 从中间向两端发散计算
 */
public class leetcode84 {
    public int largestRectangleArea (int[] heights) {
        int max = 0;
        for (int i = 0; i < heights.length; ++i) {
            int index = heights[i];
            int l = i, r = i;
            while (l >= 0 && heights[l] >= index)
                --l;
            while (r < heights.length && heights[r] >= index)
                ++r;
            int area = heights[i] * (r - l + 1-2);
            max = Math.max(area, max);
        }
        return max;
    }

    public static void main (String[] args) {
        int[] nums = new int[]{2, 1, 5, 6, 2, 3};
        new leetcode84().largestRectangleArea(nums);
    }
}
