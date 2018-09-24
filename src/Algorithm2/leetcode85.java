package Algorithm2;

/**
 * 给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 * 示例:
 * 输入:
 * [
 * ['1','0','1','0','0'],
 * ['1','0','1','1','1'],
 * ['1','1','1','1','1'],
 * ['1','0','0','1','0']
 * ]
 * 输出: 6
 *
 * 将矩阵转换成一每一行为底的柱形图，以leetcode84方法求解
 */
public class leetcode85 {
    public int maximalRectangle (char[][] matrix) {
        if (matrix.length == 0)
            return 0;
        int column = matrix[0].length, row = matrix.length;
        int max = 0;
        int[][] numOfOne = new int[row][column];
        for (int i = 0; i < row; ++i) {
            int[] heights = new int[column];
            for (int j = 0; j < column; ++j) {
                if (matrix[i][j] == '0')
                    numOfOne[i][j] = 0;
                else
                    numOfOne[i][j] = i > 0 ? numOfOne[i - 1][j] + 1 : 1;
                heights[j] = numOfOne[i][j];
            }
            max = Math.max(largestRectangleArea(heights), max);
        }
        return max;
    }

    public int largestRectangleArea (int[] heights) {
        int max = 0;
        for (int i = 0; i < heights.length; ++i) {
            int index = heights[i];
            int l = i, r = i;
            while (l >= 0 && heights[l] >= index)
                --l;
            while (r < heights.length && heights[r] >= index)
                ++r;
            int area = heights[i] * (r - l + 1 - 2);
            max = Math.max(area, max);
        }
        return max;
    }

    public static void main (String[] args) {
        char[][] nums = new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        new leetcode85().maximalRectangle(nums);
    }
}
