package Algorithm;

public class KMP {
    public static int kmp (String target, String pattern) {
        int i = 0, j = 0;
        int res = 0;
        int[] next = getNextArray2(pattern);
        while (i < pattern.length() && j < target.length()) {
            if (i == -1 || pattern.charAt(i) == target.charAt(j)) {
                i++;
                j++;
            } else {
                /** 回退
                 * ABCDABD
                 * 如最后一位没有匹配到，则需回退到下标2
                 */
                i = i - 1 > 0 ? next[i - 1] : -1;
            }
        }
        if (i == pattern.length())
            return j;
        else
            return -1;
    }

    /**
     * 计算出的数组A表示以这一位位阶为的最长前后缀
     * 而next数组则为数组A右移一位，第一个值赋为-1
     * 如ABCDABD
     * getNextArray计算出来：0 0 0 0 1 2 0
     * 真正的next：-1 0 0 0 0 1 2
     */
    public static int[] getNextArray (String pattern) {
        int[] next = new int[pattern.length()];
        next[0] = 0;
        for (int i = 1; i < pattern.length(); i++) {
            /**
             *    ABCABD
             *    判断D与C是否相等
             *    类似于动态规划
             */
            if (pattern.charAt(next[i - 1]) == pattern.charAt(i))
                next[i] = next[i - 1] + 1;
            else {
                /**
                 * 不相等，递归next
                 * ABABCABABD
                 * D不等于C,递归next[C的下标 - 1]
                 */
                int j = next[i - 1];
                while (j > 0) {
                    if (pattern.charAt(j) == pattern.charAt(i))
                        next[i] = j + 1;
                    else
                        j = next[j-1];
                }
                if (j == 0 && pattern.charAt(0) == pattern.charAt(i))
                    next[i] = 1;
                else
                    next[i] = 0;
            }
        }
        return next;
    }
    //直接求next数组
    public static int[] getNextArray2 (String pattern) {
        int[] next = new int[pattern.length()];
        next[0] = -1;
        int i = 0, j = -1;
        while (i < pattern.length()-1) {
            if (j == -1 || pattern.charAt(j) == pattern.charAt(i)) {
                ++i;
                ++j;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
        return next;
    }

        public static void main (String[]args){
            KMP.kmp("BBC_ABCDAB_ABCDABCDABDE", "ABABBCABB");
        }
    }