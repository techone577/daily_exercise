package Algorithm2;

public class MergeSort {
    /**
     * sort左边，sort右边，归并
     */
    public static void MergeSort (int[] nums, int l, int h) {
        if (l >= h)
            return;
        int left = l, right = h;
        int mid = (left + right) / 2;
        MergeSort(nums, left, mid);
        MergeSort(nums, mid + 1, right);
        Merge(nums, left, mid, right);
    }

    /**
     *左边l-m，右边m+1 - h
     */
    private static void Merge (int[] nums, int l, int m, int h) {
        int newNums[] = new int[h - l + 1];
        int i = l, j = m + 1, k = 0;
        while (i <= m && j <= h) {
            newNums[k++] = nums[i] < nums[j] ? nums[i++] : nums[j++];
        }
        while (i <= m)
            newNums[k++] = nums[i++];
        while (j <= h)
            newNums[k++] = nums[j++];
        for (int p = 0; p < newNums.length; p++) {
            nums[p + l] = newNums[p];
        }
    }

    public static void main (String[] args) {
        int []nums = new int[] {4,3,6,2,1,1,1,1,8,5,9,10,0};
        MergeSort(nums,0,nums.length-1);
        for(int t:nums) {
            System.out.print(t+" ");
        }
    }
}
