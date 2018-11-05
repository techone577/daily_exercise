package Algorithm2;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串 S 和一个字符串 T，请在 S 中找出包含 T 所有字母的最小子串。
 * 示例：
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * 说明：
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 */
public class leetcode76 {
    public String minWindow (String s, String t) {
        if (t.length() > s.length())
            return "";
        //map保存t中所有字符的数量
        Map<Character, Integer> tMap = new HashMap<>();
        int minLen = Integer.MAX_VALUE, startPos = 0;
        for (Character c : t.toCharArray())
            tMap.put(c, tMap.containsKey(c) ? tMap.get(c) + 1 : 1);
        int count = 0, left = 0, right = 0;
        for (; right < s.length(); ++right) {
            //right先动，寻找到包含t所有字符的子字符串
            char rc = s.charAt(right);
            if (!tMap.containsKey(rc))
                continue;
            tMap.put(rc, tMap.get(rc) - 1);
            //每次count++都是有效的
            if (tMap.get(rc) >= 0)
                count++;
            //改变窗口，左边动
            while (count == t.length()) {
                int len = right - left + 1;
                if (len < minLen) {
                    minLen = len;
                    startPos = left;
                }
                char lc = s.charAt(left);
                //恢复有效字符数
                if (tMap.containsKey(lc)) {
                    //使得包含t.length-1的字符串最短
                    count = tMap.get(lc) >= 0 ? count - 1 : count;
                    tMap.put(lc, tMap.get(lc) + 1);
                }
                left++;
            }
        }
        if (minLen == Integer.MAX_VALUE)
            return "";
        return s.substring(startPos, startPos + minLen);
    }

    public static void main (String[] args) {
        System.out.println(new leetcode76().minWindow("ADOBECODEBANC", "ABC"));
    }
}
