package Algorithm;

import java.util.ArrayList;
import java.util.List;

public class leetcode784 {
    public static List<String> letterCasePermutation (String S) {
        List<String> res = new ArrayList<>();
        letterCasePermutationHelper(res, S, 0, new StringBuilder());
        return res;
    }

    private static void letterCasePermutationHelper (List<String> list, String s, int pos, StringBuilder sb) {
        for (int i = pos; i < s.length(); i++) {
            if ('0' <= s.charAt(i) && s.charAt(i) <= '9')
                sb.append(s.charAt(i));
            else{
                sb.append(s.charAt(i));
                StringBuilder t = new StringBuilder(sb.toString());
                letterCasePermutationHelper(list, s, i + 1, sb);
                sb = t;
                sb.deleteCharAt(i);
                sb.append(transLeeterCase(s.charAt(i)));
            }
        }
        list.add(sb.toString());
    }

    private static char transLeeterCase (char letter) {
        char res = ' ';
        if ('a' <= letter && letter <= 'z') {
            res = (char) (letter-('a'-'A'));
        } else if ('A' <= letter && letter <= 'Z') {
            res = (char) (letter+'a'-'A');
        }
        return res;
    }

    public static void main (String[] args) {
        System.out.print(leetcode784.letterCasePermutation("a1c2b3"));
    }
}
