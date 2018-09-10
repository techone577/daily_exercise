package Algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * 示例:
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 */
public class leetcode93 {
    public List<String> restoreIpAddresses (String s) {
        StringBuilder str = new StringBuilder(s);
        List<String> res = new ArrayList<>();
        helper(res, str, new StringBuilder(), 0, 1);
        return res;
    }

    private void helper (List<String> res, StringBuilder str, StringBuilder bag, int pos, int depth) {
        if (depth == 4 && isValid(str, pos, str.length() - 1) != null) {
            res.add(new StringBuilder(bag).toString());
            return;
        }
        for (int i = 0; i < 3; i++) {
            String num = isValid(str, pos, i);
            if (num != null) {
                StringBuilder temp = new StringBuilder(bag);
                bag.append(num + '.');
                helper(res, str, bag, pos + i + 1, depth + 1);
                bag = temp;
            }
        }
    }

    private String isValid (StringBuilder stringBuilder, int start, int end) {
        if (start < end)
            return null;
        StringBuilder temp = new StringBuilder(stringBuilder.substring(start, end+1));
        int ipNum = Integer.valueOf(temp.toString());
        if (0 <= ipNum && ipNum <= 255)
            return String.valueOf(ipNum);
        return null;
    }

    public static void main (String[] args) {
        new leetcode93().restoreIpAddresses("25525511135");
    }
}
