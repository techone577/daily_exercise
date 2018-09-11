package Algorithm;

/**
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 * 轉移方程：
 * dp[i][j] = grid[0][0]
 * dp[i][j] = dp[i > 0 ? i - 1 : 0][j > 0 ? j - 1 : 0] + grid[i][j]
 * dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j]
 */
public class leetcode64 {

    public int minPathSum (int[][] grid) {
        int m = grid[0].length;
        int n = grid.length;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0)
                    dp[i][j] = grid[0][0];
                else if (i == 0 || j == 0)
                    dp[i][j] = dp[i > 0 ? i - 1 : 0][j > 0 ? j - 1 : 0] + grid[i][j];
                else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }
            }
        }
        return dp[n-1][m-1];
    }
}
