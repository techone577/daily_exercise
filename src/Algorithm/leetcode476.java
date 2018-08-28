package Algorithm;

import java.util.TreeMap;

public class leetcode476 {
    public static int findComplement (int num) {
        int mask = (Integer.highestOneBit(num) << 1) - 1;
        return mask ^ num;
    }

    public static void main (String[] args) {
        System.out.print(leetcode476.findComplement(5));
    }
}
