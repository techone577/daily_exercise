package Algorithm;

import java.util.Scanner;

/**
 * 给定一个非降序的整数数组，数组中包含重复数字（重复数字很多） ，给定任意整数，对数组进行二分查找，返回数组正确的位置，给出函数实现。
 a.	连续相同的数字，返回最后一个匹配的位置
 b.	如果数字不存在返回 -1。
 */

public class BoundSearch {
    public static int boundSearch(int[] nums, int target) {
        if (nums.length == 0)
            return -1;
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target)
                right = mid;
            else
                left = left + 1;
        }
        if (nums[left - 1] == target)
            return left - 1;
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lenght = scanner.nextInt();
        int target = scanner.nextInt();
        int[] nums = new int[lenght];
        for (int i = 0; i < lenght;i++){
           nums[i] = scanner.nextInt();
        }
        System.out.println(BoundSearch.boundSearch(nums,target));
    }

}
