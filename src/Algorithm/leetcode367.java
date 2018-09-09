package Algorithm;

/**
 * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
 * 说明：不要使用任何内置的库函数，如  sqrt。
 *
 * 二分查找
 * 一个数的平方根一定小于这个数的一半
 */
public class leetcode367 {
    public static boolean isPerfectSquare (int num) {
        if (num < 1)
            return false;
        if (num == 1)
            return true;
        long left = 0;
        long right = num / 2;
        while (left <= right) {
            long mid = (left + right) / 2;
            if (mid * mid == num)
                return true;
            else if (mid * mid < num)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return false;
    }

    public static void main (String[] args) {
        System.out.print(leetcode367.isPerfectSquare(808201));
    }
}
