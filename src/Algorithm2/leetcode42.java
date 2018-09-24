package Algorithm2;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 * 示例:
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 */
public class leetcode42 {
    public int trap (int[] height) {
        if (height.length == 0)
            return 0;
        int maxHeight = 0, maxLeft = 0, maxRight = 0, maxIndex = 0;
        int res = 0;
        //用最长的高度分割两侧
        for (int i = 0; i < height.length; ++i) {
            maxHeight = Math.max(maxHeight, height[i]);
            maxIndex = maxHeight == height[i] ? i : maxIndex;
        }
        //左边计算
        maxLeft = height[0];
        for (int i = 0; i <= maxIndex; ++i) {
            if (maxLeft > height[i])
                res += maxLeft - height[i];
            else
                maxLeft = height[i];
        }
        //右边计算
        for (int i = height.length - 1; i >= maxIndex; --i) {
            if (maxRight > height[i])
                res += maxRight - height[i];
            else
                maxRight = height[i];
        }
        return res;
    }
}
