package Algorithm;

public class leetcode11 {
    public static int maxArea (int[] height) {
        if (height.length < 2)
            return 0;
        int left = 0;
        int right = height.length-1;
        int max = 0;
        while (left < right) {
            int h = Math.min(height[left], height[right]);
            max = Math.max(max, h * (right - left));
            if (h == height[left])
                left++;
            else
                right--;
        }
        return max;
    }
    public static void main(String []args){
        int []h = {1,8,6,2,5,4,8,3,7};
        leetcode11.maxArea(h);
    }
}
