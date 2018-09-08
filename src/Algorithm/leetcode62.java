package Algorithm;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 问总共有多少条不同的路径？
 * dp[i][j]表示从原点到i，j总路径数目
 * 转移方程：dp[i][j] = dp[i-1][j] + dp[i][j-1] 到i，j的路径数目等于到上面一个点与左面一个点数目之和
 */
public class leetcode62 {
    public int uniquePaths (int m, int n) {
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 1;
                else
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];

                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[n - 1][m - 1];
    }

    /**
     * O(n)空间复杂度
     * 7=6+1
     * 7上一轮为1
     */
    public int uniquePaths2 (int m, int n) {
        int[] dp = new int[m];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[j] += dp[j - 1];
            }

        }
        return dp[m - 1];
    }

    public static void main (String[] args) {
        new leetcode62().uniquePaths(7, 3);
    }
}
