package Algorithm2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 可以任意选择答案输出的顺序
 *
 * dfs
 */
public class leetcode17 {

    private static Map<Character, String> map = new HashMap<>();

    public List<String> letterCombinations (String digits) {
        if (digits.length() == 0)
            return new ArrayList<String>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        List<String> res = new ArrayList<>();
        helper(res, new String(), digits, 0);
        return res;
    }

    private void helper (List<String> res, String bag, String digits, int pos) {
        if (pos == digits.length()) {
            res.add(bag);
            return;
        }
        char digit = digits.charAt(pos);
        String letter = map.get(digit);
        for (int i = 0; i < letter.length(); i++) {
            helper(res, bag + letter.charAt(i), digits, pos + 1);
        }
    }

    public static void main (String[] args) {
        new leetcode17().letterCombinations("23");
    }
}
