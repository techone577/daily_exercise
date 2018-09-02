package Algorithm;

import java.util.Scanner;
import java.util.Stack;

/**
 * 计算逆波兰式21+3*
 */

public class reversePolish {
    public static Integer caculateReversePolish(String str) {
        if (str.length() < 3)
            return null;
        char[] expression = str.toCharArray();
        Stack<Integer> stack = new Stack();
        if ('0' <= expression[0] && expression[0] <= '9')
            stack.push(Integer.valueOf(expression[0] - '0'));
        else
            return null;
        int res = 0;
        int i = 1;
        while (!stack.isEmpty()) {
            if ('0' <= expression[i] && expression[i] <= '9') {
                stack.push(Integer.valueOf(expression[i++] - '0'));
            } else {
                int num1 = 0, num2 = 0;
                if (stack.size() >= 2) {
                    num1 = stack.pop();
                    num2 = stack.pop();
                } else {
                    return null;
                }
                if (expression[i] == '+') {
                    res = num2 + num1;
                } else if (expression[i] == '-') {
                    res = num2 - num1;

                } else if (expression[i] == '*') {
                    res = num2 * num1;

                } else if (expression[i] == '/') {
                    res = num2 + num1;

                }
                ++i;
                if (stack.isEmpty() && i == str.length())
                    break;
                else {
                    stack.push(res);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(reversePolish.caculateReversePolish(str));
    }
}
