package Algorithm2;


import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 */
public class leetcode20 {
    public boolean isValid (String s) {
        if (("").equals(s))
            return true;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{')
                stack.push(c);
            else {
                if (stack.isEmpty())
                    return false;
                Character peek = stack.peek();
                String match = new StringBuilder().append(peek).append(c).toString();
                if ("()".equals(match) || "[]".equals(match) || "{}".equals(match))
                    stack.pop();
                else
                    stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public static void main (String[] args) {
        System.out.println(new leetcode20().isValid("[]"));
    }
}
