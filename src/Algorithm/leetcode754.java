package Algorithm;

/**
 * 在一根无限长的数轴上，你站在0的位置。终点在target的位置。
 * 每次你可以选择向左或向右移动。第 n 次移动（从 1 开始），可以走 n 步。
 * 返回到达终点需要的最小移动次数。
 */
public class leetcode754 {
    public int reachNumber (int target) {
        target = target > 0 ? target : 0 - target;
        int k = 0, sum = 0;
        while (sum < target) {
            k++;
            sum += k;
        }
        if ((sum - target) % 2 == 0)
            return k;
        else {
            if (k % 2 == 0)
                return k + 1;
            else
                return k + 2;
        }
    }

    public static void main (String[] args) {
        new leetcode754().reachNumber(3);
    }
}
