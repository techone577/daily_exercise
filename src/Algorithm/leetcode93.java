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
        if(s.length()<4 || s.length()>12)
            return res;
        helper(res, s, new String(), 0, 1);
        return res;
    }

    private void helper (List<String> res, String s, String str, int pos, int depth) {
        if (depth > 3) {
            String seg = s.substring(pos);
            if (isValid(seg)) {
                str = str + seg;
                res.add(str);
            }
            return;
        }
        for (int i = 1; i <= 3 && pos + i < s.length(); i++) {
            //important
            String seg = s.substring(pos, pos + i);
            if (isValid(seg)) {
                helper(res, s, str + seg + ".", pos + i, depth + 1);
            }
        }
    }

    private boolean isValid (String seg) {
        if(seg.charAt(0) == '0' && seg.length()>1)
            return false;
        int ipNum = Integer.valueOf(seg);
        if (0 <= ipNum && ipNum <= 255)
            return true;
        return false;
    }

    public static void main (String[] args) {
        new leetcode93().restoreIpAddresses("010010");
    }
}
