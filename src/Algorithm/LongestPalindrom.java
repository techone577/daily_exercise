package Algorithm;

public class LongestPalindrom {

    public static String longestSubString (String s) {
        int n = s.length();
        String sRevert = new StringBuilder(s).reverse().toString();
        int maxLength = 0;
        int pos = 0;
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (s.charAt(i - 1) == sRevert.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    maxLength = Math.max(dp[i][j], maxLength);
                    if (maxLength == dp[i][j]) pos = i;
                } else
                    dp[i][j] = 0;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = pos - 1; i > pos - maxLength - 1; i--)
            stringBuilder.append(s.charAt(i));
        return stringBuilder.toString();
    }

    public static String manacher (String s) {
        StringBuilder stringBuilder = new StringBuilder(s);
        stringBuilder.insert(0, "#");
        for (int i = 1; i < s.length() * 2; i = i + 2) {
            stringBuilder.insert(i + 1, "#");
        }
        String str = stringBuilder.toString();
        int mx = 0;
        int id = 0;
        int p[] = new int[str.length()];
        p[0] = 0;
        for (int i = 0; i < str.length(); i++) {
            if (i < mx)
                p[i] = Math.min(mx - i, p[2 * id - i]);
            while (i - p[i] >= 0 && i + p[i] <= str.length() - 1 && (str.charAt(i - p[i]) == str.charAt(i + p[i])))
                p[i]++;
            if (i + p[i] > mx) {
                mx = i + p[i];
                id = i;
            }
        }
        int max = 0;
        for (int i = 0; i < p.length; i++) {
            max = Math.max(max, p[i]);
            if (max == p[i])
                id = i;
        }
        stringBuilder = new StringBuilder();
        if (str.charAt(id) != '#')
            stringBuilder.append(str.charAt(id));
        for (int i = 1; i < max; i++) {
            if (str.charAt(i+id) != '#') {
                stringBuilder.append(str.charAt(i + id));
                stringBuilder.insert(0, str.charAt(i + id));
            }
        }
        return stringBuilder.toString();
    }

    public static void main (String[] args) {
        System.out.print(LongestPalindrom.manacher("babad"));
    }
}
