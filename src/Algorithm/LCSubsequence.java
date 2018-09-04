package Algorithm;

/**
 * 最长公共子序列
 * dp[i][j]表示s1...si与t1...tj字符串的最长公共子序列值
 * dp[i][j] =  s[i]== t[j] ? 1 : 0, i==0 and j==0;
 * dp[i][j] =  s[i]== t[j] ? 1 : dp[i == 0 ? 0 : i - 1][j == 0 ? 0 : j - 1],i==0 or j==0 and i!=j;
 * dp[i][j] =  dp[i-1][j-1] + 1, s[i] == t[j];
 * dp[i][j] = max(dp[i-1][j], dp[i][j-1]), s[i] != t[j];
 */
public class LCSubsequence {
    public static int LongestCommonSubsequence (String s1, String s2) {
        int[][] dp = new int[s1.length()][s2.length()];
        int max = 0;
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                if (i == 0 && j == 0)
                    dp[i][j] = s1.charAt(i) == s2.charAt(j) ? 1 : 0;
                else if (i == 0 || j == 0) {
                    if (s1.charAt(i) == s2.charAt(j))
                        dp[i][j] = 1;
                    else
                        dp[i][j] = dp[i == 0 ? 0 : i - 1][j == 0 ? 0 : j - 1];
                } else {
                    if (s1.charAt(i) == s2.charAt(j))
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    else
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
                max = Math.max(max, dp[i][j]);
                System.out.print(dp[i][j]);
            }
            System.out.println();
        }
        return max;
    }

    public static void showSubsequence (int[][] dp, String s, String t) {
        int i = s.length() - 1, j = t.length() - 1;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 && j >= 0) {
            if (s.charAt(i) == s.charAt(j)) {
                sb.append(s.charAt(i));
                ++i;
                ++j;
            } else {
            }
        }

    }

    public static void main (String[] args) {
        System.out.println(LCSubsequence.LongestCommonSubsequence("bdcaba", "abcbdab"));
    }
}
