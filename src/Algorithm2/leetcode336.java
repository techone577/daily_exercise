package Algorithm2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一组唯一的单词， 找出所有不同 的索引对(i, j)，使得列表中的两个单词， words[i] + words[j] ，可拼接成回文串。
 * 示例 1:
 * 输入: ["abcd","dcba","lls","s","sssll"]
 * 输出: [[0,1],[1,0],[3,2],[2,4]]
 * 解释: 可拼接成的回文串为 ["dcbaabcd","abcddcba","slls","llssssll"]
 * 示例 2:
 * 输入: ["bat","tab","cat"]
 * 输出: [[0,1],[1,0]]
 * 解释: 可拼接成的回文串为 ["battab","tabbat"]
 *
 * 思路：
 * 1、将字符串反转后和字符串下标放入map中
 * 2、遍历words数组，对每个字符串遍历即str = ls + rs
 * 3、如果ls是回文串，判断rs是否在map中，如果在，则   sr+ls+rs(map中存的是sr的反转序列)，则（map中的下标，当前字符串下标）为一组结果
 * 4、如果rs是回文串，判断ls是否在map中，如果在，则 ls+rs+sl 是反转序列，则（当前字符串下标，map中的下标）为一组结果
 * 5、对于空字符串""单独判断，如果words中字符串是回文串，则将下标保存到list，（空字符串下标，list中保存的下标）
 */
public class leetcode336 {
    //TLE超时
    public List<List<Integer>> palindromePairs (String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                StringBuilder s1 = new StringBuilder().append(words[i]).append(words[j]);
                StringBuilder s2 = new StringBuilder().append(words[j]).append(words[i]);
                if (s1.toString().equals(s1.reverse().toString())) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    res.add(list);
                }
                if (s2.toString().equals(s2.reverse().toString())) {
                    List<Integer> list = new ArrayList<>();
                    list.add(j);
                    list.add(i);
                    res.add(list);
                }
            }
        }
        return res;
    }
    //AC
    public List<List<Integer>> solution (String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(new StringBuilder(words[i]).reverse().toString(), i);
        }
        List<List<Integer>> res = new ArrayList<>();
        boolean flag = false;
        List<Integer> palindromeList = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                String ls = words[i].substring(0, j);
                String rs = words[i].substring(j, words[i].length());
                if (j == 0 && isPalindrome(rs))
                    palindromeList.add(i);
                if (isPalindrome(ls) && map.containsKey(rs)) {
                    List<Integer> list = new ArrayList<>();
                    if (map.get(rs) != i) {
                        list.add(map.get(rs));
                        list.add(i);
                        res.add(list);
                    }
                }
                if (isPalindrome(rs) && map.containsKey(ls)) {
                    List<Integer> list = new ArrayList<>();
                    if (map.get(ls) != i) {
                        list.add(i);
                        list.add(map.get(ls));
                        res.add(list);
                    }
                }
            }
            //处理空字符串
            if (words[i].equals(""))
                flag = true;
        }
        if (flag) {
            for (Integer t : palindromeList) {
                List<Integer> list = new ArrayList<>();
                list.add(map.get(""));
                list.add(t);
                res.add(list);
            }
        }
        return res;
    }

    public static boolean isPalindrome (String str) {
        return str.equals(new StringBuilder(str).reverse().toString());
    }

    public static void main (String[] args) {
        String[] words = new String[]{"a", ""};
        new leetcode336().solution(words);
    }
}
