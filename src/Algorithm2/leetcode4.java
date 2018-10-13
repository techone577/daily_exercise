package Algorithm2;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2 。
 * 请找出这两个有序数组的中位数。要求算法的时间复杂度为 O(log (m+n)) 。
 * 你可以假设 nums1 和 nums2 不同时为空。
 */

public class leetcode4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int res = 0;
        int median = (n + m+1) / 2;
        boolean flag = true;
        if ((n + m) % 2 == 0)
            flag = false;
        int i = 0, j = 0, count = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                res = nums1[i];
                ++i;
            } else {
                res = nums2[j];
                ++j;
            }
            if (++count == median) {
                if(flag == false) {
                    if( i<nums1.length && j<nums2.length) {
                        res += nums1[i] < nums2[j] ? nums1[i] : nums2[j];
                    }
                    else{
                        res+=i<nums1.length?nums1[i]:nums2[j];
                    }
                    double ret = (double) res / 2;
                    return ret;
                }
                return res;
            }
        }
        while(i<nums1.length){
            res = nums1[i];
            ++i;
            if (++count == median) {
                if(flag == false) {
                    res += nums1[i];
                    double ret = (double)res/2;
                    return ret;
                }
                return res;
            }
        }
        while(j<nums2.length){
            res = nums2[j];
            ++j;
            if (++count == median) {
                if(flag == false) {
                    res += nums2[j];
                    double ret = (double)res/2;
                    return ret;
                }
                return res;
            }
        }
        return -1;
    }

    public static void main(String []args){
        int []nums1 = new int[]{1,2};
        int nums2[] = new int []{3,4};
        System.out.println(new leetcode4().findMedianSortedArrays(nums1,nums2));
    }
}
