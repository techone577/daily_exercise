package Algorithm;

/**
 * 最长公共子串
 * dp[i][j]表示以以i、j结尾的以s1[i]、s2[j]为结尾的相同子串的最大长度
 * dp[i][j] = s1[i] == s2[j] ? 1 : 0 ,i==0||j==0
 * dp[i][j] = s1[i] == s2[j] ? dp[i-1][j-1]+1 : 0
 */
public class LCSubstring {
    public static int longestCommonSubstring (String s1, String s2) {
        int[][] dp = new int[s1.length()][s2.length()];
        int max=0;
        int x=0,y=0;
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = s1.charAt(i) == s2.charAt(j) ? 1 : 0;
                else
                    dp[i][j] = s1.charAt(i) == s2.charAt(j) ? dp[i - 1][j - 1] + 1 : 0;
                max = Math.max(max,dp[i][j]);
                if(max==dp[i][j]){
                    x=i;
                    y=j;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=x,j=y;i>=0&&j>=0&&dp[i][j]>=1;i--,j--)
            sb.append(s1.charAt(i));
        System.out.println(sb.reverse().toString());
        return max;
    }
    public static void main (String []args) {
        System.out.println(LCSubstring.longestCommonSubstring("acbcbce","abcbced"));
    }
}
