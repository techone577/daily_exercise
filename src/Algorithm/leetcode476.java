package Algorithm;

import java.util.TreeMap;

/**
 * 给定一个正整数，输出它的补数。补数是对该数的二进制表示取反。
 * 注意:
 * 给定的整数保证在32位带符号整数的范围内,
 * 你可以假定二进制数不包含前导零位。
 *
 * 对二进制取反，其实就是与相同位数全为1的二进制异或
 * Integer.highestOneBit(n),比如n二进制位1100，则计算出的结果为10000，所以全为1用前面所求的值-1即可
 */
public class leetcode476 {
    public static int findComplement (int num) {
        int mask = (Integer.highestOneBit(num) << 1) - 1;
        return mask ^ num;
    }

    public static void main (String[] args) {
        System.out.print(leetcode476.findComplement(5));
    }
}
