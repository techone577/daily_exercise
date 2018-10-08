package Algorithm2;

/**
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 */

public class leetcode59 {

    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int up = 0, down = n - 1, right = n - 1, left = 0;
        int num = 1;
        for (; ; ) {
            for (int i = left; i <= right; i++) {
                res[up][i] = num++;
            }
            if (++up > down)
                break;
            for (int i = up; i <= down; i++) {
                res[i][right] = num++;
            }
            if (--right < left)
                break;
            for (int i = right; i >= left; i--) {
                res[down][i] = num++;
            }
            if (--down < up)
                break;
            for (int i = down; i >= up; i--)
                res[i][left] = num++;
            if (++left > right)
                break;
        }
        return res;
    }
}
