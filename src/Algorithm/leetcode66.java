package Algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 */
public class leetcode66 {
    public int[] plusOne (int[] digits) {
        int i = digits.length - 1;
        boolean isCarry = false;
        while (i >= 0) {
            int temp = digits[i] + 1;
            if (temp >= 10) {
                digits[i] = temp % 10;
                if (i == 0)
                    isCarry = true;
                --i;
            } else {
                digits[i] = temp;
                return digits;
            }
        }
        int[] res = null;
        if (isCarry) {
            res = new int[digits.length + 1];
            res[0] = 1;
            for (int j = 0; j < digits.length; j++)
                res[j + 1] = digits[j];
        }
        return res;
    }
}
