package Algorithm;

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
